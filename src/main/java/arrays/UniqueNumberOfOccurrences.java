package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 * <p>
 * Example 1:
 * ----------
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * <p>
 * Example 2:
 * ----------
 * Input: arr = [1,2]
 * Output: false
 * <p>
 * Example 3:
 * ----------
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 * <p>
 * Constraints:
 * ------------
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */
public class UniqueNumberOfOccurrences {

    private static boolean uniqueOccurrences(int[] arr) {
        // Store the frequency of elements in the unordered map.
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Store the frequency count of elements in the unordered set.
        Set<Integer> freqSet = new HashSet<>(freq.values());

        // If the set size is equal to the map size,
        // It implies frequency counts are unique.
        return freq.size() == freqSet.size();
    }

    public static void main(String[] args) {
        int[] arr = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        System.out.println(uniqueOccurrences(arr));
    }
}
