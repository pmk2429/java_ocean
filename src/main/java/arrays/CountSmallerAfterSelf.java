package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to
 * the right of nums[i].
 * <p>
 * Example 1:
 * ----------
 * Input: nums = [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * <p>
 * Example 2:
 * ----------
 * Input: nums = [-1]
 * Output: [0]
 * <p>
 * Example 3:
 * ----------
 * Input: nums = [-1,-1]
 * Output: [0,0]
 * <p>
 * Constraints:
 * ------------
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class CountSmallerAfterSelf {

    private static List<Integer> smallerNumbersAfterSelf(int[] nums) {
        List<Integer> res = new ArrayList<>();

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        System.out.println(smallerNumbersAfterSelf(nums));
        int[] nums1 = {-1};
        System.out.println(smallerNumbersAfterSelf(nums1));
        int[] nums2 = {-1, -1};
        System.out.println(smallerNumbersAfterSelf(nums2));
    }
}
