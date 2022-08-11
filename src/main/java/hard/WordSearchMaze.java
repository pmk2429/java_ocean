package hard;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example:
 * --------
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearchMaze {
    private static boolean exist(char[][] board, int row, int col, char[] word, int i) {
        if (i == word.length) {
            return true;
        }

        if (row < 0 || col < 0 || row == board.length || col == board[row].length) {
            return false;
        }

        if (board[row][col] != word[i]) {
            return false;
        }

        // Mark X & Y in Maze as visited
        board[row][col] ^= 256;

        boolean exist = exist(board, row, col + 1, word, i + 1)
            || exist(board, row, col - 1, word, i + 1)
            || exist(board, row + 1, col, word, i + 1)
            || exist(board, row - 1, col, word, i + 1);

        // Mark X & Y unvisited
        board[row][col] ^= 256;

        return exist;
    }

    private static boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (exist(board, i, j, w, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        String a = "ABCCED";
        System.out.println(exist(board, a));
        String b = "SEE";
        System.out.println(exist(board, b));
        String c = "ABCB";
        System.out.println(exist(board, c));
    }
}
