package tree.problems;

/**
 * Given the root of a binary tree, return the sum of all left leaves.
 * A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
 * <p>
 * Example 1:
 * ----------
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 24
 * Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
 * <p>
 * Example 2:
 * ----------
 * Input: root = [1]
 * Output: 0
 * <p>
 * Constraints:
 * ----------
 * The number of nodes in the tree is in the range [1, 1000].
 * -1000 <= Node.val <= 1000
 */
public class SumOfLeftLeaves {
    private static int leftLeavesSumHelper(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && isLeft) {
            return root.data;
        }
        return leftLeavesSumHelper(root.left, true) + leftLeavesSumHelper(root.right, false);
    }

    private static int sumOfLeftLeaves(TreeNode root) {
        return leftLeavesSumHelper(root, false);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createBT();
        System.out.println(sumOfLeftLeaves(root));
    }
}
