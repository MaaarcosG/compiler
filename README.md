# Decaf Compiler

Codigo Fuente: https://github.com/MaaarcosG/compiler.git

Hecho por:
- Sergio Juan Marcos Gutierrez Romero
- Carne: 17909

## Requerimientos

- Python 3.8 or higher
- Graphicviz installed on the computer
- Antlr4 python
- Flask

Primero clonar el repositorio
```bash
$ git clone https://github.com/MaaarcosG/compiler.git
```
Todos los requerimientos se encuentra en el archivo requeriments.txt

```bash
$ pip install -r requirements.txt
```
## Creacion de archivos Decaf
Irse a la carpeta Grammar, para ejecutar la gramatica de Decaf.g4
```bash
$ java -Xmx500M -cp antlr4.jar org.antlr.v4.Tool -Dlanguage=Python3 Decaf.g4 -visitor
```
## Compilar en la Terminal
Regresar al root del proyecto, ejecutar el compiler.py que recibe como parametro el archivo a compilar. Este si gusta usarlo desde la terminal del sistema operativo.

```bash
$ python compiler.py Tests\test.txt 
```
Para revisar el arbol generado se encuentra en la carpeta Trees

## Ejecucion con GUI

La interfaz grafica se encuentra en el archivo compiler_gui.py
En esta actualmente se puede hacer lo siguienteÑ
- Analizador Semantico
- Generación de Codigo Intermedio

```bash
$ git python compiler_gui.py
```
Luego de ejecutarse el archivo y a la direccion
```bash
http://localhost:5000
```
Dentro se tiene una interfaz del usuario, facil de usar. 
