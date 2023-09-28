package graph.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
 * You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 * - Each 0 marks an empty land which you can pass by freely.
 * - Each 1 marks a building which you cannot pass through.
 * - Each 2 marks an obstacle which you cannot pass through.
 * <p>
 * For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
 * -------------------
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
 * <p>
 * Note: There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 */
public class ShortestDistanceToAllBuildings {

    private static int M;
    private static int N;

    private static boolean isValid(int i, int j, int[][] grid, boolean[][] visited) {
        return i >= 0 && i < M && j >= 0 && j < N && grid[i][j] == 0 && !visited[i][j];
    }

    private static void bfs(int[][] grid, int[][] dis, int[][] num, int x, int y) {
        M = grid.length;
        N = grid[0].length;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});

        boolean[][] visited = new boolean[M][N];

        int dist = 0;

        while (!queue.isEmpty()) {
            dist++;
            // all size number of node, their neighbors belongs to next dist which for distance
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int k = top[0] + directions[j][0];
                    int l = top[1] + directions[j][1];
                    if (isValid(k, l, grid, visited)) {
                        visited[k][l] = true;
                        dis[k][l] += dist;
                        num[k][l]++;
                        queue.add(new int[]{k, l});
                    }
                }
            }
        }
    }

    private static int shortestDistance(int[][] grid) {
        if (M == 0 || N == 0) {
            return -1;
        }

        int buildingNums = 0;

        int[][] dis = new int[M][N]; // distance sum of all building to dis[x][y];
        int[][] num = new int[M][N]; // how many buildings can reach num[x][y]

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    buildingNums++;
                    bfs(grid, dis, num, i, j);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0 && dis[i][j] != 0 && num[i][j] == buildingNums) {
                    min = Math.min(min, dis[i][j]);
                }
            }
        }

        return (min < Integer.MAX_VALUE) ? min : -1;
    }
}
