package tree.problems;

public class KthSmallestMorrisTraversal {

    private static TreeNode kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        TreeNode curr = root;
        TreeNode kSmallest = null;
        // count variable to keep count of visited Nodes
        int count = 0;

        while (curr != null) {
            if (curr.left == null) {
                if (++count == k) {
                    kSmallest = curr;
                }
                curr = curr.right;
            }
            else {
                TreeNode predecessor = TreeNode.predecessor(curr);

                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                }
                else {
                    predecessor.right = null;
                    if (++count == k) {
                        kSmallest = curr;
                    }
                    curr = curr.right;
                }
            }
        }
        return kSmallest;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createBSTEven();
        System.out.println(kthSmallest(root, 3));
    }

}
