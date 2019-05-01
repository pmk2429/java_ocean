package hard;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;

public class LRUCache {
  // store keys of cache
  static Deque<Integer> dq;
  // store references of key in cache
  static HashSet<Integer> map;
  //maximum capacity of cache
  static int csize;

  LRUCache(int n) {
    dq = new LinkedList<>();
    map = new HashSet<>();
    csize = n;
  }

  /* Refers key x with in the LRU cache */
  private void refer(int x) {
    if (!map.contains(x)) {
      if (dq.size() == csize) {
        int last = dq.removeLast();
        map.remove(last);
      }
    } else {
      int index = 0, i = 0;
      for (Integer integer : dq) {
        if (integer == x) {
          index = i;
          break;
        }
        i++;
      }
      dq.remove(index);
    }
    dq.push(x);
    map.add(x);
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

