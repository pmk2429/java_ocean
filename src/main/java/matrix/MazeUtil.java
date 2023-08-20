package matrix;

public class MazeUtil {

    // Check if it is possible to go to (x, y) from current position. The
    // function returns false if the cell has value 0 or already visited
    private static boolean isValid(int[][] maze, boolean[][] visited, int x, int y) {
        return (maze[x][y] != 0 && !visited[x][y]);
    }

    // if not a valid position, return false
    private static boolean isNavigable(int x, int y, int M, int N) {
        return (x >= 0 && y >= 0 && x < M && y < N);
    }

    public static void printSolution(int[][] maze) {
        int M = maze.length;
        int N = maze[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printSolution(boolean[][] visited) {
        int M = visited.length;
        int N = visited[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int step = visited[i][j] ? 1 : 0;
                System.out.print(" " + step + " ");
            }
            System.out.println();
        }
    }
}
