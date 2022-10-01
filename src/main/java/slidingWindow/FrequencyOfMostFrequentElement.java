package slidingWindow;

import java.util.Arrays;

/**
 * The frequency of an element is the number of times it occurs in an array.
 * You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and
 * increment the element at that index by 1.
 * Return the maximum possible frequency of an element after performing at most k operations.
 * <p>
 * Example 1:
 * ==========
 * Input: nums = [1,2,4], k = 5
 * Output: 3
 * Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
 * 4 has a frequency of 3.
 * <p>
 * Example 2:
 * ==========
 * Input: nums = [1,4,8,13], k = 5
 * Output: 2
 * Explanation: There are multiple optimal solutions:
 * - Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
 * - Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
 * - Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
 * <p>
 * Example 3:
 * ==========
 * Input: nums = [3,9,6], k = 2
 * Output: 1
 *
 * ~!@#HARD:REVISE
 */
public class FrequencyOfMostFrequentElement {
    /**
     * the key is to find out the valid condition:
     * k + sum >= size * max
     * which is
     * k + sum >= (j - i + 1) * A[j]
     * <p>
     * For every new element A[j] to the sliding window,
     * Add it to the sum by sum += A[j].
     * Check if it's valid window by
     * sum + k < (long)A[j] * (j - i + 1)
     * <p>
     * If not, removing A[i] from the window by
     * sum -= A[i] and i += 1.
     */
    private static int maxFrequency(int[] A, int k) {
        int res = 1, i = 0, j;
        int sum = 0;
        Arrays.sort(A);
        for (j = 0; j < A.length; j++) {
            sum += A[j];
            while (sum + k < (long) A[j] * (j - i + 1)) {
                sum -= A[i];
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4};
        int k = 5;
        System.out.println(maxFrequency(nums, k));

        int[] nums1 = {1, 4, 8, 13};
        int k1 = 5;
        System.out.println(maxFrequency(nums1, k1));
    }
}
