''' contains the possible errors found '''

def generic(text, number_line):
    error = 'ERROR: %s on the line %d' % (text, number_line)
    return error

def not_defined(text, got, number_line):
    error = 'ERROR: %s %s does not exist is found on line %d' % (text, got, number_line)
    return error

def expect_error(expected, got, number_line):
    error = 'ERROR: %s instead obtained %s is found on line %d' % (expected, got, number_line)
    return error