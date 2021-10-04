from os import name
from Grammar.DecafParser import DecafParser
from Grammar.DecafLexer import DecafLexer
from create_tree import get_printer_tree
from antlr4 import *
from decaf_function import CustomVisitor
from decaf_errors import printer
import sys

def compiler_gui(text):
    input = InputStream(text)
    lexer = DecafLexer(input)
    stream = CommonTokenStream(lexer)
    parser = DecafParser(stream)
    tree = parser.program()

    visitor = CustomVisitor()
    visitor.visit(tree) 

    name = 'gui'
    # creamos el arbol
    (view, _) = get_printer_tree(tree, name)
    view.render('tree_'+name+'.gv', './Interfaz/Static/img')

    return visitor

def main(argv):
    input = FileStream(argv[1])
    lexer = DecafLexer(input)
    stream = CommonTokenStream(lexer)
    parser = DecafParser(stream)
    tree = parser.program()
    visitor = CustomVisitor()
    visitor.visit(tree)   
    # print(visitor.scope.peek().id)
    # printer(visitor.validator.errors)

    # obtenemos la informacion del archivo y lo mandamos para que se imprima el arbol
    data = str(argv[1])
    name = data.split('\\')[-1].split('.')[0]
    
    '''
    # creamos el arbol
    (view, _) = get_printer_tree(tree, name)
    view.view()
    '''
    
if __name__ == '__main__':
    main(sys.argv) 
