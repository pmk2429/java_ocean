package arrays;

import java.util.Arrays;

public class FirstAndLastIndex {

    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int L = 0;
        int R = nums.length;

        while (L < R) {
            int M = (L + R) / 2;
            if (nums[M] > target || (left && target == nums[M])) {
                R = M;
            }
            else {
                L = M + 1;
            }
        }

        return L;
    }

    private static int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

        return targetRange;
    }

    private static int lastIndex(int[] arr, int target) {
        int L = 0;
        int R = arr.length - 1;
        int lastIndex = -1;

        while (L < R) {
            int M = (L + R) / 2;
            if (arr[M] < target) {
                L = M;
            }
            else if (arr[M] > target) {
                R = M;
            }
            else {
                L = M + 1;
                lastIndex = M;
            }
        }
        return lastIndex;
    }

    private static int indexOf(int[] arr, int target) {
        if (arr.length == 0)
            return -1;

        if (arr.length == 1 && arr[0] == target)
            return 0;

        int L = 0;
        int R = arr.length;
        int startIndex = -1;

        while (L < R) {
            int M = (L + R) / 2;
            if (target < arr[M]) {
                R = M;
            }
            else if (target > arr[M]) {
                L = M;
            }
            else {
                R = M - 1;
                startIndex = M;
            }
        }

        return startIndex;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        System.out.println(indexOf(nums, target));
        System.out.println(lastIndex(nums, target));

        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
