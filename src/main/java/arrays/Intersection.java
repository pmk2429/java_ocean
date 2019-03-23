package arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * WAP to find intersecting elements from two arrays and return a new array.
 */
public class Intersection {

  private static int[] findIntersection(int[] arr1, int[] arr2) {
    HashSet<Integer> set1 = new HashSet<>();
    for (int i : arr1) {
      set1.add(i);
    }

    HashSet<Integer> set2 = new HashSet<>();
    for (int i : arr2) {
      if (set1.contains(i)) {
        set2.add(i);
      }
    }

    int[] result = new int[set2.size()];
    int i = 0;
    for (int n : set2) {
      result[i++] = n;
    }

    return result;
  }

  public static void main(String[] args) {
    int[] arr1 = new int[]{1, 2, 3, 4, 5};
    int[] arr2 = new int[]{4, 5, 6, 7, 8};
    int[] intersection = findIntersection(arr1, arr2);
    System.out.println(Arrays.toString(intersection));
  }
}
