package maze;

import static maze.MazeUtil.printSolution;

public class ShortestPathEndOfMaze {
    // M x N matrix
    private static int M;
    private static int N;

    // legitimacy of next step
    private static boolean isValid(int[][] maze, boolean[][] visited, int i, int j) {
        return maze[i][j] == 1 && !visited[i][j];
    }

    // checks bounds
    private static boolean isNavigable(int i, int j) {
        return i >= 0 && i < M && j >= 0 && j < N;
    }

    private static int findShortestPathToEndOfMaze(int[][] maze, boolean[][] visited, int i, int j, int x, int y, int minDist, int distance) {
        if (i == x && j == y) {
            minDist = Math.min(minDist, distance);
            return minDist;
        }

        visited[i][j] = true;

        // right
        if (isNavigable(i + 1, j) && isValid(maze, visited, i + 1, j)) {
            minDist = findShortestPathToEndOfMaze(maze, visited, i + 1, j, x, y, minDist, distance + 1);
        }

        // left
        if (isNavigable(i - 1, j) && isValid(maze, visited, i - 1, j)) {
            minDist = findShortestPathToEndOfMaze(maze, visited, i - 1, j, x, y, minDist, distance + 1);
        }

        // top
        if (isNavigable(i, j + 1) && isValid(maze, visited, i, j + 1)) {
            minDist = findShortestPathToEndOfMaze(maze, visited, i, j + 1, x, y, minDist, distance + 1);
        }

        // down
        if (isNavigable(i, j - 1) && isValid(maze, visited, i, j - 1)) {
            minDist = findShortestPathToEndOfMaze(maze, visited, i, j - 1, x, y, minDist, distance + 1);
        }


        visited[i][j] = false;

        return minDist;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
            {0, 0, 1, 0, 1, 1, 1, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
            {0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
            {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
            {0, 0, 1, 0, 0, 1, 1, 0, 0, 1},
        };

        M = maze.length;
        N = maze[0].length;

        boolean[][] visited = new boolean[M][N];

        int minDistance = findShortestPathToEndOfMaze(maze, visited, 0, 0, M - 1, N - 1, Integer.MAX_VALUE, 0);

        if (minDistance != Integer.MAX_VALUE) {
            System.out.println("The shortest path from source to destination has length: " + minDistance);
        }
        else {
            System.out.println("Destination can't be reached from source");
        }

        printSolution(visited);
    }
}