package evaluator;

import java.util.Stack;

/**
 * ReversPolish notation Class evaluates the ReversePolishNotation. For a given
 * expression: "2", "1", "+", "3", "*", "3", "/", "5", "+" , the the
 * evalRPN(String []) method will receive an Array of String and will process
 * the Array for operators and operands. We can loop through each element in the
 * given array. When it is a number, push it to the stack. When it is an
 * operator, pop two numbers from the stack, do the calculation, and push back
 * the result.
 */

public class ReversePolish {
    private static int evalRPN(String[] tokens) {
        int returnValue;
        String operators = "+-*/";
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (!operators.contains(token)) {
                stack.push(token);
            }
            else {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                switch (token) {
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(b - a));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }
        returnValue = Integer.parseInt(stack.pop());
        return returnValue;
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*", "3", "/", "5", "+"};
        System.out.println(evalRPN(tokens));
    }
}
