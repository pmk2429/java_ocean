package slidingWindow;

import java.util.Arrays;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array
 * to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by
 * one position. Return the max sliding window.
 * <p>
 * Example:
 * --------
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * <p>
 * Window position                Max
 * -------------------------     -----
 * [1  3  -1] -3  5  3  6  7      3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * Note:
 * -----
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * <p>
 * Follow up:
 * ----------
 * Could you solve it in linear time?
 *
 * ~!@#HARD:REVISE
 */
public class SlidingWindowMaximum {

    private static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int sizeOfMaxArr = length - k + 1;
        // contains max at each window
        int[] maxInWindow = new int[sizeOfMaxArr];

        int count = 0;
        for (int i = 0; i < length; i++) {
            int j = i;
            int max = Integer.MIN_VALUE;
            while (j < i + k && j < length) {
                if (nums[j] > max) {
                    max = nums[j];
                }
                j++;
            }

            // add max element in current window to maxArr
            if (count < sizeOfMaxArr) {
                maxInWindow[count++] = max;
            }
        }

        return maxInWindow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
