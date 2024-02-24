package tree.problems;

import linkedlist.ListNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class SortedListToBST {
    private ListNode list;

    private TreeNode sortedListToBST(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode leftChild = sortedListToBST(start, mid - 1);
        TreeNode parent = new TreeNode(list.data);
        parent.left = leftChild;
        list = list.next;
        parent.right = sortedListToBST(mid + 1, end);
        return parent;
    }

    private TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.data);
        }

        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            n++;
        }
        list = head;
        return sortedListToBST(0, n - 1);
    }

    public static void main(String[] args) {

    }
}
