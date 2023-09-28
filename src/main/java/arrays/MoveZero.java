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

    public static int[] moveZeroesToLeft(int[] arr) {
        int i = arr.length - 1;
        int j = arr.length - 1;

        while (i >= 0) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                j--;
            }
            i--;
        }

        while (j >= 0) {
            arr[j] = 0;
            j--;
        }

        return arr;
    }

    /*
     * Given an integer array, move all elements containing '0' to the right while maintaining the order of
     * other elements in the array.
     * */
    public static int[] moveZeroesToRight(int[] arr) {
        int i = 0;
        int j = 0;

        while (i < arr.length) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            }
            i++;
        }

        while (j < arr.length) {
            arr[j] = 0;
            j++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 3, 4, 7, 0, 6, 2, 0, 9, 0, 0, 12};
        System.out.print(Arrays.toString(arr) + " ---> ");
        System.out.print(Arrays.toString(moveZeroesWithoutSort(arr)));
        System.out.println();
        int[] arr1 = new int[]{1, 0, 3, 4, 7, 0, 6, 2, 0, 9, 0, 0, 12};
        System.out.print(Arrays.toString(arr1) + " ---> ");
        System.out.print(Arrays.toString(moveZeroesToLeft(arr1)));
        System.out.println();
        int[] arr2 = new int[]{1, 0, 3, 4, 7, 0, 6, 2, 0, 9, 0, 0, 12};
        System.out.print(Arrays.toString(arr2) + " ---> ");
        System.out.print(Arrays.toString(moveZeroesToRight(arr2)));
        System.out.println();
    }
}