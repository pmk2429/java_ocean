package arrays;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * ----------
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * <p>
 * Example 2:
 * ----------
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class FindElementInRotatedArray {

    private static int[] nums;
    private static int target;

    private static int findRotateIndex(int left, int right) {
        if (nums[left] < nums[right]) {
            return 0;
        }

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1]) {
                return pivot + 1;
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

    /**
     * Performs Binary Search
     */
    private static int binarySearchIndex(int left, int right) {
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target) {
                return pivot;
            }
            else if (target < nums[pivot]) {
                right = pivot - 1;
            }
            else {
                left = pivot + 1;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int tgt) {
        nums = arr;
        target = tgt;

        int n = nums.length;

        if (n == 0) {
            return -1;
        }

        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int rotateIndex = findRotateIndex(0, n - 1);

        // if target is the smallest element
        if (nums[rotateIndex] == target) {
            return rotateIndex;
        }
        // if array is not rotated, search in the entire array
        if (rotateIndex == 0) {
            return binarySearchIndex(0, n - 1);
        }

        if (target < nums[0]) {
            // right sub array
            return binarySearchIndex(rotateIndex, n - 1);
        }
        else {
            // left sub array
            return binarySearchIndex(0, rotateIndex);
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(binarySearch(a, target));
    }
}
