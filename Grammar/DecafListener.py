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


    # Enter a parse tree produced by DecafParser#struct_declar.
    def enterStruct_declar(self, ctx:DecafParser.Struct_declarContext):
        pass

    # Exit a parse tree produced by DecafParser#struct_declar.
    def exitStruct_declar(self, ctx:DecafParser.Struct_declarContext):
        pass


    # Enter a parse tree produced by DecafParser#var_declar.
    def enterVar_declar(self, ctx:DecafParser.Var_declarContext):
        pass

    # Exit a parse tree produced by DecafParser#var_declar.
    def exitVar_declar(self, ctx:DecafParser.Var_declarContext):
        pass


    # Enter a parse tree produced by DecafParser#structInstantiation.
    def enterStructInstantiation(self, ctx:DecafParser.StructInstantiationContext):
        pass

    # Exit a parse tree produced by DecafParser#structInstantiation.
    def exitStructInstantiation(self, ctx:DecafParser.StructInstantiationContext):
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


    # Enter a parse tree produced by DecafParser#statement.
    def enterStatement(self, ctx:DecafParser.StatementContext):
        pass

    # Exit a parse tree produced by DecafParser#statement.
    def exitStatement(self, ctx:DecafParser.StatementContext):
        pass


    # Enter a parse tree produced by DecafParser#location.
    def enterLocation(self, ctx:DecafParser.LocationContext):
        pass

    # Exit a parse tree produced by DecafParser#location.
    def exitLocation(self, ctx:DecafParser.LocationContext):
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


    # Enter a parse tree produced by DecafParser#relationOp.
    def enterRelationOp(self, ctx:DecafParser.RelationOpContext):
        pass

    # Exit a parse tree produced by DecafParser#relationOp.
    def exitRelationOp(self, ctx:DecafParser.RelationOpContext):
        pass


    # Enter a parse tree produced by DecafParser#methodCallExpr.
    def enterMethodCallExpr(self, ctx:DecafParser.MethodCallExprContext):
        pass

    # Exit a parse tree produced by DecafParser#methodCallExpr.
    def exitMethodCallExpr(self, ctx:DecafParser.MethodCallExprContext):
        pass


    # Enter a parse tree produced by DecafParser#conditionalOp.
    def enterConditionalOp(self, ctx:DecafParser.ConditionalOpContext):
        pass

    # Exit a parse tree produced by DecafParser#conditionalOp.
    def exitConditionalOp(self, ctx:DecafParser.ConditionalOpContext):
        pass


    # Enter a parse tree produced by DecafParser#negationExpr.
    def enterNegationExpr(self, ctx:DecafParser.NegationExprContext):
        pass

    # Exit a parse tree produced by DecafParser#negationExpr.
    def exitNegationExpr(self, ctx:DecafParser.NegationExprContext):
        pass


    # Enter a parse tree produced by DecafParser#locationExpr.
    def enterLocationExpr(self, ctx:DecafParser.LocationExprContext):
        pass

    # Exit a parse tree produced by DecafParser#locationExpr.
    def exitLocationExpr(self, ctx:DecafParser.LocationExprContext):
        pass


    # Enter a parse tree produced by DecafParser#equalityOp.
    def enterEqualityOp(self, ctx:DecafParser.EqualityOpContext):
        pass

    # Exit a parse tree produced by DecafParser#equalityOp.
    def exitEqualityOp(self, ctx:DecafParser.EqualityOpContext):
        pass


    # Enter a parse tree produced by DecafParser#literalExpr.
    def enterLiteralExpr(self, ctx:DecafParser.LiteralExprContext):
        pass

    # Exit a parse tree produced by DecafParser#literalExpr.
    def exitLiteralExpr(self, ctx:DecafParser.LiteralExprContext):
        pass


    # Enter a parse tree produced by DecafParser#negativeExpr.
    def enterNegativeExpr(self, ctx:DecafParser.NegativeExprContext):
        pass

    # Exit a parse tree produced by DecafParser#negativeExpr.
    def exitNegativeExpr(self, ctx:DecafParser.NegativeExprContext):
        pass


    # Enter a parse tree produced by DecafParser#parentExpr.
    def enterParentExpr(self, ctx:DecafParser.ParentExprContext):
        pass

    # Exit a parse tree produced by DecafParser#parentExpr.
    def exitParentExpr(self, ctx:DecafParser.ParentExprContext):
        pass


    # Enter a parse tree produced by DecafParser#higherArithOp.
    def enterHigherArithOp(self, ctx:DecafParser.HigherArithOpContext):
        pass

    # Exit a parse tree produced by DecafParser#higherArithOp.
    def exitHigherArithOp(self, ctx:DecafParser.HigherArithOpContext):
        pass


    # Enter a parse tree produced by DecafParser#arithOp.
    def enterArithOp(self, ctx:DecafParser.ArithOpContext):
        pass

    # Exit a parse tree produced by DecafParser#arithOp.
    def exitArithOp(self, ctx:DecafParser.ArithOpContext):
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