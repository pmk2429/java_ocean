package misc;

import java.util.Scanner;

public class Armstrong {
	static int inputNumber;

	public static void main(String[] args) {
		System.out
				.println("Enter the number to check whether it is Armstrong or not:");
		System.out.print("> ");
		Scanner input = new Scanner(System.in);
		inputNumber = input.nextInt();
		input.close();
		Armstrong armstrongObj = new Armstrong();
		boolean check = armstrongObj.isArmstrong(inputNumber);
		armstrongObj.printResult(check);

	}

	private void printResult(boolean result) {
		if (result == true) {
			System.out.println("\nYES, Number " + Armstrong.inputNumber
					+ " is armstrong no!!!");
		} else {
			System.out.println("\nNO, Number " + Armstrong.inputNumber
					+ " is not a armstrong no.");
		}
	}

	private boolean isArmstrong(int inputNumber) {
		boolean result = false;
		int div = 0, sum = 0, divCubed = 0;
		int originalNumber = inputNumber;
		while (originalNumber > 0) {
			div = originalNumber % 10;
			divCubed = div * div * div;
			sum += divCubed;
			originalNumber = originalNumber / 10;
		}
		if (sum == inputNumber) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
}
