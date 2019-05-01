package arrays;

/**
 * Given a big sorted array, find the first index of a target number.
 * Your algorithm should be in O(log k), where k is the first index of the target number.
 * Return -1, if the number doesn't exist in the array.
 * <p>
 * Example
 * Given [1, 3, 6, 9, 21], and target = 3, return 1.
 * Challenge
 * O(log k), k is the first index of the given target number.
 */
public class SearchInBigSortedArray {

  private static int search(int[] arr, int target) {
    int targetIndex = -1;
    if (arr == null || arr.length == 0) {
      return targetIndex;
    }

    int i = 0;
    while (i < arr.length) {
      if (arr[i] == target) {
        targetIndex = i;
      }
      i++;
    }
    return targetIndex;
  }

  public static void main(String[] args) {
    int[] a = {1, 3, 6, 9};
    System.out.println(search(a, 3));
  }
}
