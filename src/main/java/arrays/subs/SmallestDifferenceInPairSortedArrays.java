package arrays.subs;

import java.util.Arrays;

/**
 * Smallest Difference a pair of values between two unsorted Arrays
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
public class SmallestDifferenceInPairSortedArrays {

    private static int findSmallestDifference(int[] A, int[] B, int m, int n) {
        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0, j = 0;

        int minDiff = Integer.MAX_VALUE;

        while (i < m && j < n) {
            // store the min difference and keep updating on each iteration
            int currDiff = Math.abs(A[i] - B[j]);
            if (currDiff < minDiff) {
                minDiff = currDiff;
            }

            // Move Smaller Value from 2 Arrays
            if (A[i] < B[j]) {
                i++;
            }
            else {
                j++;
            }
        }

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
