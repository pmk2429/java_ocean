package list.linkedlist;

/**
 * Inserts an element in rotated, cyclical LinkedList.
 * Since the list is rotates, the first element will be greater than the new val to insert.
 * This problem is same as {@link InsertInSortedLinkedList}.
 */
public class InsertInRotatedCyclicalList {

    private static ListNode insert(ListNode head, int data) {
        if (head == null) {
            return null;
        }

        ListNode curr = head;
        // assuming List is sorted
        while (curr.data > data) {
            curr = curr.next;
        }

        ListNode nodeToInsert = new ListNode(data);
        nodeToInsert.next = curr.next;
        curr.next = nodeToInsert;

        return head;
    }

    public static void main(String[] args) {
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n1 = new ListNode(1);
        n3.next = n4;
        n4.next = n1;
        n1.next = n3;

        ListNode head = insert(n3, 2);

        System.out.println(head.data);
    }
}
