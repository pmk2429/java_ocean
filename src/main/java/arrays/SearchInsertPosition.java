package arrays;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index
 * where it would be if it were inserted in order. You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * ----------
 * Input: [1,3,5,6], 5
 * Output: 2
 * <p>
 * Example 2:
 * ----------
 * Input: [1,3,5,6], 2
 * Output: 1
 * <p>
 * Example 3:
 * ----------
 * Input: [1,3,5,6], 7
 * Output: 4
 * <p>
 * Example 4:
 * ----------
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class SearchInsertPosition {
    private static int searchInsert(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;

        while (L <= R) {
            int M = (L + R) / 2;
            if (target < nums[M]) {
                R = M - 1;
            }
            else {
                L = M + 1;
            }
        }
        return L;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 4;
        System.out.println(searchInsert(nums1, target1));
    }
}
