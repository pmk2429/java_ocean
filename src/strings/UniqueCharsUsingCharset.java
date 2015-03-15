package strings;

import java.util.Scanner;

public class UniqueCharsUsingCharset {
	public static void main(String[] args) {
		System.out.println("Enter String to check for unique chars:");
		System.out.print("> ");
		Scanner in = new Scanner(System.in);
		String inputString = in.nextLine();
		in.close();
		UniqueCharsUsingCharset uniqueObj = new UniqueCharsUsingCharset();
		boolean isUnique = uniqueObj.isUniqueChars(inputString);
		if (isUnique) {
			System.out.println("String contains unique Chars.");
		} else {
			System.out.println("String contains duplicate Chars.");
		}
	}

	public boolean isUniqueChars(String inputString) {
		int checker = 0;
		for (int i = 0; i < inputString.length(); ++i) {
			int value = inputString.charAt(i) - 'a';
			if ((checker & (1 << value)) > 0) {
				return false;
			}
			checker |= (1 << value);
		}
		return true;
	}

	public boolean isUniqueCharsUsingCharSet(String inputString) {
		boolean[] char_set = new boolean[256];

		return true;

	}
}
