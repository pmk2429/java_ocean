package arrays;

import io.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class FindMinRotatedSortedArray {

    private static int[] nums;

    private static int findRotateIndex(int left, int right) {
        if (nums[left] < nums[right]) {
            return 0;
        }

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1]) {
                return pivot;
            }
            else if (nums[pivot] < nums[left]) {
                right = pivot - 1;
            }
            else {
                left = pivot + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int rotateIndex = findRotateIndex(0, nums.length - 1);
        System.out.println(Arrays.toString(nums) + " rotateIndex -> " + rotateIndex);
        int minElem = nums[rotateIndex + 1];
        System.out.println(minElem);
    }
}
