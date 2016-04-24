package numbers;

import java.util.Arrays;

/**
 * Created by Pavitra on 4/22/2016.
 */
public class MaxSubarray {

    public static void main(String[] args) {
        int[] max = subArraySum(new int[]{-1, 2, -1, -12, 35, 31, 26});
        System.out.println(Arrays.toString(max));
    }

    public static int[] subArraySum(int A[]) {
        int[] m = new int[A.length];
        int startingIndex = A.length - 1;
        int endingIndex = 0;

        //find endingIndex
        m[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            m[i] = Math.max(A[i], m[i - 1] + A[i]);
            if (m[endingIndex] < m[i]) {
                endingIndex = i;
            }
        }

        //find startingIndex
        Arrays.fill(m, 0);
        m[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            m[i] = Math.max(A[i], m[i + 1] + A[i]);
            if (m[startingIndex] < m[i]) {
                startingIndex = i;
            }
        }

        if (endingIndex <= startingIndex) {
            return null;//no array size less than 2 allowed
        }
        int[] result = Arrays.copyOfRange(A, startingIndex, endingIndex + 1);

        return result;
    }
}