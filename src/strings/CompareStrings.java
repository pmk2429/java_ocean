package strings;

import java.util.Scanner;

public class CompareStrings {
	public static void main(String[] args) {
		System.out.println("Enter strings to compare:");
		System.out.print("String 1> ");
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		System.out.print("String 2> ");
		Scanner input2 = new Scanner(System.in);
		String inputString2 = input2.nextLine();
		CompareStrings stringObj = new CompareStrings();

		boolean compare = stringObj.compareStrings(inputString, inputString2);
		if (compare == true) {
			System.out.println("\nYES, strings are equal!!!");
		} else {
			System.out.println("\nNO, strings are not equal!!!");
		}
	}

	private boolean compareStrings(String inputString, String inputString2) {
		boolean compare = inputString.equals(inputString2);
		return compare;
	}
}
