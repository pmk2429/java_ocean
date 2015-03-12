package misc;

import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciSeries {
	public static void main(String[] args) {
		FibonacciSeries fibonacciObj = new FibonacciSeries();
		System.out.println("Enter the range for Fibonacci series: ");
		System.out.print("> ");
		Scanner input = new Scanner(System.in);
		int range = input.nextInt();

		fibonacciObj.printFibonacciSeries(range);
	}

	private void printFibonacciSeries(int range) {
		int previous = 0, next = 1, temp = 0;
		System.out.print(previous + " ");
		for (int i = 0; i < range; i++) {
			next = next + previous;
			previous = temp;
			temp = next;
			System.out.print(next + " ");
		}

	}
}
