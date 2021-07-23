import sys
from antlr4 import *
from antlr4.tree.Trees import Trees
from DecafLexer import DecafLexer
from DecafParser import DecafParser
from DecafListener import DecafListener

def main(argv):
    # ejecutamos el lexer
    input = FileStream(argv[1])
    lexer = DecafLexer(input)

    # corremos el parser
    stream = CommonTokenStream(lexer)
    parser = DecafParser(stream)
    parser_tree = parser.program()

    walker = ParseTreeWalker()
    # printer = DecafPrintingListener()
    printer = DecafListener()
    walker.walk(printer, parser_tree)
    
    print(Trees.toStringTree(parser_tree, None, parser))

if __name__ == '__main__':
    main(sys.argv)