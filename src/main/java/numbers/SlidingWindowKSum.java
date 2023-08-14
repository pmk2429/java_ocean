package numbers;

import slidingWindow.SlidingWindowMaximum;

/**
 * Same as {@link SlidingWindowMaximum}
 */
public class SlidingWindowKSum {

    /**
     * Returns maximum sum in a sub array of size k.
     */
    private static int maxSum(int[] arr, int k) {
        int length = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int iteratorIndex = length - k + 1;
        // Consider all blocks starting with 'i'.
        for (int i = 0; i < iteratorIndex; i++) {
            int currentSum = 0;
            int j = i;
            while (j < i + k && j < length) {
                currentSum += arr[j];
                j++;
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        System.out.println(maxSum(arr, k));
    }

}
