package arrays;

/**
 * You are given an integer array nums.
 * You are initially positioned at the array's first index, and each element in the array represents your maximum jump
 * length at that position.
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * Example 1:
 * ----------
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Example 2:
 * ----------
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what.
 * Its maximum jump length is 0, which makes it impossible to reach the last index.
 * <p>
 * Constraints:
 * ----------
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */
public class CanJump {

    private static boolean canJump(int[] nums) {
        int currMaximum = 0;
        int checker = 0;
        if (nums.length == 1) {
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            currMaximum = Math.max(currMaximum, nums[i] + i);
            if (checker == i) {
                checker = currMaximum;
            }
            if (currMaximum >= nums.length - 1) {
                return true;
            }
            if (nums[checker] == 0 && i == checker) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("2, 3, 1, 1, 4 -> " + canJump(nums));
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("3, 2, 1, 0, 4 -> " + canJump(nums2));
    }
}
