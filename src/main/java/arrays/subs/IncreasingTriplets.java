package arrays.subs;

/**
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k)
 * such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 * <p>
 * Example 1:
 * ----------
 * Input: nums = [1,2,3,4,5]
 * Output: true
 * Explanation: Any triplet where i < j < k is valid.
 * <p>
 * Example 2:
 * ----------
 * Input: nums = [5,4,3,2,1]
 * Output: false
 * Explanation: No triplet exists.
 * <p>
 * Example 3:
 * ----------
 * Input: nums = [2,1,5,0,4,6]
 * Output: true
 * Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 * <p>
 * Constraints:
 * ----------
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * Follow up: Could you implement a solution that runs in O(n) time complexity and O(1) space complexity?
 * This problem is similar to {@link arrays.ThirdLargest} except we don't need to find ThirdLargest.
 */
public class IncreasingTriplets {
    private static boolean increasingTriplet(int[] nums) {
        int firstNum = Integer.MAX_VALUE;
        int secondNum = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= firstNum) {
                firstNum = n;
            }
            else if (n <= secondNum) {
                secondNum = n;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
    }
}
