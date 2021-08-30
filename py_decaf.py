from antlr4 import *
# importamos la gramatica
from Grammar.DecafVisitor import DecafVisitor
from Grammar.DecafParser import DecafParser
from stack import Decaf_Stack
from collections import OrderedDict
from symbol_table import Symbol, SymbolTable, Type_Item, Type_Table

class CustomVisitor(DecafVisitor):

    def __init__(self):
        self.scope = Decaf_Stack()
        self.errors = []
        self.offset = 0

    def error(self):
        self.flag = True
    
    def enter_scope(self, name, t='scope'):
        parent = self.scope.peek()
        # data of symbol table
        st = SymbolTable(name, parent=parent, stype=t, typeTable=Type_Table(), id={})
        self.scope.push(st) # ADD data symbol table
        # debugg
        print('Enter Scope: %s' % name)

    def exit_scope(self):
        if self.scope.empty():
            pass
        else:
            return self.scope.pop()

    # get errors
    def get_Error(self, error):
        data_error = ('DECLARATION ERROR %s' % error)
        return data_error

    '''
        FUNCIONES QUE SE ENCUENTRAN DENTRO DEL DECAFVISITOR
    '''
    def visitProgram(self, ctx: DecafParser.ProgramContext):
        self.enter_scope('GLOBAL')
        return self.visitChildren(ctx)
    
        
    def visitSingle_VarDeclar(self, ctx: DecafParser.Single_VarDeclarContext):
        name = str(ctx.ID())
        scope = self.scope.peek()
        vartype = ctx.var_Type.getText()

        # found struct
        if scope.scopeType == 'struct':
            typeTable = scope.parent.typeTable
            param = Symbol(name, vartype, 0)

            # Add size and parameter
            typeTable.addSize(name, typeTable.getSize(vartype))
            typeTable.addParam(scope.name, param)
            return self.visitChildren(ctx)

        elif 'struct' in vartype:
            # add struct to symbol table
            symbol_name = vartype.replace('struct', '')

            struct = Symbol(name, symbol_name, self.offset)
            scope.add(struct)

            structParams = scope.typeTable.getParams(symbol_name)
            for param in structParams.values():
                s = Symbol(symbol_name + param.name, param.stype, self.offset)
                self.offset += scope.typeTable.getSize(symbol_name)
                scope.add(s)
            
            return self.visitChildren(ctx)

        s = Symbol(name, vartype, self.offset)
        self.offset += scope.typeTable.getSize(vartype)
        scope.add(s)

        return self.visitChildren(ctx)

    def visitList_VarDeclar(self, ctx: DecafParser.List_VarDeclarContext):
        name = str(ctx.ID())
        scope = self.scope.peek()
        vartype = ctx.var_Type.getText().replace('struct', '')

        size = int(str(ctx.NUM()))

        s = Symbol(name, vartype, self.offset, listSize=size)
        print(scope.typeTable.entrys['int'])
        self.offset += (scope.typeTable.getSize(vartype) * size)
        scope.add(s)

        return self.visitChildren(ctx)
    
    def visitStruct_declar(self, ctx: DecafParser.Struct_declarContext):
        name = str(ctx.ID())
        scope = self.scope.peek()
        self.enter_scope(name, 'struct')
        s = Type_Item(name, 0, 'struct', {})
        scope.addType(s)
        self.exit_scope()
        return self.visitChildren(ctx)
    
    def visitMethod_declar(self, ctx: DecafParser.Method_declarContext):
        name = str(ctx.ID())
        scope = self.scope.peek()
        returnType = ctx.returnType.getText()
        
        s = Type_Item(name, 0, 'method', {}, returnType)
        
        for param in ctx.parameter():
            values = self.visitParameter(param)
            s.addParam(values)

        scope.addType(s)

        # enter method scope
        self.enter_scope(name, 'method')
        self.exit_scope()
        
        return self.visitChildren(ctx)

    def visitParameter(self, ctx: DecafParser.ParameterContext):
        name = str(ctx.ID())
        scope = self.scope.peek()
        vartype = ctx.var_Type.getText()
        
        s = Symbol(name, vartype, self.offset)
        scope.add(s)
        v = self.visitChildren(ctx)
        return s