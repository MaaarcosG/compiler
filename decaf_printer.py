from io import DEFAULT_BUFFER_SIZE
from antlr4 import *
# importamos la gramatica
from Grammar.DecafListener import DecafListener
from Grammar.DecafParser import DecafParser
from stack import Decaf_Stack
from collections import OrderedDict

class Decaf_Printer(DecafListener):
    def __init__(self):
        self.stack = Decaf_Stack()
        self.flag = False
        self.symbole_table = OrderedDict()
        self.error_names = []
        # print('Hola Mundo!')

    def error(self):
        self.flag = True
    
    # dentro del scope 
    def enter_Scope(self, name):
        self.symbole_table[name] = OrderedDict()
        self.stack.push(name)

    def exit_Scope(self):
        if self.stack.empty():
            pass
        else:
            pop_data = self.stack.pop()
            return pop_data
    
    # obtenemos el error
    def get_error(self, error):
        data_error = ('DECLARATION ERROR %s' % error)
        return data_error

    '''
        FUNCIONES QUE SE ENCUENTRAN DENTRO DEL DECAFLISTENER
    '''
    def enterProgram(self, ctx: DecafParser.ProgramContext):
        self.enter_Scope('GLOBAL')
    
    def exitProgram(self, ctx: DecafParser.ProgramContext):
        self.exit_Scope()
    
    def enterVar_declar(self, ctx: DecafParser.Var_declarContext):
        type = ctx.getChild(0).getText()
        name = ctx.getChild(1).getText()
        # printeamos los valores 
        print('%s\n-> Variable de Tipo: %s\n-> Nombre de la variable %s' % (('*'*50), type, name))
        _scope = self.stack.peek()

    def exitVar_declar(self, ctx: DecafParser.Var_declarContext):
        pass

    def enterStruct_declar(self, ctx: DecafParser.Struct_declarContext):
        name = ctx.getChild(1).getText()
        print('Struct name: %s' % name)
        self.enter_Scope(name)

    def exitStruct_declar(self, ctx: DecafParser.Struct_declarContext):
        scope = self.exit_Scope()
        for i in self.symbole_table[scope]:
            pass
    
    def enterVar_type(self, ctx: DecafParser.Var_typeContext):
        pass

    def enterMethod_declar(self, ctx: DecafParser.Method_declarContext):
        pass

    def exitMethod_declar(self, ctx: DecafParser.Method_declarContext):
        pass