'''ARCHIVO QUE GENERA EL CODIGO INTERMEDIO UTILIZA BASE DE DECAF VISITOR'''

# Importamos el Decaf Visitor
from Grammar.DecafVisitor import DecafVisitor
from Grammar.DecafParser import DecafParser

class Intermediate(DecafVisitor):
    '''
        *scope extraido del analisis semantico (sin errores)
    '''
    def __init__(self, scope):
        super().__init__()
        self.op_registers = ['r'+str(i) for i in range(0,8)]
        self.registers = self.op_registers[::-1]
        self.global_scope = ['global']
        self.scopes = scope
        ''' mismos contadores que el analisis semantico '''
        self.scope_ids = 0
        self.offset = 0
        self.line = '' # esta variable guardara el codigo generado
        
    
