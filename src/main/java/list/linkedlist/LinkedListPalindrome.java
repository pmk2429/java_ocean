package list.linkedlist;

import static list.linkedlist.LinkedListUtil.reverseList;

public class LinkedListPalindrome {

    /**
     * Returns the middle node of the LinkedList aka the first half if it's palindrome.
     */
    private static ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // Find the end of first half and reverse second half.
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // Check whether there is a palindrome.
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.data != p2.data) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore the list and return the result
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createPalindrome();
        System.out.println(isPalindrome(head));
    }
}
