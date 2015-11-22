package operators;

/**
 * Conditional Operator ( ? : ): 
 * Conditional operator is also known as the
 * ternary operator. This operator consists of three operands and is used to
 * evaluate Boolean expressions. The goal of the operator is to decide which
 * value should be assigned to the variable. The operator is written as:
 * 
 * 	variable x = (expression) ? value if true : value if false
 * 
 * @author Pavitra
 * 
 */

public class ConditionalOperatorDemo {
	public static void main(String[] args) {
		int a, b;
		a = 10;
		System.out.println("a: " + a + "\n");
		System.out.println("b = (a == 1) ? 20 : 30  gives");
		b = (a == 1) ? 20 : 30;
		System.out.println("Value of b = " + b);

		System.out.println("\nb = (a == 10) ? 20 : 30 gives");
		b = (a == 10) ? 20 : 30;
		System.out.println("Value of b = " + b);
	}
}
