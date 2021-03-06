from os import error, name
from Grammar.DecafParser import DecafParser
from Grammar.DecafLexer import DecafLexer
from create_tree import get_printer_tree
from antlr4 import *
from decaf_function import CustomVisitor
from decaf_errors import printer
from intermediate_code import Intermediate
from symbol_table import print_code
import sys

from arm import code_generate

def compiler_gui(text):
    input = InputStream(text)
    lexer = DecafLexer(input)
    stream = CommonTokenStream(lexer)
    parser = DecafParser(stream)
    tree = parser.program()

    visitor = CustomVisitor()
    visitor.visit(tree) 

    # jalamos la informacion de la clase Intermediate creada
    intermediate = Intermediate(visitor.total)
    intermediate.visit(tree)
    ic = intermediate.code

    name = 'gui'
    # creamos el arbol
    (view, _) = get_printer_tree(tree, name)
    view.render('tree_'+name+'.gv', './Interfaz/Static/img')

    return visitor, ic

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
    
    # jalamos la informacion de la clase Intermediate creada
    intermediate = Intermediate(visitor.total)
    intermediate.visit(tree)
    ic = intermediate.code

    # GUARDAMOS EN UN TXT EL CODIGO INTERMEDIO
    file = open(('./IC/ic_%s.txt' % name), 'w')
    file.write(ic)
    file.close

    # GUARDA EL CODIGO EN UN ARCHIVO DE TEXTO
    code = code_generate(visitor.total)
    arm = code.print_code_generation(ic)
    code_file = open(('./ARM/code_arm_%s.txt' % name), 'w')
    code_file.write(arm)
    code_file.close()
    print(arm)
    '''
    # creamos el arbol
    (view, _) = get_printer_tree(tree, name)
    view.view()
    '''
    
if __name__ == '__main__':
    main(sys.argv) 
