package arrays.subs;

import java.util.Arrays;

/**
 * Smallest Difference pair of values between two unsorted Arrays
 * Given two arrays of integers, compute the pair of values (one value in each array) with the smallest (non-negative)
 * difference. Return the difference.
 * <p>
 * Examples :
 * ----------
 * Input : A[] = {l, 3, 15, 11, 2}
 * B[] = {23, 127, 235, 19, 8}
 * Output : 3
 * That is, the pair (11, 8)
 * ----------
 * Input : A[] = {l0, 5, 40}
 * B[] = {50, 90, 80}
 * Output : 10
 * That is, the pair (40, 50)
 */
public class SmallestDifferenceInPairnsortedArrays {

  private static int findSmallestDifference(int[] A, int[] B, int m, int n) {
    Arrays.sort(A);
    Arrays.sort(B);

    int a = 0, b = 0;

    // Initialize result as max value
    int minDiff = Integer.MAX_VALUE;

    // Scan Both Arrays upto sizeof of the Arrays
    while (a < m && b < n) {
      // store the min difference and keep updating on each iteration

      if ((Math.abs(A[a]) - Math.abs(B[b])) < minDiff) {
        minDiff = (Math.abs(A[a]) - Math.abs(B[b]));
      }

      // Move Smaller Value from 2 Arrays
      if (A[a] < B[b]) {
        a++;
      } else {
        b++;
      }
    }

    // return final sma result
    return minDiff;
  }

  public static void main(String[] args) {
    int[] A = {1, 2, 11, 5};
    int[] B = {4, 12, 19, 23, 127, 235};

    int m = A.length;
    int n = B.length;

    System.out.println(findSmallestDifference(A, B, m, n));

  }
}
