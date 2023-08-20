package market;

import java.util.Arrays;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 * Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times
 * and sell at most k times.
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * ----------
 * Input: k = 2, prices = [2,4,1]
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * <p>
 * Example 2:
 * ----------
 * Input: k = 2, prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * <p>
 * Constraints:
 * ------------
 * 1 <= k <= 100
 * 1 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 * <p>
 * ~!@#HARD:REVISE
 */
public class BestTimeToBuyAndSellStock4 {

    private static int maxProfit(int[] prices, int k) {
        if (k == 0) return 0;

        // create profit and cost arrays with length = k + 1
        int[] profit = new int[k + 1];
        int[] cost = new int[k + 1];

        profit[0] = 0;
        Arrays.fill(cost, Integer.MAX_VALUE);

        for (int price : prices) {
            for (int i = 0; i < k; i++) {
                cost[i + 1] = Math.min(cost[i + 1], price - profit[i]);
                profit[i + 1] = Math.max(profit[i + 1], price - cost[i + 1]);
            }
        }
        // return last element in the profit array
        return profit[k];
    }

    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(prices, 2));
        int[] prices2 = {2, 4, 1};
        System.out.println(maxProfit(prices2, 2));
    }
}
