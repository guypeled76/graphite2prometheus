grammar Arithmetic;
 
content
    : assignment
    | plusAssignment
    | minusAssignment
    | equation
    | expression
    ;

assignment
    : variable ASSIGN expression
    ;

plusAssignment
    : variable PLUSASSIGN expression
    ;

minusAssignment
    : variable MINUSASSIGN expression
    ;

equation
   : expression relop expression
   ;

expression
   : simpleExpression
   | additionExpression
   | subtractionExpression
   ;

simpleExpression
    : term
    ;

additionExpression
    : term PLUS expression
    ;

subtractionExpression
    : term MINUS expression
    ;




term
   : simpleTerm
   | divisionTerm
   | multiplicationTerm
   ;

simpleTerm
    : factor
    ;

multiplicationTerm
    : factor TIMES term
    ;

divisionTerm
    : factor DIV term
    ;

factor
   : simpleFactor
   | powerFactor
   ;

simpleFactor
    : atom
    ;

powerFactor
    : atom POW factor
    ;

atom
   : number
   | variable
   | minusVariable
   | parentheses
   ;

parentheses
    : LPAREN expression RPAREN
    ;

number
   : simpleNumber
   | minusNumber
   | scientificNumber
   ;

minusNumber
    : MINUS simpleNumber
    ;

simpleNumber
    : DIGIT + (POINT DIGIT +)?
    ;

scientificNumber
   : simpleNumber (E simpleNumber)
   ;

relop
   : EQ
   | GT
   | LT
   | LTE
   | GTE
   ;



minusVariable
   : MINUS variable
   ;

minusminusVariable
    : MINUSMINUS variable
    ;

plusplusVariable
    : PLUSPLUS variable
    ;

variable
   : LETTER (LETTER | DIGIT)*
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

MINUSASSIGN
   : '-='
   ;

PLUS
   : '+'
   ;

PLUSASSIGN
   : '+='
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
