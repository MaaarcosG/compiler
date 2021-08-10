from graphviz import Digraph
from antlr4.tree.Trees import Trees
from Grammar.DecafParser import DecafParser

# clases de java para DecafParser ambos son para NODOS
TERMINAL_TYPE = "<class 'antlr4.tree.Tree.TerminalNodeImpl'>"
ERROR_TYPE = "<class 'antlr4.tree.Tree.ErrorNodeImpl'>"

# obtenemos el nombre del nodo correspondiente
def get_node(node):
    data = node.toString(DecafParser.ruleNames, node.stop)
    return data.replace('[', ']').replace(']', '').split(' ')[0]

# obtenemos cada una de las iteraciones realizadas
def convert_printer(tree, diagram, node):
    children = tree.getChildCount()
    node_id = node
    # recorremos la lista creada
    for i in range(children):
        child = tree.getChild(i)
        data_node = str(type(child))
        # iteramos cada uno de los hijos si es correcto
        if (data_node == TERMINAL_TYPE):
            label = child.getText()
            color = 'blue'
        # iteramos cada uno de los hijos si tira un error
        elif (data_node == ERROR_TYPE):
            label = child.getText()
            color = 'red'
        # si todo va en el camino correcto
        else:
            label = get_node(child)
            color = 'green'
        
        node += 1
        diagram.node(str(node), label, color=color)
        diagram.edge(str(node_id), str(node))
        # evitamos errores en el tamano
        if (child.getChildCount() > 0):
            _, node = convert_printer(child, diagram, node)
    
    return diagram, node
 
def get_printer_tree(data, name):
    tree = Digraph('Trees/tree_'+name, 'Trees/tree_'+name+'.gv')
    tree.node('0', get_node(data))
    return convert_printer(data, tree, 0)