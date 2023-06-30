package arrays;

/**
 * Find the minimum element in a sorted and rotated array
 * A sorted array is rotated at some unknown point, find the minimum element in it.
 * Following solution assumes that all elements are distinct.
 * <p>
 * Examples:
 * Input: {5, 6, 1, 2, 3, 4}
 * Output: 1
 * Input: {1, 2, 3, 4}
 * Output: 1
 * Input: {2, 1}
 * Output: 1
 */
public class MinimumElementInSortedRotatedArray {

    // Works only for sorted arrays
    private static int findMinimumElement(int[] arr) {
        int minimum = Integer.MAX_VALUE;
        for (int j : arr) {
            if (j < minimum) {
                minimum = j;
            }
        }
        return minimum;
    }

    public static void main(String[] args) {
        int arr[] = {5, 6, 1, 2, 3, 4};
        System.out.println(findMinimumElement(arr));
    }
}
