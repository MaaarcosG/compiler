grammar Decaf;

/*Definiciones para letras y digitos*/
fragment LETTER: ('a'..'z'|'A'..'Z') ;
fragment DIGIT: '0'..'9' ;

/*Reglas de DECAF*/
ID: LETTER (LETTER|DIGIT)*;

NUM: DIGIT (DIGIT)* ;

CHAR: '\'' LETTER '\'';

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
      var_Type=var_type  name=ID ';' #single_VarDeclar
    | var_Type=var_type  name=ID '[' size=NUM ']' ';' #list_VarDeclar;

structInstantiation: 'struct' struct=ID name=ID;

var_type:
     'int'
    | 'char' 
    | 'boolean' 
    | 'struct' ID 
    | struct_declar 
    | 'void' ;

method_declar: returnType=method_type name=ID '(' (parameter (',' parameter)*)* ')' block;

method_type:
      'int' 
    | 'char' 
    | 'boolean' 
    | 'void';

parameter: 
      var_Type=parameter_type name=ID 
    | var_Type=parameter_type name=ID '[' ']' 
    | 'void';

parameter_type: 
      'int' 
    | 'char'
    | 'boolean';

block: '{' (decl=var_declar)* (state=statement)* '}';

statement:
      ifStmt
    | whileStmt
    | returnStmt
    | method_call ';'
    | block
    | assigStmt
    | (expression)? ';';

ifStmt: 'if' '(' expression ')' ifblock=block ('else' elseblock=block)?;

whileStmt: 'while' '(' expression ')' block;

returnStmt: 'return' (expression)? ';';

assigStmt: left=location '=' right=expression;

location: (name=ID | name=ID '[' expr=expression ']') ('.' loc=location)?;

method_call: method=ID '(' (arg (',' arg)*)* ')';

arg: expression;

expression:
      method_call #methodCallExpression
    | location #locationExpression
    | literal #literalExpression
    | left=expression op=higher_arith_op right=expression #higherArithOp
    | left=expression op=arith_op right=expression #arithOp
    | left=expression op=rel_op right=expression #relationOp
    | left=expression op=eq_op right=expression #equalityOp
    | left=expression op=cond_op right=expression #conditionalOp
    | '-' expression #negativeExpression
    | '!' expression #negationExpression
    | '(' expression ')' #parentExpression;

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