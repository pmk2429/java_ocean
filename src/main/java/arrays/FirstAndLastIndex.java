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

    private static int findFirst(int[] nums, int target) {
        int firstIndex = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target <= nums[mid]) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
            if (nums[mid] == target) firstIndex = mid;
        }
        return firstIndex;
    }

    private static int findLast(int[] nums, int target) {
        int lastIndex = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target >= nums[mid]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
            if (nums[mid] == target) lastIndex = mid;
        }
        return lastIndex;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6, 8, 8, 8, 9, 10};
        int target = 8;

        System.out.println(findFirst(nums, target));
        System.out.println(findLast(nums, target));

        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
