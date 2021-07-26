grammar Decaf;

/* Lexer Rules */

CLASS               : 'class';

PROGRAM             : 'Program';

IF                  : 'if';

ELSE                : 'else';

FOR                 : 'for';

RETURN              : 'return';

BREAK               : 'break';

CONTINUE            : 'continue';

BOOLEAN             : 'boolean';

STRUCT              : 'struct';

CHAR                : 'char';

INT                 : 'int';

STRING              : 'string';

TRUE                : 'True';

FALSE               : 'False';

VOID                : 'void';

CALLOUT             : 'callout';

// Symbol Specification
SEMICOLON           : ';';

LCURLY              : '{';

RCURLY              : '}';

LSQUARE             : '[';

RSQUARE             : ']';

LROUND              : '(';

RROUND              : ')';

COMMA               : ',';

QUOTES              : '"';

APOSTROPHE          : '\'';

ADD                 : '+';

SUB                 : '-';

MULTIPLY            : '*';

DIVIDE              : '/';

REMINDER            : '%';

AND                 : '&&';

OR                  : '||';

NOT                 : '!';

GREATER_OP          : '>';

LESS_OP             : '<';

GREATER_eq_op       : '>=';

LESS_eq_op          : '<=';

EQUAL_OP            : '=';

ADD_eq_op           : '+=';

SUB_eq_op           : '-=';

EQUALITY_OP         : '==';

UNEQUALITY_OP       : '!=';

ID                  : LETTER(LETTER|DIGIT)*;

LETTER      : [a-zA-Z_];

CHAR_LITERAL        : APOSTROPHE ( '\\' [btnfr"'\\] | ~[\r\n\\"] ) APOSTROPHE;

DECIMAL_LITERAL     : [0-9]+;

fragment DIGIT      : [0-9];

HEX_LITERAL         : '0'[xX][0-9a-fA-F]+;

BOOL_LITERAL        : TRUE | FALSE;

STRING_LITERAL      : '"' ( '\\' [btnfr"'\\] | ~[\r\n\\"] )* '"';

/* Parser Rules */

program		    : CLASS PROGRAM LCURLY field_declar* method_declar* RCURLY;

var_declar            : (var_type field_var) (COMMA var_type field_var)* SEMICOLON;

struct_declar       : STRUCT ID LCURLY (var_declar*) RCURLY;

field_declar         : var_type field_var (COMMA field_var)* SEMICOLON;

array_id            : ID LSQUARE int_literal RSQUARE;

field_var           : var_id | array_id;

var_id              : ID;

method_declar        : return_type method_name LROUND ((var_type var_id) (COMMA var_type var_id)*)? RROUND block;

return_type         : (var_type | VOID);

block               : LCURLY var_declar* statement* RCURLY;

statement           : IF LROUND expr RROUND block (ELSE block)?
                    | FOR var_id (EQUAL_OP int_literal)? COMMA ((var_id (EQUAL_OP int_literal)?) | int_literal) block
                    | RETURN expr SEMICOLON
                    | method_call
                    | location assign_op expr
                    | location assign_op expr SEMICOLON
                    | var_id EQUAL_OP expr SEMICOLON
                    | BREAK SEMICOLON;

method_call_inter   : method_name LROUND (expr (COMMA expr)*)? RROUND;

method_call         : method_call_inter
                    | method_call_inter SEMICOLON
                    | CALLOUT LROUND STRING_LITERAL (COMMA callout_arg (COMMA callout_arg)*)? RROUND SEMICOLON;

expr                : location
                    | literal
                    | expr bin_op expr
                    | SUB expr
                    | method_call
                    | NOT expr
                    | LROUND expr RROUND;

location            : (var_id | array_id) ('.' location)?;

callout_arg         : expr | STRING_LITERAL;

int_literal         : DECIMAL_LITERAL | HEX_LITERAL;

rel_op              : GREATER_OP | LESS_OP | LESS_eq_op | GREATER_eq_op;

eq_op               : EQUALITY_OP | UNEQUALITY_OP;

cond_op             : AND | OR;

literal             : int_literal | CHAR_LITERAL | BOOL_LITERAL;

bin_op              : arith_op | rel_op | eq_op | cond_op;

arith_op            : ADD | SUB | MULTIPLY | DIVIDE | REMINDER;

var_type            : INT | BOOLEAN | STRUCT ID | struct_declar | VOID;

assign_op           : EQUAL_OP
                    | ADD_eq_op
                    | SUB_eq_op;

method_name         : ID;

WHITESPACE			: [ \t\r\n] -> skip ;