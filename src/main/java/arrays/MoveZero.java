package arrays;

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

  private static int[] moveZeroesWithoutSort(int[] arr) {
    int i = 0;
    int j = arr.length - 1;
    int n = arr.length;

    while (i < n && j > 0) {
      if (arr[i] == 0) {
        // swap elements
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        j--;
      }
      i++;
    }

    return arr;
  }

  private static void moveZeroes(int[] arr) {
    Arrays.sort(arr);
    // distance is total number of zeroes to move left(end) of array
    int distance = 0;
    int length = arr.length;
    for (int anArr : arr) {
      if (anArr == 0) {
        distance++;
      }
    }

    for (int j = 0; j < distance; j++) {
      // arr iteration
      int temp = arr[0];
      for (int d = 0; d < length - 1; d++) {
        arr[d] = arr[d + 1];
      }
      arr[length - 1] = temp;
    }

    System.out.println(Arrays.toString(arr));
  }

  public static void main(String[] args) {
    int[] arr = new int[]{0, 1, 0, 3, 12};
    moveZeroes(arr);
    System.out.println(Arrays.toString(moveZeroesWithoutSort(arr)));
  }
}