package linkedlist;

public class InsertNodeNthPosition {
    private static ListNode insertAtNthPosition(ListNode head, int data, int position) {
        ListNode nodeToInsert = new ListNode();
        nodeToInsert.data = data;
        if (head == null) {
            return nodeToInsert;
        }
        if (position == 0) {
            nodeToInsert.next = head;
            return nodeToInsert;
        }
        int index = 0;
        ListNode curr = head;
        // We don't assume that the position that we are given will ever be greater
        // than the number of elements in the list + 1. If so, we would need to add
        // the element at the end of the list.
        while (curr.next != null && index != position - 1) {
            curr = curr.next;
            index++;
        }

        insertInBetween(curr, nodeToInsert);
        return head;
    }

    private static void insertInBetween(ListNode current, ListNode toInsert) {
        ListNode tmp = current.next;
        current.next = toInsert;
        toInsert.next = tmp;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createSmall();
    }
}
