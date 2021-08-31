from typing import Type
from Grammar.DecafVisitor import DecafVisitor
from Grammar.DecafParser import DecafParser
# librery create
from symbol_table import Type_Enum
from decaf_errors import generic, expect_error, not_defined

class Evaluator(DecafVisitor):
    def __init__(self, scopes):
        self.scopes = scopes
        # list of errors save
        self.errors = []

    ''' TIPOS DE DATOS --> Tomamos los tipos de datos, de la tabla de simbolo'''
        
    def visitInt_literal(self, ctx: DecafParser.Int_literalContext):
        self.visitChildren(ctx)
        return Type_Enum.Integer
    
    def visitChar_literal(self, ctx: DecafParser.Char_literalContext):
        self.visitChildren(ctx)
        return Type_Enum.Char
    
    def visitBool_literal(self, ctx: DecafParser.Bool_literalContext):
        self.visitChildren(ctx)
        return Type_Enum.Boolean
    
    '''EXPRESIONNS'''

    def visitMethod_call(self, ctx: DecafParser.Method_callContext):
        methodName = str(ctx.ID())
        scope = self.scope.peek()
        method = scope.t_exist(methodName, 'method')
        # lista de valores
        value = []
        # lista de parametros encontrados
        params = [i.stype for i in method.paramlist]

        if not method:
            error = not_defined('method', methodName, ctx.start.line)
            self.errors.append(error) # anadimos el error
            return Type_Enum.Error
        
        # recorremos los argumentos posibles
        for i in ctx.arg():
            value.append(self.visitArg(i))

        # verificamos que los value no se encuentren en los parametros
        if params != value:
            error = expect_error(params, value, ctx.start.line)
            self.errors.append(error)
            return Type_Enum.Error
        
        return method.ret
    
    def visitArg(self, ctx: DecafParser.ArgContext):
        return self.visitChildren(ctx)

    # expression boolean
    def visitNegationExpression(self, ctx: DecafParser.NegationExpressionContext):
        data = self.visit(ctx.expression())
        # si encuentra boolean
        if data != Type_Enum.Boolean:
            error = generic('Only negate boolean expression', ctx.start.line)
            self.errors.append(error)
            return Type_Enum.Error
        return Type_Enum.Boolean
    
    def visitNegativeExpression(self, ctx: DecafParser.NegativeExpressionContext):
        data = self.visit(ctx.expression())
        # si encuentra boolean
        if data != Type_Enum.Integer:
            error = generic('Only negate integer expression', ctx.start.line)
            self.errors.append(error)
            return Type_Enum.Error
        return Type_Enum.Integer
    
    def visitLocationExpression(self, ctx: DecafParser.LocationExpressionContext):
        return self.visitChildren(ctx)
    
    '''OPERACIONES'''
    
    def visitRelationOp(self, ctx: DecafParser.RelationOpContext):
        return self.visitChildren(ctx)
    
    def visitConditionalOp(self, ctx: DecafParser.ConditionalOpContext):
        return self.visitChildren(ctx)
    
    def visitEqualityOp(self, ctx: DecafParser.EqualityOpContext):
        return self.visitChildren(ctx)
    
    def visitHigherArithOp(self, ctx: DecafParser.HigherArithOpContext):
        return self.visitChildren(ctx)
    
    def visitArith_op(self, ctx: DecafParser.Arith_opContext):
        return self.visitChildren(ctx)