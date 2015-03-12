package operators;

/**
 * instanceof Operator: This operator is used only for object reference
 * variables. The operator checks whether the object is of a particular
 * type(class type or interface type). instanceof operator is written as:
 * 
 * 
 * 	( Object reference variable ) instanceof (class/interface type)
 * 
 * If the object referred by the variable on the left side of the operator passes the IS-A
 * check for the class/interface type on the right side, then the result will be
 * true.
 * 
 * @author Pavitra
 * 
 */

public class InstanceofOperatorDemo {
	public static void main(String[] args) {
		String name = "James";
		Integer number = 10;
		// following will return true since name is type of String
		System.out.println("name: " + name + "; is a String object");
		System.out.println("Expression: <name instanceof String> will yield");
		boolean result = name instanceof String;
		System.out.println(result);

		System.out.println();
		System.out.println("number: " + number
				+ "; is an Integer class object not primitive type");
		System.out
				.println("Expression: <number instanceof Integer> will yield");
		boolean result1 = number instanceof Integer;
		System.out.println(result1);
	}
}
