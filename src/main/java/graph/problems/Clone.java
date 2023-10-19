package graph.problems;

import java.util.*;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */
public class Clone {

    private GraphNode cloneGraph2(GraphNode vertex) {
        if (vertex == null) {
            return null;
        }

        Map<GraphNode, GraphNode> edgeMap = new HashMap<>();
        Queue<GraphNode> queue = new ArrayDeque<>();
        queue.add(vertex);

        GraphNode graphCopy = new GraphNode(vertex.label);
        edgeMap.put(vertex, graphCopy);

        while (!queue.isEmpty()) {
            GraphNode currNode = queue.poll();
            for (GraphNode neighbor : currNode.neighbors) {
                if (!edgeMap.containsKey(neighbor)) {
                    GraphNode neighborCopy = new GraphNode(neighbor.label);
                    edgeMap.put(neighbor, neighborCopy);
                    queue.add(neighbor);
                }
                else {
                    // add the neighbor as neighbor of clone node
                    edgeMap.get(neighbor).neighbors.add(edgeMap.get(neighbor));
                }
            }
        }
        return graphCopy;
    }

    /**
     * Time Complexity: O(N+M)
     * Space Complexity: O(N)
     */
    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return null;
        }

        // Hash map to save the visited node, and it's respective clone
        // as key and value respectively. This helps to avoid cycles.
        Map<GraphNode, GraphNode> visited = new HashMap<>();

        // Put the first node in the queue
        Deque<GraphNode> queue = new ArrayDeque<>();
        queue.add(node);
        visited.put(node, new GraphNode(node.data, new ArrayList<>()));

        // Start BFS traversal
        while (!queue.isEmpty()) {
            // Pop a node say "n" from the front of the queue.
            GraphNode n = queue.poll();
            // Iterate through all the neighbors of the node "n"
            for (GraphNode neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // Clone the neighbor and put in the visited, if not present already
                    visited.put(neighbor, new GraphNode(neighbor.data, new ArrayList<>()));
                    // Add the newly encountered node to the queue.
                    queue.add(neighbor);
                }
                // Add the clone of the neighbor to the neighbors of the clone node "n".
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }

        // Return the clone of the node from visited.
        return visited.get(node);
    }
}
