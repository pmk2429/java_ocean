package arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array
 * to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by
 * one position. Return the max sliding window.
 * <p>
 * Example:
 * --------
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * <p>
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7      3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * Note:
 * -----
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 * <p>
 * Follow up:
 * ----------
 * Could you solve it in linear time?
 */
public class SlidingWindowMaximum {

  private static int[] maxSlidingWindow(int[] nums, int k) {
    int sizeOfMaxArr = nums.length - k + 1;
    // contains max at each window
    int[] maxInWindow = new int[sizeOfMaxArr];

    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      int j = i;
      int max = Integer.MIN_VALUE;
      while (j < i + 3 && j < nums.length) {
        if (nums[j] > max) {
          max = nums[j];
        }
        j++;
      }

      // add max element in current window to maxArr
      if (count < sizeOfMaxArr) {
        maxInWindow[count++] = max;
      }
    }

    return maxInWindow;
  }

  // Function to print the maximum for every k size sub-array
  private static void printMaxInSlidingWindow(int[] a, int n, int k) {
    // max_upto array stores the index
    // upto which the maximum element is a[i]
    // i.e. max(a[i], a[i + 1], ... a[max_upto[i]]) = a[i]

    int[] max_upto = new int[n];

    // Update max_upto array similar to
    // finding next greater element
    Stack<Integer> s = new Stack<>();
    s.push(0);
    for (int i = 1; i < n; i++) {
      while (!s.empty() && a[s.peek()] < a[i]) {
        max_upto[s.peek()] = i - 1;
        s.pop();
      }
      s.push(i);
    }
    while (!s.empty()) {
      max_upto[s.peek()] = n - 1;
      s.pop();
    }
    int j = 0;
    for (int i = 0; i <= n - k; i++) {
      // j < i is to check whether the
      // jth element is outside the window
      while (j < i || max_upto[j] < i + k - 1) {
        j++;
      }
      System.out.print(a[j] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;

    System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
  }
}
