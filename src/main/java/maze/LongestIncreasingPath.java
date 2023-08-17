package maze;

/**
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 * From each cell, you can either move in four directions: left, right, up, or down.
 * You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 * <p>
 * Example 1:
 * ----------
 * Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * <p>
 * Example 2:
 * ----------
 * Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * <p>
 * Example 3:
 * ----------
 * Input: matrix = [[1]]
 * Output: 1
 * <p>
 * Constraints:
 * ------------
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * 0 <= matrix[i][j] <= 231 - 1
 */
public class LongestIncreasingPath {

    private static boolean isValid(int i, int j) {
        return i >= 0 && i < M && j >= 0 && j < N;
    }

    private static final int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int M, N;

    private static boolean isGreater(int[][] matrix, int i, int j, int x, int y) {
        return matrix[x][y] > matrix[i][j];
    }

    private static int dfs(int[][] matrix, int i, int j) {
        int ans = 0;
        for (int[] d : direction) {
            int x = i + d[0];
            int y = j + d[1];
            if (isValid(x, y) && isGreater(matrix, i, j, x, y)) {
                ans = Math.max(ans, dfs(matrix, x, y));
            }
        }
        return ++ans;
    }

    private static int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        M = matrix.length;
        N = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}
        };
        System.out.println(longestIncreasingPath(maze));
        int[][] maze1 = {
            {3, 4, 5},
            {3, 2, 6},
            {2, 2, 1}
        };
        System.out.println(longestIncreasingPath(maze1));
    }
}
