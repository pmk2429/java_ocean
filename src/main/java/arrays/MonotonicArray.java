package arrays;

/**
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * <p>
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].
 * An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * Return true if and only if the given array A is monotonic.
 * <p>
 * Example 1:
 * Input: [1,2,2,3]
 * Output: true
 * Example 2:
 * Input: [6,5,4,4]
 * Output: true
 * Example 3:
 * Input: [1,3,2]
 * Output: false
 * Example 4:
 * Input: [1,2,4,5]
 * Output: true
 * Example 5:
 * Input: [1,1,1]
 * Output: true
 * <p>
 * Note:
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 */
public class MonotonicArray {

  private static boolean increasing(int[] arr) {
    for (int i = 0; i < arr.length - 1; ++i)
      if (arr[i] >= arr[i + 1]) {
        return false;
      }
    return true;
  }

  private static boolean decreasing(int[] arr) {
    for (int i = 0; i < arr.length - 1; ++i)
      if (arr[i] <= arr[i + 1]) {
        return false;
      }
    return true;
  }

  private static boolean isMonotonic(int[] A) {
    return increasing(A) || decreasing(A);
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 5, 4};
    System.out.println(isMonotonic(a));
  }
}
