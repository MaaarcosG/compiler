class Node_IC:
    def __init__(self, operation, left_data, right_data, code=[], line=''):
        self.operation = operation
        self.left_data = left_data
        self.right_data = right_data
        self.code = code
        self.line = line
    
    def get_right_data(self, child):
        self.right_data = child
    
    def get_left_data(self, child):
        self.left_data = child