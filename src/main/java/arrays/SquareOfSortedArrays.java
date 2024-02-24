package arrays;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted
 * in non-decreasing order.
 * <p>
 * Example 1:
 * ----------
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * <p>
 * Example 2:
 * ----------
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * <p>
 * Constraints:
 * ----------
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 * <p>
 * Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using
 * a different approach?
 */
public class SquareOfSortedArrays {
    /**
     * Starting from the end of the array, find the greater element using its absolute value.
     * If the element is greater at the end of array, do the square and decrement the end counter else do the square
     * with the start counter and increment the start counter.
     */
    private static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int start = 0;
        int end = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int square;
            // first move the start or end pointers based on their absolute value
            if (Math.abs(nums[end]) > Math.abs(nums[start])) {
                square = nums[end];
                end--;
            }
            else {
                square = nums[start];
                start++;
            }
            result[i] = square * square;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
        int[] nums2 = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares(nums2)));
    }
}
