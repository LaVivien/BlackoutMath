# Blackout math puzzle

## Decription

Write code to programmatically solve a Blackout Math puzzle. In a Blackout Math puzzle, you are given an incorrect equation and have to black out (remove) exactly two characters to create a correct equation. For example, consider the puzzle and solution given below.

![Alt text](https://github.com/lavivien-ds-algo/stackBlackoutMath/blob/master/blackout-math.jpg?raw=true "Title")

In your solution, you will need to use stacks to correctly handle operator precedence (e.g., multiplication before addition) and parentheses. For example, the puzzle given below requires all of these.

![Alt text](https://github.com/lavivien-ds-algo/stackBlackoutMath/blob/master/blackout-math2.jpg?raw=true "Title")

As as first step to solving this problem you will need to write a method (evaluate) that evaluates infix expressions. There are 4 case studies.

```
exampleExpression   = "[(21+9)/4]*(2^3-2)";      //should return 42
MalformedExpression = "5+{7**2";                 //should return null

exampleEquation       = "[(137-3)/2]^2=3+2^20+6*7"; //should return the string "[(17-3)/2]^2=3+2^2+6*7"
exampleEquationPuzzle = "168/24+8=11*3-16";         //should return the string "18/2+8=11*3-16"
```

## Requirements

You will write code for two different methods evaluate and solve. Make sure to read the documentation in the file closely before beginning. Here are a couple of more detailed requirements.

As written the solution should handle addition(+), subtraction(−), division(/), multiplica-tion(*), and exponentiation(∧) as well as parentheses ( ), brackets [ ], and curly braces{ }. Additionally it is only expected to handle input expressions with positive integers 0, 1 , 2 ,...(note that the solution may be negative). However, when writing your solution you should keep it as general as possible so that it can easily be extended to handle new operators or parenthesis. Note that you should not modify the static data fieldsOPERATORS,OPEN,CLOSE, or OPERATORPRECEDENCE.

To solve the blackout math problem, you do not need a postfix expression. In your solution you should evaluate the inorder expression directly using a two stack solution “You will need two stacks: one to contain operators and the other to contain operands. When an operand is encountered, it is pushed onto the operand stack. When an operator is encountered, it is pushed onto the operand stack. When an operator is encountered, it is processed as described in the infix to postfix algorithm. When an operator is popped off the operator stack, it is processed as described in the postfix evaluation algorithm: The top two operands are popped off the operand stack, the operation is performed, and the result is pushed back onto the operand stack.”







