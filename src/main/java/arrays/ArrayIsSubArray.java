package arrays;

import java.util.Arrays;

/**
 * Check whether an Array is Sub Array of another Array
 * <p>
 * Input : A[] = {2, 3, 0, 5, 1, 1, 2}, B[] = {3, 0, 5, 1}
 * Output : Yes
 * <p>
 * Input : A[] = {1, 2, 3, 4, 5}, B[] = {2, 5, 6}
 * Output : No
 */
public class ArrayIsSubArray {

  private static boolean isSubArray(int[] main, int[] sub) {
    boolean isSubArray = false;
    int m = main.length;
    int n = sub.length;
    int i = 0, j = 0, k = i + 1;

    while (i < m && j < n) {
      if (main[i] == sub[j]) {
        i++;
        j++;


        // if entire B is traversed, return true
        if (j == n) {
          isSubArray = true;
        }
      } else {
        if (k < m && main[i] != main[k]) {
          i++;
          k++;
        }
        j = 0;
      }
    }

    return isSubArray;
  }

  /*
  binarySearch() can ONLY be used on sorted arrays.
  If the array is sorted, you can use the following code to search the target element:
  */
  public static boolean useArraysBinarySearch(String[] arr, String targetValue) {
    int a = Arrays.binarySearch(arr, targetValue);
    if (a > 0)
      return true;
    else
      return false;
  }

  public static void main(String[] args) {
    int main[] = {2, 3, 0, 5, 1, 1, 2};
    int sub[] = {1, 2};

    System.out.println(isSubArray(main, sub));
  }
}
