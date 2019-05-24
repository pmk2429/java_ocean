package arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Write two programs to merger 2 sorted arrays
 * <p>
 * 1) Merge two sorted arrays in O(1) space
 * We are given two sorted array. We need to merge these two arrays such that the initial numbers
 * (after complete sorting) are in the first array and the remaining numbers are in the second array.
 * Extra space allowed in O(1).
 * <p>
 * Example 1:
 * ----------
 * Input:
 * ar1[] = {10};
 * ar2[] = {2, 3};
 * Output:
 * ar1[] = {2}
 * ar2[] = {3, 10}
 * <p>
 * Example 2:
 * ----------
 * Input:
 * ar1[] = {1, 5, 9, 10, 15, 20};
 * ar2[] = {2, 3, 8, 13};
 * Output:
 * ar1[] = {1, 2, 3, 5, 8, 9}
 * ar2[] = {10, 13, 15, 20}
 * <p>
 * <p>
 * 2) Merge two sorted arrays in O(nLogn) time
 * - Use Min heap (PriorityQueue)
 */
public class MergeSortedArrays {

  private static int[] mergeUsingMinHeap(int[] a, int[] b) {
    PriorityQueue<Integer> heap = new PriorityQueue<>();

    for (int ele : a) {
      heap.offer(ele);
    }

    for (int ele : b) {
      heap.offer(ele);
    }

    return heap.stream().mapToInt(i -> i).toArray();
  }

  private static void mergeO1Space(int[] a, int[] b) {
    int m = a.length;
    int n = b.length;
    // Iterate through all elements of b[] starting from the last element
    for (int i = n - 1; i >= 0; i--) {
      /* Find the smallest element greater than b[i]. Move all
      elements one position ahead till the smallest greater
      element is not found */
      int j;
      int lastA = a[m - 1];
      // loop from second last element of A and compare each element with B
      for (j = m - 2; j >= 0 && a[j] > b[i]; j--) {
        a[j + 1] = a[j];
      }

      // If there was a greater element
      if (j != m - 2 || lastA > b[i]) {
        a[j + 1] = b[i];
        b[i] = lastA;
      }
    }

    System.out.println(Arrays.toString(a));
    System.out.println(Arrays.toString(b));
  }

  public static void main(String[] args) {
    int[] arr1 = new int[]{1, 5, 9, 10, 15, 20};
    int[] arr2 = new int[]{2, 3, 8, 13};
    mergeO1Space(arr1, arr2);
  }
}
