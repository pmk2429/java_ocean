package misc;

import java.util.Scanner;

public class Palindrome {
	public static void main(String args[]) {
		String original, reverse = "";
		Scanner in = new Scanner(System.in);

		System.out.println("Enter a string to check if it is a palindrome:");
		System.out.print("> ");
		original = in.nextLine();

		int length = original.length();

		for (int i = length - 1; i >= 0; i--) {
			reverse = reverse + original.charAt(i);
		}

		System.out.println();
		if (original.equals(reverse)) {
			System.out.println("YES, Entered string is a palindrome.");
		} else {
			System.out.println("NO, Entered string is not a palindrome.");
		}

	}
}
