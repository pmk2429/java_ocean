package matrix;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Cut Off Trees for Golf Event.
 * <p>
 * You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D set,
 * in this set:
 * <p>
 * 0 represents the obstacle can't be reached.
 * 1 represents the ground can be walked through.
 * The place with number bigger than 1 represents a tree can be walked through, and this positive number represents
 * the tree's height.
 * You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree
 * with the lowest height first. And after cutting, the original place has the tree will become a grass (value 1).
 * You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees.
 * If you can't cut off all the trees, output -1 in that situation.
 * You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.
 * <p>
 * Example 1:
 * ----------
 * Input:
 * [
 * [1,2,3],
 * [0,0,4],
 * [7,6,5]
 * ]
 * Output: 6
 * <p>
 * Example 2:
 * ----------
 * Input:
 * [
 * [1,2,3],
 * [0,0,0],
 * [7,6,5]
 * ]
 * Output: -1
 * <p>
 * Example 3:
 * ----------
 * Input:
 * [
 * [2,3,4],
 * [0,0,5],
 * [8,7,6]
 * ]
 * Output: 6
 * Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.
 * <p>
 * Hint: size of the given matrix will not exceed 50x50.
 */
public class CutOffTrees {

    /**
     * We perform a breadth-first-search, processing nodes (grid positions) in a queue. seen keeps track of nodes that
     * have already been added to the queue at some point - those nodes will be already processed or are in the
     * queue awaiting processing.
     * For each node that is next to be processed, we look at its neighbors. If they are in the forest (grid),
     * they haven't been enqueued, and they aren't an obstacle, we will enqueue that neighbor.
     * We also keep a side count of the distance travelled for each node. If the node we are processing is our
     * destination 'target' (tr, tc), we'll return the answer.
     */
    public int bfs(List<List<Integer>> forest, int i, int j, int x, int y) {
        int R = forest.size();
        int C = forest.get(0).size();

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j, 0});

        boolean[][] visited = new boolean[R][C];

        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == x && cur[1] == y) {
                return cur[2];
            }
            for (int di = 0; di < 4; ++di) {
                int r = cur[0] + i;
                int c = cur[1] + j;
                if (0 <= r && r < R && 0 <= c && c < C && !visited[r][c] && forest.get(r).get(c) > 0) {
                    visited[r][c] = true;
                    queue.add(new int[]{r, c, cur[2] + 1});
                }
            }
        }
        return -1;
    }
}
