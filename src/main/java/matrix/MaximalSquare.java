package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MaximalSquare {
  public int maximalSquare(char[][] matrix) {
    int[][] cache = new int[matrix.length][matrix[0].length];
    int maxSquare = 0;
    for (int i = 0; i < matrix.length; ++i) {
      for (int j = 0; j < matrix[0].length; ++j) {
        if (matrix[i][j] == '1') {
          if (i > 0 && j > 0) {
            cache[i][j] = Math.min(cache[i - 1][j - 1], Math.min(cache[i - 1][j], cache[i][j - 1])) + 1;
          } else cache[i][j] = 1;
        }
        maxSquare = Math.max(cache[i][j], maxSquare);
      }
    }
    return maxSquare * maxSquare;
  }

  public static int largestArea(int size, List<List<Integer>> samples) {

    if (samples == null || samples.size() == 0 || samples.get(0) == null || samples.get(0).size() == 0) {
      return 0;
    }

    int R = samples.size();
    int C = samples.get(0).size();

    int[][] area = new int[R][C];
    int maxSquare = 0;
    for (int i = 0; i < size; ++i) {
      for (int j = 0; j < size; ++j) {
        if (samples.get(i).get(j) == 1) {
          if (i > 0 && j > 0) {
            area[i][j] = Math.min(area[i - 1][j - 1], Math.min(area[i - 1][j], area[i][j - 1])) + 1;
          } else {
            area[i][j] = 1;
          }
        }
        maxSquare = Math.max(area[i][j], maxSquare);
      }
    }
    return maxSquare;
  }

  public static void main(String[] args) {
    ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));
    ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 1, 1, 0, 0));
    ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1, 1, 1, 0, 0));
    ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(1, 1, 1, 0, 0));
    ArrayList<Integer> list5 = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));

    List<List<Integer>> mainList = new ArrayList<>();
    mainList.add(list1);
    mainList.add(list2);
    mainList.add(list3);
    mainList.add(list4);
    mainList.add(list5);

    int ans = largestArea(5, mainList);
    System.out.println(ans);
  }
}
