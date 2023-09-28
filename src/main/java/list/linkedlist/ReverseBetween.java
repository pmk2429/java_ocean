package list.linkedlist;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 * <p>
 * Example 1:
 * ---------
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * <p>
 * Example 2:
 * ---------
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 */
public class ReverseBetween {

    private static ListNode reverseBetween(ListNode head, int left, int right) {
        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point in the list.
        ListNode curr = head, prev = null;
        while (left > 1) {
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = curr;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode next;
        while (right > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            right--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        }
        else {
            head = prev;
        }

        tail.next = curr;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createSmall();
        LinkedListUtil.printFancy(head);
        ListNode reversedHead = reverseBetween(head, 2, 4);
        LinkedListUtil.printFancy(reversedHead);
    }
}
