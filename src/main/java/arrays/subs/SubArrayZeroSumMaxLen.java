package arrays.subs;

import java.util.HashMap;

public class SubArrayZeroSumMaxLen {
  // Returns length of the maximum length subarray with 0 sum
  private static int maxLen(int[] arr) {
    // Creates an empty HashMap
    HashMap<Integer, Integer> sumMap = new HashMap<>();

    int sum = 0; // Initialize sum of elements
    int maxLen = 0; // Initialize result

    // Traverse through the given array
    for (int i = 0; i < arr.length; i++) {
      // Add current element to sum
      sum += arr[i];

      if (arr[i] == 0 && maxLen == 0) {
        maxLen = 1;
      }

      if (sum == 0) {
        maxLen = i + 1;
      }

      // Look this sum in hash table
      Integer iPrev = sumMap.get(sum);

      // If this sum is seen before, then update maxLen
      // if required
      if (iPrev != null) {
        maxLen = Math.max(maxLen, i - iPrev);
      } else { // Else put this sum in hash table
        sumMap.put(sum, i);
      }
    }

    return maxLen;
  }

  // Drive method
  public static void main(String arg[]) {
    int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
    System.out.println("Length of the longest 0 sum subarray is " + maxLen(arr));
  }
}
