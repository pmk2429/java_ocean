package maze;

class UniquePaths {
    private static int M;
    private static int N;

    private static boolean isValid(int[][] maze, boolean[][] visited, int x, int y) {
        return maze[x][y] == 1 && !visited[x][y];
    }

    private static boolean isNavigable(int x, int y) {
        return x >= 0 && y >= 0 && x < M && y < N;
    }

    private static int countPaths(int[][] maze, int i, int j, boolean[][] visited, int count) {
        // if destination (bottom-rightmost cell) is found, increment the path count
        if (i == M - 1 && j == N - 1) {
            count++;
            return count;
        }

        // mark current cell as visited
        visited[i][j] = true;

        // if current cell is a valid and open cell
        if (isNavigable(i, j) && maze[i][j] == 1) {

            // go down (x, y) --> (x + 1, y)
            if (isNavigable(i + 1, j) && !visited[i + 1][j]) {
                count = countPaths(maze, i + 1, j, visited, count);
            }

            // go up (x, y) --> (x - 1, y)
            if (isNavigable(i - 1, j) && !visited[i - 1][j]) {
                count = countPaths(maze, i - 1, j, visited, count);
            }

            // go right (x, y) --> (x, y + 1)
            if (isNavigable(i, j + 1) && !visited[i][j + 1]) {
                count = countPaths(maze, i, j + 1, visited, count);
            }

            // go left (x, y) --> (x, y - 1)
            if (isNavigable(i, j - 1) && !visited[i][j - 1]) {
                count = countPaths(maze, i, j - 1, visited, count);
            }
        }

        // backtrack from current cell and remove it from current path
        visited[i][j] = false;

        return count;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 1, 1, 1},
            {1, 1, 0, 1},
            {0, 1, 0, 1},
            {1, 1, 1, 1}
        };

        M = maze.length;
        N = maze[0].length;

        // stores number of unique paths from source to destination
        int count = 0;

        // 2D matrix to keep track of cells involved in current path
        boolean[][] visited = new boolean[M][N];

        // start from source cell (0, 0)
        count = countPaths(maze, 0, 0, visited, count);

        System.out.println("Total number of unique paths are --- " + count);
    }
}