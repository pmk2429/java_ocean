package arrays;

/**
 * Make all numbers of an array equal
 * Given an array arr[], the task is to make all the array elements equal with the given operation.
 * In a single operation, any element of the array can be either multiplied by 2 or by 3.
 * If its possible to make all the array elements equal with the given operation then print Yes else print No.
 * <p>
 * Example 1:
 * ----------
 * Input: arr[] = {50, 75, 100}
 * Output: Yes
 * {50 * 2 * 3, 75 * 2 * 2, 100 * 3} = {300, 300, 300}
 * <p>
 * Example 2:
 * ----------
 * Input: arr[] = {10, 14}
 * Output: No
 */
public class MakeAllNosEqual {

  private static boolean canConvertToEqual(int[] a) {
    int n = a.length;
    for (int i = 0; i < n; i++) {
      // Divide number by 2
      while (a[i] % 2 == 0) {
        a[i] /= 2;
      }

      // Divide number by 3
      while (a[i] % 3 == 0) {
        a[i] /= 3;
      }
    }

    // Remaining numbers
    for (int i = 1; i < n; i++) {
      if (a[i] != a[0]) {
        return false;
      }
    }

    return true;
  }

  private static int gcd(int a, int b) {
    if (a == 0) {
      if (b == 0) {
        return 0;
      }
      return b;
    }

    // Always set to positive
    a = (a > 0) ? a : -a;
    b = (b > 0) ? b : -b;

    while (a != b) {
      if (a > b) {
        a -= b;
      } else {
        b -= a;
      }
    }
    return a;
  }

  private static int HCF(int[] arr) {
    int result = arr[0];
    for (int i = 1; i < arr.length; i++) {
      result = gcd(arr[i], result);
    }

    return result;
  }

  public static void main(String[] args) {
    int[] a = {50, 75, 100};
    System.out.println(canConvertToEqual(a));
    System.out.println(HCF(a));
  }
}
