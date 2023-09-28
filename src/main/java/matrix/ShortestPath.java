package matrix;

public class ShortestPath {
    // M x N matrix
    private static final int M = 10;
    private static final int N = 10;

    // Check if it is possible to go to (x, y) from current position. The
    // function returns false if the cell has value 0 or already visited
    private static boolean isValid(int[][] maze, boolean[][] visited, int x, int y) {
        return (maze[x][y] != 0 && !visited[x][y]);
    }

    // if not a valid position, return false
    private static boolean isNavigable(int x, int y) {
        return (x >= 0 && y >= 0 && x < M && y < N);
    }

    // Find the shortest Possible Route in a Matrix mat from source cell (0, 0)
    // to destination cell (x, y)

    // 'min_dist' stores length of longest path from source to destination
    // found so far and 'dist' maintains length of path from source cell to
    // the current cell (i, j)
    private static int findShortestPath(int[][] maze, boolean[][] visited, int i, int j, int x, int y, int minimumDistance, int dist) {
        // if destination is found, update min_dist
        if (i == x && j == y) {
            return Math.min(dist, minimumDistance);
        }

        // set (i, j) cell as visited
        visited[i][j] = true;

        // go to bottom cell
        if (isNavigable(i + 1, j) && isValid(maze, visited, i + 1, j)) {
            minimumDistance = findShortestPath(maze, visited, i + 1, j, x, y, minimumDistance, dist + 1);
        }

        // go to top cell
        if (isNavigable(i - 1, j) && isValid(maze, visited, i - 1, j)) {
            minimumDistance = findShortestPath(maze, visited, i - 1, j, x, y, minimumDistance, dist + 1);
        }

        // go to right cell
        if (isNavigable(i, j + 1) && isValid(maze, visited, i, j + 1)) {
            minimumDistance = findShortestPath(maze, visited, i, j + 1, x, y, minimumDistance, dist + 1);
        }

        // go to left cell
        if (isNavigable(i, j - 1) && isValid(maze, visited, i, j - 1)) {
            minimumDistance = findShortestPath(maze, visited, i, j - 1, x, y, minimumDistance, dist + 1);
        }

        // Backtrack - Reset and remove (i, j) from visited matrix
        visited[i][j] = false;

        return minimumDistance;
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

        // construct a matrix to keep track of visited cells
        boolean[][] visited = new boolean[M][N];

        int minDistance = findShortestPath(maze, visited, 0, 0, 7, 5, Integer.MAX_VALUE, 0);

        if (minDistance != Integer.MAX_VALUE) {
            System.out.println("The shortest path from source to destination has length: " + minDistance);
        }
        else {
            System.out.println("Destination can't be reached from source");
        }
    }
}