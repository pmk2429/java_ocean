package tree.problems;

public class ClosestBinarySearchTreeValue {

    private static int closestValue(TreeNode root, double target) {
        if (root == null) {
            return -1;
        }

        int closestValue = root.data;

        while (root != null) {
            int curr = root.data;
            closestValue = Math.abs(curr - target) < Math.abs(closestValue - target) ? curr : closestValue;
            root = target < root.data ? root.left : root.right;
        }

        return closestValue;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createBSTSmall();
        System.out.println(closestValue(root, 4.50));
    }
}
