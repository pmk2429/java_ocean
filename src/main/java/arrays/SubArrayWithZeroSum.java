package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Find if there is a subarray with 0 sum
 * Given an array of positive and negative numbers, find if there is a subarray (of size at-least one) with 0 sum.
 * Examples :
 * <p>
 * Input: {4, 2, -3, 1, 6}
 * Output: true
 * There is a subarray with zero sum from index 1 to 3.
 * <p>
 * Input: {4, 2, 0, 1, 6}
 * Output: true
 * There is a subarray with zero sum from index 2 to 2.
 * <p>
 * Input: {-3, 2, 3, 1, 6}
 * Output: false
 * There is no subarray with zero sum.
 */
public class SubArrayWithZeroSum {

  /*
  We can also use hashing. The idea is to iterate through the array and for every element arr[i],
  calculate sum of elements form 0 to i (this can simply be done as sum += arr[i]).
  If the current sum has been seen before, then there is a zero sum array.
  Hashing is used to store the sum values, so that we can quickly store sum and find out whether the
  current sum is seen before or not.

  Example :
  arr[] = {1, 4, -2, -2, 5, -4, 3}

  If we consider all prefix sums, we can notice that there is a subarray with 0 sum when :
  1) Either a prefix sum repeats or
  2) Or prefix sum becomes 0.

  Prefix sums for above array are:
  1, 5, 3, 1, 6, 2, 5

  Since prefix sum 1 repeats, we have a subarray with 0 sum.
   */
  private static boolean subArrayExists(int[] arr) {
    Map<Integer, Integer> prevSum = new HashMap<>();
    int sum = 0;

    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];

      // return the if one the following conditions hold true:
      // 1) Current element is 0
      // 2) Prev sum already exists in the HashMap
      // 3) Sum of elements from 0 to i is 0
      if (arr[i] == 0 || prevSum.get(sum) != null || sum == 0) {
        return true;
      }

      prevSum.put(sum, i);
    }
    return false;
  }

  public static void main(String[] args) {
    int[] arr = {-3, 2, 3, 1, 6};
    int[] arr1 = {1, 4, -2, -2, 5, -4, 3};
    System.out.println("Subarray with 0 sum exists - " + subArrayExists(arr1));
  }
}
