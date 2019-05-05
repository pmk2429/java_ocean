package arrays.subs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

  private static void backtrack(int[] candidates, int target, List<Integer> combination, List<List<Integer>> res, int start) {
    if (0 == target) {
      res.add(new ArrayList<>(combination));
    } else if (target > 0) {
      for (int i = start; i < candidates.length; i++) {
        if (target < candidates[i]) {
          return;
        }
        combination.add(candidates[i]);
        backtrack(candidates, target - candidates[i], combination, res, i);
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
    backtrack(candidates, target, new ArrayList<>(), res, 0);
    return res;
  }

  public static void main(String[] args) {
    int[] candidates = {2, 3, 6, 7};
    int target = 7;

    List<List<Integer>> res = combinationSum(candidates, target);
    for (List<Integer> list : res) {
      System.out.println(list);
    }
  }
}
