package numbers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Pavitra on 4/21/2016.
 */
public class AllSubsets {

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> allSubsets = subsets(new int[]{1, 2, 3, 4, 5});
    for (int i = 0; i < allSubsets.size(); i++) {
      for (int j = 0; j < allSubsets.get(i).size(); j++) {
        System.out.print(allSubsets.get(i).get(j) + " ");
      }
      System.out.println();
    }
  }

  public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
    if (S == null)
      return null;

    Arrays.sort(S);

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    for (int i = 0; i < S.length; i++) {
      ArrayList<ArrayList<Integer>> temp = new ArrayList<>();

      //get sets that are already in result
      for (ArrayList<Integer> a : result) {
        temp.add(new ArrayList<>(a));
      }

      //add S[i] to existing sets
      for (ArrayList<Integer> existingList : temp) {
        existingList.add(S[i]);
      }

//            //add S[i] only as a set
      ArrayList<Integer> single = new ArrayList<Integer>();
      single.add(S[i]);
      temp.add(single);

      result.addAll(temp);
    }

    //add empty set
    result.add(new ArrayList<Integer>());

    ArrayList<ArrayList<Integer>> finalSubsets = new ArrayList<>();
    for (int i = 0; i < result.size(); i++) {
      if (result.get(i).size() >= 2) {
        if (sumOfArray(result.get(i)) <= 5) {
          finalSubsets.add(result.get(i));
        }
      }
    }

    return finalSubsets;
  }

  public static int sumOfArray(ArrayList<Integer> list) {
    int sum = 0;
    for (int i = 0; i < list.size(); i++) {
      sum += list.get(i);
    }
    return sum;
  }
}
