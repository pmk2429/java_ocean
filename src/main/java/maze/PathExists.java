package maze;

/*
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

 You, a robot, are tasked with navigating a maze. You are placed at a certain starting position (start) in the maze and need to determine
 if you can reach another position (end). Positions in the maze will either be open (denoted by a 1) or blocked with an obstacle
 (denoted by a 0). Positions are identified by the Point class defined for you below.

 You may make the following assumptions:
 - The maze will never be empty
 - You will always start on an open position
 - You may only move North, South, East, and West. Unfortunately, you haven't been programmed to move diagonally :(

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
*/

class Point {
  int row;
  int column;

  Point(int row, int column) {
    this.row = row;
    this.column = column;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Point)) {
      return false;
    }
    Point object = (Point) obj;
    return this.row == object.row && this.column == object.column;
  }
}

// 1 -> navigate
// 2-> not visited
// UP, LEFT, RIGHT, DOWN
// int[][] visited

public class PathExists {

  private static int[][] mazeTest = {
      {1, 1, 1, 1, 0},
      {0, 1, 0, 0, 0},
      {1, 1, 0, 1, 1},
      {0, 1, 1, 1, 1},
      {0, 0, 0, 0, 1}};

  // check the validity of cell
  private static boolean isValid(int[][] maze, Point curr, int[][] visited) {
    if (maze[curr.row][curr.column] != 0 && visited[curr.row][curr.column] == 0) {
      return true;
    }
    return false;
  }

  // checks bounds
  private static boolean isNavigable(Point cell) {
    if (cell.row >= 0 && cell.row < M && cell.column >= 0 && cell.column < N) {
      return true;
    }
    return false;
  }

  private static boolean isValid(int x, int y) {
    return (x < M && y < N && x >= 0 && y >= 0);
  }

  private static int M, N;

  private static boolean hasPath(int[][] maze, Point start, Point end, int[][] visited) {
    // Your solution goes here
    // base case
    if (start.equals(end)) {
      return true;
    }

    // edge case : start should always start from 1

    int i = start.row;
    int j = start.column;

    // mark the start as visited for loop
    visited[i][j] = 1;

    Point top = new Point(i - 1, j);
    Point down = new Point(i + 1, j);
    Point left = new Point(i, j - 1);
    Point right = new Point(i, j + 1);

    boolean isTop = false, isDown = false, isLeft = false, isRight = false;
    if (isNavigable(top) && isValid(maze, top, visited)) {
      isTop = hasPath(maze, top, end, visited);
    }

    if (isNavigable(down) && isValid(maze, down, visited)) {
      isDown = hasPath(maze, down, end, visited);
    }

    if (isNavigable(left) && isValid(maze, left, visited)) {
      isLeft = hasPath(maze, left, end, visited);
    }

    if (isNavigable(right) && isValid(maze, right, visited)) {
      isRight = hasPath(maze, right, end, visited);
    }

    visited[i][j] = 0;

    boolean pathExists = isTop || isDown || isLeft || isRight;

    return pathExists;
  }

  // recursive solution for going in only one direction until bounds is reached or 1.
  private static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  private static boolean hasPathDFS(int[][] maze, int[] start, int[] destination) {
    boolean[][] visited = new boolean[maze.length][maze[0].length];
    return dfs(maze, visited, start, destination);
  }

  private static boolean dfs(int[][] maze, boolean[][] visited, int[] c, int[] des) {
    if (visited[c[0]][c[1]]) {
      return false;
    }
    if (c[0] == des[0] && c[1] == des[1]) {
      return true;
    }

    visited[c[0]][c[1]] = true;
    boolean result = false;
    for (int[] d : dir) {
      int x = c[0] + d[0];
      int y = c[1] + d[1];
      while (0 <= x && x < maze.length && 0 <= y && y < maze[0].length && maze[x][y] == 0) {
        x += d[0];
        y += d[1];
      }
      result = result || dfs(maze, visited, new int[]{x - d[0], y - d[1]}, des);
    }
    return result;
  }

  private static boolean hasPath(int[][] maze, Point start, Point end) {
    int rowLength = maze.length; // row
    int colLength = maze[0].length; // column

    M = rowLength;
    N = colLength;

    int[][] visited = new int[M][N]; // visited will mirror maze in dimensions

    return hasPath(maze, start, end, visited);
  }

  public static void main(String args[]) throws Exception {
    //System.out.println(hasPath(mazeTest, new Point(0, 0), new Point(4, 4)) ? "The maze has a valid path." : "The " +
    //"maze" +
    //" does NOT have a valid path."); //valid
    System.out.println(hasPath(mazeTest, new Point(0, 0), new Point(4, 2)) ? "The maze has a valid path." : "The maze does NOT have a valid path."); //valid
    // System.out.println(hasPath(maze3, new Point(0, 0), new Point(0, 0)) ? "The maze has a valid path." : "The maze does NOT have a valid path."); //valid
    // System.out.println(hasPath(maze4, new Point(0, 0), new Point(3, 3)) ? "The maze has a valid path." : "The maze does NOT have a valid path."); //invalid
    // System.out.println(hasPath(maze5, new Point(0, 0), new Point(4, 4)) ? "The maze has a valid path." : "The maze does NOT have a valid path."); //invalid
    // System.out.println(hasPath(maze6, new Point(0, 0), new Point(2, 2)) ? "The maze has a valid path." : "The maze does NOT have a valid path."); //invalid
  }
}
