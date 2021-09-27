from typing import Type
from antlr4 import *
# importamos la gramatica
from Grammar.DecafVisitor import DecafVisitor
from Grammar.DecafParser import DecafParser
from stack import Decaf_Stack
from symbol_table import Symbol, SymbolTable, More
from decaf_errors import generic, expect_error, not_defined

Default = {
    'int': 4,
    'boolean': 1,
    'char': 1
}

class CustomVisitor(DecafVisitor):
    def __init__(self):
        self.error = []
        self.scope_ids = 0
        self.symbol_ids = 0
        self.offset = 0
        self.data_ids = 0
        self.global_scope = SymbolTable()
        self.scopes = [self.global_scope]
        self.total = {self.global_scope.name: self.global_scope,}

    def visitProgram(self, ctx: DecafParser.ProgramContext):
        self.visitChildren(ctx)
        if self.scopes[-1].search('main') == None:
            error = generic('Main method is not define', ctx.start.line)
            self.error.append(error)
    
    def visitMethod_declar(self, ctx: DecafParser.Method_declarContext):
        method_name = ctx.ID().getText()
        method_type = ctx.method_type().getText()
        self.scope_ids =+ 1
        nw_scope = SymbolTable(self.scope_ids, method_name, self.scopes[-1].id, method_type)
        self.scopes.append(nw_scope)
        parameters = ctx.parameter()
        # lista de parametros
        param = []
        param_names = []
        for i in parameters:
            param_type = i.parameter_type().getText()
            param_name = i.ID().getText()
            if param_name not in param_names:
                param_names.append(param_name)
                nw_p = Symbol(param_type, param_name, 1)
                param.append(nw_p)
                self.symbol_ids += 1
                size = 0
                if param_type in Default:
                    size += Default[param_type]
                else:
                    get = param_type.replace('struct', '')
                    for scope in self.scopes[::-1]:
                        found = scope.search(get)
                        if found:
                            if found.stype == 'struct':
                                size += found.size
                                break
                    else:
                        error = generic('Type %s not found' % get, ctx.start.line)
                        self.error.append(error)
                self.scopes[-1].addSymbol(param_type, param_name, self.symbol_ids)
            else:
                error = generic('Parameter already defined', ctx.start.line)
                self.error.append(error)
        data = ctx.block().statement()
        for i in data:
            if 'return' in i.getText():
                break
        else:
            if method_type != 'void':
                error = generic('Return not match', ctx.start.line)
                self.error.append(error)

        if self.scopes[-2].search(method_name):
            error = generic('Method already defined')
            self.error.append(error)
        else:
            self.scopes[-2].add(self.data_ids, method_name, method_type, None, param)
        self.visitChildren(ctx)
        # termina el scope
        end_scope = self.scopes.pop()
        self.total[nw_scope.name] = end_scope
        return 0
    
    def visitLocation(self, ctx: DecafParser.LocationContext, parent=None):
        method_name = ctx.ID().getText()
        if ctx.expression() != None:
            sco = self.visit(ctx.expression())
            if sco != 'int':
                error = expect_error('int', ctx.expression(), ctx.start.line)
                self.error.append(error)

        if parent != None:
            for i in self.scopes[::-1]:
                symbol = i.attribute(parent, method_name)
                if symbol != None:
                    value = self.visitLocation(ctx.location(), symbol.stypereplace('struct', ''))
                    return value
                return symbol.stype
            else:
                error = generic('%s not found' % method_name, ctx.start.line)
                self.error.append(error)

        if not ctx.location():
            for i in self.scopes[::-1]:
                symbol = i.getSymbol(method_name)
                if symbol != None:
                    sm_type = symbol.stype
                    return sm_type
            else:
                error = generic('%s not found' % method_name, ctx.start.line)
                self.error.append(error)
        else:
            for i in self.scopes[::-1]:
                symbol = i.getSymbol(method_name)
                if symbol != None:
                    sm_type = symbol.stype
                    if 'struct' in sm_type:
                        value = self.visitLocation(ctx.location(), sm_type.replace('struct', ''))
                        return value
                    else:
                        error = generic('%s not attribute' % method_name, ctx.start.line)
                        self.error.append(error)
        return None
    
    def visitStruct_declar(self, ctx: DecafParser.Struct_declarContext):
        method_name = ctx.ID().getText()
        stype = 'struct'
        attribute = ctx.var_declar()
        sub_params = []
        size = 0
        attribute_name = []
        for i in attribute:
            var_type = i.var_type().getText()
            var_name = i.ID().getText()
            if var_name not in attribute_name:
                attribute_name.append(var_name)
                sub_symbol = Symbol(var_type, var_name, id)
                sub_params.append(sub_symbol)
                if var_type in Default:
                    size += Default[var_type]
                else:
                    get = var_type.replace('struct', '')
                    for i in self.scopes[::-1]:
                        found = i.search(get)
                        if found:
                            if found.stype == 'struct':
                                size += found.size
                                break
                    else:
                        error = generic('Type %s not found' % get, ctx.start.line)
                        self.error.append(error)
            else:
                error = generic('Type %s already defined' % var_name, ctx.start.line)
                self.error.append(error)
        # anadimos al scope
        self.scopes[-1].add(self.data_ids,  method_name, 'struct', None, sub_params, size)
        self.data_ids += 1
        return (stype, method_name)

    def visitBlock(self, ctx: DecafParser.BlockContext):
        self.visitChildren(ctx)
        return None

    def visitIf_Scope(self, ctx: DecafParser.If_ScopeContext):
        sco = self.visit(ctx.expression())
        self.scope_ids += 1
        # si no encuentra boolean
        if sco != 'boolean':
            error = generic('Expected boolean', ctx.start.line)
            self.error.append(error)
        name = 'if' + str(self.scope_ids)
        nw = SymbolTable(self.scope_ids, name, self.scopes[-1])
        self.scopes.append(nw)
        self.visitChildren(ctx)
        self.scopes.pop()
        return None
    
    def visitStmnt_return(self, ctx: DecafParser.Stmnt_returnContext):
        if ctx.expression() != None:
            sco = self.visit(ctx.expression())
            for i in self.scopes[::-1]:
                if i.stype != None:
                    if sco != i.stype:
                        error = generic('Return %s does not match' % ctx.expression().getText(), ctx.start.line)
                        self.error.append(error)
                        break
        else:
            for i in self.scopes[::-1]:
                if i.stype != None:
                    if 'void' != i.stype:
                        error = generic('Empty return %s' % i.stype, ctx.start.line)
                        self.error.append(error)
                        break
        return None
    
    def visitWhile_Scope(self, ctx: DecafParser.While_ScopeContext):
        sco = self.visit(ctx.expression())
        self.scope_ids += 1
        if sco != 'boolean':
            error = generic('Expected boolean got %s' % sco, ctx.start.line)
            self.error.append(error)
        name = 'while' + str(self.scope_ids)
        nw = SymbolTable(self.scope_ids, name, self.scopes[-1])
        self.scopes.append(nw)
        self.visitChildren(ctx)
        self.scopes.pop()
        return None