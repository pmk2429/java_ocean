package recursion;

public class Coin {

    public static void main(String args[]) {
        int coins[] =  {9, 6, 5, 1};
        int m = coins.length;
        int V = 11;
        System.out.println("Minimum coins required is "+ minCoins(coins, m, V));
    }

    // A Naive recursive JAVA program to find minimum of coins
    // to make a given change V
    // m is size of coins array (number of different coins)
    static int minCoins(int coins[], int m, int V) {
        // base case
        if (V == 0) return 0;

        // Initialize result
        int res = Integer.MAX_VALUE;

        // Try every coin that has smaller value than V
        for (int i=0; i<m; i++) {
            if (coins[i] <= V) {
                int sub_res = minCoins(coins, m, V-coins[i]);

                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) {
                    res = sub_res + 1;
                }
            }
        }
        return res;
    }
}

/**
 * This problem is solved using recursion where for each recursive call, the problem set is narrowed down
 * for a smaller target.
 * The recursive function is limited withing bounds of the Integer.MAX_VALUE considering the coins will always be
 * and integer value.
 * The sub_res variable stores the evaluated value returned from the minCoins method. Depending on whether sub_res is
 *
 */