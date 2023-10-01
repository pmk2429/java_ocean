package tree.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumDepth {

    /**
     * An iterative solution that uses BFS instead of any need to store depth in the stack.
     */
    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createUnusualTree();
        System.out.println("Max Depth = " + maxDepth(root));
    }

}
