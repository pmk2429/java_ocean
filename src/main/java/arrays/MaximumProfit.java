package arrays;

import java.util.Arrays;

/**
 * Maximum profit after buying and selling the stocks
 * Given an array of positive integers containing the price of stocks and transaction fee, the task is to
 * find the maximum profit and the difference of days on which you are getting the maximum profit.
 * <p>
 * Examples:
 * ---------
 * Input: arr[] = {6, 1, 7, 2, 8, 4}
 * transactionFee = 2
 * Output: 8 1
 * <p>
 * Input: arr[] = {7, 1, 5, 3, 6, 4}
 * transactionFee = 1
 * Output: 5 1
 */
public class MaximumProfit {

  private static int[] maxProfit(int[] transactions) {
    int currProfit;
    int maxProfit = -1;
    int transactionFee = 2;
    int[] transactionDays = new int[2];
    for (int i = 0; i < transactions.length; i++) {
      int j = i + 1;
      while (j < transactions.length) {
        currProfit = transactions[j] - transactions[i] - transactionFee;
        if (currProfit > maxProfit) {
          maxProfit = currProfit;
          transactionDays[0] = transactions[i];
          transactionDays[1] = transactions[j];
        }
        j++;
      }
    }
    return transactionDays;
  }

  private static int maxProfitOnePass(int[] prices) {
    int minprice = Integer.MAX_VALUE;
    int maxprofit = 0;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minprice) {
        minprice = prices[i];
      } else if (prices[i] - minprice > maxprofit) {
        maxprofit = prices[i] - minprice;
      }
    }
    return maxprofit;
  }

  public static void main(String[] args) {
    int arr[] = {6, 1, 7, 2, 8, 4};
    System.out.println(Arrays.toString(maxProfit(arr)));
    System.out.println(maxProfitOnePass(arr));
  }
}
