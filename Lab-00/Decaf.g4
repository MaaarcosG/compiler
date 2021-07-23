
/*Gramatica de DECAF*/
grammar Decaf;

fragment DIGIT: [0-9];

fragment LETTER: [a-zA-Z_];

NUM: DIGIT (DIGIT)* ;

ID: LETTER (LETTER|DIGIT)* ;
CHAR:'\'' LETTER '\'';
SPACES : [ \t\r\n\f]+  ->channel(HIDDEN);

program: 'class' 'Program' '{' (declaration)* '}' EOF;

declaration: structDeclaration | varDeclaration | methodDeclaration;

varDeclaration: varType ID ';' | varType ID '[' NUM ']' ';';

structDeclaration: 'struct' ID '{' (varDeclaration)* '}' ';';

varType: 'int' | 'char' | 'boolean' | 'struct' ID | structDeclaration | 'void';

methodDeclaration: methodType ID '(' (parameter | parameter (',' parameter)*)?  ')' block ;

methodType: 'int' | 'char' | 'boolean' | 'void';

parameter: parameterType ID | parameterType ID '[' ']';

parameterType: 'int' | 'char' | 'boolean';

block: '{' (varDeclaration)* (statement)* '}';

statement: 'if' '(' expression ')' block1 = block ('else' block2 = block)?
        | 'while' '(' expression ')' block
        | 'return' (expression)? ';'
        | methodCall ';'
        | block
        | left = location '=' right = expression
        | (expression)? ';'; 

location: (ID | ID '[' expression ']' ) ('.' location)?;

expression: methodCall | location | literal
        | '(' expression ')' 
        | '-' expression
        | '!' expression
        | left = expression p_arith_op right = expression
        | left = expression arith_op right = expression
        | left = expression rel_op right = expression
        | left = expression eq_op right = expression
        | left = expression cond_op right = expression ;
        
methodCall: ID '(' (arg | arg (',' arg)*)?    ')';

arg: expression;

arith_op: '+' | '-' ;

p_arith_op: '*' | '/' | '%';

rel_op: '<' | '>' | '<=' | '>=';

eq_op: '==' | '!=';

cond_op: '&&' | '||';

literal: int_literal | char_literal | bool_literal;

int_literal: NUM;

char_literal: CHAR; 

bool_literal: 'true' | 'false';