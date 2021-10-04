# Generated from Decaf.g4 by ANTLR 4.9.2
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .DecafParser import DecafParser
else:
    from DecafParser import DecafParser

# This class defines a complete listener for a parse tree produced by DecafParser.
class DecafListener(ParseTreeListener):

    # Enter a parse tree produced by DecafParser#program.
    def enterProgram(self, ctx:DecafParser.ProgramContext):
        pass

    # Exit a parse tree produced by DecafParser#program.
    def exitProgram(self, ctx:DecafParser.ProgramContext):
        pass


    # Enter a parse tree produced by DecafParser#declaration.
    def enterDeclaration(self, ctx:DecafParser.DeclarationContext):
        pass

    # Exit a parse tree produced by DecafParser#declaration.
    def exitDeclaration(self, ctx:DecafParser.DeclarationContext):
        pass


    # Enter a parse tree produced by DecafParser#single_VarDeclar.
    def enterSingle_VarDeclar(self, ctx:DecafParser.Single_VarDeclarContext):
        pass

    # Exit a parse tree produced by DecafParser#single_VarDeclar.
    def exitSingle_VarDeclar(self, ctx:DecafParser.Single_VarDeclarContext):
        pass


    # Enter a parse tree produced by DecafParser#list_VarDeclar.
    def enterList_VarDeclar(self, ctx:DecafParser.List_VarDeclarContext):
        pass

    # Exit a parse tree produced by DecafParser#list_VarDeclar.
    def exitList_VarDeclar(self, ctx:DecafParser.List_VarDeclarContext):
        pass


    # Enter a parse tree produced by DecafParser#struct_declar.
    def enterStruct_declar(self, ctx:DecafParser.Struct_declarContext):
        pass

    # Exit a parse tree produced by DecafParser#struct_declar.
    def exitStruct_declar(self, ctx:DecafParser.Struct_declarContext):
        pass


    # Enter a parse tree produced by DecafParser#var_type.
    def enterVar_type(self, ctx:DecafParser.Var_typeContext):
        pass

    # Exit a parse tree produced by DecafParser#var_type.
    def exitVar_type(self, ctx:DecafParser.Var_typeContext):
        pass


    # Enter a parse tree produced by DecafParser#method_declar.
    def enterMethod_declar(self, ctx:DecafParser.Method_declarContext):
        pass

    # Exit a parse tree produced by DecafParser#method_declar.
    def exitMethod_declar(self, ctx:DecafParser.Method_declarContext):
        pass


    # Enter a parse tree produced by DecafParser#method_type.
    def enterMethod_type(self, ctx:DecafParser.Method_typeContext):
        pass

    # Exit a parse tree produced by DecafParser#method_type.
    def exitMethod_type(self, ctx:DecafParser.Method_typeContext):
        pass


    # Enter a parse tree produced by DecafParser#parameter.
    def enterParameter(self, ctx:DecafParser.ParameterContext):
        pass

    # Exit a parse tree produced by DecafParser#parameter.
    def exitParameter(self, ctx:DecafParser.ParameterContext):
        pass


    # Enter a parse tree produced by DecafParser#parameter_type.
    def enterParameter_type(self, ctx:DecafParser.Parameter_typeContext):
        pass

    # Exit a parse tree produced by DecafParser#parameter_type.
    def exitParameter_type(self, ctx:DecafParser.Parameter_typeContext):
        pass


    # Enter a parse tree produced by DecafParser#block.
    def enterBlock(self, ctx:DecafParser.BlockContext):
        pass

    # Exit a parse tree produced by DecafParser#block.
    def exitBlock(self, ctx:DecafParser.BlockContext):
        pass


    # Enter a parse tree produced by DecafParser#ifStmt.
    def enterIfStmt(self, ctx:DecafParser.IfStmtContext):
        pass

    # Exit a parse tree produced by DecafParser#ifStmt.
    def exitIfStmt(self, ctx:DecafParser.IfStmtContext):
        pass


    # Enter a parse tree produced by DecafParser#whileStmt.
    def enterWhileStmt(self, ctx:DecafParser.WhileStmtContext):
        pass

    # Exit a parse tree produced by DecafParser#whileStmt.
    def exitWhileStmt(self, ctx:DecafParser.WhileStmtContext):
        pass


    # Enter a parse tree produced by DecafParser#returnStmt.
    def enterReturnStmt(self, ctx:DecafParser.ReturnStmtContext):
        pass

    # Exit a parse tree produced by DecafParser#returnStmt.
    def exitReturnStmt(self, ctx:DecafParser.ReturnStmtContext):
        pass


    # Enter a parse tree produced by DecafParser#methodCallStmt.
    def enterMethodCallStmt(self, ctx:DecafParser.MethodCallStmtContext):
        pass

    # Exit a parse tree produced by DecafParser#methodCallStmt.
    def exitMethodCallStmt(self, ctx:DecafParser.MethodCallStmtContext):
        pass


    # Enter a parse tree produced by DecafParser#blockStmt.
    def enterBlockStmt(self, ctx:DecafParser.BlockStmtContext):
        pass

    # Exit a parse tree produced by DecafParser#blockStmt.
    def exitBlockStmt(self, ctx:DecafParser.BlockStmtContext):
        pass


    # Enter a parse tree produced by DecafParser#assigStmt.
    def enterAssigStmt(self, ctx:DecafParser.AssigStmtContext):
        pass

    # Exit a parse tree produced by DecafParser#assigStmt.
    def exitAssigStmt(self, ctx:DecafParser.AssigStmtContext):
        pass


    # Enter a parse tree produced by DecafParser#expressionStmt.
    def enterExpressionStmt(self, ctx:DecafParser.ExpressionStmtContext):
        pass

    # Exit a parse tree produced by DecafParser#expressionStmt.
    def exitExpressionStmt(self, ctx:DecafParser.ExpressionStmtContext):
        pass


    # Enter a parse tree produced by DecafParser#location.
    def enterLocation(self, ctx:DecafParser.LocationContext):
        pass

    # Exit a parse tree produced by DecafParser#location.
    def exitLocation(self, ctx:DecafParser.LocationContext):
        pass


    # Enter a parse tree produced by DecafParser#negationExpression.
    def enterNegationExpression(self, ctx:DecafParser.NegationExpressionContext):
        pass

    # Exit a parse tree produced by DecafParser#negationExpression.
    def exitNegationExpression(self, ctx:DecafParser.NegationExpressionContext):
        pass


    # Enter a parse tree produced by DecafParser#relationOp.
    def enterRelationOp(self, ctx:DecafParser.RelationOpContext):
        pass

    # Exit a parse tree produced by DecafParser#relationOp.
    def exitRelationOp(self, ctx:DecafParser.RelationOpContext):
        pass


    # Enter a parse tree produced by DecafParser#conditionalOp.
    def enterConditionalOp(self, ctx:DecafParser.ConditionalOpContext):
        pass

    # Exit a parse tree produced by DecafParser#conditionalOp.
    def exitConditionalOp(self, ctx:DecafParser.ConditionalOpContext):
        pass


    # Enter a parse tree produced by DecafParser#negativeExpression.
    def enterNegativeExpression(self, ctx:DecafParser.NegativeExpressionContext):
        pass

    # Exit a parse tree produced by DecafParser#negativeExpression.
    def exitNegativeExpression(self, ctx:DecafParser.NegativeExpressionContext):
        pass


    # Enter a parse tree produced by DecafParser#equalityOp.
    def enterEqualityOp(self, ctx:DecafParser.EqualityOpContext):
        pass

    # Exit a parse tree produced by DecafParser#equalityOp.
    def exitEqualityOp(self, ctx:DecafParser.EqualityOpContext):
        pass


    # Enter a parse tree produced by DecafParser#methodCallExpression.
    def enterMethodCallExpression(self, ctx:DecafParser.MethodCallExpressionContext):
        pass

    # Exit a parse tree produced by DecafParser#methodCallExpression.
    def exitMethodCallExpression(self, ctx:DecafParser.MethodCallExpressionContext):
        pass


    # Enter a parse tree produced by DecafParser#locationExpression.
    def enterLocationExpression(self, ctx:DecafParser.LocationExpressionContext):
        pass

    # Exit a parse tree produced by DecafParser#locationExpression.
    def exitLocationExpression(self, ctx:DecafParser.LocationExpressionContext):
        pass


    # Enter a parse tree produced by DecafParser#literalExpression.
    def enterLiteralExpression(self, ctx:DecafParser.LiteralExpressionContext):
        pass

    # Exit a parse tree produced by DecafParser#literalExpression.
    def exitLiteralExpression(self, ctx:DecafParser.LiteralExpressionContext):
        pass


    # Enter a parse tree produced by DecafParser#higherArithOp.
    def enterHigherArithOp(self, ctx:DecafParser.HigherArithOpContext):
        pass

    # Exit a parse tree produced by DecafParser#higherArithOp.
    def exitHigherArithOp(self, ctx:DecafParser.HigherArithOpContext):
        pass


    # Enter a parse tree produced by DecafParser#parentExpression.
    def enterParentExpression(self, ctx:DecafParser.ParentExpressionContext):
        pass

    # Exit a parse tree produced by DecafParser#parentExpression.
    def exitParentExpression(self, ctx:DecafParser.ParentExpressionContext):
        pass


    # Enter a parse tree produced by DecafParser#arithOp.
    def enterArithOp(self, ctx:DecafParser.ArithOpContext):
        pass

    # Exit a parse tree produced by DecafParser#arithOp.
    def exitArithOp(self, ctx:DecafParser.ArithOpContext):
        pass


    # Enter a parse tree produced by DecafParser#method_call.
    def enterMethod_call(self, ctx:DecafParser.Method_callContext):
        pass

    # Exit a parse tree produced by DecafParser#method_call.
    def exitMethod_call(self, ctx:DecafParser.Method_callContext):
        pass


    # Enter a parse tree produced by DecafParser#arg.
    def enterArg(self, ctx:DecafParser.ArgContext):
        pass

    # Exit a parse tree produced by DecafParser#arg.
    def exitArg(self, ctx:DecafParser.ArgContext):
        pass


    # Enter a parse tree produced by DecafParser#higher_arith_op.
    def enterHigher_arith_op(self, ctx:DecafParser.Higher_arith_opContext):
        pass

    # Exit a parse tree produced by DecafParser#higher_arith_op.
    def exitHigher_arith_op(self, ctx:DecafParser.Higher_arith_opContext):
        pass


    # Enter a parse tree produced by DecafParser#arith_op.
    def enterArith_op(self, ctx:DecafParser.Arith_opContext):
        pass

    # Exit a parse tree produced by DecafParser#arith_op.
    def exitArith_op(self, ctx:DecafParser.Arith_opContext):
        pass


    # Enter a parse tree produced by DecafParser#rel_op.
    def enterRel_op(self, ctx:DecafParser.Rel_opContext):
        pass

    # Exit a parse tree produced by DecafParser#rel_op.
    def exitRel_op(self, ctx:DecafParser.Rel_opContext):
        pass


    # Enter a parse tree produced by DecafParser#eq_op.
    def enterEq_op(self, ctx:DecafParser.Eq_opContext):
        pass

    # Exit a parse tree produced by DecafParser#eq_op.
    def exitEq_op(self, ctx:DecafParser.Eq_opContext):
        pass


    # Enter a parse tree produced by DecafParser#cond_op.
    def enterCond_op(self, ctx:DecafParser.Cond_opContext):
        pass

    # Exit a parse tree produced by DecafParser#cond_op.
    def exitCond_op(self, ctx:DecafParser.Cond_opContext):
        pass


    # Enter a parse tree produced by DecafParser#literal.
    def enterLiteral(self, ctx:DecafParser.LiteralContext):
        pass

    # Exit a parse tree produced by DecafParser#literal.
    def exitLiteral(self, ctx:DecafParser.LiteralContext):
        pass


    # Enter a parse tree produced by DecafParser#int_literal.
    def enterInt_literal(self, ctx:DecafParser.Int_literalContext):
        pass

    # Exit a parse tree produced by DecafParser#int_literal.
    def exitInt_literal(self, ctx:DecafParser.Int_literalContext):
        pass


    # Enter a parse tree produced by DecafParser#char_literal.
    def enterChar_literal(self, ctx:DecafParser.Char_literalContext):
        pass

    # Exit a parse tree produced by DecafParser#char_literal.
    def exitChar_literal(self, ctx:DecafParser.Char_literalContext):
        pass


    # Enter a parse tree produced by DecafParser#bool_literal.
    def enterBool_literal(self, ctx:DecafParser.Bool_literalContext):
        pass

    # Exit a parse tree produced by DecafParser#bool_literal.
    def exitBool_literal(self, ctx:DecafParser.Bool_literalContext):
        pass



del DecafParser