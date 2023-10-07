package tree.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Similar to {@link RangeSumBST}.
 */
public class PrintAllNodesBetweenLevels {

    private static void printNodes(TreeNode root, int startLevel, int endLevel) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        TreeNode curr;

        int level = 0;

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            while (size-- > 0) {
                curr = queue.poll();

                if (startLevel <= level && level <= endLevel) {
                    System.out.print(curr.data + " ");
                }

                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }

            if (startLevel <= level && level <= endLevel) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createUnusualTree();
        printNodes(root, 2, 3);
    }
}
