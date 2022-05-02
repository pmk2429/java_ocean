package hard;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class LRUCache {

    // store keys of cache
    private final Deque<Integer> dq;
    // store references of key in cache
    private final HashSet<Integer> set;
    //maximum capacity of cache
    private final int CAPACITY;

    private LRUCache(int n) {
        dq = new LinkedList<>();
        set = new HashSet<>();
        CAPACITY = n;
    }

    /* Refers key x with in the LRU cache */
    private void refer(int x) {
        if (!set.contains(x)) {
            if (dq.size() == CAPACITY) {
                int last = dq.removeLast();
                set.remove(last);
            }
        }
        else {
            // remove the matched element from the Queue
            dq.remove(x);
        }
        // keep adding elements to the Head of the Queue
        dq.push(x);
        set.add(x);
    }

    // display contents of cache
    private void display() {
        for (Integer integer : dq) {
            System.out.print(integer + " ");
        }
    }

    public static void main(String[] args) {
        LRUCache ca = new LRUCache(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }
}
