package maze;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * We are given a 2-dimensional grid. "." is an empty cell, "#" is a wall, "@" is the starting point,
 * ("a", "b", ...) are keys, and ("A", "B", ...) are locks.
 * We start at the starting point, and one move consists of walking one space in one of the 4 cardinal directions.
 * We cannot walk outside the grid, or walk into a wall.  If we walk over a key, we pick it up.
 * We can't walk over a lock unless we have the corresponding key.
 * For some 1 <= K <= 6, there is exactly one lowercase and one uppercase letter of the first K letters of the
 * English alphabet in the grid.  This means that there is exactly one key for each lock, and one lock for each key;
 * and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.
 * Return the lowest number of moves to acquire all keys. If it'addStr impossible, return -1.
 * <p>
 * Example 1:
 * ----------
 * Input: ["@.a.#","###.#","b.A.B"]
 * Output: 8
 * <p>
 * Example 2:
 * ----------
 * Input: ["@..aA","..B#.","....b"]
 * Output: 6
 * <p>
 * Note:
 * -----
 * 1 <= grid.length <= 30
 * 1 <= grid[0].length <= 30
 * grid[i][j] contains only '.', '#', '@', 'a'-'f' and 'A'-'F'
 * The number of keys is in [1, 6].  Each key has a different letter and opens exactly one lock.
 */
public class ShortestPathToGetKeys {
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int si = -1, sj = -1, k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    si = i;
                    sj = j;
                }
                if (isKey(c)) {
                    k++;
                }
            }
        }

        NodeInfo start = new NodeInfo(si, sj, 0);
        Queue<NodeInfo> q = new LinkedList<>();
        q.offer(start);
        Set<String> visited = new HashSet<>();

        visited.add(si + " " + sj + " " + 0);

        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                NodeInfo cur = q.poll();
                if (cur.key == (1 << k) - 1) {
                    return level;
                }

                for (int[] d : dirs) {
                    int x = cur.i + d[0];
                    int y = cur.j + d[1];
                    int key = cur.key;
                    if (!isValid(grid, x, y, m, n)) {
                        continue;
                    }
                    char c = grid[x].charAt(y);

                    if (isKey(c)) {
                        key |= (1 << (c - 'a'));
                    }

                    if (isLock(c) && (key >> (c - 'A') & 1) == 0) {
                        continue;
                    }

                    if (visited.add(x + " " + y + " " + key)) {
                        q.offer(new NodeInfo(x, y, key));
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private boolean isLock(char c) {
        return c >= 'A' && c <= 'F';
    }

    private boolean isKey(char c) {
        return c >= 'a' && c <= 'f';
    }

    private boolean isValid(String[] grid, int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n && grid[i].charAt(j) != '#';
    }

    public static void main(String[] args) {

    }
}

class NodeInfo {
    int i, j, key;

    public NodeInfo(int i, int j, int key) {
        this.i = i;
        this.j = j;
        this.key = key;
    }
}
