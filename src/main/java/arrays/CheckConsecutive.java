package arrays;

/**
 * Check if array elements are consecutive
 * Given an unsorted array of numbers, write a function that returns true if array consists of consecutive numbers.
 * <p>
 * Examples:
 * ---------
 * a) If array is {5, 2, 3, 1, 4}, then the function should return true because the array has consecutive numbers from 1 to 5.
 * b) If array is {83, 78, 80, 81, 79, 82}, then the function should return true because the array has consecutive numbers from 78 to 83.
 * c) If the array is {34, 23, 52, 12, 3 }, then the function should return false because the elements are not consecutive.
 * d) If the array is {7, 6, 5, 5, 3, 4}, then the function should return false because 5 and 5 are not consecutive.
 */
public class CheckConsecutive {

  private static int getMax(int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  private static int getMin(int[] arr) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < min) {
        min = arr[i];
      }
    }
    return min;
  }

  private static boolean isConsecutive(int[] arr) {
    int n = arr.length;
    if (n < 1) {
      return false;
    }

    int min = getMin(arr);
    int max = getMax(arr);

    // for a consecutive array of length n, the difference between max and min should yield length of array
    if (max - min + 1 == n) {
      // create temp array to hold visited flags for elements at specified indexes
      boolean[] visited = new boolean[n];
      int i;
      for (i = 0; i < n; i++) {
        int position = arr[i] - min;
        // element encountered again - already visited
        if (visited[position]) {
          return false;
        }
        // mark it visited
        visited[position] = true;
      }
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int[] arr = {5, 2, 3, 1, 4};
    System.out.println(isConsecutive(arr));
  }
}
