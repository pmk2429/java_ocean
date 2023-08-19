package maze;

/**
 * Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
 * <p>
 * Example 1:
 * ----------
 * Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * Output: true
 * Explanation:
 * In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 * <p>
 * Example 2:
 * ----------
 * Input: matrix = [[1,2],[2,2]]
 * Output: false
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 * <p>
 * Constraints:
 * ------------
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 20
 * 0 <= matrix[i][j] <= 99
 * <p>
 * Follow up:
 * ------------
 * What if the matrix is stored on disk, and the memory is limited such that you can only load at most one row of the matrix into the memory at once?
 * What if the matrix is so large that you can only load up a partial row into the memory at once?
 */
public class Toeplitz {

    private static int M;
    private static int N;

    private static boolean isToeplitz(int[][] maze) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i > 0 && j > 0 && maze[i][j] != maze[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
        };
        M = maze.length;
        N = maze[0].length;

        System.out.println(isToeplitz(maze));
    }

}
