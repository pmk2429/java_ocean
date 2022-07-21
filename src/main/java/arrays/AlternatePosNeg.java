package arrays;

import java.util.Arrays;

/**
 * Rearrange array in alternating positive and negative number.
 * <p>
 * Given an array of positive and negative numbers, arrange them in an alternate fashion such that
 * every positive number is followed by negative and vice-versa maintaining the order of appearance.
 * <p>
 * Number of positive and negative numbers need not be equal. If there are more positive numbers
 * they appear at the end of the array. If there are more negative numbers, they too appear in the end of the array.
 * <p>
 * Example:
 * <p>
 * Input: {1, 2, 3, -4, -1, 4};
 * Output: {-4, 1, -1, 2, 3, 4}
 * <p>
 * Input: {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
 * Output: {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}
 */
public class AlternatePosNeg {

    // move all negative integers to start of the array
    private static int[] segregate(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return arr;
    }

    private static int[] alternate(int[] arr) {
        int length = arr.length;
        int[] segArr = segregate(arr);
        int neg = 0;
        int pos = 0;

        while (segArr[pos] < 0) {
            pos++;
        }

        int[] res = new int[length];

        int i = 0;
        while (i < length) {
            res[i++] = segArr[neg++];
            res[i++] = segArr[pos++];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(alternate(new int[]{1, 2, 3, -4, -1, 4})));
    }
}
