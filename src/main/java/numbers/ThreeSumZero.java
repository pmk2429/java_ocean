package numbers;

import java.util.*;

public class ThreeSumZero {

  private static List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> res = new HashSet<>();
    if (nums.length == 0) {
      return new ArrayList<>(res);
    }
    // sort array
    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == 0) {
          res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
        } else if (sum > 0) {
          k--;
        } else {
          j++;
        }
      }

    }
    return new ArrayList<>(res);
  }

  public static void main(String[] args) {
    int[] a = {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> tSum = threeSum(a);
    for (List<Integer> sum : tSum) {
      System.out.println(sum);
    }
  }
}