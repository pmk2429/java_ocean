package arrays;

import java.util.ArrayList;

/**
 * Remove minimum number of elements such that no common element exist in both array
 * Given two arrays A[] and B[] consisting of n and m elements respectively.
 * Find minimum number of elements to remove from each array such that no common element exist in both.
 * <p>
 * Example 1:
 * ----------
 * Input : A[] = { 1, 2, 3, 4}
 * B[] = { 2, 3, 4, 5, 8 }
 * Output : 3
 * We need to remove 2, 3 and 4 from any array.
 * <p>
 * Example 2:
 * ----------
 * Input : A[] = { 4, 2, 4, 4}
 * B[] = { 4, 3 }
 * Output : 1
 * We need to remove 4 from from B[]
 * <p>
 * Example 3:
 * ----------
 * Input : A[] = { 1, 2, 3, 4 }
 * B[] = { 5, 6, 7 }
 * Output : 0
 * There is no common element in both.
 */
public class MinimumRemove {

  private static int minRemove(int[] a, int[] b) {
    int minRemove = -1;
    int n = a.length;
    int m = b.length;

    if (a.length == 0 || b.length == 0) {
      return minRemove;
    }

    int i = 0, j = 0;

    ArrayList<Integer> intersection = new ArrayList<>();

    while (i < n && j < m) {
      if (a[i] < b[j]) {
        i++;
      } else if (b[j] < a[i]) {
        j++;
      } else {
        // when both are equal
        intersection.add(a[i]);
        i++;
        j++;
      }
    }
    minRemove = intersection.stream().mapToInt(val -> val).toArray().length;

    return minRemove;
  }

  public static void main(String[] args) {
    int[] A = {1, 2, 3, 4};
    int[] B = {2, 3, 4, 5, 8};

    System.out.println(minRemove(A, B));
  }
}
