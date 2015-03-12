package misc;

import java.util.Scanner;

public class ReverseNumber {
	public static void main(String[] args) {
		System.out.println("Enter the number to Reverse:");
		System.out.print("> ");
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		input.close();
		ReverseNumber reverseObj = new ReverseNumber();
		int reversedNumber = reverseObj.reverseNumber(number);
		System.out.println("\nReverse of entered number is: " + reversedNumber);
	}

	private int reverseNumber(int number) {
		int reverse = 0;
		int remainder = 0;

		do {
			remainder = number % 10;
			reverse = reverse * 10 + remainder;
			number = number / 10;

		} while (number > 0);
		return reverse;
	}
}
