package arrays.subs;

import java.util.HashMap;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * <p>
 * Example 1:
 * ----------
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class SubArraySumK {

  private static int subarraySum(int[] nums, int target) {
    int count = 0, sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      int twoSum = sum - target;
      if (map.containsKey(twoSum)) {
        count += map.get(twoSum);
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }

  public static void main(String[] args) {
    int[] nums = {1, 1, 1};
    int k = 2;
    System.out.println(subarraySum(nums, k));
  }
}
