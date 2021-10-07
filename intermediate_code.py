'''ARCHIVO QUE GENERA EL CODIGO INTERMEDIO UTILIZA BASE DE DECAF VISITOR'''

# Importamos el Decaf Visitor
from Grammar.DecafVisitor import DecafVisitor
from Grammar.DecafParser import DecafParser

default_variable = {'int': 4, 'boolean': 1, 'char': 1}

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
        return super().visitProgram(ctx)
    
    # nombre de cada una de las funciones
    def visitMethod_declar(self, ctx: DecafParser.Method_declarContext):
        method_name = ctx.ID().getText()
        # print(method_name)
        # colocamos el nombre de las funciones dentro del scope
        self.scope_ids += 1
        self.global_scope.append(method_name)
        actual_scope = self.scopes[self.global_scope[-1]]
        start_method = ('%s: \n') % method_name
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
                # print(self.registers)

    def visitMethod_call(self, ctx: DecafParser.Method_callContext):
        method_name = ctx.ID().getText()
        if ctx.arg():
            for i in ctx.arg():
                parameter = i.getText()
                # print('Parameters: %s' % param)
                self.line += ('push param %s \n' % parameter)
                if parameter in self.op_registers:
                    self.registers.append(parameter)
        data_regs = self.registers.pop()
        self.line += ('%s = LCall %s \n' % (data_regs, method_name))
        if data_regs in self.op_registers:
            self.registers.append(data_regs)
        # print(method_name)
    
    def visitIfStmt(self, ctx: DecafParser.IfStmtContext):
        self.scope_ids += 1
        method_name = ('if %s' % str(self.scope_ids))
        self.global_scope.append(method_name)
        '''
        print(self.global_scope)
        print(self.scope_ids)
        '''
        expression = ctx.expression().getText()
        jump_instruction = ('L%s' % str(self.offset))
        self.offset += 1
        line_if = ('if %s goto %s \n' % (expression, jump_instruction))
        # print(line_if)
        # condicion para agregarlo al registro
        if expression in self.op_registers:
            self.registers.append(expression)
        self.line += line_if
        self.visit(ctx.block1)
        if ctx.block2:
            end = '%s: \n' % jump_instruction
            final = 'L%s' % str(self.offset)
            self.line += 'goto %s \n' % final
            self.line += end
            self.visit(ctx.block2)
            self.line += '%s: \n' % final
            self.offset += 1
        else:
            end = '%s: \n' % jump_instruction
            self.line += end
        self.global_scope.pop()
    
    def visitWhileStmt(self, ctx: DecafParser.WhileStmtContext):
        self.scope_ids += 1
        method_name = ('while %s' % str(self.scope_ids))
        self.global_scope.append(method_name)
        start = ('L%s' % str(self.offset))
        line_while = ('%s: \n' % start)
        self.offset += 1
        self.line += line_while
        expression = ctx.expression().getText()
        end = ('L%s' % str(self.offset))
        self.offset += 1
        wc = ('if %s goto %s \n' % (expression, end))
        if expression in self.op_registers:
            self.registers.append(expression)
        self.line += wc
        self.visit(ctx.block())
        we = 'goto %s \n' % start
        we += '%s: \n' % end
        self.line += we
        self.global_scope.pop() 


    
    def visitAssigStmt(self, ctx: DecafParser.AssigStmtContext):
        left_data = ctx.left.getText()
        right_data = ctx.right.getText()
        equal = ('%s = %s \n' % (left_data, right_data))
        if right_data in self.op_registers:
            self.registers.append(right_data)
        self.line += equal
    
    def visitParentExpression(self, ctx: DecafParser.ParentExpressionContext):
        print('pasa')
        return self.visit(ctx.expression())
        
    def visitLocation(self, ctx: DecafParser.LocationContext, parent=None):
        method_name = ctx.ID().getText()
        offset = 0

        # revisamos el scope
        for i in self.global_scope[::-1]:
            actual = self.scopes[i]
            # miramos los simbolos
            if symbol := actual.getSymbol(method_name):
                break
        for symbol in actual.symbol:
            if symbol.name == method_name:
                break
            else:
                if symbol.stype in default_variable:
                    offset += default_variable[symbol.stype]
                else:
                    offset += actual.get_data_size(symbol.stype.replace('struct', '')) * symbol.param
        
        if ctx.expression() != None:
            data = self.visit(ctx.expression())
            # print(data)
            try:
                if symbol.stype in default_variable:
                    offset += default_variable[symbol.stype] * int(ctx.expression().getText())
                else:
                    st = symbol.stype.replace('struct', '')
                    offset += actual.get_data_size(st) * int(ctx.expression().getText())
            except:
                register = self.registers.pop()
                if symbol.stype in default_variable:
                    self.line += ('%s = %s * %s \n' % (register, data, str(default_variable[symbol.stype])))
                else:
                    st = symbol.stype.replace('struct', '')
                    self.line += ('%s = %s * %s \n' % (register, data, str(actual.get_data_size(st))))
                offset = register
        
        symbol_name = actual.name[0] + str(actual.id)
        value = ('%s[%s]' % (symbol_name, str(offset)))
        return value

