package arrays.subs;

public class SumOfAllSubArrays {

  // Computes sum all sub-array
  private static int SubArraySum(int[] arr, int n) {
    int result = 0;

    // Pick starting point
    for (int i = 0; i < n; i++) {
      // Pick ending point
      for (int j = i; j < n; j++) {
        // sum subarray between current starting and ending points
        for (int k = i; k <= j; k++) {
          result += arr[k];
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {

  }
}
