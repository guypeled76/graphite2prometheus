# Text Based Calculator

Design Goals:
==========================
1. Language specifications should be defined using ebnf and should encapsulate
   the arithmetics operator precedence in it's rules hierarchy.
2. Solution should have an AST (abstract syntax tree) layer that will be used to 
   evaluate the arithemtic expressions. 
3. Language specification rules should be broken to corelate to the required AST
   structure. That will minimize transition code from parse rules to AST.
4. Interaction with the 
   



Implementation Details:
==========================
1. To represent operator precedence rules where categorized into expressions, terms,
   factors and atoms. Precedence is defineds as (1)atom (2)factors (3)terms and (4)expressions.
   See Arithmetic.g4 for complete language specification.
2. The translation between the parse rule tree and the abstract syntax tree
   will be named ExpressionBuilder and will be implemented based on a parse rule 
   tree visitor. 
   See ExpressionBuilder.java for implementation.