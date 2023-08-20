package matrix;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes
 * the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example:
 * --------
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * <p>
 * ~!@#HARD:REVISE
 */
public class MinPathSum {

    private static int calculate(int[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        return grid[i][j] + Math.min(calculate(grid, i + 1, j), calculate(grid, i, j + 1));
    }

    private static int minPathSum(int[][] grid) {
        return calculate(grid, 0, 0);
    }


    public int minPathSumDP(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                }
                else if (j == grid[0].length - 1 && i != grid.length - 1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                }
                else if (j != grid[0].length - 1 && i != grid.length - 1) {
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
                else {
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {

    }
}
