package maze;

import static maze.MazeUtil.printSolution;

public class RatMaze {

    private static int M;
    private static int N;

    /* This function solves the Maze problem using
    Backtracking. It mainly uses solveMazeUtil()
    to solve the problem. It returns false if no
    path is possible, otherwise return true and
    prints the path in the form of 1s. Please note
    that there may be more than one solutions, this
    function prints one of the feasible solutions.*/

    private static boolean isSafe(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static boolean isNavigable(int[][] maze, int x, int y) {
        return maze[x][y] == 1;
    }

    private static boolean solveMazeDFS(int[][] maze, int x, int y, int[][] visited) {
        // base case
        if (x == M - 1 && y == N - 1) {
            visited[x][y] = 1;
            return true;
        }

        if (isSafe(x, y) && isNavigable(maze, x, y)) {
            visited[x][y] = 1;

            if (solveMazeDFS(maze, x + 1, y, visited)) {
                return true;
            }

            if (solveMazeDFS(maze, x, y + 1, visited)) {
                return true;
            }

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

        M = maze.length;
        N = maze[0].length;

        int[][] sol = new int[M][N];

        if (!solveMazeDFS(maze, 0, 0, sol)) {
            System.out.print("Solution doesn't exist");
        }
        else {
            printSolution(sol);
        }
    }
}
