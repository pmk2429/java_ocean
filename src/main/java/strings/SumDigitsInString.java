package strings;

import java.util.Scanner;

public class SumDigitsInString {
	public static void main(String[] args) {
		System.out.print("> ");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		int sum = new SumDigitsInString().sumOfDigits(input);
		System.out.println(sum);
		in.close();
	}

	public int sumOfDigits(String input) {
		char[] arr = input.toCharArray();
		int sum = 0;
		String digits = "";
		for (int i = 0; i < arr.length; i++) {
			if (Character.isDigit(arr[i])) {
				digits += arr[i];
			} else {
				if (digits != "") {
					sum += Integer.parseInt(digits);
					digits = "";
				}
			}
		}
		return sum;
	}
}
