package numbers;

import slidingWindow.SlidingWindowMaximum;

/**
 * Same as {@link SlidingWindowMaximum}
 */
public class SlidingWindowKSum {

    /**
     * Returns maximum sum in a sub array of size k.
     */
    private static int maxSum(int[] arr, int n, int k) {
        int maxSum = Integer.MIN_VALUE;
        int iteratorIndex = n - k + 1;
        // Consider all blocks starting with 'i'.
        for (int i = 0; i < iteratorIndex; i++) {
            int currentSum = 0;
            for (int j = 0; j < k; j++) {
                currentSum += arr[i + j];
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        int n = arr.length;
        System.out.println(maxSum(arr, n, k));
    }

}
