package hard;

/**
 * Given length balloons, indexed from 0 to length-1. Each balloon is painted with a number on it represented by array nums.
 * You are asked to burst all the balloons. If the you burst balloon i you will get
 * nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i.
 * After the burst, the left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * <p>
 * Note:
 * -----
 * You may imagine nums[-1] = nums[length] = 1. They are not real therefore you can not burst them.
 * 0 ≤ length ≤ 500, 0 ≤ nums[i] ≤ 100
 * <p>
 * Example:
 * --------
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5    +    3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class BurstBalloons {

    private static int get(int[] nums, int i) {
        if (i == -1 || i == nums.length) {
            return 1;
        }
        return nums[i];
    }

    private static int maxCoins(int[] nums, int[][] table, int start, int end) {
        if (start > end) {
            return 0;
        }

        if (table[start][end] != 0) {
            return table[start][end];
        }

        int max = nums[start];

        for (int i = start; i <= end; i++) {
            int val = maxCoins(nums, table, start, i - 1)
                + (get(nums, start - 1) * get(nums, i) * get(nums, end + 1))
                + maxCoins(nums, table, i + 1, end);

            max = Math.max(max, val);
        }

        table[start][end] = max;

        return max;
    }

    private static int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        return maxCoins(nums, dp, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] ballons = {3, 1, 5, 8};
        System.out.println(maxCoins(ballons));
    }

}
