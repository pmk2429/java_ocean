package numbers;

import java.util.*;

/**
 * Created by Pavitra on 5/7/2016.
 */
public class PowerSet {
  public static void main(String[] args) {
    Set<Set<Integer>> powerset = powerSet(new HashSet<>(Arrays.asList(1, 2, 3)));
  }

  static Set<Set<Integer>> powerSet(Set<Integer> originalSet) {
    Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
    if (originalSet.isEmpty()) {
      sets.add(new HashSet<Integer>());
      return sets;
    }
    List<Integer> list = new ArrayList<Integer>(originalSet);
    Integer head = list.get(0);
    Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));
    for (Set<Integer> set : powerSet(rest)) {
      Set<Integer> newSet = new HashSet<Integer>();
      newSet.add(head);
      newSet.addAll(set);
      sets.add(newSet);
      sets.add(set);
    }
    return sets;
  }
}
