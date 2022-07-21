package arrays;

/**
 * On a staircase, the i-th step has some non-negative cost; cost[i] assigned (0 indexed).
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach
 * the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 * <p>
 * Example 1:
 * ----------
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * <p>
 * Example 2:
 * ----------
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * <p>
 * Note:
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 */
public class MinCostClimbingStairs {

    private static int minCostClimbingStairs(int[] costs) {
        int length = costs.length;

        if (length < 2 || length > 1000) {
            return -1;
        }

        int f1 = 0, f2 = 0;
        //for (int i = length - 1; i >= 0; i--) {
        for (int cost : costs) {
            int f0 = cost + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }

    public static void main(String[] args) {
        int[] stairs = {10, 15, 20};
        System.out.println(minCostClimbingStairs(stairs));
        int[] stairs2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(stairs2));
    }
}
