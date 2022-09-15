package arrays;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of
 * the non-zero elements.
 * <p>
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * <p>
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZero {

    private static int[] moveZeroesWithoutSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return null;
        }

        int lastNonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, lastNonZeroIndex++, i);
            }
        }

        return nums;
    }

    private static void swap(@NotNull int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 3, 2, 0, 12};
        System.out.println(Arrays.toString(moveZeroesWithoutSort(arr)));
    }
}