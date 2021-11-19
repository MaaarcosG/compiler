from typing import Type
from antlr4 import *
# importamos la gramatica
from Grammar.DecafVisitor import DecafVisitor
from Grammar.DecafParser import DecafParser
from stack import Decaf_Stack
from symbol_table import Symbol, SymbolTable, More, Type_Enum
from decaf_errors import generic, expect_error, not_defined
from decaf_validate import Evaluator

default_variable = {'int': 4, 'boolean': 1, 'char': 1}

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
        # self.validator = Evaluator(scopes = self.scopes)
    
    def error(self):
        self.flag = True
        
    # get errors
    def get_Error(self, error):
        data_error = ('DECLARATION ERROR %s' % error)
        return data_error
    
    def enter_scope(self, name, t='scope'):
        parent = self.scope.peek()
        # data of symbol table
        # st = SymbolTable(name, parent=parent, stype=t, typeTable=Type_Table(), id={})
        # self.scope.push(st) # ADD data symbol table
        # debugg
        # print('Enter Scope: %s' % name)
    
    def exit_scope(self):
        if self.scope.empty():
            pass
        else:
            popp = self.scope.pop()
            self.save[popp.name] = popp
            return popp
    
    '''
        FUNCIONES QUE SE ENCUENTRAN DENTRO DEL DECAFVISITOR
    '''
    def visitProgram(self, ctx: DecafParser.ProgramContext):
        self.error = []
        self.visitChildren(ctx)
        if not self.scopes[-1].search("main"):
            error = generic("main method not defined", ctx.start.line)
            self.error.append(error)
        return 0
    
    def visitSingle_VarDeclar(self, ctx: DecafParser.Single_VarDeclarContext):
        method_type = ctx.var_type().getText()
        method_name = ctx.ID().getText()
        self.symbol_ids += 1
        if self.scopes[-1].getSymbol(method_name):
            error = generic('%s already defined in scope' % method_name, ctx.start.line)
            self.error.append(error)
        else:
            self.scopes[-1].addSymbol(method_type, method_name, 1, self.symbol_ids, self.offset)
        if method_type in default_variable:
            self.offset += default_variable[method_type]
            # print('Si entra a este metodo, tipo de dato aceptado %s...' % method_type)
        else:
            get = method_type.replace("struct", "")
            
            # print(get)
            for scope in self.scopes[::-1]:
                found = scope.search(get)
                # print(found)
                if found:
                    if found.stype == "struct":
                        self.offset += found.size
                        break
            else:
                error = generic("Type %s not found" % get, ctx.start.line)
                self.error.append(error)
        self.visitChildren(ctx)
        return (method_type, method_name)
    
    def visitList_VarDeclar(self, ctx: DecafParser.List_VarDeclarContext):
        method_type = ctx.var_type().getText()
        method_name = ctx.ID().getText()
        method_num = ctx.NUM().getText()
        if int(method_num) <= 0:
            error = generic('Index out of range < 0 ', ctx.start.line)
            self.error.append(error)
        else:
            self.symbol_ids += 1
            self.scopes[-1].addSymbol(method_type, method_name, method_num, self.symbol_ids, self.offset)
            if method_type in default_variable:
                self.offset += (default_variable[method_type] * int(method_num))
            else:
                get = method_type.replace("struct", "")
                for scope in self.scopes[::-1]:
                    found = scope.search(get)
                    if found:
                        if found.stype == "struct":
                            self.offset += found.size * int(method_num)
                            break
                else:
                    error = generic("Type %s not found" % get, ctx.start.line)
                    self.error.append(error)
        self.visitChildren(ctx)
        return 0
    
    def visitStruct_declar(self, ctx: DecafParser.Struct_declarContext):
        method_name = ctx.ID().getText()
        attribute = ctx.var_declar()
        type = "struct"
        sub_params = []
        size = 0
        attribute_name = []
        for data in attribute:
            # posible error, que no jale el var_type correcto...
            varType = data.var_type().getText()
            varName = data.ID().getText()
            if varName not in attribute_name:
                attribute_name.append(varName)
                sub = Symbol(varType, varName, id)
                sub_params.append(sub)
                if varType in default_variable:
                    size += default_variable[varType]
                else:
                    get = varType.replace("struct", "")
                    for scope in self.scopes[::-1]:
                        found = scope.search(get)
                        if found:
                            if found.stype == "struct":
                                size += found.size
                                break
                    else:
                        error = generic("Type %s not found" % get, ctx.start.line)
                        self.error.append(error)
            else:
                error = generic("Type %s already defined in scope" % varName, ctx.start.line)
                self.error.append(error)
                
        self.scopes[-1].add(self.data_ids, method_name, 'struct', None, sub_params, size)
        self.data_ids += 1
        return (type, method_name)
    
    def visitMethod_declar(self, ctx: DecafParser.Method_declarContext):
        method_name = ctx.ID().getText()
        method_type = ctx.method_type().getText()
        self.scope_ids += 1
        nw_scope = SymbolTable(self.scope_ids, method_name, self.scopes[-1], method_type)
        self.scopes.append(nw_scope)
        parameters = ctx.parameter()
        param = []
        param_names = []
        for i in parameters:
            # print(i.parameter_type().getText())
            param_type = i.parameter_type().getText()
            param_name = i.ID().getText()
            if param_name not in param_names:
                param_names.append(param_name)
                new_param = Symbol(param_type, param_name, 1)
                param.append(new_param)
                self.symbol_ids += 1
                size = 0
                if param_type in default_variable:
                    size = default_variable[param_type]
                else:
                    get = param_type.replace("struct", "")
                    for scope in self.scopes[::-1]:
                        found = scope.search(get)
                        if found:
                            if found.stype == "struct":
                                size = found.size
                                break
                    else:
                        error = generic("Type %s not found" % get, ctx.start.line)
                        self.error.append(error)
                self.scopes[-1].addSymbol(param_type, param_name, 1, self.symbol_ids)
                self.offset += size
            else:
                error = generic("Parameter already defined", ctx.start.line)
                self.error.append(error)
        data = (ctx.block().statement())
        if_return = None
        for part in data:
            if 'return' in part.getText():
                break
        else:
            if method_type != "void":
                error = generic("Return does not match method type", ctx.start.line)
                self.error.append(error)
        
        if self.scopes[-2].search(method_name):
            error = generic("Method already defined in scope", ctx.start.line)
            self.error.append(error)
        else:
            self.scopes[-2].add(self.data_ids, method_name, method_type, if_return, param)
        self.visitChildren(ctx)
        exit_scope = self.scopes.pop()
        self.total[nw_scope.name] = exit_scope
        return 0
    
    def visitIfStmt(self, ctx: DecafParser.IfStmtContext):
        value = self.visit(ctx.expression())
        self.scope_ids += 1
        if value != "boolean":
            error = generic("Expected boolean got %s" % value, ctx.start.line)
            self.error.append(error)
        nw_scope = SymbolTable(self.scope_ids, "if" + str(self.scope_ids), self.scopes[-1])
        # anadimos el valor al scope
        self.scopes.append(nw_scope)
        self.visitChildren(ctx)
        end = self.scopes.pop()
        self.total[nw_scope.name] = end
        return None
    
    def visitWhileStmt(self, ctx: DecafParser.WhileStmtContext):
        value = self.visit(ctx.expression())
        # print(value)
        self.scope_ids += 1
        if value != "boolean":
            error = generic("Expected boolean got %s" % value, ctx.start.line)
            self.error.append(error)
        nw_scope = SymbolTable(self.scope_ids, "while" + str(self.scope_ids), self.scopes[-1])
        self.scopes.append(nw_scope)
        self.visitChildren(ctx)
        end = self.scopes.pop()
        self.total[nw_scope.name] = end
        return None
    
    def visitReturnStmt(self, ctx: DecafParser.ReturnStmtContext):
        if ctx.expression != None:
            value = self.visit(ctx.expression())
            # print(value)
            for scope in self.scopes[::-1]:
                if scope.stype != None:
                    if value != scope.stype:
                        error = generic("Return %s does not match method type %s" % (ctx.expression().getText(), scope.stype), ctx.start.line)
                        self.error.append(error)
                        break
        else:
            for scope in self.scopes[::-1]:
                if scope.stype != None:
                    if "void" != scope.stype:
                        error = generic("Empty return does not match method type %s" % scope.stype, ctx.start.line)
                        self.error.append(error)
                        break
        return None
    
    '''Tipos de Datos'''

    def visitLiteral(self, ctx: DecafParser.LiteralContext):
        value = self.visitChildren(ctx)
        return value[0]

    def visitInt_literal(self, ctx: DecafParser.Int_literalContext):
        method_num = ctx.NUM()
        if method_num == None:
            error = generic("Expected num", ctx.start.line)
            self.error.append(error)
        return ("int", int(method_num.getText()))
    
    def visitChar_literal(self, ctx: DecafParser.Char_literalContext):
        char = ctx.CHAR()
        if char == None:
            error = generic("Expected char", ctx.start.line)
            self.error.append(error)
        return ("char", char.getText())
    
    def visitBool_literal(self, ctx: DecafParser.Bool_literalContext):
        boolean = ctx.getText()
        if (boolean != 'true') and (boolean != 'false'):
            error = generic("Expected true or false", ctx.start.line)
            self.error.append(error)
        return ("boolean", boolean)
    
    '''EXPRESIONNS'''

    def visitMethod_call(self, ctx: DecafParser.Method_callContext):
        method_name = ctx.ID().getText()
        args = ctx.arg()
        self.visitChildren(ctx)
        for scope in self.scopes[::-1]:
            method = scope.search(method_name)
            if method != None:
                if len(args) == len(method.params):
                    actual = 0
                    for arg in args:
                        value = self.visit(arg)
                        if (value != None) and (value == method.params[actual].stype):
                            break
                        elif value != None:
                            error = generic("Type of %s %s does not match with parameter %s %s " % (value, arg.getText(), method.params[actual].stype, method.params[actual].name), ctx.start.line)
                            self.error.append(error)
                        actual += 1
                return method.stype
        return None
    
    def visitNegationExpression(self, ctx: DecafParser.NegationExpressionContext):
        data = self.visit(ctx.expression())
        if data == "boolean":
            return data
        else:
            error = expect_error('boolean', data, ctx.start.line)
            self.error.append(error)
    
    def visitNegativeExpression(self, ctx: DecafParser.NegativeExpressionContext):
        data = self.visit(ctx.expression())
        # si encuentre boolean
        if data != Type_Enum.Integer:
            error = generic('Only negate integer expression', ctx.start.line)
            self.error.append(error)
        return data

    def visitAssigStmt(self, ctx: DecafParser.AssigStmtContext):
        ltype = self.visit(ctx.left)
        rtype = self.visit(ctx.right)
        # print(ctx.left.getText())
        if ltype == None:
            error = generic('%s is None in Assignment left data %s' % (ltype, ctx.left.getText()), ctx.start.line)
            self.error.append(error)
        elif rtype == None:
            error = generic('%s is None in Assignment right data %s' % (rtype, ctx.right.getText()), ctx.start.line)
            self.error.append(error)
        elif ltype != rtype:
            error = generic("Can only assing to two expressions with the same type left = %s right = %s" % (ltype, rtype), ctx.start.line)
            self.error.append(error)
        return None
    
    def visitLocation(self, ctx: DecafParser.LocationContext, parent=None):
        name  = ctx.ID().getText()
        if ctx.expression() != None:
            data = self.visit(ctx.expression())
            if data != "int":
                error = expect_error('int', "%s of type %s" % (ctx.expression(), data), ctx.start.line)
                self.error.append(error)

        if parent != None:
            for scope in self.scopes[::-1]:
                symbol = scope.attribute(parent, name)
                if symbol != None:
                    if ctx.location() != None:
                        data  = self.visitLocation(ctx.location(), symbol.stype.replace('struct', ''))
                        return data
                    return symbol.stype
            else:
                error = generic("%s not found in %s" % (name, parent), ctx.start.line)
                self.error.append(error)

        if ctx.location() == None:
            for scope in self.scopes[::-1]:
                symbol = scope.getSymbol(name)
                if symbol != None:
                    sm_type = symbol.stype
                    return sm_type
                    
            else:
                error = generic("%s not found" % name, ctx.start.line)
                self.error.append(error)
        else:
            for scope in self.scopes[::-1]:
                symbol = scope.getSymbol(name)
                if symbol != None:
                    sm_type = symbol.stype
                    if "struct" in sm_type:
                        val = self.visitLocation(ctx.location(), sm_type.replace('struct', ''))
                        return val
                    else:
                        error = generic('Location passed but %s is not a struct' % name, ctx.start.line)
                        self.error.append(error)
        return None
    
    '''OPERATION'''
    
    def visitHigherArithOp(self, ctx: DecafParser.HigherArithOpContext):
        ltype = self.visit(ctx.left)
        rtype = self.visit(ctx.right)
        # print('%s %s %s' % (ctx.left.getText(), ctx.higher_arith_op().getText(), ctx.right.getText()))
        if (rtype == 'int') and (ltype == 'int'):
            return 'int'
        elif (ltype == None):
            error = generic('%s is None left data %s' % (ltype, ctx.left.getText()), ctx.start.line)
            self.error.append(error)
        elif (rtype == None):
            error = generic('%s is None right data %s' % (rtype, ctx.right.getText()), ctx.start.line)
            self.error.append(error)
        else:
            error = expect_error('int', '%s, %s' % (ltype, rtype), ctx.start.line)
            self.error.append(error)
    
    def visitArithOp(self, ctx: DecafParser.ArithOpContext):
        ltype = self.visit(ctx.left)
        rtype = self.visit(ctx.right)
        # print('%s %s %s' % (ctx.left.getText(), ctx.arith_op().getText(), ctx.right.getText()))
        if (rtype == 'int') and (ltype == 'int'):
            return 'int'
        elif (ltype == None):
            error = generic('%s is None left data %s' % (ltype, ctx.left.getText()), ctx.start.line)
            self.error.append(error)
        elif (rtype == None):
            error = generic('%s is None right data %s' % (rtype, ctx.right.getText()), ctx.start.line)
            self.error.append(error)
        else:
            error = expect_error('int', '%s and %s' % (ltype, rtype), ctx.start.line)
            self.error.append(error)
    
    def visitRelationOp(self, ctx: DecafParser.RelationOpContext):
        ltype = self.visit(ctx.left)
        rtype = self.visit(ctx.right)
        # print('%s %s %s' % (ctx.left.getText(), ctx.rel_op().getText(), ctx.right.getText()))
        if (rtype == 'int') and (ltype == 'int'):
            return 'boolean'
        elif (ltype == None):
            error = generic('%s is None left data %s in relationOp' % (ltype, ctx.left.getText()), ctx.start.line)
            self.error.append(error)
        elif (rtype == None):
            error = generic('%s is None right data %s i relationOp' % (rtype, ctx.right.getText()), ctx.start.line)
            self.error.append(error)
        else:
            error = expect_error('int', '%s, %s' % (ltype, rtype), ctx.start.line)
            self.error.append(error)
    
    def visitEqualityOp(self, ctx: DecafParser.EqualityOpContext):
        ltype = self.visit(ctx.left)
        rtype = self.visit(ctx.right)
        # print('%s %s %s' % (ctx.left.getText(), ctx.eq_op().getText(), ctx.right.getText()))
        if (rtype == ltype):
            return 'boolean'
        elif (ltype == None):
            error = generic('%s is None left data equality operation' % ctx.left.getText(), ctx.start.line)
            self.error.append(error)
        elif (rtype == None):
            error = generic('%s is None right data equality operation' % ctx.right.getText(), ctx.start.line)
            self.error.append(error)
        else:
            error = expect_error('boolean', '%s %s' % (ltype, rtype), ctx.start.line)
            self.error.append(error)
    
    def visitConditionalOp(self, ctx: DecafParser.ConditionalOpContext):
        ltype = self.visit(ctx.left)
        rtype = self.visit(ctx.right)
        # print('%s %s %s' % (ctx.left.getText(), ctx.cond_op().getText(), ctx.right.getText()))
        if (rtype == 'boolean') and (ltype == 'boolean'):
            return 'boolean'
        elif (ltype == None):
            error = generic('%s is None left data' % ctx.left.getText(), ctx.start.line)
            self.error.append(error)
        elif (rtype == None):
            error = generic('%s is None right data' % ctx.right.getText(), ctx.start.line)
            self.error.append(error)
        else:
            error = expect_error('boolean', '%s %s' % (ltype, rtype), ctx.start.line)
            self.error.append(error)
    
    def visitParentExpression(self, ctx: DecafParser.ParentExpressionContext):
        data = self.visit(ctx.expression())
        return data