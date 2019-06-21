package arrays.subs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeSum {

  private static int[] threeSumUsingHashSet(int[] arr, int target) {
    int size = arr.length;
    int[] three = new int[3];
    boolean found = false;

    // Fix the first element as A[i]
    for (int i = 0; i < size - 2; i++) {
      // Find pair in subarray A[i+1..n-1] with sum equal to sum - A[i]
      HashSet<Integer> s = new HashSet<>();
      int complement = target - arr[i];
      three[0] = arr[i];
      for (int j = i + 1; j < size; j++) {
        int threeComplement = complement - arr[j];
        if (s.contains(threeComplement) && threeComplement != (int) s.toArray()[s.size() - 1]) {
          three[1] = arr[j];
          three[2] = complement - arr[j];
          found = true;
          break;
        }
        s.add(arr[j]);
      }
      if (found) {
        break;
      }
    }

    return three;
  }

  private static int[] threeSum(int[] arr, int target) {
    int length = arr.length;
    int[] three = new int[3];
    boolean found = false;
    Set<Integer> uniqueThree = new HashSet<>();

    for (int i = 0; i < length - 2; i++) {
      int complement = target - arr[i];
      three[0] = arr[i];
      for (int j = i + 1; j < length; j++) {
        int threeDiff = complement - arr[j];
        if (uniqueThree.contains(threeDiff) && threeDiff != (int) uniqueThree.toArray()[uniqueThree.size() - 1]) {
          three[1] = arr[j];
          three[2] = threeDiff;
          found = true;
          break;
        }
        uniqueThree.add(arr[j]);
      }
      if (found) {
        break;
      }
    }
    return three;
  }

  // Sort the array and find the sum incrementally
  private static int[] threeSumUsingSort(int[] arr, int target) {
    int l, r;
    int[] three = new int[3];
    int size = arr.length;

    // Sort the array
    Arrays.sort(arr);

    // 1. Algo for smallest solvable problem unit
    // 2. Extend the algo to the entire problem space
    // 3. Check for edge/error cases
    // 4. Test
    // 5. Optimize

    for (int i = 0; i < arr.length; i++) {
      boolean found = false;
      l = i + 1;
      r = size - 1;
      three[0] = arr[i];
      while (l < r) {
        if (arr[i] + arr[l] + arr[r] == target) {
          three[1] = arr[l];
          three[2] = arr[r];
          found = true;
          break;
        } else if (arr[i] + arr[l] + arr[r] < target) {
          l++;
        } else {
          r--;
        }
      }
      if (found) {
        break;
      }
    }
    return three;
  }

  public static void main(String[] args) {
    int A[] = {1, 4, 45, 6, 10, 8};
    int sum = 22;
    System.out.println(Arrays.toString(threeSumUsingSort(A, sum)));
    System.out.println(Arrays.toString(threeSumUsingHashSet(A, sum)));
  }
}
