# Text Based Calculator

Design Goals:
==========================
1. Language specifications should be defined using ebnf and should encapsulate
   the arithmetics operator precedence in it's rules hierarchy.
2. Solution should have an AST (abstract syntax tree) layer that will be used to 
   evaluate the arithemtic expressions. 
3. Language specification rules should be broken to corelate to the required AST
   structure. That will minimize transition code from parse rules to AST.
4. The AST model will also contain the arithmetic executing code which will
   enable to prevent conditional code and use object oriented to distinguish
   between the diffrent operations.
        - Example 1:
          2 + 2 is represented as a binary expression that holds the operator kind
          and left/right numeric expressions. When calling the evaluate method of
          the binary expression instance we will get a numeric expression of 4.
        - Example 2:
          a = 2 + 2 is represented as an assignment expression that has a variable
          expression as it's target and a binary expression as in example 1.
          When calling the execute method on the assignmet expresion the value will
          be evaluated as in the first example and the result will be stored in 
          the encapsulating process state.
   



Implementation Details:
==========================
1. To represent operator precedence rules where categorized into expressions, terms,
   factors and atoms. Precedence is defineds as (1)atom (2)factors (3)terms and (4)expressions.
   See Arithmetic.g4 for complete language specification.
2. The translation between the parse rule tree and the abstract syntax tree
   will be named ExpressionBuilder and will be implemented based on a parse rule 
   tree visitor. 
   See ExpressionBuilder.java for implementation.