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
        
        ''' FUNCIONES QUE SE ENCUENTRAN EN DECAF VISITOR'''
        
    def visitProgram(self, ctx: DecafParser.ProgramContext):
        self.visitChildren(ctx)
    
    # nombre de cada una de las funciones
    def visitMethod_declar(self, ctx: DecafParser.Method_declarContext):
        method_name = ctx.ID().getText()
        # print(method_name)
        # colocamos el nombre de las funciones dentro del scope
        self.scope_ids += 1
        self.global_scope.append(method_name)
        start_method = ('%s: \n') % method_name
        actual_scope = self.scopes[self.global_scope[-1]]
        start_method += ('func begin %s\n' % str(actual_scope.getSize()))
        # print(self.scopes[self.global_scope[-2]].getSize())
        # print(start_method)
        self.line = start_method
        self.visitChildren(ctx)
        end = ('func end \n')
        self.line += end
        self.global_scope.pop()
        print(self.line)
    
    def visitReturnStmt(self, ctx: DecafParser.ReturnStmtContext):
        if ctx.expression:
            expresssion = ctx.expression().getText()
            self.line += ('return %s \n' % expresssion)
            if expresssion in self.op_registers:
                self.registers.append(expresssion)
