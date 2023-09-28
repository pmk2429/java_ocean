package list.linkedlist;

public class MiddleNode {
    private static ListNode getMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = null;
        return slow;
    }

    /**
     * Returns the list with Middle node as the Head node.
     */
    private static ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        // this steps breaks the LinkedList into 2 separate lists
        midPrev.next = null;
        return mid;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.create();
        LinkedListUtil.printFancy(head);
        ListNode middleNode = getMid(head);
        LinkedListUtil.printFancy(middleNode);
    }
}
