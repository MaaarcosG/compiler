from os import error
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
        scope = self.scopes.peek()
        method = scope.t_exist(methodName, 'method')

        if not method:
            error = not_defined('method', methodName, ctx.start.line)
            self.errors.append(error) # anadimos el error
            return Type_Enum.Error
        
        # lista de valores
        value = []
        # lista de parametros encontrados
        params = [i.stype for i in method.paramlist.values()]

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
    
    def visitAssigStmt(self, ctx: DecafParser.AssigStmtContext):
        # datos para los arboles 
        ltype = self.visit(ctx.left)
        rtype = self.visit(ctx.right)

        if rtype != ltype:
            error = generic('Can only assing to two expressions with the same type ---> left = %s right = %s ' % (ctx.left.getText(), ctx.right.getText()), ctx.start.line)
            self.errors.append(error)
            return Type_Enum.Error
        return Type_Enum.Error
    
    def visitLocation(self, ctx: DecafParser.LocationContext):
        # return self.visitChildren(ctx)
        name = ctx.name.text
        scope = self.scopes.peek()
        data = scope.search(name)
        value = Type_Enum.Error

        # verificamos los datos
        if not data:
            error = not_defined('variable', name, ctx.start.line)
            self.errors.append(error)
            return Type_Enum.Error

        value = data.stype

        if ctx.expr:
            if not data.listSize:
                error = generic('Symbol of type %s is non suscriptable' % data.stype, ctx.start.line)
                self.errors.append(error)
                return Type_Enum.Error
        
            # numeros de expresiones
            numExpr = ctx.expr.getText()
            try:
                number = int(numExpr)
                # el numero tiene que ser mayor a 0
                if (number<0) or (number>data.listSize -1):
                    error = generic('Index out of range', ctx.start.line)
                    self.errors.append(error)
                    return Type_Enum.Error
            except ValueError:
                pass

            visit = self.visit(ctx.expr)
            if (visit != Type_Enum.Integer):
                error = generic('Index must be an INTEGER', ctx.start.line)
                self.errors.append(error)
                return Type_Enum.Error

        if ctx.loc:
            struct = scope.t_exist(data.stype, Type_Enum.Struct)
            # si no esta dentro del struct
            if not struct:
                error = generic('Location passed but %s is not a struct' % name, ctx.start.line)
                self.errors.append(error)
                return Type_Enum.Error

            # la lista esta saliendo vacia revisar porque print(struct.paramlist)

            # print(struct.paramlist)
            if ctx.loc.name.text not in struct.paramlist:
                error = generic('Location %s not defined in struct of %s of type %s' % (ctx.loc.name.text, name, data.stype), ctx.start.line)
                self.errors.append(error)
                return Type_Enum.Error
            
            value = struct.paramlist[ctx.loc.name.text].stype
            # print(value)
        return value
       
    '''OPERACIONES'''
    
    def visitRelationOp(self, ctx: DecafParser.RelationOpContext):
        opera = ctx.op.getText()

        ltype = self.visit(ctx.left)
        rtype = self.visit(ctx.right)

        if (rtype != Type_Enum.Integer) or (ltype != Type_Enum.Integer):
            error = expect_error(Type_Enum.Integer, '%s, %s' % (ltype, rtype), ctx.start.line)
            self.errors.append(error)
            return Type_Enum.Error

        return Type_Enum.Boolean
    
    def visitConditionalOp(self, ctx: DecafParser.ConditionalOpContext):
        opera = ctx.op.getText()

        ltype = self.visit(ctx.left)
        rtype = self.visit(ctx.right)

        if (rtype != Type_Enum.Integer) or (ltype != Type_Enum.Integer):
            error = expect_error(Type_Enum.Boolean, '%s, %s' % (ltype, rtype), ctx.start.line)
            self.errors.append(error)
            return Type_Enum.Error

        return Type_Enum.Boolean
    
    def visitEqualityOp(self, ctx: DecafParser.EqualityOpContext):
        opera = ctx.op.getText()
        ltype = self.visit(ctx.left)
        rtype = self.visit(ctx.right)

        if rtype != ltype:
            error = generic('Can only apply %s to two expressions with the same type' % opera, ctx.start.line)
            self.errors.append(error)
            return Type_Enum.Error
        
        return Type_Enum.Boolean
    
    def visitHigherArithOp(self, ctx: DecafParser.HigherArithOpContext):
        opera = ctx.op.getText()
        ltype = self.visit(ctx.left)
        rtype = self.visit(ctx.right)
        '''
        print(ltype)
        print(ctx.right.getText())
        '''
        if (rtype != Type_Enum.Integer) or (ltype != Type_Enum.Integer):
            error = expect_error(Type_Enum.Boolean, '%s %s %s' % (ltype, opera, rtype), ctx.start.line)
            self.errors.append(error)
            return Type_Enum.Error

        return Type_Enum.Integer
    
    def visitArithOp(self, ctx: DecafParser.ArithOpContext):
        opera = ctx.op.getText()
        ltype = self.visit(ctx.left)
        rtype = self.visit(ctx.right)

        if (rtype != Type_Enum.Integer) or (ltype != Type_Enum.Integer):
            error = expect_error(Type_Enum.Integer, '%s %s %s' % (ltype, opera, rtype), ctx.start.line)
            self.errors.append(error)
            return Type_Enum.Error

        return Type_Enum.Integer