import sys
from antlr4 import *
from antlr4.tree.Trees import Trees
from DecafLexer import DecafLexer
from DecafParser import DecafParser
from DecafListener import DecafListener

class DecafPrintingListener(DecafListener):
    def __init__(self):
        self.indent = 0

    def enterProgram(self, ctx: DecafParser.ProgramContext):
        print('Program')

    def enterBlock(self, ctx: DecafParser.BlockContext):
        print(f'{" " * self.indent} block')
        self.indent += 2

    def exitBlock(self, ctx: DecafParser.BlockContext):
        self.indent -= 2

    def enterDeclaration(self, ctx: DecafParser.DeclarationContext):
        print(f'{" " * self.indent} Declaration')

    def enterVarDeclaration(self, ctx: DecafParser.VarDeclarationContext):
        print(f'{" " * self.indent} varDeclaration')

    def enterStructDeclaration(self, ctx: DecafParser.StructDeclarationContext):
        print(f'{" " * self.indent} structDeclaration')

    def enterVarType(self, ctx: DecafParser.VarTypeContext):
        print(f'{" " * self.indent} varType')

    def enterMethodDeclaration(self, ctx: DecafParser.MethodDeclarationContext):
        print(f'{" " * self.indent} methodDeclaration')

    def enterMethodType(self, ctx: DecafParser.MethodTypeContext):
        print(f'{" " * self.indent} methodType')

    def enterParameter(self, ctx: DecafParser.ParameterContext):
        print(f'{" " * self.indent} parameter')

    def enterParameterType(self, ctx: DecafParser.ParameterTypeContext):
        print(f'{" " * self.indent} parameterType')

    def enterStatement(self, ctx: DecafParser.StatementContext):
        print(f'{" " * self.indent} statement')

    def enterLocation(self, ctx: DecafParser.LocationContext):
        print(f'{" " * self.indent} location')

    def enterExpression(self, ctx: DecafParser.ExpressionContext):
        print(f'{" " * self.indent} expression')

    def enterMethodCall(self, ctx: DecafParser.MethodCallContext):
        print(f'{" " * self.indent} methodCall')

    def enterArg(self, ctx: DecafParser.ArgContext):
        print(f'{" " * self.indent} arg')

    def enterOp(self, ctx: DecafParser.OpContext):
        print(f'{" " * self.indent} op')

def main(argv):
    # ejecutamos el lexer
    input = FileStream(argv[1])
    lexer = DecafLexer(input)

    # corremos el parser
    stream = CommonTokenStream(lexer)
    parser = DecafParser(stream)
    parser_tree = parser.program()

    walker = ParseTreeWalker()
    printer = DecafPrintingListener()
    walker.walk(printer, parser_tree)
    
    print(Trees.toStringTree(parser_tree, None, parser))

if __name__ == '__main__':
    main(sys.argv)