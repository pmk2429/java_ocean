package slidingWindow;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous
 * subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 * <p>
 * Example 1:
 * ----------
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * <p>
 * Example 2:
 * ----------
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * <p>
 * Example 3:
 * ----------
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * <p>
 * Constraints:
 * ----------
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * ~!@#HARD:REVISE
 */
public class MinSubArrayLength {
    private static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j++];
            while (sum >= target) {
                min = Math.min(min, j - i); // window
                sum -= nums[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));
    }
}
