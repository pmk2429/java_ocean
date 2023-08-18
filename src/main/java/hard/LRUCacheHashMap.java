package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of LRU Cache with HashMap and Doubly LinkedList.
 * <p>
 * ~!@#HARD:REVISE
 */
public class LRUCacheHashMap {
    private static class Node {
        /**
         * Here key seems redundant, but it'll be used in removal and updating the value.
         */
        int key;
        int value;
        Node prev, next;

        Node() {
            this(0, 0);
        }

        Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    private final Map<Integer, Node> map;
    private final Node head, tail;
    private final int CAPACITY;
    private int count;

    public LRUCacheHashMap(int capacity) {
        CAPACITY = capacity;
        count = 0;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node n = map.get(key);
        if (null == n) {
            return -1;
        }
        // when we get the Node, we update - remove and then add it back
        update(n);
        return n.value;
    }

    public void set(int key, int value) {
        Node n = map.get(key);
        if (n == null) {
            n = new Node(key, value);
            map.put(key, n);
            add(n);
            count++;
        }
        else {
            n.value = value;
            update(n);
        }

        if (count > CAPACITY) {
            Node toDel = tail.prev;
            remove(toDel);
            map.remove(toDel.key);
            count--;
        }
    }

    /**
     * Remove the node and re-insert it back next to head.
     */
    private void update(Node node) {
        remove(node);
        add(node);
    }

    /**
     * Insert the node between `head` and `head.next`
     */
    private void add(Node node) {
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }

    private void remove(Node node) {
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
    }
}
