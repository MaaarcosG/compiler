from os import error
from typing import Type
from Grammar.DecafVisitor import DecafVisitor
from Grammar.DecafParser import DecafParser
# librery create
from decaf_errors import generic, expect_error, not_defined

class Evaluator(DecafVisitor):
    def __init__(self, scopes):
        self.scopes = scopes
        # list of errors save
        self.error = []

    ''' TIPOS DE DATOS --> Tomamos los tipos de datos, de la tabla de simbolo'''
    
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
            error = expect_error(data, 'boolean', ctx.start.line)
            self.error.append(error)
    
    def visitNegativeExpression(self, ctx: DecafParser.NegativeExpressionContext):
        data = self.visit(ctx.expression())
        return data

    def visitAssigStmt(self, ctx: DecafParser.AssigStmtContext):
        left = self.visit(ctx.left)
        right = self.visit(ctx.right)
        if left == None:
            error = generic("%s is None" % ctx.left.getText(), ctx.start.line)
            self.error.append(error)
        elif right == None:
            error = generic("%s is None" % ctx.left.getText(), ctx.start.line)
            self.error.append(error)
        elif left != right:
            error = generic("%s expected %s found %s of type %s instead " % (ctx.left.getText(), left, ctx.right.getText(), right), ctx.start.line)
            self.error.append(error)
        return None
    
    def visitLocation(self, ctx: DecafParser.LocationContext, parent=None):
        name  = ctx.ID().getText()
        if ctx.expression() != None:
            data = self.visit(ctx.expression())
            if data != "int":
                error = generic("Expected int got %s of type %s" % (ctx.expression(), data), ctx.start.line)
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
                        error = generic("%s has no subattributes" % name, ctx.start.line)
                        self.error.append(error)
        return None
    
    '''OPERATION'''
    
    def visitHigherArithOp(self, ctx: DecafParser.HigherArithOpContext):
        ltype = self.visit(ctx.left)
        rtype = self.visit(ctx.right)
        
        if (rtype == 'int') and (ltype == 'int'):
            return 'int'
        elif (ltype == None):
            error = generic('%s is None left data' % ctx.left.getText(), ctx.start.line)
            self.error.append(error)
        elif (rtype == None):
            error = generic('%s is None right data' % ctx.right.getText(), ctx.start.line)
            self.error.append(error)
        else:
            error = expect_error(ltype, rtype, ctx.start.line)
            self.error.append(error)
    
    def visitArithOp(self, ctx: DecafParser.ArithOpContext):
        ltype = self.visit(ctx.left)
        rtype = self.visit(ctx.right)
        
        if (rtype == 'int') and (ltype == 'int'):
            return 'int'
        elif (ltype == None):
            error = generic('%s is None left data' % ctx.left.getText(), ctx.start.line)
            self.error.append(error)
        elif (rtype == None):
            error = generic('%s is None right data' % ctx.right.getText(), ctx.start.line)
            self.error.append(error)
        else:
            error = expect_error(ltype, rtype, ctx.start.line)
            self.error.append(error)
    
    def visitRelationOp(self, ctx: DecafParser.RelationOpContext):
        ltype = self.visit(ctx.left)
        rtype = self.visit(ctx.right)
        
        if (rtype == 'int') and (ltype == 'int'):
            return 'boolean'
        elif (ltype == None):
            error = generic('%s is None left data' % ctx.left.getText(), ctx.start.line)
            self.error.append(error)
        elif (rtype == None):
            error = generic('%s is None right data' % ctx.right.getText(), ctx.start.line)
            self.error.append(error)
        else:
            error = expect_error(ltype, rtype, ctx.start.line)
            self.error.append(error)
    
    def visitEqualityOp(self, ctx: DecafParser.EqualityOpContext):
        ltype = self.visit(ctx.left)
        rtype = self.visit(ctx.right)
        
        if (rtype == ltype):
            return 'boolean'
        elif (ltype == None):
            error = generic('%s is None left data' % ctx.left.getText(), ctx.start.line)
            self.error.append(error)
        elif (rtype == None):
            error = generic('%s is None right data' % ctx.right.getText(), ctx.start.line)
            self.error.append(error)
        else:
            error = expect_error(ltype, rtype, ctx.start.line)
            self.error.append(error)
    
    def visitConditionalOp(self, ctx: DecafParser.ConditionalOpContext):
        ltype = self.visit(ctx.left)
        rtype = self.visit(ctx.right)
        
        if (rtype == 'boolean') and (ltype == 'boolean'):
            return 'boolean'
        elif (ltype == None):
            error = generic('%s is None left data' % ctx.left.getText(), ctx.start.line)
            self.error.append(error)
        elif (rtype == None):
            error = generic('%s is None right data' % ctx.right.getText(), ctx.start.line)
            self.error.append(error)
        else:
            error = expect_error(ltype, rtype, ctx.start.line)
            self.error.append(error)
    
    def visitParentExpression(self, ctx: DecafParser.ParentExpressionContext):
        data = self.visit(ctx.expression())
        return data
