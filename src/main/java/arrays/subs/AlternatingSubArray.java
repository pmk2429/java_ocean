package arrays.subs;

import java.util.Arrays;

/**
 * Length of the continuous longest alternating sub array.
 * Given an array of N including positive and negative numbers only. The task is to find the length of the
 * longest alternating (means negative-positive-negative or positive-negative-positive) sub array present in the array.
 * <p>
 * Examples:
 * ---------
 * Input: a[] = {-5, -1, -1, 2, -2, -3}
 * Output: 3
 * The sub array {-1, 2, -2}
 * <p>
 * Input: a[] = {1, -5, 1, -5}
 * Output: 4
 */
public class AlternatingSubArray {
    public static int longestAlternating(int[] arr, int n) {
        int[] count = new int[n];
        // update the last index to 1
        count[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] * arr[i + 1] < 0) {
                count[i] = count[i + 1] + 1;
            }
            else {
                count[i] = 1;
            }
        }
        return Arrays.stream(count).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] a = {-5, -1, -1, 2, -2, -3};
        System.out.println(longestAlternating(a, a.length));
        int[] b = {1, -5, 1, -5};
        System.out.println(longestAlternating(b, b.length));
    }

}
