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

    private static int maxConsecutiveOnes(int[] nums, int k) {
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            // If we included a zero in the window we reduce the value of k.
            // Since k is the maximum zeros allowed in a window.
            if (nums[right] == 0) {
                k--;
            }
            // A negative k denotes we have consumed all allowed flips and window has
            // more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
            if (k < 0) {
                // If the left element to be thrown out is zero we increase k.
                k += 1 - nums[left];
                left++;
            }
        }
        return right - left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(maxConsecutiveOnes(nums, k));
    }
}
