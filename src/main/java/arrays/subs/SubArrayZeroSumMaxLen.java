package arrays.subs;

import java.util.HashMap;
import java.util.Map;

public class SubArrayZeroSumMaxLen {
    // Returns length of the maximum length sub-array with 0 sum
    private static int maxLen(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLength = 0;

        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {
            // Add current element to sum
            sum += arr[i];

            if (arr[i] == 0 && maxLength == 0) {
                maxLength = 1;
            }

            // increment the count of maxLength
            if (sum == 0) {
                maxLength = i + 1;
            }

            // Look this sum in hash table
            Integer prev = map.get(sum);

            // If this sum is seen before, then update maxLen
            if (prev != null) {
                maxLength = Math.max(maxLength, i - prev);
            }
            else { // Else put this sum in hash table
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] arg) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Length of the longest 0 sum subarray is " + maxLen(arr));
    }
}
