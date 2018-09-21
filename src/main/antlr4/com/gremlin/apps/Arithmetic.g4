grammar Arithmetic;
 
equation
   : expression relop expression
   ;

expression
   : term ((PLUS | MINUS) term)*
   ;

term
   : factor ((TIMES | DIV) factor)*
   ;

factor
   : atom (POW atom)*
   ;

atom
   : scientific
   | variable
   | LPAREN expression RPAREN
   ;

scientific
   : number (E number)?
   ;

relop
   : ASSIGN
   | EQ
   | GT
   | LT
   | LTE
   | GTE
   ;

number
   : MINUS? DIGIT + (POINT DIGIT +)?
   ;

variable
   : MINUS? LETTER (LETTER | DIGIT)*
   ;


LPAREN
   : '('
   ;


RPAREN
   : ')'
   ;


PLUSPLUS
   : '++'
   ;

MINUSMINUS
   : '--'
   ;

PLUS
   : '+'
   ;

MINUS
   : '-'
   ;


TIMES
   : '*'
   ;


DIV
   : '/'
   ;

GTE
   : '>='
   ;

GT
   : '>'
   ;

LTE
   : '<='
   ;

LT
   : '<'
   ;

EQ
   : '=='
   ;

ASSIGN
   : '='
   ;


POINT
   : '.'
   ;


E
   : 'e' | 'E'
   ;


POW
   : '^'
   ;


LETTER
   : ('a' .. 'z') | ('A' .. 'Z')
   ;


DIGIT
   : ('0' .. '9')
   ;


WS
   : [ \r\n\t] + -> channel (HIDDEN)
   ;
