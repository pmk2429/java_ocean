package arrays;

import java.util.Arrays;

/**
 * Given an array arr[] of size n, its prefix sum array is another array prefixSum[] of same size such that
 * the value of prefixSum[i] is arr[0] + arr[1] + arr[2] … arr[i].
 * <p>
 * Examples :
 * <p>
 * Input  : arr[] = {10, 20, 10, 5, 15}
 * Output : prefixSum[] = {10, 30, 40, 45, 60}
 * <p>
 * Explanation : While traversing the array, update
 * the element by adding it with its previous element.
 * prefixSum[0] = 10,
 * prefixSum[1] = prefixSum[0] + arr[1] = 30,
 * prefixSum[2] = prefixSum[1] + arr[2] = 40 and so on.
 */
public class PrefixSum {

    // Fills prefix sum array
    private static void fillPrefixSum(int[] arr, int[] prefixSum) {
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 16, 20};
        int[] prefixSum = new int[arr.length];

        fillPrefixSum(arr, prefixSum);

        Arrays.stream(prefixSum).forEach(System.out::println);
    }
}
