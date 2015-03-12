package search;

import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {
		int c, first, last, middle, n, search, array[];

		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of elements:");
		System.out.print("> ");
		n = in.nextInt();
		array = new int[n];

		System.out.println();
		System.out.println("Enter " + n + " integers:");
		System.out.print("> ");

		for (c = 0; c < n; c++) {
			array[c] = in.nextInt();
		}

		System.out.println();
		System.out.println("Enter value to find:");
		System.out.print("> ");
		search = in.nextInt();

		first = 0;
		last = n - 1;
		middle = (first + last) / 2;

		while (first <= last) {
			if (array[middle] < search) {
				first = middle + 1;
			} else if (array[middle] == search) {
				System.out.println(search + " found at location " + (middle + 1) + ".");
				break;
			} else {
				last = middle - 1;
			}
			middle = (first + last) / 2;
		}
		System.out.println();
		if (first > last) {
			System.out.println("->" + search + " is not present in the list.\n");
		}
	}
}
