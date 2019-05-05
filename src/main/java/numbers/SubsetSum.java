package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pavitra on 4/22/2016.
 */
public class SubsetSum {
  public static List<Integer> findSubsetSum(int[] numbers, int sum) {
    ArrayList<Integer> subset = new ArrayList<>();
    for (int i = 0; i < numbers.length; i++) {
      if (findSubsetSum(numbers, i, subset, sum)) {
        return subset;
      }
    }

    return null;
  }

  private static boolean findSubsetSum(int[] numbers, int index, ArrayList<Integer> subset, int sum) {
    if (index >= numbers.length) {
      return false;
    }

    if (sum - numbers[index] == 0) {
      subset.add(numbers[index]);
      return true;
    }

    if (sum - numbers[index] < 0) {
      return false;
    }

    sum -= numbers[index];
    for (int i = index + 1; i < numbers.length; i++) {
      if (findSubsetSum(numbers, i, subset, sum)) {
        subset.add(numbers[index]);
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int values[] = {2, 3, 4, 5, 6, 7, 8};
    System.out.println(findSubsetSum(values, 15));
  }
}
