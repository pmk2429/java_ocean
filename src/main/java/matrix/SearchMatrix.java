package matrix;

/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * <p>
 * Example 1:
 * ----------
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true
 * <p>
 * Example 2:
 * ----------
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * Output: false
 * <p>
 * Constraints:
 * ------------
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matrix[i][j] <= 109
 * All the integers in each row are sorted in ascending order.
 * All the integers in each column are sorted in ascending order.
 * -109 <= target <= 109
 */
public class SearchMatrix {

    /**
     * Search Space Reduction
     * ======================
     * First, we initialize a (row,col)(row, col)(row,col) pointer to the bottom-left of the
     * matrix.
     * Then, until we find target and return true (or the pointer points to a (row,col)(row, col)(row,col) that lies
     * outside the dimensions of the matrix), we do the following:
     * - if the currently-pointed-to value is larger than target we can move one row "up".
     * - Otherwise, if the currently-pointed-to value is smaller than target, we can move one column "right".
     * It is not too tricky to see why doing this will never prune the
     * correct answer; because the rows are sorted from left-to-right, we know that
     * every value to the right of the current value is larger.
     * Therefore, if the current value is already larger than target, we know that every value to
     * its right will also be too large.
     * A very similar argument can be made for the columns, so this manner of search will always find target in the
     * matrix (if it is present).
     */
    private static boolean searchMatrix(int[][] matrix, int target) {
        // start our "pointer" in the bottom-left
        int M = matrix.length;
        int N = matrix[0].length;
        int row = M - 1;
        int col = 0;

        while (row >= 0 && col < N) {
            if (target < matrix[row][col]) {
                row--;
            }
            else if (target > matrix[row][col]) {
                col++;
            }
            else { // found it
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        int target = 5;
        System.out.println(searchMatrix(matrix, target));
    }

}
