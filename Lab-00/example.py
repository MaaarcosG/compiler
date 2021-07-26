import os
import re
import sys
from antlr4 import * 
from antlr4.tree.Trees import Trees
from DecafLexer import DecafLexer
from DecafParser import DecafParser
from DecafVisitor import DecafVisitor

os.system("java -Xmx500M -cp antlr4.jar org.antlr.v4.Tool -Dlanguage=Python3 Decaf.g4 -visitor")

class Parser_Tree(DecafVisitor):
    def __init__(self):
        super().__init__()
        self.text = ""

    def print_node_tree(self, ctx):
        self.text = self.text + '{\"name\": \"' + parser.ruleNames[ctx.getRuleIndex()] + '\",' + '\"value\":2,' + '\"children\":['
        self.visitChildren(ctx)
        self.text = self.text + ']},'

    def visitTerminal(self, ctx):
        self.text = self.text + '{\"name\": \"' + ctx.getText().replace('\\', '\\\\').replace('\"', '\\\"') + '\"},'

    # Visit a parse tree produced by DecafParser#program.
    def visitProgram(self, ctx:DecafParser.ProgramContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#vardeclr.
    def visitVardeclr(self, ctx:DecafParser.Var_declarContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#field_declr.
    def visitField_declr(self, ctx:DecafParser.Field_declarContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#array_id.
    def visitArray_id(self, ctx:DecafParser.Array_idContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#field_var.
    def visitField_var(self, ctx:DecafParser.Field_varContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#var_id.
    def visitVar_id(self, ctx:DecafParser.Var_idContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#method_declr.
    def visitMethod_declr(self, ctx:DecafParser.Method_declarContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#return_type.
    def visitReturn_type(self, ctx:DecafParser.Return_typeContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#block.
    def visitBlock(self, ctx:DecafParser.BlockContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#statement.
    def visitStatement(self, ctx:DecafParser.StatementContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#method_call_inter.
    def visitMethod_call_inter(self, ctx:DecafParser.Method_call_interContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#method_call.
    def visitMethod_call(self, ctx:DecafParser.Method_callContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#expr.
    def visitExpr(self, ctx:DecafParser.ExprContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#location.
    def visitLocation(self, ctx:DecafParser.LocationContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#callout_arg.
    def visitCallout_arg(self, ctx:DecafParser.Callout_argContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#int_literal.
    def visitInt_literal(self, ctx:DecafParser.Int_literalContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#rel_op.
    def visitRel_op(self, ctx:DecafParser.Rel_opContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#eq_op.
    def visitEq_op(self, ctx:DecafParser.Eq_opContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#cond_op.
    def visitCond_op(self, ctx:DecafParser.Cond_opContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#literal.
    def visitLiteral(self, ctx:DecafParser.LiteralContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#bin_op.
    def visitBin_op(self, ctx:DecafParser.Bin_opContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#arith_op.
    def visitArith_op(self, ctx:DecafParser.Arith_opContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#var_type.
    def visitVar_type(self, ctx:DecafParser.Var_typeContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#assign_op.
    def visitAssign_op(self, ctx:DecafParser.Assign_opContext):
        return self.print_node_tree(ctx)


    # Visit a parse tree produced by DecafParser#method_name.
    def visitMethod_name(self, ctx:DecafParser.Method_nameContext):
        return self.print_node_tree(ctx)

# path de archivo
test = os.path.join(os.getcwd(), "tests", "parser")

# path del archivo a probar
filename = input("Ingrese el path del archivo a probar: \n")
test_case_path = os.path.join(test, filename)

# abrimos el archivo a probar
filename = open(test_case_path, 'r')
input_read = filename.read()


lexer = DecafLexer(InputStream(input_read))
stream = CommonTokenStream(lexer)
parser = DecafParser(stream)
parser_tree = parser.program()

visitor = Parser_Tree()
visitor.visit(parser_tree)
print("\n")
print(Trees.toStringTree(parser_tree, None, parser))

parser_tree_graph = open("parser_tree.html", 'r')
parser_tree_graph_text = parser_tree_graph.read()
parser_tree_graph.close()

# funciones para mandar el codigo al html
match = re.compile('(// tree data start)(.*)(// tree data end)', re.DOTALL)
    
parser_tree_graph = open("parser_tree.html", 'w')
# mandamos el dato del arbol para que escriba automaticamente
new_data = "// tree data start\n var treeData = [" + visitor.text + "\n]\n// tree data end"
new_code = match.sub(new_data, parser_tree_graph_text)

# escribimos el codigo para graficarlo en html
parser_tree_graph.write(new_code)
parser_tree_graph.close()

