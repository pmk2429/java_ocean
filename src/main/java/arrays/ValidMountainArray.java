package arrays;

/**
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 * <p>
 * Recall that A is a mountain array if and only if:
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[B.length - 1]
 * <p>
 * Example 1:
 * ----------
 * Input: [2,1]
 * Output: false
 * <p>
 * Example 2:
 * ----------
 * Input: [3,5,5]
 * Output: false
 * <p>
 * Example 3:
 * ----------
 * Input: [0,3,2,1]
 * Output: true
 * <p>
 * Note:
 * -----
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */
public class ValidMountainArray {

    private static boolean validMountainArray(int[] A) {
        int N = A.length;
        if (N <= 2 || N > 1000) {
            return false;
        }

        int i = 0;

        // climb up
        while (i + 1 < N && A[i] < A[i + 1]) {
            i++;
        }

        // climb down
        while (i + 1 < N && A[i] > A[i + 1]) {
            i++;
        }

        return i == N - 1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 4, 6, 5, 3, 2, 1};
        int[] arr1 = {0, 3, 2, 6, 5, 3, 2, 1};
        int[] arr2 = {0, 2, 4, 5, 1, 7, 6, 3};
        System.out.println(validMountainArray(arr1));
    }
}
