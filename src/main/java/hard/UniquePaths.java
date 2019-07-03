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
  public int uniquePaths(int m, int n) {

    int totalStep = m + n - 2;
    int small = m > n ? (n - 1) : (m - 1);
    int i = 0;
    long x = 1;
    while (i < small) {
      x = x * (totalStep - i);
      i++;
    }
    long y = 1;
    while (small > 1) {
      y = y * small;
      small--;
    }

    return (int) (x / y);
  }
}
