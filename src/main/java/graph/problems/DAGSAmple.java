package graph.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DAGNode<T> {
    private final T value;
    private final List<DAGNode<T>> children;

    public DAGNode(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public T getValue() {
        return value;
    }

    public List<DAGNode<T>> getChildren() {
        return children;
    }

    public void addChild(DAGNode<T> child) {
        children.add(child);
    }
}

class DirectedAcyclicGraph<T> {
    private final Map<T, DAGNode<T>> nodes;

    public DirectedAcyclicGraph() {
        this.nodes = new HashMap<>();
    }

    public void addNode(T value) {
        if (!nodes.containsKey(value)) {
            nodes.put(value, new DAGNode<>(value));
        }
    }

    public void addEdge(T from, T to) {
        DAGNode<T> fromNode = nodes.get(from);
        DAGNode<T> toNode = nodes.get(to);
        if (fromNode != null && toNode != null) {
            fromNode.addChild(toNode);
        }
    }

    public DAGNode<T> getNode(T value) {
        return nodes.get(value);
    }

    public List<DAGNode<T>> getAllNodes() {
        return new ArrayList<>(nodes.values());
    }
}

public class DAGSAmple {
    public static void main(String[] args) {
        DirectedAcyclicGraph<Integer> graph = new DirectedAcyclicGraph<>();

        // Adding nodes
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);

        // Adding edges
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        // Retrieving and printing nodes
        List<DAGNode<Integer>> nodes = graph.getAllNodes();
        for (DAGNode<Integer> node : nodes) {
            System.out.print("Node " + node.getValue() + " has children: ");
            for (DAGNode<Integer> child : node.getChildren()) {
                System.out.print(child.getValue() + " ");
            }
            System.out.println();
        }
    }
}
