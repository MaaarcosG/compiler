from enum import Enum
from typing import Type

class Type_Enum(Enum):
    Char = 0
    Boolean = 1
    Integer = 2
    Struct = 3
    Error = 4
    Void = 5

class SymbolTable:
    def __init__(self, name='', id={}, parent=None, typeTable=None, stype='scope'):
        self.name = name
        self.id = id
        self.parent = parent
        self.typeTable = typeTable
        self.scopeType = stype
    
    def search(self, name):
        if name not in self.id:
            return self.parent and self.parent.search(name)
        return self.id[name]
        
    def add(self, symbol):
        self.id[symbol.name] = symbol
        
    def delete(self, name):
        if name in self.id:
            del self.id[name]
    
    def addType(self, t):
        self.typeTable.add(t)
    
    def t_exist(self, t, spect=None):
        if t in self.typeTable.id:
            ids = self.typeTable.id[t]
            return ((ids.type == spect) or not spect) and ids
        return self.parent and self.parent.t_exist(t, spect) 
    
    def __str__(self) -> str:
        string = 'Name: ' + str(self.name) + '\n'
        string = string + 'id: ' + str(self.id) + '\n'
        string = string + 'parent: ' + str(self.parent) + '\n'
        string = string + 'typeTable: ' + str(self.typeTable) + '\n'
        string = string + 'scopeType: ' + str(self.scopeType) + '\n'

        return string

class Symbol:
    def __init__(self, name, stype, offset=0, param=False, listSize=0):
        self.name = name
        self.stype = stype
        self.offset = offset
        self.param = param
        self.listSize = listSize

    def __str__(self) -> str:
        string = 'Name: ' + str(self.name) + '\n'
        string = string + 'stype: ' + str(self.stype) + '\n'
        string = string + 'offset: ' + str(self.offset) + '\n'
        string = string + 'param: ' + str(self.param) + '\n'
        string = string + 'offset: ' + str(self.listSize) + '\n'

        return string

class Type_Item:
    def __init__(self, name, size=0, type='struct', paramlist={}, ret=None):
        self.name = name
        self.size = size
        self.paramlist = paramlist
        self.type = type
        self.ret = ret
    
    def addParam(self, param):
        self.paramlist[param.name] = param
    
    def __str__(self) -> str:
        string = 'Name: ' + str(self.name) + '\n'
        string = string + 'size: ' + str(self.size) + '\n'
        string = string + 'paramlist: ' + str(self.paramlist) + '\n'
        string = string + 'type: ' + str(self.type) + '\n'
        string = string + 'ret: ' + str(self.ret) + '\n'

        return string

class Type_Table:
    def __init__(self):
        self.id = {}
        self.id['char'] = Type_Item(Type_Enum.Char, 1)
        self.id['int'] = Type_Item(Type_Enum.Integer, 4)
        self.id['boolean'] = Type_Item(Type_Enum.Boolean, 1)
        self.id['void'] = Type_Item(Type_Enum.Void, 0)

    def addParam(self, name, param):
        if name in self.id:
            self.id[name].addParam(param)
            return True
        return False

    def addSize(self, name, size):
        if name in self.id:
            self.id[name].size += size
            return True
        return False

    def add(self, data):
        self.id[data.name] = data
    
    def getSize(self, name):
        if name in self.id:
            return self.id[name].size
        return None

    def getParams(self, name):
        if name in self.id:
            return self.id[name].paramlist
        return None
    
    def __str__(self) -> str:
        string = 'Id: ' + str(self.id) + '\n'

        return string