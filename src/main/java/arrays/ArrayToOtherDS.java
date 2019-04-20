package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayToOtherDS {

  public static boolean useList(String[] arr, String targetValue) {
    return Arrays.asList(arr).contains(targetValue);
  }

  public static boolean useSet(String[] arr, String targetValue) {
    Set<String> set = new HashSet<String>(Arrays.asList(arr));
    return set.contains(targetValue);
  }

  public static boolean useLoop(String[] arr, String targetValue) {
    for (String s : arr) {
      if (s.equals(targetValue))
        return true;
    }
    return false;
  }

  public static boolean useArraysBinarySearch(String[] arr, String targetValue) {
    int a = Arrays.binarySearch(arr, targetValue);
    if (a > 0)
      return true;
    else
      return false;
  }

  public static void main(String[] args) {
    int[] arr = {};
  }
}
