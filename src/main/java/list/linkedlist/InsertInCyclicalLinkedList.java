package list.linkedlist;

public class InsertInCyclicalLinkedList {

    private static ListNode push(ListNode head, int data) {
        ListNode first = new ListNode(data, head);
        ListNode curr = head;

        /* If linked list is not null then set the next of last node */
        if (head != null) {
            while (curr.next != head) {
                curr = curr.next;
            }
            curr.next = first;
        }
        else {
            first.next = first; /* Circular list - For the first node */
        }

        head = first;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = null;
        head = push(head, 12);
        head = push(head, 5);
        head = push(head, 56);
        head = push(head, 2);
        head = push(head, 11);
    }

}
