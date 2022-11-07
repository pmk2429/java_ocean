package hard;

import java.util.Arrays;

/**
 * A robot is located in the top-left corner of an m x length grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * Note: m and length will be at most 100.
 * <p>
 * Example 1:
 * ==========
 * Input: m = 3, length = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * <p>
 * Example 2:
 * ==========
 * Input: m = 7, length = 3
 * Output: 28
 */
public class UniquePaths {

    private static int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];

        // 1 path to any grid on first row
        Arrays.fill(memo[0], 1);

        for (int i = 0; i < memo.length; i++) {
            // 1 path to any grid on first column
            memo[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // number of paths to grid(row, col) is the sum of number of paths to grid to the left
                // and number of paths to grid above
                memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
            }
        }

        return memo[m - 1][n - 1]; //number of paths to finish point
    }

    public static void main(String[] args) {
        int m = 7, n = 3;
        System.out.println(uniquePaths(m, n));
    }
}
