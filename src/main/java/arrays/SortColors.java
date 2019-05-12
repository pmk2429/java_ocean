package arrays;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color
 * are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.
 * <p>
 * Example:
 * --------
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * <p>
 * Follow up:
 * ----------
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's,
 * then 1's and followed by 2's.
 * <p>
 * Bonus
 * ------
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class SortColors {

  // Does inplace sorting of elements
  private static int[] sortColors(int[] nums) {
    // for all idx < i : nums[idx < i] = 0 j is an index of element under consideration
    int x = 0, curr = 0;
    // for all idx > k : nums[idx > k] = 2
    int y = nums.length - 1;

    int tmp;
    while (curr <= y) {
      if (nums[curr] == 0) {
        // swap p0-th and curr-th elements
        // i++ and j++
        tmp = nums[x];
        nums[x++] = nums[curr];
        nums[curr++] = tmp;
      } else if (nums[curr] == 2) {
        // swap k-th and curr-th elements
        // p2--
        tmp = nums[curr];
        nums[curr] = nums[y];
        nums[y--] = tmp;
      } else {
        curr++;
      }
    }
    return nums;
  }

  public static void main(String[] args) {
    int[] colors = {2, 0, 2, 1, 1, 0, 2, 0, 1, 2};
    System.out.println(Arrays.toString(sortColors(colors)));
  }
}
