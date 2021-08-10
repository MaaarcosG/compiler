# Decaf Compiler

Codigo Fuente: https://github.com/MaaarcosG/compiler.git

Hecho por:
- Sergio Juan Marcos Gutierrez Romero
- Carne: 17909

## Requerimientos

- Python 3.8 or higher
- Graphicviz installed on the computer
- Antlr4 python

```bash
$ pip install antlr4-python3-runtime
```
## Uso
Primero clonar el repositorio

```bash
$ git clone https://github.com/MaaarcosG/Automatas.git
```
Irse a la carpeta Grammar, para ejecutar la gramatica de Decaf.g4
```bash
$ java -Xmx500M -cp antlr4.jar org.antlr.v4.Tool -Dlanguage=Python3 Decaf.g4 -visitor
```
Regresar al root del proyecto, ejecutar el compiler.py que recibe como parametro el archivo a compilar.

```bash
$ python compiler.py Tests\test.txt 
```
Para revisar el arbol generado se encuentra en la carpeta Trees
