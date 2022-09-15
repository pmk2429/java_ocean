package maze;

public class RatMaze {

    private static int N;

    private static void printSolution(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* This function solves the Maze problem using
    Backtracking. It mainly uses solveMazeUtil()
    to solve the problem. It returns false if no
    path is possible, otherwise return true and
    prints the path in the form of 1s. Please note
    that there may be more than one solutions, this
    function prints one of the feasible solutions.*/

    private static boolean solveMaze(int[][] maze) {
        int[][] sol = new int[N][N];

        if (!solveMazeUtil(maze, 0, 0, sol)) {
            System.out.print("Solution doesn't exist");
            return false;
        }

        printSolution(sol);
        return true;
    }

    private static boolean isSafe(int[][] maze, int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    private static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] visited) {
        // base case
        if (x == N - 1 && y == N - 1) {
            visited[x][y] = 1;
            return true;
        }


        if (isSafe(maze, x, y)) {
            // mark as visited
            visited[x][y] = 1;

            if (solveMazeUtil(maze, x + 1, y, visited)) {
                return true;
            }

            if (solveMazeUtil(maze, x, y + 1, visited)) {
                return true;
            }

            // mark as un-visited
            visited[x][y] = 0;
            return false;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        N = maze.length;
        solveMaze(maze);
    }
}
