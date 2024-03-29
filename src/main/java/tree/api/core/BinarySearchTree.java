package tree.api.core;

import tree.api.exceptions.BoundaryViolationException;
import tree.api.exceptions.InvalidNodeException;

import java.util.*;
import java.util.function.Consumer;

/**
 * A Generic implementation of the Binary Search Tree. This class exhibits all the important behavior
 * specified in the ITree. Binary Tree class extends the Comparable Interface for comparing the data based
 * <p>
 * Created by Pavitra on 10/17/2015.
 */
public class BinarySearchTree<T extends Comparable<T>> implements ITree<T>, Iterable<T> {

    private static final String INVALID_NODE_MESSAGE = "Invalid Node in Tree";
    private static final String INVALID_NODE_ERROR_CODE = "Invalid_Node";
    private Node<T> root;
    private final Comparator<T> comparator;

    // Default constructor.
    public BinarySearchTree() {
        root = null;
        comparator = null;
    }

    // default constructor to initialize the Comparator
    public BinarySearchTree(Comparator<T> comp) {
        this.comparator = comp;
    }

    // Method to compare two objects of calling type T based on the Comparable compareTo() method.
    private int compare(T x, T y) {
        if (comparator == null) {
            return x.compareTo(y);
        }
        else {
            return comparator.compare(x, y);
        }
    }

    // Helper method used to add the type specific data to the Tree based on the index.
    private Node<T> add(Node<T> root, T data) {
        // if root is null, create root.
        if (root == null) {
            return new Node<>(data);
        }

        // if the data to be inserted is same as root, return the root.
        if (compare(data, root.data) == 0)
            return root;

        // if the data to be inserted is less than the root data, insert to left of child.
        if (compare(data, root.data) < 0) {
            root.left = add(root.left, data);
        }
        // if the data to be inserted is greater than the' root data, insert to right of child.
        else {
            root.right = add(root.right, data);
        }
        return root;
    }

    @Override
    public void add(T data) {
        root = add(root, data);
    }

    /**
     * This method is used to delete the node from the BinarySearchTree.
     */
    @Override
    public void delete(T data) {
        root = delete(root, data);
    }

    // helper method to delete the data using the root Node.
    private Node<T> delete(Node<T> root, T data) {
        if (root == null) {
            throw new RuntimeException("Cannot delete");
        }
        // if the desired element to be deleted is less than the current node.
        else if (compare(data, root.data) < 0) {
            root.left = delete(root.left, data);
        }
        // if the desired element to be deleted is greater than the current node.
        else if (compare(data, root.data) > 0) {
            root.right = delete(root.right, data);
        }
        // if the node to be deleted is not found.
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                // get the data from the right most node in the left subtree.
                root.data = (T) rightMost(root.left);
                // delete the rightmost node in the left subtree.
                root.left = delete(root.left, root.data);
            }
        }
        return root;
    }

    /**
     * Helper method to traverse to the Right most Node in the Tree - SubTree
     */
    private T rightMost(Node<T> node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    /**
     * Helper method to traverse to the Left most Node in the Tree - SubTree
     */
    private T leftMost(Node<T> node) {
        while (node.left != null) node = node.left;
        return node.data;
    }

    /**
     * Method to return whether the input Tree is BinarySearchTree or not.
     */
    public boolean isBinaryTree(Node root) {
        return false;
    }

    @Override
    public boolean isRoot(T node) throws BoundaryViolationException, InvalidNodeException {
        // check if the current node is parent or not
        return this.root.data == node;
    }

    @Override
    public void deleteMin() throws InvalidNodeException {
        root = deleteMin(root);
    }

    /**
     * Helper method to delete the Node from the Tree. It traverses the Left sub tree to get the Minimum element node.
     */
    private Node<T> deleteMin(Node<T> root) throws InvalidNodeException {
        if (root.left == null) {
            return root.right;
        }
        else {
            root.left = deleteMin(root.left);
            return root;
        }
    }

    /**
     * Traverses in the right Sub Tree of the Tree and finds the Max element.
     */
    @Override
    public void deleteMax() {
        root = deleteMax(root);
    }

    /**
     * Helper method to delete the maximum element in the BST
     */
    private Node<T> deleteMax(Node<T> root) {
        if (root.right == null) return root.left;
        else {
            root.right = deleteMax(root.right);
            return root;
        }
    }

    @Override
    public Node<T> getRoot() {
        return root;
    }

    @Override
    public T replace(T originalNode, T replacementNode) {
        return null;
    }

    /**
     * Returns the position of the Node in the Tree.
     */
    public int getPosition(Node node) {
        return 0;
    }

    @Override
    public int height(T node) {
        if (node == null) {
            return -1;
        }
        else {
            Node currentNode = search(node);
            return currentNode != null ? heightMain(currentNode) : -1;
        }
    }


    /**
     * Helper method to find the Height of a specific Node in BinarySearchTree.
     */
    private int heightMain(Node node) {
        if (node != null) {
            return Math.max(heightMain(node.getLeft()), heightMain(node.getRight())) + 1;
        }
        else {
            return -1;
        }
    }

    @Override
    public Node<T> search(T node) {
        if (node == null) {
            return null;
        }
        else {
            return search(root, node);
        }
    }

    @Override
    public int countLeaves() {
        return countLeaves(root);
    }

    @Override
    public int diameter() {
        return diameter(root);
    }

    @Override
    public List<Node<T>> getNodesAtLevel(int level) throws InvalidNodeException {

        return level > 0 ? getNodesAtLevel(root, level) : null;
    }

    private List<Node<T>> getNodesAtLevel(Node<T> root, int desiredLevel) throws
        InvalidNodeException {
        if (root == null)
            throw new InvalidNodeException(INVALID_NODE_MESSAGE, INVALID_NODE_ERROR_CODE);

        int currentLevel = 0;
        List<Node<T>> listOfNodes = new ArrayList<>();
        Queue<Node> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);

        while (!bfsQueue.isEmpty()) {
            int levels = bfsQueue.size();
            while (levels > 0) {
                Node<T> node = bfsQueue.poll();
                if (currentLevel == desiredLevel) {
                    listOfNodes.add(node);
                    break;
                }
                if (node.left != null) {
                    bfsQueue.add(node.left);
                }
                if (node.right != null) {
                    bfsQueue.add(node.right);
                }
                levels--;
            }
            currentLevel++;
        }
        return listOfNodes;
    }

    /**
     * Helper method to count diameter of a Tree.
     */
    private int diameter(Node<T> root) {
        if (root == null) return 0;

        //the path goes through the root
//        int len1 = height(root.left) + height(root.right) + 3;

        //the path does not pass the root
//        int len2 = Math.max(diameter(root.left), diameter(root.right));

//        return Math.max(len1, len2);
        return 0;
    }

    /**
     * Helper method to count total Leaf Nodes in a given Tree.
     */
    private int countLeaves(Node<T> root) {
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return 1;
        else return countLeaves(root.left) + countLeaves(root.right);
    }

    /**
     * Helper method to find the desired Node in a Tree.
     */
    private Node<T> search(Node<T> root, T node) {
        if (root != null) {
            // if both are same
            if (compare(root.data, node) == 0) {
                return root;
            }
            else {
                Node foundNode = null;
                if (compare(node, (T) root.data) < 0) {
                    foundNode = search(root.left, node);
                }
                else {
                    foundNode = search(root.right, node);
                }
                return foundNode;
            }
        }
        else {
            return null;
        }
    }


    @Override
    public int depth(T node) throws InvalidNodeException, BoundaryViolationException {
        if (isRoot(node)) {
            return 0;
        }
        else {
            try {
                return 1 + depth(this.parent(node).data);
            } catch (InvalidNodeException e) {
                e.getMessage();
            } catch (BoundaryViolationException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public Node<T> maximum() {
        return maximum(root);
    }

    /**
     * Helper method to find the Maximum element in a Tree or SubTree.
     */
    private Node<T> maximum(Node<T> node) {
        while (node.right != null) node = node.right;
        return node;
    }

    @Override
    public Node minimum() {
        return minimum(root);
    }

    /**
     * Helper method to get the Minimum element in the Binary Search Tree
     */
    private Node minimum(Node<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * Returns the predecessor of the given Node in this BST.
     */
    public Node<T> predecessor(T node) {
        return null;
    }

    /**
     * Returns the successor of the given Node in this BST.
     */
    public Node<T> successor(T node) {
        return null;
    }

    @Override
    public Node<T> parent(T data) throws InvalidNodeException, BoundaryViolationException {
        if (data == null) {
            throw new InvalidNodeException(INVALID_NODE_MESSAGE, INVALID_NODE_ERROR_CODE);
        }
        else {
            return parent(root, data);
        }
    }

    /**
     * Helper method to find the Parent of a specific Node in a Tree
     *
     * @param data
     */
    private Node<T> parent(Node<T> root, T data) throws BoundaryViolationException, InvalidNodeException {
        // Root does not have any parent.
        if (isRoot(data) || root == null) {
            return getNullNode();
        }
        else {
            // if the root's left or right is root itself, return root.
            if (root.left.data == data || root.right.data == data) {
                return root;
            }
            else {
                // if the data in root is less than data in given Node
                if (root.data.compareTo(data) < 0) {
                    return parent(root.right, data);
                }
                else {
                    return parent(root.left, data);
                }
            }
        }
    }

    private boolean isExternal(Node<T> node) {
        return (node.left == null && node.right == null);
    }

    @Override
    public boolean isExternal(T node) throws InvalidNodeException {
        if (node != null) {
            Node<T> foundNode = search(node);
            if (foundNode != null) {
                return isExternal(foundNode);
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public boolean hasChild(T node) {
        if (node != null) {
            Node<T> foundNode = search(node);
            return hasChild(foundNode);
        }
        else {
            return false;
        }
    }

    /**
     * Helper method to check if this Node has Child or not.
     */
    private boolean hasChild(Node<T> node) {
        return node.hasChild();
    }

    @Deprecated
    @Override
    public int getTotalChild(T node) {
        return 2;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Node<T> getNullNode() {

        Node<T> nullNode = new Node<>((T) "NAN");
        return nullNode;
    }

    @Override
    public int size() {
        return size(root);
    }

    /**
     * Helper method to find the size of this BST.
     */
    private int size(Node<T> root) {
        if (root == null)
            return 0;
        else {
            return 1 + size(root.left) + size(root.right);
        }
    }

    @Override
    public boolean contains(T data) {
        if (data == null) return false;
        else {
            Node<T> foundNode = contains(root, data);
            return (foundNode != null && foundNode.data.equals(data));
        }
    }

    /**
     * Helper method to check if this BST contains a specific Node.
     */
    private Node<T> contains(Node<T> root, T node) {
        if (root != null) {
            // if both are same
            if (compare(root.data, node) == 0) {
                return root;
            }
            else {
                Node foundNode = null;
                if (compare(node, (T) root.data) < 0) {
                    foundNode = contains(root.left, node);
                }
                else {
                    foundNode = contains(root.right, node);
                }
                return foundNode;
            }
        }
        else {
            return null;
        }
    }

    @Override
    public Iterable<T> children(T node) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    /**
     * Method to perform Pre order Traversal.
     */
    public void preOrderTraversal() {
        preOrderTraversal(root);
    }


    /**
     * Helper method to perform pre order Traversal.
     */
    private void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    /**
     * Returns the List of Nodes at each level in this Binary Tree.
     */
    private List<List<T>> levelOrder(Node<T> root) {
        List<List<T>> al = new ArrayList<>();
        List<T> nodeValues = new ArrayList<>();
        if (root == null) {
            return al;
        }

        List<Node<T>> current = new LinkedList<>();
        List<Node<T>> next = new LinkedList<>();
        current.add(root);

        while (!current.isEmpty()) {
            Node<T> node = ((LinkedList<Node<T>>) current).remove();

            if (node.left != null)
                next.add(node.left);
            if (node.right != null)
                next.add(node.right);

            nodeValues.add(node.data);
            if (current.isEmpty()) {
                current = next;
                next = new LinkedList<>();
                al.add(nodeValues);
                nodeValues = new ArrayList<>();
            }
        }
        return al;
    }

    /**
     * Method to Traverse this Binary Search Tree in PreOrder Traversal Fashion.
     */
    public List<List<T>> levelOrder() {
        if (root == null)
            return null;

        return levelOrder(root);
    }

    // Other basic features of the BinarySearchTree.

    /**
     * This method provides the Recursive approach to find the <tt>Lowest Common Ancestor</tt>.
     * <p>
     * <b>Conditions for LCA in Binary Tree</b>
     * <ul>
     * <li>If the binary tree itself is null, you don�t have any common ancestor. This is an error condition.</li>
     * <li>If one of the two nodes is the root, then the root itself is the common ancestor.</li>
     * <li>Otherwise, recursively start finding the ancestor on the leftChild node and right node.</li>
     * </ul>
     * <p>
     * If Node a and Node b lie in the leftChild, their Lowest Common Ancestor is in the leftChild.
     * If Node a and Node b lie in the right,their Lowest Common Ancestor is in the right.
     * Otherwise, root is the Lowest common ancestor.
     */
    public Node getLowestCommonAncestor(Node root, Node a, Node b) {

        Node left = null;
        Node right = null;

        if (root == null) {
            return null;
        }

        //if a or b is itself the root, then the root itself is the LCA
        if (a == root || b == root) {
            return root;
        }

        // If Node a and Node b lie in the leftChild, their Lowest Common Ancestor is in the leftChild.
        left = getLowestCommonAncestor(root.left, a, b);

        // If Node a and Node b lie in the right,their Lowest Common Ancestor is in the right.
        right = getLowestCommonAncestor(root.right, a, b);

        // Otherwise, root is the Lowest common ancestor.
        if (left != null && right != null) {
            return root;
        }

        return (left != null) ? left : right;
    }
}
