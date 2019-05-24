package hard;

import java.util.Arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * ----------
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * <p>
 * Example 2:
 * ----------
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianTwoSortedArrays {

  private static double median(int[] a, int[] b) {
    if (a == null || b == null || a.length == 0 || b.length == 0) {
      return -1;
    }
    int[] union = new int[a.length + b.length];

    int m = a.length;
    int n = b.length;
    int i = 0, j = 0, k = 0;
    while (i < m && j < n) {
      if (a[i] < b[j]) {
        union[k++] = a[i++];
      } else if (b[j] < a[i]) {
        union[k++] = b[j++];
      } else { // handles the case where there are duplicates
        union[k] = a[i];
        k++;
        i++;
        j++;
      }
    }

    // add remaining elements
    while (i < m) {
      union[k++] = a[i++];
    }

    // add remaining elements
    while (j < n) {
      union[k++] = b[j++];
    }

    // now we have the union array so simply find the median based on length of array
    int size = union.length;
    int mid = (size - 1) / 2;
    double median = 0;
    if (size % 2 == 0) {
      median = (double) (union[mid] + union[mid + 1]) / 2;
    } else {
      median = union[mid];
    }
    System.out.println(Arrays.toString(union));
    return median;
  }

  public static void main(String[] args) {
    int[] a = {1, 2};
    int[] b = {3, 4};
    System.out.println(median(a, b));
  }
}
