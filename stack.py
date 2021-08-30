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
        if self.items:
            return self.items[len(self.items)-1]
        else:
            print('Stack Empty')
            return None