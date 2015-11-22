package misc;

public class FindBiggest {
	public static void main(String[] args) {
		int[] list = { 15, 25, 84, 14, 5, 99, 105, 24, 150 };
		int secondBig = 0;
		int big = 0;
		for (int n : list) {
			if (big < n) {
				secondBig = big;
				big = n;
			} else if (secondBig < n) {
				secondBig = n;
			}
		}
		System.out.println("Largest in Array:      " + big);
		System.out.println("Second Largest in Array: " + secondBig);

		/*
		 * Code to find the largest in an array:
		 * 
		 * for(int i=0;i<list.length;i++){ if(big < list[i]){ big = list[i]; } }
		 * System.out.println("Largets in array: " + big);
		 */

	}
}
