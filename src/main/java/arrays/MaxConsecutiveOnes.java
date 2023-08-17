package arrays;

/**
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array
 * if you can flip at most k 0's.
 * <p>
 * Example 1:
 * ----------
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * -----------
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * <p>
 * Example 2:
 * ----------
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * <p>
 * Constraints:
 * -----------
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 * 0 <= k <= nums.length
 * <p>
 * ~!@#HARD:REVISE
 */
public class MaxConsecutiveOnes {

    private static int maxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num == 1) {
                count++;
            }
            else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }

        return Math.max(maxCount, count);
    }

    /**
     * Sliding window problem
     * ======================
     * If we included a zero in the window we reduce the value of k.
     * Since k is the maximum zeros allowed in a window.
     * A negative k denotes we have consumed all allowed flips and window has
     * more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
     * If the left element to be thrown out is zero we increase k.
     */
    private static int maxConsecutiveOnes(int[] nums, int k) {
        int i = 0, j;
        for (j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                k--;
            }
            if (k < 0) {
                k += 1 - nums[i];
                i++;
            }
        }
        return j - i;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(maxConsecutiveOnes(nums, k));
    }
}
