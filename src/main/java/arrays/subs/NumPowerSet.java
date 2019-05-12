package arrays.subs;

import java.util.*;

public class NumPowerSet {

  // Print all subsets of given set[]
  private static List<List<Integer>> printSubsetsUsingBitManipulation(int[] set) {
    List<List<Integer>> powerset = new ArrayList<>();

    int n = set.length;

    // Run a loop from 0 to 2^n
    for (int i = 0; i < (1 << n); i++) {
      // System.out.println("{");
      List<Integer> subset = new ArrayList<>();
      int m = 1; // m is used to check set bit in binary representation.
      // Print current subset
      for (int value : set) {
        if ((i & m) > 0) {
          subset.add(value);
          // System.out.print(value + " ");
        }
        m = m << 1;
      }
      powerset.add(subset);
      // System.out.println("}");
    }
    return powerset;
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

  private static void backtrack(List<List<Integer>> powerSet, List<Integer> subSet, int[] nums, int start) {
    powerSet.add(subSet);
    System.out.println(powerSet);
    for (int i = start; i < nums.length; i++) {
      subSet.add(nums[i]);
      // reduce the problem space for the node currently branched
      backtrack(powerSet, subSet, nums, i + 1);
      // once the candidates as deduced to be not suitable for obtaining solution, backtrack/remove it
      subSet.remove(subSet.size() - 1);
    }
  }

  private static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
  }

  public static void main(String[] args) {
    int[] a = {12, 92, 36, 45, 89, 24, 63, 57};
    //System.out.println(subsets(a));

    System.out.println(printSubsetsUsingBitManipulation(a));
  }
}
