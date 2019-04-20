package arrays.subs;

/**
 * Sum of XOR of all subarrays
 * Given an array containing N positive integers, the task is to find the sum of XOR of all sub-arrays of the array.
 * <p>
 * Examples:
 * ---------
 * Input : arr[] = {1, 3, 7, 9, 8, 7}
 * Output : 128
 * <p>
 * Input : arr[] = {3, 8, 13}
 * Output : 46
 * <p>
 * Explanation for second test-case:
 * XOR of {3} = 3
 * XOR of {3, 8} = 11
 * XOR of {3, 8, 13} = 6
 * XOR of {8} = 8
 * XOR of {8, 13} = 5
 * XOR of {13} = 13
 * <p>
 * Sum = 3 + 11 + 6 + 8 + 5 + 13 = 46
 */
public class XORSum {

  private static int findXorSum(int arr[], int n) {
    // variable to store
    // the final sum
    int sum = 0;

    // multiplier
    int mul = 1;

    for (int i = 0; i < 30; i++) {

      // variable to store number of
      // sub-arrays with odd number of elements
      // with ith bits starting from the first
      // element to the end of the array
      int c_odd = 0;

      // variable to check the status
      // of the odd-even count while
      // calculating c_odd
      boolean odd = false;

      // loop to calculate initial
      // value of c_odd
      for (int j = 0; j < n; j++) {
        if ((arr[j] & (1 << i)) > 0) {
          odd = (!odd);
        }
        if (odd) {
          c_odd++;
        }
      }

      // loop to iterate through
      // all the elements of the
      // array and update sum
      for (int j = 0; j < n; j++) {
        sum += (mul * c_odd);

        if ((arr[j] & (1 << i)) > 0) {
          c_odd = (n - j - c_odd);
        }
      }

      // updating the multiplier
      mul *= 2;
    }

    // returning the sum
    return sum;
  }

  public static void main(String[] args) {
    int[] arr = {3, 8, 13};
    int n = arr.length;

    System.out.println(findXorSum(arr, n));
  }
}
