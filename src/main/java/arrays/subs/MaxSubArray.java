package arrays.subs;

public class MaxSubArray {

  private static int maxSubArray(int[] nums) {
    int ans = nums[0], sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum = Math.max(nums[i], sum + nums[i]);
      ans = Math.max(ans, sum);
    }
    return ans;
  }

  public static void main(String[] args) {

  }
}
