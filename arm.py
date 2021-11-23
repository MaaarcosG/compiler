# ARCHIVO PARA CONVERTIR CODIGO INTERMEDIO A ARM

class register():
    def __init__(self, name):
        self.name = name
        self.available = True

class code_generate():
    def __init__(self, scopes):
        self.registers_arm =  ['R'+str(i) for i in range(15, -1, -1)]
        self.operation = ['+', '-', '*', '/', '%', '=']
        self.true_regis = []
        self.scopes = scopes
    
    def read_ic_code(self, ic):
        arm_code = ""
        ic_lines_code = ic.split(" ")

        for data in ic_lines_code:
            if len(data) > 0:
                # si encuentra el main, comienza el programa ARM
                if data == 'main:':
                    arm_code += '_start:\n'
                if data[-1] == ':':
                    arm_code += ('%s \n' % data)

                # si encuentra el operador +
                if data == self.operation[0]:
                    # agregamos a los registros
                    registro_1 = self.registers_arm.pop()
                    registro_2 = self.registers_arm.pop()
                    # aniadiamos a la linea
                    arm_code += ('  mov %s %s \n' % (registro_1, ic_lines_code[ic_lines_code.index(data)-1]))
                    arm_code += ('  mov %s %s \n' % (registro_2, ic_lines_code[ic_lines_code.index(data)+1]))
                    arm_code += ('  add %s %s \n' % (registro_1, registro_2))
                    self.registers_arm.append(registro_2)
                
                # si encuentra el operador -
                if data == self.operation[1]:
                    # agregamos los registros
                    registro_1 = self.registers_arm.pop()
                    registro_2 = self.registers_arm.pop()
                    # aniadimos a la linea
                    arm_code += ('  mov %s %s \n' % (registro_1, ic_lines_code[ic_lines_code.index(data)-1]))
                    arm_code += ('  mov %s %s \n' % (registro_2, ic_lines_code[ic_lines_code.index(data)+1]))
                    arm_code += ('  sub %s %s \n' % (registro_1, registro_2))
                    self.registers_arm.append(registro_2)

                # si encuentra el operador *
                if data == self.operation[2]:
                    registro_1 = self.registers_arm.pop()
                    registro_2 = self.registers_arm.pop()
                    # aniadimos a la linea
                    arm_code += ('  mov %s %s \n' % (registro_1, ic_lines_code[ic_lines_code.index(data)-1]))
                    arm_code += ('  mov %s %s \n' % (registro_2, ic_lines_code[ic_lines_code.index(data)+1]))
                    arm_code += ('  sub %s %s \n' % (registro_1, registro_2))
                    self.registers_arm.append(registro_2)

                # si encuentra el operador =
                if data == self.operation[5]:
                    arm_code += ('  mov %s %s \n' % (ic_lines_code[ic_lines_code.index(data)-1], ic_lines_code[ic_lines_code.index(data)+1]))
                
                # si encuentra un goto en el codigo intermedio
                if data == 'goto':
                    arm_code += ('  je %s \n' % ic_lines_code[ic_lines_code.index(data)+1])

        # si encuentra la palabra func
        if ic_lines_code[0] == 'func':
            # si encuentra la palabra end para finalizar cada funcion
            if 'end' in ic_lines_code[1]:
                arm_code += '  ret\n'

        return arm_code

    # funcion para ver la data del scope
    def data_selection(self, scopes):
        arm_code ='.section .data\n'
        # recorremos el scope
        for sc in scopes:
            scope = scopes[sc]
            #arm_code += scope.name[0] + str(scope.id) + " TIMES " + str(int(scope.getSize()/4)) + " DB 0\n"
            arm_code += ('%s%s TIME DB 0 \n' % (scope.name[0], str(int(scope.getSize()/4))))

        return arm_code

    def print_code_generation(self, ic_code):
        # obtenemos el codigo intermedio
        ic_code = ic_code.split('\n')
        # numeros de registros
        num = 15
        # mandamos la data para el arm
        arm_code = self.data_selection(self.scopes)
        # ciclo para generar el codigo objetivo
        while num > 0:
            regi = register("R" + str(num))
            self.true_regis.append(regi)
            num -= 1
        arm_code += '.section .text\n.global _start\n'
        # CODIGO ARM 
        for ic in ic_code:
            arm_code += self.read_ic_code(ic)
        
        return arm_code

