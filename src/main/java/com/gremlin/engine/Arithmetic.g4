grammar Arithmetic;
 
content
    : assignment
    | plusAssignment
    | minusAssignment
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
   | moduloTerm
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

moduloTerm
    : factor MODULO term
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
   | minusminusVariable
   | plusplusVariable
   | variableMinusminus
   | variablePlusplus
   | parentheses
   ;

parentheses
    : LPAREN expression RPAREN
    ;

number
   : simpleNumber
   | minusNumber
   | scientificNumber
   | hexNumber
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

hexNumber
   : HEX hexString
   ;

hexString
    : (LETTER | DIGIT)+
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

variableMinusminus
    : variable MINUSMINUS
    ;

variablePlusplus
    : variable PLUSPLUS
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

MODULO
    : '%'
    ;

E
   : 'e' | 'E'
   ;


POW
   : '^'
   ;

HEX 
    : '0x'
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
