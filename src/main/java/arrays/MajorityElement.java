package arrays;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 * <p>
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {

  // O*log(n)
  private static int majorityElement(int[] nums) {
    int n = nums.length;
    // safety measures
    if (nums.length == 1) {
      return nums[0];
    }

    if (nums.length == 0) {
      return 0;
    }
    // sort the array
    Arrays.sort(nums);
    int prev = nums[0];
    int count = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == prev) {
        count++;
        if (count > n / 2) {
          return nums[i];
        }
      } else {
        count = 1;
        prev = nums[i];
      }
    }
    return -1;
  }

  private static int majorityElement2(int[] num) {
    if (num.length == 1) {
      return num[0];
    }

    Arrays.sort(num);
    return num[num.length / 2];
  }

  public static void main(String[] args) {
    int arr[] = new int[]{2, 2, 1, 1, 1, 2, 2, 4, 3};
    System.out.println(majorityElement2(arr));
  }

}
