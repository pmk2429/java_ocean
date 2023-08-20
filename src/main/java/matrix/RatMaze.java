package matrix;

import static matrix.MazeUtil.printSolution;

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

    private static boolean isSafe(int i, int j) {
        return i >= 0 && i < M && j >= 0 && j < N;
    }

    private static boolean isNavigable(int[][] maze, int i, int j) {
        return maze[i][j] == 1;
    }

    private static boolean solveMazeDFS(int[][] maze, int i, int j, int[][] visited) {
        // base case
        if (i == M - 1 && j == N - 1) {
            visited[i][j] = 1;
            return true;
        }

        if (isSafe(i, j) && isNavigable(maze, i, j)) {
            visited[i][j] = 1;

            if (solveMazeDFS(maze, i + 1, j, visited)) {
                return true;
            }

            if (solveMazeDFS(maze, i, j + 1, visited)) {
                return true;
            }

            visited[i][j] = 0;

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

        int[][] visited = new int[M][N];

        if (!solveMazeDFS(maze, 0, 0, visited)) {
            System.out.print("Solution doesn't exist");
        }
        else {
            printSolution(visited);
        }
    }
}
