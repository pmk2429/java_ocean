package misc;

import java.util.Random;

public class FindKthLargest {
	public static void main(String[] args) {
		int[] nums = new int[5];
		Random random = new Random();
		System.out.println("Numbers: ");
		for (int i = 0; i < nums.length; i++) {
			nums[i] = random.nextInt(10);
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		System.out.println("\n3th largest value in array is: "
				+ findKthLargest(nums, 3));

		System.out.println("\nAfter finding kth element: ");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}

	}

	public static int findKthLargest(int[] nums, int k) {
		// make sure that k is valid and between 0 and nums.length - 1
		if (k < 1 || k > nums.length) {
			return -1;
		}

		return findKthLargest(nums, 0, nums.length - 1, k);
	}

	public static int findKthLargest(int[] nums, int start, int end, int k) {
		/**
		 * Here, Quicksort algorithm is used by picking a pivot and put in place
		 * and check if it is a value we are looking for.
		 */

		int pivot = start;
		int left = start;
		int right = end;

		// ******************************************************************
		// Main loop to put all the values less than pivot
		// to left and all the values greater than pivot on the right.

		while (left <= right) {
			// scan from left to right until we find a value larger than pivot
			// value;

			/**
			 * This while() loop is used to check if the numbers starting from
			 * left until the last element are LESS THAN PIVOT or NOT. If they
			 * are less then pivot, then its OK and keep incrementing LEFT
			 * variable. else stop and store the LEFT variable value.
			 */
			while (left <= right && nums[left] <= nums[pivot]) {
				++left;
			}
			// same for this while() loop but loop only until the values stargin
			// from right are greater than the pivot.
			while (left <= right && nums[right] >= nums[pivot]) {
				--right;
			}
			// Now if left<right then swap its value
			if (left < right) {
				swap(nums, left, right);
			}
			// Main loop ends to put all small and large values to left and
			// right of pivot respectively.

			// ******************************************************************
		}
		/**
		 * Now after the loop, the correct pivot position should rely on right's
		 * position
		 */

		swap(nums, pivot, right);

		// From this point, it is different than Quick sort
		// Unlike from Quick sort, we firstly check if we can return from here.
		if (k == right + 1) { // notice, k it nth so start from 1, while index
								// starts from 0
			return nums[right]; // right is set so just return.
		} else if (k > right + 1) {
			// this means we have divided values in 2 groups and kth largest can
			// exist only on right group.
			return findKthLargest(nums, right + 1, end, k);
		} else {
			// focus on left half;
			return findKthLargest(nums, start, right - 1, k);
		}

	}

	// Method to swap the values
	private static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
