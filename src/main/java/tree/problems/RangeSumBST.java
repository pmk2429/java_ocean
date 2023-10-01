package tree.problems;

import java.util.Stack;

/**
 * Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes
 * with a value in the inclusive range [low, high].
 * <p>
 * Example 1:
 * ----------
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
 * <p>
 * Example 2:
 * ----------
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 * Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 * <p>
 * Constraints:
 * -----------
 * The number of nodes in the tree is in the range [1, 2 * 104].
 * 1 <= Node.data <= 105
 * 1 <= low <= high <= 105
 * All Node.val are unique.
 */
public class RangeSumBST {

    /**
     * Time Complexity: O(N), where N is the number of nodes in the tree.
     * <p>
     * Space Complexity: O(N)
     */
    private static int rangeSumBST(TreeNode root, int low, int high) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (low <= node.data && node.data <= high) {
                    ans += node.data;
                }
                if (low < node.data) {
                    stack.push(node.left);
                }
                if (node.data < high) {
                    stack.push(node.right);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createBSTSmall();
        System.out.println(rangeSumBST(root, 6, 10));
    }
}
