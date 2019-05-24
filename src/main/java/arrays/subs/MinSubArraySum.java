package arrays.subs;

import static java.lang.Math.min;

public class MinSubArraySum {
  int minSubArrayLen(int s, int[] nums) {
    int n = nums.length;
    int ans = Integer.MAX_VALUE;
    int left = 0;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      while (sum >= s) {
        ans = min(ans, i + 1 - left);
        sum -= nums[left++];
      }
    }
    return (ans != Integer.MAX_VALUE) ? ans : 0;
  }

  public static void main(String[] args) {

  }
}
