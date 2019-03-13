package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * WAP to find top two numbers from an integer array.
 */
public class TopTwo {

  private static List<Integer> topTwo(int[] arr) {
    List<Integer> topTwo = new ArrayList<>();
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max1) {
        max2 = max1;
        max1 = arr[i];
      } else if(arr[i] > max2) {
        max2 = arr[i];
      }
    }
    topTwo.add(max1);
    topTwo.add(max2);
    return topTwo;
  }

  public static void main(String[] args) {
    System.out.println(topTwo(new int[]{20, 34, 21, 87, 92, Integer.MAX_VALUE}));
    System.out.println(topTwo(new int[]{0, Integer.MIN_VALUE, -2}));
    System.out.println(topTwo(new int[]{Integer.MAX_VALUE, 0, Integer.MAX_VALUE}));
    System.out.println(topTwo(new int[]{1, 1, 0}));
  }
}
