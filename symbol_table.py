from enum import Enum
from os import replace
from typing import Type

# Los tipos de variables aceptables
default_variable = {'int': 4, 'boolean': 4, 'char': 4}

def print_code(code):
    return '\n'.join(code)
    
class Type_Enum(Enum):
    Char = 0
    Boolean = 1
    Integer = 2
    Struct = 3
    Error = 4
    Void = 5

class SymbolTable:
    def __init__(self, id=0, name='global', parent=None, stype=None):
        self.id = id
        self.stype = stype
        self.name = name
        self.parent = parent
        # lista de los simbolos
        self.symbol = []
        self.data = []
    
    def search(self, name):
        for datas in self.data:
            if datas.name == name:
                return datas
    
    def add(self, id, name, stype, retorn=None, data=[], size=0):
        data = More(id, name, stype, retorn, data, size)
        self.data.append(data)
    
    def getSymbol(self, name):
        for symbol in self.symbol:
            if symbol.name == name:
                return symbol
    
    def addSymbol(self, stype, name, param, id=0, offset=0):
        symbol = Symbol(stype, name, param, id, offset)
        self.symbol.append(symbol)
    
    def attribute(self, data_name, param_name):
        for i in self.data:
            if i.name == data_name:
                for j in i.data:
                    if j.name == param_name:
                        return j
        return None
    
    def get_data_size(self, data_name):
        for i in self.data:
            if i.name == data_name:
                return i.size
        else:
            return self.parent.get_data_size(data_name)
    
    def getSize(self):
        size = 0
        for symbol in self.symbol:
            if symbol.stype in default_variable:
                size += default_variable[symbol.stype] * int(symbol.param)
            else:
                if left_size:=self.search(symbol.stype )!=None:
                    size += left_size.size * int(symbol.param)
                else:
                    left_size = self.parent.search(symbol.stype.replace('struct', ''))
                    size += left_size.size * int(symbol.param)
        return size
    
    def __str__(self) -> str:
        string = 'Name: ' + str(self.name) + '\n'
        string = string + 'id: ' + str(self.id) + '\n'
        string = string + 'stype: ' + str(self.stype) + '\n'
        string = string + 'parent: ' + str(self.parent) + '\n'
        string = string + 'symbol: ' + str(self.symbol) + '\n'
        string = string + 'data: ' + str(self.data) + '\n'

        return string

class Symbol:
    def __init__(self, stype, name, param, id=0, offset=0):
        self.stype = stype
        self.name = name
        self.param = param
        self.id = id
        self.offset = offset

    def __str__(self) -> str:
        string = 'Name: ' + str(self.name) + '\n'
        string = string + 'id: ' + str(self.id) + '\n'
        string = string + 'stype: ' + str(self.stype) + '\n'

        return string

# clase extra para la instantiacion de los metodos
class More:
    def __init__(self, id=0, name=None, stype=None, retorn=None, data=[], size = 0):
        self.id = id
        self.name = name
        # si encuentra un struct en el lenguaje
        if stype == 'struct':
            self.stype = stype
            self.size = size
            self.data = data
        else:
            self.stype = stype
            self.retorn = retorn
            self.params = data
    
    def __str__(self) -> str:
        string = 'Name: ' + str(self.name) + '\n'
        string = string + 'id: ' + str(self.id) + '\n'
        string = string + 'stype: ' + str(self.stype) + '\n'

        return string