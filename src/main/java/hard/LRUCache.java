package hard;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class LRUCache {
  // store keys of cache
  static Deque<Integer> dq;
  // store references of key in cache
  static HashSet<Integer> set;
  //maximum capacity of cache
  static int csize;

  LRUCache(int n) {
    dq = new LinkedList<>();
    set = new HashSet<>();
    csize = n;
  }

  /* Refers key x with in the LRU cache */
  private void refer(int x) {
    if (!set.contains(x)) {
      if (dq.size() == csize) {
        int last = dq.removeLast();
        set.remove(last);
      }
    } else {
      // dq.contains(x);
      for (Integer elem : dq) {
        if (elem == x) {
          break;
        }
      }
      // remove the matched element from the Queue
      dq.remove(x);
      //dq.removeLast();
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

