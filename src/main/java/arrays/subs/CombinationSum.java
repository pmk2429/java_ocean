package arrays.subs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

  private static void backtrack(int[] candidates, int target, List<Integer> combination, List<List<Integer>> res,
                                int start, int k) {
    if (0 == target && combination.size() == k) {
      res.add(new ArrayList<>(combination));
    } else if (target > 0) {
      for (int i = start; i < candidates.length; i++) {
        if (target < candidates[i]) {
          return;
        }
        combination.add(candidates[i]);
        backtrack(candidates, target - candidates[i], combination, res, i, k);
        combination.remove(combination.size() - 1);
      }
    }
  }

  private static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (candidates == null || candidates.length == 0 || target <= 0) {
      return res;
    }
    Arrays.sort(candidates);
    int k = 3;
    backtrack(candidates, target, new ArrayList<>(), res, 0, k);
    return res;
  }

  public static void backtrack(List<List<Integer>> res, List<Integer> lst, int start, int k, int target) {
    if (k < 0 && target < 1) {
      return;
    }
    if (k == 0 && target == 0) {
      res.add(new ArrayList<>(lst));
      return;
    }
    for (; start <= 9; start++) {
      lst.add(start);
      backtrack(res, lst, start + 1, k - 1, target - start);
      lst.remove(lst.size() - 1);
    }
  }

  private static List<List<Integer>> combinationSumIndex(int k, int n) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(res, new ArrayList<>(), 1, k, n);
    return res;
  }

  public static void main(String[] args) {
    //int[] candidates = {2, 3, 6, 7, 7, 11, 5};
    int[] candidates = {4, 5, 10, 7, 3, 4, 7, 4, 1, 8};
    int target = 20;
    int k = 3;

    List<List<Integer>> res = combinationSumIndex(k, 10);
    for (List<Integer> list : res) {
      System.out.println(list);
    }
  }
}
