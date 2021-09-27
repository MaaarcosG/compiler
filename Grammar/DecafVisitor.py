# Generated from Decaf.g4 by ANTLR 4.9.2
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .DecafParser import DecafParser
else:
    from DecafParser import DecafParser

# This class defines a complete generic visitor for a parse tree produced by DecafParser.

class DecafVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by DecafParser#program.
    def visitProgram(self, ctx:DecafParser.ProgramContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#declaration.
    def visitDeclaration(self, ctx:DecafParser.DeclarationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#single_VarDeclar.
    def visitSingle_VarDeclar(self, ctx:DecafParser.Single_VarDeclarContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#list_VarDeclar.
    def visitList_VarDeclar(self, ctx:DecafParser.List_VarDeclarContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#struct_declar.
    def visitStruct_declar(self, ctx:DecafParser.Struct_declarContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#var_type.
    def visitVar_type(self, ctx:DecafParser.Var_typeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#method_declar.
    def visitMethod_declar(self, ctx:DecafParser.Method_declarContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#method_type.
    def visitMethod_type(self, ctx:DecafParser.Method_typeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#parameter.
    def visitParameter(self, ctx:DecafParser.ParameterContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#parameter_type.
    def visitParameter_type(self, ctx:DecafParser.Parameter_typeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#block.
    def visitBlock(self, ctx:DecafParser.BlockContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#if_Scope.
    def visitIf_Scope(self, ctx:DecafParser.If_ScopeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#while_Scope.
    def visitWhile_Scope(self, ctx:DecafParser.While_ScopeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#stmnt_return.
    def visitStmnt_return(self, ctx:DecafParser.Stmnt_returnContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#stmnt_methodCall.
    def visitStmnt_methodCall(self, ctx:DecafParser.Stmnt_methodCallContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#stmnt_block.
    def visitStmnt_block(self, ctx:DecafParser.Stmnt_blockContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#stmnt_equal.
    def visitStmnt_equal(self, ctx:DecafParser.Stmnt_equalContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#stmnt_expression.
    def visitStmnt_expression(self, ctx:DecafParser.Stmnt_expressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#location.
    def visitLocation(self, ctx:DecafParser.LocationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#negationExpression.
    def visitNegationExpression(self, ctx:DecafParser.NegationExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#relationOp.
    def visitRelationOp(self, ctx:DecafParser.RelationOpContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#conditionalOp.
    def visitConditionalOp(self, ctx:DecafParser.ConditionalOpContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#negativeExpression.
    def visitNegativeExpression(self, ctx:DecafParser.NegativeExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#equalityOp.
    def visitEqualityOp(self, ctx:DecafParser.EqualityOpContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#methodCallExpression.
    def visitMethodCallExpression(self, ctx:DecafParser.MethodCallExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#locationExpression.
    def visitLocationExpression(self, ctx:DecafParser.LocationExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#literalExpression.
    def visitLiteralExpression(self, ctx:DecafParser.LiteralExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#higherArithOp.
    def visitHigherArithOp(self, ctx:DecafParser.HigherArithOpContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#parentExpression.
    def visitParentExpression(self, ctx:DecafParser.ParentExpressionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#arithOp.
    def visitArithOp(self, ctx:DecafParser.ArithOpContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#method_call.
    def visitMethod_call(self, ctx:DecafParser.Method_callContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#arg.
    def visitArg(self, ctx:DecafParser.ArgContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#higher_arith_op.
    def visitHigher_arith_op(self, ctx:DecafParser.Higher_arith_opContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#arith_op.
    def visitArith_op(self, ctx:DecafParser.Arith_opContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#rel_op.
    def visitRel_op(self, ctx:DecafParser.Rel_opContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#eq_op.
    def visitEq_op(self, ctx:DecafParser.Eq_opContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#cond_op.
    def visitCond_op(self, ctx:DecafParser.Cond_opContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#literal.
    def visitLiteral(self, ctx:DecafParser.LiteralContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#int_literal.
    def visitInt_literal(self, ctx:DecafParser.Int_literalContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#char_literal.
    def visitChar_literal(self, ctx:DecafParser.Char_literalContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by DecafParser#bool_literal.
    def visitBool_literal(self, ctx:DecafParser.Bool_literalContext):
        return self.visitChildren(ctx)



del DecafParser