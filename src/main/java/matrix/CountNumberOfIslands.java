package matrix;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary matrix where 0 represents water and 1 represents land, and connected ones form an island, count
 * the total islands.
 */
public class CountNumberOfIslands {
    // Below arrays detail all eight possible movements from a cell
    // (top, right, bottom, left, and four diagonal moves)
    private static final int[] row = {-1, -1, -1, 0, 1, 0, 1, 1};
    private static final int[] col = {-1, 1, 0, -1, -1, 1, 0, 1};

    private static final int M = row.length;
    private static final int N = col.length;

    // Function to check if it is safe to go to position (x, y)
    // from the current position. The function returns false if (x, y)
    // is not valid matrix coordinates or (x, y) represents water or
    // position (x, y) is already processed
    public static boolean isSafe(int[][] maze, int x, int y, boolean[][] visited) {
        return (x >= 0 && x < M) &&
            (y >= 0 && y < N) &&
            maze[x][y] == 1 &&
            !visited[x][y];
    }

    private static boolean isValid(int[][] mat, int x, int y, boolean[][] visited) {
        return mat[x][y] == 1 && !visited[x][y];
    }

    public static void BFS(int[][] maze, boolean[][] visited, int i, int j) {
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(i, j));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;

            // check for all eight possible movements from the current cell
            // and enqueue each valid movement
            for (int k = 0; k < M; k++) {
                int rowMovement = x + row[k];
                int colMovement = y + col[k];
                // skip if the location is invalid, or already processed, or has water
                if (isSafe(maze, rowMovement, colMovement, visited)) {
                    visited[rowMovement][colMovement] = true;
                    Pair pair = new Pair(rowMovement, colMovement);
                    q.add(pair);
                }
            }
        }
    }

    public static int countIslands(int[][] maze) {
        if (maze == null || maze.length == 0) {
            return 0;
        }

        int M = maze.length;
        int N = maze[0].length;

        // stores if a cell is processed or not
        boolean[][] visited = new boolean[M][N];

        int island = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (isValid(maze, i, j, visited)) {
                    BFS(maze, visited, i, j);
                    island++;
                }
            }
        }

        return island;
    }

    public static void main(String[] args) {
        int[][] mat =
            {
                {1, 0, 1, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 1, 1, 1},
                {0, 1, 0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 1, 1, 0},
                {1, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 1, 1, 1}
            };

        System.out.print("Total islands: " + countIslands(mat));
    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
