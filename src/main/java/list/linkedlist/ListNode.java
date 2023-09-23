package list.linkedlist;

public class ListNode {
    public int data;
    public ListNode next;
    public ListNode random;

    public ListNode() {
    }

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public ListNode(ListNode next) {
        this.data = -1;
        this.next = next;
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public ListNode(int data, ListNode next, ListNode random) {
        this.data = data;
        this.next = next;
        this.random = random;
    }
}
