package numbers;

import java.util.Scanner;

public class Prime {
	static int inputNumber;

	public static void main(String[] args) {
		System.out.println("Enter the number to find the sum of its digits:");
		System.out.print("> ");
		Scanner input = new Scanner(System.in);
		inputNumber = input.nextInt();
		input.close();
		Prime primeObj = new Prime();
		boolean check = primeObj.checkPrime(inputNumber);
		primeObj.printResult(check);

	}

	private void printResult(boolean result) {
		if (result == true) {
			System.out.println("\nYES, Number " + Prime.inputNumber
					+ " is prime!!!");
		} else {
			System.out.println("\nNO, Number " + Prime.inputNumber
					+ " is not a prime");
		}

	}

	private boolean checkPrime(int inputNumber) {
		boolean result = true;
		for (int i = 2; i <= inputNumber / 2; i++) {
			if (inputNumber % i == 0) {
				result = false;
			}
		}
		return result;
	}
}
