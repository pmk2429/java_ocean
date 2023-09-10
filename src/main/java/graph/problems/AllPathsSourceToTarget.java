package graph.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to
 * node n - 1 and return them in any order.
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a
 * directed edge from node i to node graph[i][j]).
 * <p>
 * Example 1:
 * ----------
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * <p>
 * Example 2:
 * ----------
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * <p>
 * Constraints:
 * ----------
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i (i.e., there will be no self-loops).
 * All the elements of graph[i] are unique.
 * The input graph is guaranteed to be a DAG.
 */
public class AllPathsSourceToTarget {
    private int target;
    private int[][] graph;
    private List<List<Integer>> results;

    protected void backtrack(int currNode, Deque<Integer> path) {
        if (currNode == target) {
            // Note: one should make a deep copy of the path
            results.add(new ArrayList<>(path));
            return;
        }
        // explore the neighbor nodes one after another.
        for (int nextNode : graph[currNode]) {
            // mark the choice, before backtracking.
            path.offer(nextNode);
            backtrack(nextNode, path);
            // remove the previous choice, to try the next choice
            path.removeLast();
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] inputGraph) {
        target = inputGraph.length - 1;
        graph = inputGraph;
        results = new ArrayList<>();
        // adopt the LinkedList for fast access to the tail element.
        Deque<Integer> path = new ArrayDeque<>();
        path.offer(0);
        // kick of the backtracking, starting from the source (node 0)
        backtrack(0, path);
        return results;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {1, 1, 1, 1},
            {1, 1, 0, 1},
            {0, 1, 0, 1},
            {1, 1, 1, 1}
        };

        AllPathsSourceToTarget allPaths = new AllPathsSourceToTarget();
    }
}
