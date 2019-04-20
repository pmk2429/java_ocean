package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted sequence a[], the task is to find the K-th missing contiguous element in the increasing sequence
 * of the array elements i.e. consider the array in sorted order and find the kth missing number.
 * If no k-th missing element is there output -1.
 * <p>
 * Note: Only elements exists in the range of minimum and maximum element to be considered.
 * <p>
 * Example 1:
 * ----------
 * Input: arr[] = {2, 4, 10, 7}, k = 5
 * Output: 9
 * Missing elements in the given array: 3, 5, 6, 8, 9
 * 5th missing is 9.
 * <p>
 * Example 2:
 * ----------
 * Input: arr[] = {1, 3, 4}, k = 5
 * Output: -1
 */
public class KthMissingElementInUnsortedArray {
  private static int findKthMissing(int[] arr, int n, int k) {
    Set<Integer> missing = new HashSet<>();
    int count = 0;

    // Insert all the elements in a set
    for (int i = 0; i < n; i++) {
      missing.add(arr[i]);
    }

    // Find the maximum and minimum element
    int min = Arrays.stream(arr).min().getAsInt();
    int max = Arrays.stream(arr).max().getAsInt();

    // Traverse from the minimum to maximum element
    for (int i = min; i <= max; i++) {
      // Check if "i" is missing
      if (!missing.contains(i)) {
        count++;
      }

      // Check if it is kth missing
      if (count == k) {
        return i;
      }
    }

    // If no kth element is missing
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {2, 10, 9, 4};
    int n = arr.length;
    int k = 5;

    System.out.println(findKthMissing(arr, n, k));
  }
}
