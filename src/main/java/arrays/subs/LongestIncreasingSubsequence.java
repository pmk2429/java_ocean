package arrays.subs;

import java.util.ArrayList;
import java.util.List;

/**
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given
 * sequence such that all elements of the subsequence are sorted in increasing order. For example, the length of LIS
 * for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80} longest-increasing-subsequence
 * <p>
 * Example 1:
 * ----------
 * Input  : arr[] = {3, 10, 2, 1, 20}
 * Output : Length of LIS = 3
 * The longest increasing subsequence is 3, 10, 20
 * <p>
 * Example 2:
 * ----------
 * Input  : arr[] = {3, 2}
 * Output : Length of LIS = 1
 * The longest increasing subsequences are {3} and {2}
 * <p>
 * Example 3:
 * ----------
 * Input : arr[] = {50, 3, 10, 7, 40, 80}
 * Output : Length of LIS = 4
 * The longest increasing subsequence is {3, 7, 40, 80}
 * <p>
 * ~!@#HARD:REVISE
 */
public class LongestIncreasingSubsequence {

    private static List<Integer> getLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            int size = list.size();
            // if the current element is greater than the last inserted element in the list, add it to the list
            if (size == 0 || num > list.get(size - 1)) {
                list.add(num);
            }
            else {
                int start = 0;
                int end = size - 1;

                // binary search
                while (start < end) {
                    int mid = (start + end) / 2;
                    if (num > list.get(mid)) {
                        start = mid + 1;
                    }
                    else {
                        end = mid;
                    }
                }
                // list.add(end, num); -- adds element at specified position
                list.set(end, num); // -- replaces element at a specified position
            }
        }

        return list;
    }

    private static int lis(int[] arr, int n) {
        int[] lis = new int[n];
        int i, j, max = 0;

        /* Initialize LIS values for all indexes */
        for (i = 0; i < n; i++) {
            lis[i] = 1;
        }

        /* Compute optimized LIS values in bottom up manner */
        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        /* Pick maximum of all LIS values */
        for (i = 0; i < n; i++) {
            if (max < lis[i]) {
                max = lis[i];
            }
        }

        return max;
    }

    // driver program to test above functions
    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
        int n = arr.length;
        System.out.println("Length of lis is " + lis(arr, n) + "\n");


        System.out.println(getLIS(arr));
    }
}