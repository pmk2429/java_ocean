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
 * <p>
 * ~!@#HARD:REVISE
 */
public class WordSearchMaze {

    private static int M;
    private static int N;

    private static boolean isValid(char[][] board, int i, int j, String word, int index) {
        return i >= 0 && j >= 0 && i < M && j < N && board[i][j] == word.charAt(index);
    }

    private static boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (!isValid(board, i, j, word, index)) {
            return false;
        }

        char temp = board[i][j];

        // mark as visited
        board[i][j] = ' ';

        boolean found = dfs(board, i + 1, j, word, index + 1) ||
            dfs(board, i - 1, j, word, index + 1) ||
            dfs(board, i, j + 1, word, index + 1) ||
            dfs(board, i, j - 1, word, index + 1);

        // mark as unvisited
        board[i][j] = temp;

        return found;
    }

    private static boolean exist(char[][] board, String word) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (dfs(board, i, j, word, 0)) {
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

        M = board.length;
        N = board[0].length;

        String a = "ABCCED";
        System.out.println(exist(board, a));
        String b = "SEE";
        System.out.println(exist(board, b));
        String c = "ABCB";
        System.out.println(exist(board, c));
    }
}
