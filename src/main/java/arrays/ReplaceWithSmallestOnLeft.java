package arrays;

import java.util.Arrays;

/**
 * Replace every element with the smallest element on its left side
 * <p>
 * Given an array of integers, the task is to replace every element with the smallest element on its left side.
 * Note: Replace the first element with -1 as it has no element in its left.
 * Examples:
 * <p>
 * Input: arr[] = {4, 5, 2, 1, 7, 6}
 * Output: -1 4 4 2 1 1
 * Since, 4 has no element in its left, so replace it by -1.
 * For 5, 4 is the smallest element in its left.
 * For 2, 4 is the smallest element in its left.
 * For 1, 2 is the smallest element in its left.
 * For 7, 1 is the smallest element in its left.
 * For 6, 1 is the smallest element in its left.
 * <p>
 * Input: arr[] = {3, 2, 5, 7, 1}
 * Output: -1 3 2 2 2
 */
public class ReplaceWithSmallestOnLeft {

  // O(1) Auxiliary space and O(n) space
  private static int[] replaceWithSmallestOnLeft(int[] arr) {
    // MIN value initialised
    // to element at 0th index
    int min_ele = arr[0];
    arr[0] = -1;

    for (int i = 1; i < arr.length; ++i) {
      // If min_ele is smaller tha arr[i]
      // then just replace arr[i] with min_ele
      if (min_ele < arr[i]) {
        arr[i] = min_ele;
      } // Else if update the min_ele also
      else if (min_ele >= arr[i]) {
        int temp = arr[i];
        arr[i] = min_ele;
        min_ele = temp;
      }
    }
    return arr;
  }

  public static void main(String[] args) {
    int arr[] = {4, 5, 2, 1, 7, 6};
    System.out.println(Arrays.toString(replaceWithSmallestOnLeft(arr)));
  }
}
