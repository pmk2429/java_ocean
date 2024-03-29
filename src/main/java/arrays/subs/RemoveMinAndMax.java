package arrays.subs;

/**
 * Example 1:
 * ----------
 * Input: nums = [2,10,7,5,4,1,8,6]
 * Output: 5
 * Explanation:
 * The minimum element in the array is nums[5], which is 1.
 * The maximum element in the array is nums[1], which is 10.
 * We can remove both the minimum and maximum by removing 2 elements from the front and 3 elements from the back.
 * This results in 2 + 3 = 5 deletions, which is the minimum number possible.
 * <p>
 * Example 2:
 * ----------
 * Input: nums = [0,-4,19,1,8,-2,-3,5]
 * Output: 3
 * Explanation:
 * The minimum element in the array is nums[1], which is -4.
 * The maximum element in the array is nums[2], which is 19.
 * We can remove both the minimum and maximum by removing 3 elements from the front.
 * This results in only 3 deletions, which is the minimum number possible.
 * <p>
 * Example 3:
 * ----------
 * Input: nums = [101]
 * Output: 1
 * Explanation:
 * There is only one element in the array, which makes it both the minimum and maximum element.
 * We can remove it with 1 deletion.
 */
public class RemoveMinAndMax {

    private static int minMaxDeletion(int[] nums) {
        int minIdx = -1;
        int maxIdx = -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }

            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }

        int firstDiff = Math.max(maxIdx, minIdx) + 1;
        int lastDiff = n - Math.min(maxIdx, minIdx);
        int midDiff = n - Math.max(maxIdx, minIdx) + Math.min(maxIdx, minIdx) + 1;

        // return lowest of 3
        return Math.min(Math.min(firstDiff, lastDiff), midDiff);
    }

    public static void main(String[] args) {
        int[] nums = {0, -4, 19, 1, 8, -2, -3, 5};
        System.out.println(minMaxDeletion(nums));
    }
}
