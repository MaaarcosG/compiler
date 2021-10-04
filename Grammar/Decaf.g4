grammar Decaf;

/*Definiciones para letras y digitos*/
fragment LETTER: [a-zA-Z_];
fragment DIGIT: [0-9]; 

/*Reglas de DECAF*/
ID: LETTER (LETTER|DIGIT)*;
NUM: DIGIT (DIGIT)* ;
CHAR: '\'' LETTER '\'';
SPACES : [ \t\r\n\f]+  ->channel(HIDDEN);
LINE_COMMENT: '//' ~[\r\n]* -> skip;

/*Parser Rules*/
program: 'class' 'Program' '{' (declaration)* '}';

declaration:
      struct_declar
    | var_declar
    | method_declar;

var_declar:
      var_type  ID ';' #single_VarDeclar
    | var_type  ID '[' NUM ']' ';' #list_VarDeclar;

struct_declar: 'struct' ID '{' (var_declar)* '}' (';')?;
      
var_type:
      'int'
    | 'char' 
    | 'boolean' 
    | 'struct' ID 
    | struct_declar 
    | 'void' ;

method_declar: method_type ID '(' (parameter (',' parameter)*)?  ')' block;

method_type:
      'int' 
    | 'char' 
    | 'boolean' 
    | 'void';

parameter: 
      parameter_type ID 
    | parameter_type ID '[' ']';

parameter_type: 
      'int' 
    | 'char'
    | 'boolean';

block: '{' (var_declar)* (statement)* '}';

statement:
      'if' '(' expression ')' block1 = block ('else' block2 = block)? #ifStmt
    | 'while' '(' expression ')' block #whileStmt
    | 'return' (expression)? ';' #returnStmt
    | method_call ';' #methodCallStmt
    | block #blockStmt
    | left = location '=' right = expression #assigStmt
    | (expression)? ';' #expressionStmt; 

location: (ID | ID '[' expression ']' ) ('.' location)?;

expression:
      method_call #methodCallExpression
    | location #locationExpression
    | literal #literalExpression
    | '-' expression #negativeExpression
    | '!' expression #negationExpression
    | '(' expression ')' #parentExpression
    | left=expression higher_arith_op right=expression #higherArithOp
    | left=expression arith_op right=expression #arithOp
    | left=expression rel_op right=expression #relationOp
    | left=expression eq_op right=expression #equalityOp
    | left=expression cond_op right=expression #conditionalOp;

method_call: ID '(' (arg | arg (',' arg)*)?    ')';

arg: expression;

higher_arith_op: '*' | '/' | '%';

arith_op: '+' | '-';

rel_op: '<' | '>' | '<=' | '>=';

eq_op: '==' | '!=';

cond_op: '&&' | '||';

literal: 
      int_literal 
    | char_literal
    | bool_literal;

int_literal: NUM;

char_literal: CHAR;

bool_literal: 'true' | 'false';