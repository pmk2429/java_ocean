package arrays;

/**
 * Smallest Pair Sum in an array
 * Given an array of distinct integers arr[], the task is to find a pair which has the minimum sum and print the sum.
 * <p>
 * Example 1:
 * ----------
 * Input: arr[] = {1, 2, 3}
 * Output: 3
 * The pair (1, 2) will have the minimum sum pair i.e. 1 + 2 = 3
 * <p>
 * Example 2:
 * ----------
 * Input: arr[] = {3, 5, 6, 2, -4}
 * Output: 5
 */
public class SmallestPairSum {

  // find smallest and nextSmallest, return their sum
  private static int findSmallestPair(int[] arr) {
    int smallestPairSum = -1;
    if (arr == null || arr.length == 0) {
      return smallestPairSum;
    }

    if (arr.length == 1) {
      smallestPairSum = arr[0];
      return smallestPairSum;
    }

    if (arr.length == 2) {
      smallestPairSum = arr[0] + arr[1];
      return smallestPairSum;
    }

    int smallest = Integer.MAX_VALUE;
    int secondSmallest = Integer.MAX_VALUE;
    for (int value : arr) {
      if (value < smallest) {
        secondSmallest = smallest;
        smallest = value;
      } else if (value < secondSmallest) {
        secondSmallest = value;
      }
    }

    smallestPairSum = secondSmallest + smallest;

    return smallestPairSum;
  }

  public static void main(String[] args) {
    int[] arr = {3, 5, 6, 2, -4};
    System.out.println(findSmallestPair(arr));
  }
}
