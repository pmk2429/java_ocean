package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in
 * the range [1, n] that do not appear in nums.
 * <p>
 * Example 1:
 * ----------
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * <p>
 * Example 2:
 * ----------
 * Input: nums = [1,1]
 * Output: [2]
 * <p>
 * Constraints:
 * -----------
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * <p>
 * Follow up: Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 */
public class FindAllDisappearedNumbers {

    private static List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int n = nums.length;

        if (n == 1) {
            return Collections.singletonList(nums[0]);
        }

        for (int i = 0; i < n; i++) {
            int newIndex = Math.abs(nums[i]) - 1;

            // Check the magnitude of value at this new index
            // If the magnitude is positive, make it negative
            // thus indicating that the number nums[i] has
            // appeared or has been visited.
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }
        List<Integer> result = new ArrayList<>();

        // this control loop can also be
        // for (int i = min; i <= max; i++)
        for (int i = 1; i <= n; i++) {
            // if the integer element `i` at index `i-1` is not marked as visited, add it to the list
            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
