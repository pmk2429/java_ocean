package maze;

import static maze.MazeUtil.printSolution;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * ----------
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * <p>
 * Example 2:
 * ----------
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 */
public class RotateImage {

    private static void rotate(int[][] maze) {
        int N = maze.length;
        for (int i = 0; i < (N + 1) / 2; i++) {
            for (int j = 0; j < N / 2; j++) {
                int lastIndex = N - 1;
                int temp = maze[lastIndex - j][i];
                maze[lastIndex - j][i] = maze[lastIndex - i][N - j - 1];
                maze[lastIndex - i][N - j - 1] = maze[j][lastIndex - i];
                maze[j][lastIndex - i] = maze[i][j];
                maze[i][j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
        };
        printSolution(maze);
        System.out.println("------- Rotate -------");
        rotate(maze);
        printSolution(maze);
    }
}
