package arrays.subs;

import java.util.*;

public class NumPowerSet {

  // Print all subsets of given set[]
  private static void printSubsetsUsingBitManipulation(int[] set) {
    int n = set.length;

    // Run a loop from 0 to 2^n
    for (int i = 0; i < (1 << n); i++) {
      System.out.print("{ ");
      int m = 1; // m is used to check set bit in binary representation.
      // Print current subset
      for (int j = 0; j < n; j++) {
        if ((i & m) > 0) {
          System.out.print(set[j] + " ");
        }
        m = m << 1;
      }

      System.out.println("}");
    }
  }

  private static Set<Set<Integer>> powerSet(Set<Integer> originalSet) {
    Set<Set<Integer>> sets = new HashSet<>();
    if (originalSet.isEmpty()) {
      sets.add(new HashSet<>());
      return sets;
    }
    List<Integer> list = new ArrayList<>(originalSet);
    Integer head = list.get(0);
    Set<Integer> rest = new HashSet<>(list.subList(1, list.size()));
    for (Set<Integer> set : powerSet(rest)) {
      Set<Integer> newSet = new HashSet<>();
      newSet.add(head);
      newSet.addAll(set);
      sets.add(newSet);
      sets.add(set);
    }
    return sets;
  }

  private static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
  }

  private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
    list.add(new ArrayList<>(tempList));
    System.out.println(list);
    for (int i = start; i < nums.length; i++) {
      tempList.add(nums[i]);
      // reduce the problem space for the node currently branched
      backtrack(list, tempList, nums, i + 1);
      // once the candidates as deduced to be not suitable for obtaining solution, backtrack/remove it
      tempList.remove(tempList.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3};
    System.out.println(subsets(a));
  }
}
