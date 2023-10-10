package graph.problems;

import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi
 * first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers,
 * return any of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * Example 1:
 * ----------
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0.
 * So the correct course order is [0,1].
 * <p>
 * Example 2:
 * ----------
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * <p>
 * Example 3:
 * ----------
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 */
public class CourseScheduleFindOrder {

    private static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();
        int[] inDegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        // Create the adjacency list representation of the graph
        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];

            // init the Graph
            List<Integer> adjacencyList = graph.getOrDefault(u, new ArrayList<>());
            adjacencyList.add(v);
            graph.put(u, adjacencyList);

            // Record in-degree of each vertex
            inDegree[v]++;
        }

        // Add all vertices with 0 in-degree to the queue
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int counter = 0;
        while (!queue.isEmpty()) {
            int nodeId = queue.poll();
            topologicalOrder[counter] = nodeId;

            // Reduce the in-degree of each neighbor by 1
            if (graph.containsKey(nodeId)) {
                for (int neighborId : graph.get(nodeId)) {
                    inDegree[neighborId]--;

                    // If in-degree of a neighbor becomes 0, add it to the Q
                    if (inDegree[neighborId] == 0) {
                        queue.add(neighborId);
                    }
                }
            }
            counter++;
        }

        // Check to see if topological sort is possible or not.
        if (counter == numCourses) {
            return topologicalOrder;
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int numOfCourses = 4;
        int[][] preReqs = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(findOrder(numOfCourses, preReqs)));
    }

}
