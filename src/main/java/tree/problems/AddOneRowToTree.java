package tree.problems;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth.
 * Note that the root node is at depth 1.
 * The adding rule is:
 * ===================
 * - Given the integer depth, for each not null tree node cur at the depth - 1, create two tree nodes with value
 * val as cur's left subtree root and right subtree root.
 * - cur's original left subtree should be the left subtree of the new left subtree root.
 * 0 cur's original right subtree should be the right subtree of the new right subtree root.
 * - If depth == 1 that means there is no depth - 1 at all, then create a tree node with value val as the new
 * root of the whole original tree, and the original tree is the new root's left subtree.
 * <p>
 * Example 1:
 * ----------
 * Input: root = [4,2,6,3,1,5], val = 1, depth = 2
 * Output: [4,1,1,2,null,null,6,3,1,5]
 * <p>
 * Example 2:
 * ----------
 * Input: root = [4,2,null,3,1], val = 1, depth = 3
 * Output: [4,2,null,1,1,3,null,null,1]
 * <p>
 * Constraints:
 * ------------
 * The number of nodes in the tree is in the range [1, 104].
 * The depth of the tree is in the range [1, 104].
 * -100 <= Node.val <= 100
 * -105 <= val <= 105
 * 1 <= depth <= the depth of tree + 1
 */
public class AddOneRowToTree {

    /**
     * Time complexity : O(n).
     * A total of nnn nodes of the given tree will be considered in the worst case.
     * <p>
     * Space complexity : O(x)
     * The size of the queue or temp queue can grow upto x only. Here, x refers to the number of maximum
     * number of nodes at any level in the given tree.
     */
    private static TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = root;
            return n;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 1;

        while (depth < d - 1) {
            Queue<TreeNode> temp = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                if (node.left != null) temp.add(node.left);
                if (node.right != null) temp.add(node.right);
            }
            queue = temp;
            depth++;
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            TreeNode temp = node.left;
            node.left = new TreeNode(v);
            node.left.left = temp;
            temp = node.right;
            node.right = new TreeNode(v);
            node.right.right = temp;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
