package linkedlist;

public class LinkedListUtil {

    public static ListNode newNode(int val) {
        return new ListNode(val, null);
    }

    public static ListNode create() {
        ListNode head = newNode(1);
        head.next = newNode(2);
        head.next.next = newNode(3);
        head.next.next.next = newNode(4);
        head.next.next.next.next = newNode(5);
        head.next.next.next.next.next = newNode(6);
        head.next.next.next.next.next.next = newNode(7);
        head.next.next.next.next.next.next.next = newNode(8);
        head.next.next.next.next.next.next.next.next = newNode(9);
        head.next.next.next.next.next.next.next.next.next = newNode(10);

        return head;
    }

    public static ListNode createSmall() {
        ListNode head = newNode(1);
        head.next = newNode(2);
        head.next.next = newNode(3);
        head.next.next.next = newNode(4);
        head.next.next.next.next = newNode(5);
        head.next.next.next.next.next = newNode(6);

        return head;
    }

    public static ListNode createPalindrome() {
        ListNode head = newNode(1);
        head.next = newNode(2);
        head.next.next = newNode(3);
        head.next.next.next = newNode(4);
        head.next.next.next.next = newNode(3);
        head.next.next.next.next.next = newNode(2);
        head.next.next.next.next.next.next = newNode(1);

        return head;
    }

    public static ListNode createUnsorted() {
        ListNode head = newNode(4);
        head.next = newNode(5);
        head.next.next = newNode(1);
        head.next.next.next = newNode(3);
        head.next.next.next.next = newNode(2);
        head.next.next.next.next.next = newNode(8);
        head.next.next.next.next.next.next = newNode(6);

        return head;
    }

    public static ListNode createWithDuplicatesUnsorted() {
        ListNode head = newNode(1);
        head.next = newNode(2);
        head.next.next = newNode(3);
        head.next.next.next = newNode(4);
        head.next.next.next.next = newNode(5);
        head.next.next.next.next.next = newNode(6);
        head.next.next.next.next.next.next = newNode(4);
        head.next.next.next.next.next.next.next = newNode(7);
        head.next.next.next.next.next.next.next.next = newNode(4);
        head.next.next.next.next.next.next.next.next.next = newNode(8);

        return head;
    }

    public static ListNode createWithDuplicates() {
        ListNode head = newNode(1);
        head.next = newNode(2);
        head.next.next = newNode(3);
        head.next.next.next = newNode(3);
        head.next.next.next.next = newNode(3);
        head.next.next.next.next.next = newNode(4);
        head.next.next.next.next.next.next = newNode(5);
        head.next.next.next.next.next.next.next = newNode(6);
        head.next.next.next.next.next.next.next.next = newNode(6);
        head.next.next.next.next.next.next.next.next.next = newNode(6);
        head.next.next.next.next.next.next.next.next.next.next = newNode(7);
        head.next.next.next.next.next.next.next.next.next.next.next = newNode(8);

        return head;
    }

    public static ListNode createFromArray() {
        int[] keys = {1, 2, 3, 4, 5, 7, 24, 9, 6, 15};
        ListNode head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new ListNode(keys[i], head);
        }
        return head;
    }

    public static ListNode createFromArray(int[] keys) {
        ListNode head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new ListNode(keys[i], head);
        }
        return head;
    }

    public static void printFancy(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " —> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void display(ListNode head) {
        ListNode temp = head;
        if (head == null) {
            System.out.print("null\n");
            return;
        }
        while (temp != null) {
            System.out.printf("%d --> ", temp.data);
            temp = temp.next;
        }
        System.out.print("null\n");
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}
