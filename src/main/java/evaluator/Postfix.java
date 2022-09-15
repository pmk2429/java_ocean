package evaluator;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Postfix {
	public static void main(String[] args) {
		System.out.println("Enter input POSTFIX expression:");
		System.out.print("> ");
		Scanner input = new Scanner(System.in);
		String inputExpression = input.nextLine();
		input.close();
		Postfix postfixObj = new Postfix();
		int expressionResult = postfixObj.evaluatePostfixExpression(inputExpression);
		System.out.println("Result: " + expressionResult);

	}

	public int evaluatePostfixExpression(String inputExpression) {
		Stack<Integer> stack = new Stack<>();
		int op1, op2, result;
		String token;
		StringTokenizer strToken = new StringTokenizer(inputExpression);
		try {
			while (strToken.hasMoreTokens()) {
				token = strToken.nextToken();
				if (isOperator(token)) {
					op2 = stack.pop();
					op1 = stack.pop();
					result = evaluateSingleOperation(token.charAt(0), op1, op2);
					stack.push(result);
				} else {
					stack.push(Integer.parseInt(token));
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return stack.pop();
	}

	private int evaluateSingleOperation(char operator, int op1, int op2) {
		int result = 0;

		if (operator == '+') {
			result = op1 + op2;
		} else if (operator == '-') {
			result = op1 - op2;
		} else if (operator == '*') {
			result = op1 * op2;
		} else if (operator == '/') {
			result = op1 / op2;
		} else if (operator == '^') {
			result = op1 ^ op2;
		}
		return result;
	}

	private boolean isOperator(String token) {
		return (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*") || token.equals("^"));
	}
}
