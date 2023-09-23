package list.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Clone LinkedList - Deep Copy LinkedList
 * <p>
 * A linked list is given such that each node contains an additional random pointer that could point to any node in the list or null.
 * Return a deep copy of the list.
 * <p>
 * O(n) runtime, O(n) space – HashMap:
 * <p>
 * It is now natural to lead to a mapping, so we can quickly look up the node to connect. We can easily build the
 * map of indices to cloned nodes. Therefore, we have reduced the complexity to O(1) when connecting the random nodes.
 * This had got us started, although it requires two maps. On closer inspection, it turns out that the two maps
 * could be shortened into one single map. We just need to map the original node to its random node directly.
 * <p>
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand-new nodes, where each new node
 * has its value set to the value of its corresponding original node. Both the next and random pointer of the new
 * nodes should point to new nodes in the copied list such that the pointers in the original list and copied list
 * represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 * <p>
 * Example 1:
 * ==========
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * <p>
 * Example 2:
 * ==========
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 * <p>
 * Example 3:
 * ==========
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 */
public class CopyRandomList {

    private ListNode copyRandomList(ListNode head) {
        Map<ListNode, ListNode> map = new HashMap<>();
        ListNode p = head;
        ListNode dummy = new ListNode(0);
        ListNode q = dummy;

        while (p != null) {
            q.next = new ListNode(p.data);
            map.put(p, q.next);
            p = p.next;
            q = q.next;
        }

        p = head;
        q = dummy;

        while (p != null) {
            q.next.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }
        return dummy.next;
    }

    /**
     * Complexity Analysis
     * <p>
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     */
    private ListNode copyRandomListO1Space(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode ptr = head;
        // Create interleaving Nodes next to the same List
        while (ptr != null) {
            ListNode next = ptr.next;
            ListNode copy = new ListNode(ptr.data);
            ptr.next = copy;
            copy.next = next;
            ptr = next;
        }

        ptr = head;

        // align the random pointers in the newly created adjacent list.
        // this step aligns the random pointers of copy list.
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        ptr = head;
        ListNode headCopy = ptr.next;

        // final step to detach the original LinkedList and return the new copy list head
        while (ptr != null) {
            ListNode copy = ptr.next;
            ptr.next = copy.next;
            ptr = ptr.next;
            copy.next = (ptr != null) ? ptr.next : null;
        }
        return headCopy;
    }

    public static void main(String[] args) {

    }
}
