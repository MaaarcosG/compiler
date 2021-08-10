class Decaf_Stack():
    def __init__(self):
        self.items = []
    
    # empty
    def empty(self):
        return self.items == []

    # add item
    def push(self, item):
        self.items.append(item)
    
    # remove item
    def pop(self):
        return self.items.pop()

    # take
    def peek(self):
        if self:
            return self.items[len(self.items)-1]
        else:
            print('Stack Empty')
    
    def size(self):
        return len(self.items)
    
    def pretty(self):
        # reccoremos la lista de items
        for i in self.items:
            print('Parents: ')
            i.pprint()
            print('Left Child')
        if i.leftChild != None:
            i.leftChild.pprint()
        else:
            print("No Left Child")
            print("Right Child ")
        if i.rightChild != None:
            i.rightChild.pprint()
        else:
            print("No Right Child")
            print("End of Current Stack")

    def printStack(self):
        print(len('STACK')*'*'+'STACK'+len('STACK')*'*')
        for node in self.items:
            print(node)
        print(len('END STACK')*'*'+'END STACK'+len('END STACK')*'*') 