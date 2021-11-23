'''ARCHIVO QUE GENERA EL CODIGO INTERMEDIO UTILIZA BASE DE DECAF VISITOR'''

# Importamos el Decaf Visitor
from Grammar.DecafVisitor import DecafVisitor
from Grammar.DecafParser import DecafParser
from decaf_function import default_variable
from ic_node import Node_IC
from symbol_table import Type_Enum

class Intermediate(DecafVisitor):
    '''
        *scope extraido del analisis semantico (sin errores)
    '''
    def __init__(self, scope):
        super().__init__()
        self.op_registers =  ['r'+str(i) for i in range(0,8)]
        self.registers = self.op_registers[::-1]
        self.global_scope = ['global']
        self.scopes = scope
        ''' mismos contadores que el analisis semantico '''
        self.scope_ids = 0
        self.offset = 0
        self.code = '' # esta variable guardara el codigo generado

    '''FUNCIONES NECESARIAS PARA CREAR IC'''

    def generate_code(self, *args):
        return '%s = %s %s %s' % args
    
    def get_location(self, scope, ofsset):
        return '%s[%s]' % (scope.capitalize(), str(ofsset))
    
    def get_actual(self):
        data = self.op_registers.pop()
        self.registers.add(data)
        return data
    
    def add_register(self, re):
        if re in self.op_registers:
            self.registers.append(re)
    
    ''' FUNCIONES QUE SE ENCUENTRAN EN DECAF VISITOR'''
    
    def visitProgram(self, ctx: DecafParser.ProgramContext):
        self.visitChildren(ctx)
        return 0
    
    '''
        nombre de cada una de las funciones
    '''
    def visitMethod_declar(self, ctx: DecafParser.Method_declarContext):
        method_name = ctx.ID().getText()
        # print(method_name)
        # colocamos el nombre de las funciones dentro del scope
        self.scope_ids +=1
        self.global_scope.append(method_name)
        actual_scope = self.scopes[self.global_scope[-1]]
        ''' COMIENZA EL CODIGO INTERMEDIO '''
        start_method = ('%s: \n') % method_name
        start_method += ('func begin %s\n' % str(actual_scope.getSize()))
        self.code += start_method
        self.visitChildren(ctx)
        end = ('func end \n \n')
        self.code += end
        self.global_scope.pop()
        return 0
    
    '''
        si la funcion tiene return, anadido al scope
    '''
    def visitReturnStmt(self, ctx: DecafParser.ReturnStmtContext):
        if ctx.expression:
            expresssion = self.visit(ctx.expression())
            # print(expresssion )
            self.code += ('return %s \n' % expresssion)
            self.add_register(expresssion)
        return 0
    
    ''' Llama a la funcion y verifica si hay parametros '''
    def visitMethod_call(self, ctx: DecafParser.Method_callContext):
        method_name = ctx.ID().getText()
        if ctx.arg() :
            for i in ctx.arg():
                parameter = self.visit(i)
                # print('Parameters: %s' % param)
                '''
                    anadimos el parametro en el stack, lo denotamos como param para parametros
                '''
                self.code += ('push param %s \n' % parameter)
                self.add_register(parameter)
                
        data_regs = self.registers.pop()
        ''' call llamadas de los procedimientos'''
        self.code += ('%s = call %s \n' % (data_regs, method_name))
        self.add_register(data_regs)
        #self.visitChildren(ctx)
        return 0
    
    ''' OPERACIONES DE STATEMENT '''
    
    def visitIfStmt(self, ctx: DecafParser.IfStmtContext):
        self.scope_ids += 1
        method_name = ('if%s' % str(self.scope_ids))
        self.global_scope.append(method_name)
        '''
        print(self.global_scope)
        print(self.scope_ids)
        '''
        expression = self.visit(ctx.expression())
        jump_instruction = ('L%s' % str(self.offset))
        self.offset += 1
        '''
            salto condicionales (y relop x goto L)
            donde relop es la expression dentro del arbol 
        '''
        line_if = ('if %s goto %s \n' % (expression, jump_instruction))
        # print(line_if)
        # condicion para agregarlo al registro
        self.add_register(expression)

        self.code += line_if
        self.visit(ctx.block1)
        if ctx.block2:
            '''
                se ejecuta la instruccion de la etiqueta con goto L
            '''
            end = '%s: \n' % jump_instruction
            final = 'L%s' % str(self.offset)
            self.code += 'goto %s \n' % final
            self.code += end
            self.visit(ctx.block2)
            self.code += '%s: \n' % final
            self.offset += 1
        else:
            '''
                si no es asi, se ejecuta la siguiente instruccion
            '''
            end = '%s: \n' % jump_instruction
            self.code += end
        self.global_scope.pop()
    
    def visitWhileStmt(self, ctx: DecafParser.WhileStmtContext):
        self.scope_ids += 1
        method_name = ('while%s' % str(self.scope_ids))
        self.global_scope.append(method_name)
        '''
        print(self.global_scope)
        print(self.scope_ids)
        '''
        start = ('L%s' % str(self.offset))
        line_while = ('%s: \n' % start)
        self.offset += 1
        self.code += line_while
        expression = self.visit(ctx.expression())
        end = ('L%s' % str(self.offset))
        self.offset += 1
        ''' Condicioon if para el while'''
        wc = ('if %s goto %s \n' % (expression, end))
        self.add_register(expression)
        self.code += wc
        self.visit(ctx.block())
        we = 'goto %s \n' % start
        we += '%s: \n' % end
        self.code += we
        self.global_scope.pop() 
    
    def visitAssigStmt(self, ctx: DecafParser.AssigStmtContext):
        left_data = self.visit(ctx.left)
        right_data = self.visit(ctx.right)

        equal = ('%s = %s \n' % (str(left_data), str(right_data)))
        # agregamos al registro
        self.add_register(right_data)
        self.code += equal
        return left_data
    
    '''
        VALORES ESPERADOS
    '''
    def visitLiteral(self, ctx: DecafParser.LiteralContext):
        val = self.visitChildren(ctx)
        print('Entra al LITERAL: %s' % str(val))
        return val[1]
    
    def visitLiteralExpression(self, ctx: DecafParser.LiteralExpressionContext):
        return self.visitChildren(ctx)

    def visitInt_literal(self, ctx: DecafParser.Int_literalContext):
        return (Type_Enum.Integer, ctx.NUM().getText())
    
    def visitChar_literal(self, ctx: DecafParser.Char_literalContext):
        return (Type_Enum.Char, ctx.CHAR().getText())
    
    def visitBool_literal(self, ctx: DecafParser.Bool_literalContext):
        boolean = ctx.getText()
        if boolean == 'true':
            boolean = '1'
            return boolean
        return boolean
    
    ''' OPERACIONES DE EXPRESSIONES DE DECAF'''

    def visitParentExpression(self, ctx: DecafParser.ParentExpressionContext):
        print('Expresion (%s)' % self.visit(ctx.expression()))
        return self.visit(ctx.expression())

    '''
        metodo que toma las operaciones aritmeticas * / % (instrucciones de tres direcciones)
                                    x = y op z 
        op = opearciones aritmerica
        x, y, z = son direcciones
    '''
    def visitHigherArithOp(self, ctx: DecafParser.HigherArithOpContext):
        # jalamos los valores correspondientes  
        left_data = self.visit(ctx.left)  # y
        right_data = self.visit(ctx.right) #z
        operation = ctx.higher_arith_op().getText() # op
        exp = self.registers.pop() # x
        
        harith = Node_IC(operation, right_data, left_data)

        # creamos una nueva linea con los valores (x = y op z)
        expression = self.generate_code(exp, left_data, operation, right_data)
        print('HIGHER OPERATION: %s' % expression)

        # verificamos los registros y los anadimos
        self.add_register(right_data)
        self.add_register(left_data)

        self.code += ('%s \n' % expression)
        return exp
    
    '''
        toma las operaciones aritmetica '<' '>' '<='  >=
    '''
    def visitRelationOp(self, ctx: DecafParser.RelationOpContext):
        # jalamos los valores correspondientes
        left_data = self.visit(ctx.left)
        right_data = self.visit(ctx.right)
        operation = ctx.rel_op().getText()
        exp = self.registers.pop()

        # creamos la instrucciones (x = y op x)
        expression = self.generate_code(exp, left_data, operation, right_data)
        print('RELATION OPERATION: %s' % expression)

        # verificamos los registros y los anadimos
        self.add_register(right_data)
        self.add_register(left_data)

        self.code += ('%s \n' % expression)
        return exp

    '''
        toma las operaciones aritmetica + -
    '''
    def visitArithOp(self, ctx: DecafParser.ArithOpContext):
        # jalamos los valores correspondientes
        left_data = self.visit(ctx.left)
        right_data = self.visit(ctx.right)
        operation = ctx.arith_op().getText()
        exp = self.registers.pop()

        # creamos la instrucciones (x = y op x)
        expression = self.generate_code(exp, left_data, operation, right_data)
        print('ARTIH OPERATION: %s' % expression)

        # verificamos los registros y los anadimos
        self.add_register(right_data)
        self.add_register(left_data)

        self.code += ('%s \n' % expression)
        return exp
    
    '''
        toma las operaciones aritmeticas == !=
    '''
    def visitEqualityOp(self, ctx: DecafParser.EqualityOpContext):
        # jalamos los valores correspondientes
        left_data = self.visit(ctx.left)
        right_data = self.visit(ctx.right)
        operation = ctx.eq_op().getText()
        exp = self.registers.pop()

        # creamos la instrucciones (x = y op x)
        expression = self.generate_code(exp, left_data, operation, right_data)
        print('EQUIALITY OPERATION: %s' % expression)

        # verificamos los registros y los anadimos
        self.add_register(right_data)
        self.add_register(left_data)

        self.code += ('%s \n' % expression)
        return exp
    
    '''
        tomas las operaciones aritmeticas && ||
    '''
    def visitConditionalOp(self, ctx: DecafParser.ConditionalOpContext):
        # jalamos los valores correspondientes
        left_data = self.visit(ctx.left)
        right_data = self.visit(ctx.right)
        operation = ctx.cond_op().getText()
        exp = self.registers.pop()

        # creamos la instrucciones (x = y op x)
        expression = self.generate_code(exp, left_data, operation, right_data)
        print('CONDITIONAL OPERATION: %s' % expression)

        # verificamos los registros y los anadimos
        self.add_register(right_data)
        self.add_register(left_data)

        self.code += ('%s \n' % expression)
        return exp
    
    def visitLocation(self, ctx: DecafParser.LocationContext, parent=None):
        method_name = ctx.ID().getText()
        offset = 0
        print('method %s' % self.global_scope[::-1])
        # revisamos el scope
        for i in self.global_scope[::-1]:
            actual = self.scopes[i]
            # miramos los simbolos que coincidan con los types
            if symbol := actual.getSymbol(method_name):
                break
        for symbol in actual.symbol:
            if symbol.name == method_name:
                break
            else:
                if symbol.stype in default_variable:
                    offset += default_variable[symbol.stype]
                else:
                    data = symbol.stype.replace('struct', '')
                    offset += actual.get_data_size(data) * int(symbol.param)
        
        if ctx.expression() != None:
            data = self.visit(ctx.expression())
            print('data %s' % data)
            try:
                ''' anadimos al location los valores de offset'''
                if symbol.stype in default_variable:
                    offset += default_variable[symbol.stype] * int(ctx.expression().getText())
                else:
                    st = symbol.stype.replace('struct', '')
                    offset += actual.get_data_size(st) * int(ctx.expression().getText())
            except:
                register = self.registers.pop()
                if symbol.stype in default_variable:
                    ''' si el symbol es un location, y obtenemos un string'''
                    self.code += ('%s = %s * %s \n' % (register, data, str(default_variable[symbol.stype])))
                else:
                    st = symbol.stype.replace('struct', '')
                    ''' creamos un codigo donde tomamos el registro correspondiente a las asignaciones '''
                    # creamos la instrucciones (x = y op x)
                    print('LOCATION %s = %s * %s' % (register, data, str(actual.get_data_size(st))))
                    self.code += ('%s = %s * %s \n' % (register, data, str(actual.get_data_size(st))))
                offset = register
        
        '''
            creamos una variable con la inicial de la funcion
            ejemplo: main --> m+id_funcion
            
            instruccion de copia indexada
                x = y[i]
                x = valor en la ubicacion i unidad de memoria mas alla de y
                e y es el valor que se estara retornando

        '''
        symbol_name = actual.name[0] + str(actual.id)
        value = self.get_location(symbol_name, (offset))
        print('value: %s' % value)
        return value