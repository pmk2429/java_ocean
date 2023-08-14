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
public class BestTimeToBuyAndSellStock1 {

    private static int[] maxProfitTransactionDays(int[] transactions, int transactionFee) {
        int currProfit;
        int maxProfit = -1;
        int[] transactionDays = new int[2];
        int length = transactions.length;
        for (int i = 0; i < length; i++) {
            int j = i + 1;
            while (j < length) {
                currProfit = transactions[j] - transactions[i] - transactionFee;
                if (currProfit > maxProfit) {
                    maxProfit = currProfit;
                    transactionDays[0] = transactions[j];
                    transactionDays[1] = transactions[i];
                }
                j++;
            }
        }
        return transactionDays;
    }

    private static int maxProfitOnePass(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            int currProfit = price - minPrice;
            if (currProfit > maxProfit) {
                maxProfit = currProfit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(Arrays.toString(maxProfitTransactionDays(arr, 1)));
        int[] arr1 = {6, 1, 7, 2, 8, 4};
        System.out.println(Arrays.toString(maxProfitTransactionDays(arr1, 2)));
        System.out.println(maxProfitOnePass(arr));
    }
}
