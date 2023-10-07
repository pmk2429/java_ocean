package tree.problems;

public class SearchBST {
    private static TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.data != val) {
            root = val < root.data ? root.left : root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createBSTUneven();
        TreeNode searchRoot = searchBST(root, 40);
        System.out.println(searchRoot);
        TreeNode searchRoot2 = searchBST(root, 24);
        System.out.println(searchRoot2);
    }
}
