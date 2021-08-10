grammar Decaf;

/*Definiciones para letras y digitos*/
fragment LETTER: ('a'..'z'|'A'..'Z') ;
fragment DIGIT: '0'..'9' ;

/*Reglas de DECAF*/
ID: LETTER (LETTER|DIGIT)*;
NUM: DIGIT (DIGIT)* ;
/* CHAR: '\'' LETTER '\''; */
CHAR: '\'' ( ~['\r\n\\] | '\\' ['\\] ) '\'';
SPACES : [ \t\r\n\f]+  ->channel(HIDDEN);
COMMENT: '/*' .*? '*/' -> channel(2);
LINE_COMMENT: '//' ~[\r\n]* -> channel(2);

/*Parser Rules*/
program: 'class' 'Program' '{' (declaration)* '}';

declaration:
      struct_declar
    | var_declar
    | method_declar
    | structInstantiation;

struct_declar: 'struct' name=ID '{' (var_declar)* '}' (';')?;
      
var_declar:
      vType=var_type  name=ID ';'
    | vType=var_type  name=ID '[' size=NUM ']' ';';

structInstantiation:
    'struct' struct=ID name=ID;

var_type:
     'int'
    | 'char' 
    | 'boolean' 
    | 'struct' ID 
    | struct_declar 
    | 'void' ;

method_declar:
    returnType=method_type name=ID '(' (parameter (',' parameter)*)* ')' block;

method_type:
      'int' 
    | 'char' 
    | 'boolean' 
    | 'void';

parameter: 
      vType=parameter_type name=ID 
    | vType=parameter_type name=ID '[' ']' 
    | 'void';

parameter_type: 
      'int' 
    | 'char'
    | 'boolean';

block: '{' (decl=var_declar)* (state=statement)* '}';

statement:
      'if' '(' expression ')' ifblock=block ('else' elseblock=block)?
    | 'while' '(' expression ')' block
    | 'return' (expression)? ';'
    | method_call ';'
    | block
    | left=location '=' right=expression
    | (expression)? ';';

location: (name=ID | name=ID '[' expr=expression ']') ('.' loc=location)?;

method_call: method=ID '(' (arg (',' arg)*)* ')';

arg: expression;

expression:
      method_call #methodCallExpr
    | location #locationExpr
    | literal #literalExpr
    | left=expression op=higher_arith_op right=expression #higherArithOp
    | left=expression op=arith_op right=expression #arithOp
    | left=expression op=rel_op right=expression #relationOp
    | left=expression op=eq_op right=expression #equalityOp
    | left=expression op=cond_op right=expression #conditionalOp
    | '-' expression #negativeExpr
    | '!' expression #negationExpr
    | '(' expression ')' #parentExpr;

higher_arith_op:
      '*' 
    | '/' 
    | '%';

arith_op: 
      '+' 
    | '-';

rel_op: 
      '<' 
    | '>' 
    | '<=' 
    | '>=';

eq_op: 
      '=='
    | '!=';

cond_op: 
      '&&' 
    | '||';

literal: 
      int_literal 
    | char_literal
    | bool_literal;

int_literal: NUM;

char_literal: CHAR;

bool_literal: 'true' | 'false';