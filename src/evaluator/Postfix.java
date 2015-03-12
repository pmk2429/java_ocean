package evaluator;

import java.util.Stack;
import java.util.Scanner;
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
		Stack<Integer> stack = new Stack<Integer>();
		int op1 = 0, op2 = 0, result = 0;
		String token;
		StringTokenizer strToken = new StringTokenizer(inputExpression);
		try {

			while (strToken.hasMoreTokens()) {
				token = strToken.nextToken();
				if (isOperator(token)) {
					op2 = ((Integer) stack.pop()).intValue();
					op1 = ((Integer) stack.pop()).intValue();
					result = evaluateSingleOperation(token.charAt(0), op1, op2);
					stack.push(new Integer(result));
				} else {
					stack.push(new Integer(Integer.parseInt(token)));
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		result = ((Integer) stack.pop()).intValue();
		return result;
	}

	private int evaluateSingleOperation(char operation, int op1, int op2) {
		int result = 0;

		if (operation == '+') {
			result = op1 + op2;
		} else if (operation == '-') {
			result = op1 - op2;
		} else if (operation == '*') {
			result = op1 * op2;
		} else if (operation == '/') {
			result = op1 / op2;
		} else if (operation == '^') {
			result = op1 ^ op2;
		}
		return result;
	}

	private boolean isOperator(String token) {
		return (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*"));
	}
}
