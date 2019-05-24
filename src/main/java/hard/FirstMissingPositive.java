package hard;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * ----------
 * Input: [1,2,0]
 * Output: 3
 * <p>
 * Example 2:
 * ----------
 * Input: [3,4,-1,1]
 * Output: 2
 * <p>
 * Example 3:
 * ----------
 * Input: [7,8,9,11,12]
 * Output: 1
 * Note:
 * <p>
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {

  private static int smallestMissingPositive(int[] nums) {
    if (null == nums || nums.length == 0) {
      return 1;
    }

    int possibleMaxNum = nums.length;

    for (int i = 0; i < nums.length; i++) {
      int idx = nums[i];
      while (idx > 0 && idx <= possibleMaxNum && nums[idx - 1] != idx) {
        // In place sorting of all numbers using an index based sorting technique, which operates in time O(N).
        int temp = nums[idx - 1];
        nums[idx - 1] = idx;
        idx = temp;
      }
    }

    // now loop through the sorted array and check which element is missing
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return possibleMaxNum + 1;
  }

  public static void main(String[] args) {
    int[] a = {3, 4, -1, 1};
    int[] b = {7, 8, 9, 11, 12};
    int[] arr = {2, 3, 7, 6, 8, -1, -10, 15, 1};
    System.out.println("Smallest missing : " + smallestMissingPositive(arr));
  }
}
