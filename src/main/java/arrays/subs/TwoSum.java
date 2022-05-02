package arrays.subs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [5, 8, 2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[2] + nums[3] = 2 + 7 = 9,
 * return [2, 3].
 */
public class TwoSum {

    // Solving the problem using the Complement Technique where one element complements another
    private static int[] twoSum(int[] arr, int target) {
        int[] twoSum = {-1, -1};
        Map<Integer, Integer> elements = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (elements.containsKey(complement) && elements.get(complement) != i) {
                twoSum[0] = elements.get(complement);
                twoSum[1] = i;
            }
            // create a hashmap of elements and its index
            elements.put(arr[i], i);
        }
        return twoSum;
    }

    private static int binarySearch(int[] A, int key, int start) {
        int L = start, R = A.length - 1;
        while (L < R) {
            int M = (L + R) / 2;
            if (A[M] < key) {
                L = M + 1;
            }
            else {
                R = M;
            }
        }
        return (L == R && A[L] == key) ? L : -1;
    }

    // O(1) Auxiliary space and O(n) time
    private static int[] twoSumBinarySearch(int[] numbers, int target) {
        // Assume input is already sorted
        for (int i = 0; i < numbers.length; i++) {
            int j = binarySearch(numbers, target - numbers[i], i + 1);
            if (j != -1) {
                return new int[]{i + 1, j + 1};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] a = {5, 8, 2, 11, 7, 6, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(a, target)));
        System.out.println(Arrays.toString(twoSumBinarySearch(a, target)));
    }
}
