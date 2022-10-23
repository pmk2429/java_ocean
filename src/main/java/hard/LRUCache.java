package hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * ~!@#HARD:REVISE
 */
public class LRUCache {

    // store keys of cache
    private final Deque<Integer> dq;
    // store references of key in cache
    private final Set<Integer> set;
    //maximum capacity of cache
    private final int CAPACITY;

    private LRUCache(int n) {
        dq = new ArrayDeque<>();
        set = new HashSet<>();
        CAPACITY = n;
    }

    /* Refers key x with in the LRU cache */
    private void offer(int x) {
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
        dq.push(x); //dq.addFirst(x);
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
        ca.offer(1);
        ca.offer(2);
        ca.offer(3);
        ca.offer(1);
        ca.offer(4);
        ca.offer(5);
        ca.display();
    }
}
