from antlr4 import *
# importamos la gramatica
from Grammar.DecafVisitor import DecafVisitor
from Grammar.DecafParser import DecafParser
from stack import Decaf_Stack
from decaf_validate import Evaluator
from symbol_table import Symbol, SymbolTable, Type_Item, Type_Table, Type_Enum

class CustomVisitor(DecafVisitor):
    def __init__(self):
        self.scope = Decaf_Stack()
        self.errors = []
        self.offset = 0
        # counter of scope 
        self.count = 0
        # contiene los errores
        self.validator = Evaluator(scopes = self.scope)

    def error(self):
        self.flag = True
    
    def enter_scope(self, name, t='scope'):
        parent = self.scope.peek()
        # data of symbol table
        st = SymbolTable(name, parent=parent, stype=t, typeTable=Type_Table(), id={})
        self.scope.push(st) # ADD data symbol table
        # debugg
        # print('Enter Scope: %s' % name)

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
        self.enter_scope('global')
        return self.visitChildren(ctx)
    
        
    def visitSingle_VarDeclar(self, ctx: DecafParser.Single_VarDeclarContext):
        name = str(ctx.ID())
        scope = self.scope.peek()
        tt = ctx.var_Type.getText()
        vartype = scope.t_exist(tt.replace('struct', '')).name
        
        # found struct
        if scope.scopeType == 'struct':
            tt = scope.parent.typeTable
            param = Symbol(name, vartype, 0)

            # Add size and parameter
            tt.addSize(name, tt.getSize(tt))
            tt.addParam(scope.name, param)
            return self.visitChildren(ctx)

        elif 'struct' in tt:
            # add struct to symbol table
            symbol_name = tt.replace('struct', '')

            struct = Symbol(name, symbol_name, self.offset)
            # print(struct)
            scope.add(struct)

            structParams = scope.typeTable.getParams(symbol_name)
            for param in structParams.values():
                s = Symbol(symbol_name + param.name, param.stype, self.offset)
                self.offset += scope.typeTable.getSize(symbol_name)
                scope.add(s)
            
            return self.visitChildren(ctx)

        s = Symbol(name, vartype, self.offset)
        self.offset += scope.typeTable.getSize(tt)
        # print('Add %s to scope %s' % (name, scope.name))
        # Getting the line number in the ParserVisitor
        # print(ctx.start.line)
        scope.add(s)

        return self.visitChildren(ctx)

    def visitList_VarDeclar(self, ctx: DecafParser.List_VarDeclarContext):
        name = str(ctx.ID())
        scope = self.scope.peek()
        vartype = ctx.var_Type.getText().replace('struct', '')

        size = int(str(ctx.NUM()))

        if scope.scopeType == 'struct':
            typet = scope.parent.t_exist(vartype)
            typetable = scope.parent.typeTable

            param = Symbol(name, typet.name, 0, listSize=size)
            
            typetable.addSize(name, typet.size * size)
            typetable.addParam(scope.name, param)
            return self.visitChildren(ctx)

        s = Symbol(name, vartype, self.offset, listSize=size)
        self.offset += (scope.t_exist(vartype).size * size)
        scope.add(s)
        # print('ITS IN METHOD DECLARATION')
        return self.visitChildren(ctx)
    
    def visitStruct_declar(self, ctx: DecafParser.Struct_declarContext):
        name = str(ctx.ID())
        scope = self.scope.peek()
        self.enter_scope(name, 'struct')
        # Type_Enum is definition in symbol table
        s = Type_Item(name, 0, Type_Enum.Struct, {})
        scope.addType(s)
        self.exit_scope()
        return self.visitChildren(ctx)
    
    def visitMethod_declar(self, ctx: DecafParser.Method_declarContext):
        name = str(ctx.ID())
        scope = self.scope.peek()
        returnType = ctx.returnType.getText()
        
        data = Type_Item(name, 0, 'method', {}, scope.t_exist(returnType).name)
        for param in ctx.parameter():
            values = self. visitParameter(param)
            data.addParam(values)
        scope.addType(data)

        # enter method scope
        self.enter_scope(name, 'method')
        self.exit_scope()
        
        return self.visitChildren(ctx)
    
    def visitParameter(self, ctx: DecafParser.ParameterContext): 
        name = str(ctx.ID())
        scope = self.scope.peek()
        tt = ctx.getChild(0).getText()
        vartype = scope.t_exist(tt)
            
        s = Symbol(name, vartype.name, self.offset, param=True)
        self.offset += vartype.size
        scope.add(s)
        return s
            

    def visitIfStmt(self, ctx: DecafParser.IfStmtContext):
        self.enter_scope('ifblock %s if' % str(self.count))
        self.count += 1
        
        expr = self.validator.visit(ctx.expression())
        if expr != Type_Enum.Boolean:
            self.validator.errors.append('Expected boolean expression for if in line %s' % ctx.start.line)

        self.exit_scope()
        return self.visitChildren(ctx)
    
    def visitWhileStmt(self, ctx: DecafParser.WhileStmtContext):
        self.enter_scope('whileblock %s if' % str(self.count))
        self.count += 1
        
        expr = self.validator.visit(ctx.expression())
        if expr != Type_Enum.Boolean:
            self.validator.errors.append('ERROR: Expected boolean expression for if in line %s' % ctx.start.line)

        self.exit_scope()
        
    
    'OPERATIOONS'
    def visitRelationOp(self, ctx: DecafParser.RelationOpContext):
        self.validator.visit(ctx)
        return self.visitChildren(ctx)
    
    def visitConditionalOp(self, ctx: DecafParser.ConditionalOpContext):
        self.validator.visit(ctx)
        return self.visitChildren(ctx)
    
    def visitEqualityOp(self, ctx: DecafParser.EqualityOpContext):
        self.validator.visit(ctx)
        return self.visitChildren(ctx)
    
    def visitHigherArithOp(self, ctx: DecafParser.HigherArithOpContext):
        self.validator.visit(ctx)
        return self.visitChildren(ctx)
    
    def visitArithOp(self, ctx: DecafParser.ArithOpContext):
        self.validator.visit(ctx)
        return self.visitChildren(ctx)
    
    def visitAssigStmt(self, ctx: DecafParser.AssigStmtContext):
        self.validator.visit(ctx)
        return self.visitChildren(ctx)

    def visitInt_literal(self, ctx: DecafParser.Int_literalContext):
        self.validator.visit(ctx)
        return self.visitChildren(ctx)
    
    def visitBlock(self, ctx: DecafParser.BlockContext):
       return self.visitChildren(ctx)