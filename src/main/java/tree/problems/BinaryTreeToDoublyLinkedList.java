package tree.problems;

public class BinaryTreeToDoublyLinkedList {
    // the smallest (first) and the largest (last) nodes
    private static Node first = null;
    private static Node last = null;

    private static void helper(Node node) {
        if (node != null) {
            // left
            helper(node.left);
            // node
            if (last != null) {
                // link the previous node (last)
                // with the current one (node)
                last.right = node;
                node.left = last;
            }
            else {
                // keep the smallest node to close DLL later on
                first = node;
            }
            last = node;
            // right
            helper(node.right);
        }
    }

    private static Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        helper(root);
        last.right = first;
        first.left = last;
        return first;
    }

    public static void main(String[] args) {

    }
}
