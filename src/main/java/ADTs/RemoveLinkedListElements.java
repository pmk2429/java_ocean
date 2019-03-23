package ADTs;

import java.util.LinkedList;

public class RemoveLinkedListElements {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    list.add(1);
    list.add(2);
    list.add(6);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);

    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == 6) {
        list.remove(i);
      }
    }

    System.out.println(list);
  }
}
