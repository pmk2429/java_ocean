package tree.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a binary tree, return all duplicate subtrees.
 * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 * Two trees are duplicate if they have the same structure with the same node values.
 * <p>
 * Example 1:
 * ----------
 * Input: root = [1,2,3,4,null,2,4,null,null,4]
 * Output: [[2,4],[4]]
 * <p>
 * Example 2:
 * ----------
 * Input: root = [2,1,1]
 * Output: [[1]]
 * <p>
 * Example 3:
 * ----------
 * Input: root = [2,2,2,3,null,3,null]
 * Output: [[2,3],[3]]
 * <p>
 * Constraints:
 * ------------
 * The number of the nodes in the tree will be in the range [1, 5000]
 * -200 <= Node.val <= 200
 */
public class RemoveDuplicateTrees {

    private static String traverse(TreeNode node, Map<String, Integer> count, List<TreeNode> res) {
        if (node == null) {
            return "";
        }
        String representation =
            "(" + traverse(node.left, count, res) + ")" +
                node.data +
                "(" + traverse(node.right, count, res) + ")";
        count.put(representation, count.getOrDefault(representation, 0) + 1);
        if (count.get(representation) == 2) {
            res.add(node);
        }
        return representation;
    }

    private static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        traverse(root, new HashMap<>(), res);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createWithDuplicateSubTrees();
        System.out.println(findDuplicateSubtrees(root));
    }

}
