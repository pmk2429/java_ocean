package graph.problems;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    int data;
    String label;
    int degree;
    int cost;
    List<GraphNode> neighbors;

    public GraphNode(String label) {
        this.label = label;
        this.neighbors = new ArrayList<>();
    }

    public GraphNode(int val) {
        data = val;
        neighbors = new ArrayList<>();
    }

    public GraphNode(int val, List<GraphNode> nodeNeighbors) {
        data = val;
        neighbors = nodeNeighbors;
    }
}
