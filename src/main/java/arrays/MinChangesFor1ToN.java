package arrays;

import java.util.Arrays;

/**
 * Minimum array element changes to make its elements 1 to N
 * Suppose you are given an array with N elements with any integer values.
 * You need to find the minimum number of elements of the array which must be changed so that array has all
 * integer values between 1 and N(including 1, N).
 * <p>
 * Example 1:
 * ----------
 * Input : arr[] = {1 4 5 3 7}
 * Output : 1
 * We need to replace 7 with 2 to satisfy
 * condition hence minimum changes is 1.
 * <p>
 * Example 2:
 * ----------
 * Input : arr[] = {8 55 22 1 3 22 4 5}
 * Output :3
 */
public class MinChangesFor1ToN {

  private static int minChange(int[] arr) {
    if (arr == null || arr.length == 0) {
      return -1;
    }

    int length = arr.length;
    Arrays.sort(arr);
    int min = arr[0];
    int max = arr[length - 1];

    // this indicates that 1 to N are present
    if (max - min + 1 == length) {
      return 0;
    }

    int count = 0;
    int i = 0;

    while (i < length) {
      int j = i + 1;
      if (j < length) {
        if (arr[j] - arr[i] > 1) {
          count++;
          length--;
        }
      }
      i++;
    }
    return count;
  }

  public static void main(String[] args) {
    int[] a = {8, 55, 22, 1, 3, 22, 4, 5};
    System.out.println(minChange(a));
  }
}
