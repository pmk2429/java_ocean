package strings;

import java.util.Scanner;

public class StringToInt {
	public static void main(String[] args) {
		System.out.println("Enter String:");
		System.out.print("> ");
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		input.close();
		int data = strToInt(text);
		System.out.println("Integer equivalent: " + data);
	}

	public static int strToInt(String str) {
		int i = 0;
		int num = 0;
		boolean isNeg = false;

		// Check for negative sign; if it's there, set the isNeg flag
		if (str.charAt(0) == '-') {
			isNeg = true;
			i = 1;
		}

		// Process each character of the string;
		while (i < str.length()) {
			num *= 10;
			num += str.charAt(i++) - '0'; // Minus the ASCII code of '0' to get
											// the value of the charAt(i++).
		}

		if (isNeg) {
			num = -num;
		}
		return num;
	}
}
