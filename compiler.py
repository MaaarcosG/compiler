from Grammar.DecafParser import DecafParser
from Grammar.DecafLexer import DecafLexer
from create_tree import get_printer_tree
from antlr4 import *
from py_decaf import CustomVisitor
import sys

def main(argv):
    input = FileStream(argv[1])
    lexer = DecafLexer(input)
    stream = CommonTokenStream(lexer)
    parser = DecafParser(stream)
    tree = parser.program()
    visitor = CustomVisitor()
    visitor.visit(tree)   
    # obtenemos la informacion del archivo y lo mandamos para que se imprima el arbol
    data = str(argv[1])
    name = data.split('\\')[-1].split('.')[0]
    # creamos el arbol
    (view, _) = get_printer_tree(tree, name)
    view.view()

if __name__ == '__main__':
    main(sys.argv) 
