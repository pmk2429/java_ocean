package arrays;

import java.util.Arrays;

/**
 * WAP to Replace every element of the array by sum of all other elements.
 * <p>
 * Given an array of size N, the task is to find the encrypted array. The encrypted array is obtained by replacing
 * each element of the original array with the sum of the remaining array elements i.e.
 * <p>
 * For every i, arr[i] = sumOfArrayElements – arr[i]
 * Examples:
 * Input:  arr[] = {5, 1, 3, 2, 4}
 * Output: 10 14 12 13 11
 * Original array {5, 1, 3, 2, 4}
 * <p>
 * Encrypted array is obtained as:
 * = {1+3+2+4, 5+3+2+4, 5+1+2+4, 5+1+3+4, 5+1+3+2}
 * = {10, 14, 12, 13, 11}
 * Each element of original array is replaced by the sum of the remaining array elements.
 * <p>
 * <p>
 * Input: arr[] = {6, 8, 32, 12, 14, 10, 25 }
 * Output: 101 99 75 95 93 97 82
 */
public class ReplaceWithSum {

    private static void replaceWithSumExceptSelf(int[] arr) {
        int[] sumArr = new int[arr.length];
        int sum = Arrays.stream(arr).sum();

        for (int i = 0; i < arr.length; i++) {
            sumArr[i] = sum - arr[i];
        }
        System.out.println(Arrays.toString(sumArr));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 8, 32, 12, 14, 10, 25};
        replaceWithSumExceptSelf(arr);
    }
}
