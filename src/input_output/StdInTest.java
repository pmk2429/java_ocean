package input_output;

public class StdInTest {
	/**
	 * Interactive test of basic functionality.
	 */
	public static void main(String[] args) {

		System.out.println("Type a string: ");
		String s = StdIn.readString();
		System.out.println("Your string was: " + s);
		System.out.println();

		System.out.println("Type an int: ");
		int a = StdIn.readInt();
		System.out.println("Your int was: " + a);
		System.out.println();

		System.out.println("Type a boolean: ");
		boolean b = StdIn.readBoolean();
		System.out.println("Your boolean was: " + b);
		System.out.println();

		System.out.println("Type a double: ");
		double c = StdIn.readDouble();
		System.out.println("Your double was: " + c);
		System.out.println();

	}
}
