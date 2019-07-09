package hard;

/**
 * A robot is located at the top-left corner of a m x length grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * <p>
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * <p>
 * Note: m and length will be at most 100.
 * <p>
 * Example 1:
 * <p>
 * Input: m = 3, length = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 * <p>
 * Input: m = 7, length = 3
 * Output: 28
 */
public class UniquePaths {

  private static int uniquePaths(int m, int n) {
    int[][] memo = new int[m][n];
    for (int i = 0; i < memo[0].length; i++) {
      memo[0][i] = 1; // 1 path to any grid on first row
    }

    for (int i = 0; i < memo.length; i++) {
      memo[i][0] = 1; // 1 path to any grid on first column
    }

    for (int row = 1; row < memo.length; row++) {
      for (int col = 1; col < memo[0].length; col++) {
        // number of paths to grid(row, col) is the sum of number of paths to grid to the left
        // and number of paths to grid above
        memo[row][col] = memo[row][col - 1] + memo[row - 1][col];
      }
    }
    return memo[m - 1][n - 1];//number of paths to finish point
  }

  public static void main(String[] args) {
    int m = 7, n = 3;
    System.out.println(uniquePaths(m, n));
  }
}
