package arrays;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color
 * are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: You are not supposed to use the library's sort function for this problem.
 * <p>
 * Example:
 * --------
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * <p>
 * Follow up:
 * ----------
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's,
 * then 1's and followed by 2's.
 * <p>
 * Bonus
 * ------
 * Could you come up with a one-pass algorithm using only constant space?
 *
 * ~!@#HARD:REVISE
 */
public class SortColors {

    private static void sortColors(int[] A, int n) {
        int n0 = -1, n1 = -1, n2 = -1;
        for (int i = 0; i < n; i++) {
            if (A[i] == 0) {
                A[++n2] = 2;
                A[++n1] = 1;
                A[++n0] = 0;
            }
            else if (A[i] == 1) {
                A[++n2] = 2;
                A[++n1] = 1;
            }
            else if (A[i] == 2) {
                A[++n2] = 2;
            }
        }
        System.out.println(Arrays.toString(A));
    }

    // Does inplace sorting of elements
    private static int[] sortColors(int[] A) {
        int j = 0, k = A.length - 1;
        for (int i = 0; i <= k; i++) {
            if (A[i] == 0) {
                int temp = A[i];
                A[i] = A[j];
                A[j++] = temp;
            }
            else if (A[i] == 2) {
                int temp = A[i];
                A[i--] = A[k];
                A[k--] = temp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] colors = {2, 0, 2, 1, 1, 0, 2, 0, 1, 2};
        sortColors(colors, colors.length);
    }
}
