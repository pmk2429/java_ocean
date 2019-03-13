package arrays;

/**
 * Find the minimum element in a sorted and rotated array
 * A sorted array is rotated at some unknown point, find the minimum element in it. Following solution assumes that
 * all elements are distinct.
 * <p>
 * Examples:
 * ---------
 * Input: {5, 6, 1, 2, 3, 4}
 * Output: 1
 * <p>
 * Input: {1, 2, 3, 4}
 * Output: 1
 * <p>
 * Input: {2, 1}
 * Output: 1
 */
public class MinimumValue {

  // the point at which arr[j] < arr[i], return arr[j]
  private static int findSmallestInRotatedSortedArray(int[] arr) {
    int smallest = Integer.MAX_VALUE;
    int i = 0, j;
    while (i < arr.length) {
      j = i + 1;
      if (j < arr.length) {
        if (arr[i] > arr[j]) {
          smallest = arr[j];
        } else if (arr[i] < arr[j] && arr[i] < smallest) {
          smallest = arr[i];
        }
      }
      i++;
    }
    return smallest;
  }

  public static void main(String[] args) {
    int arr[] = {5, 6, 1, 2, 3, 4};
    int arr1[] = {4, 3, 2};
    int arr2[] = {1, 2, 3, 4};
    System.out.println(findSmallestInRotatedSortedArray(arr));
    System.out.println(findSmallestInRotatedSortedArray(arr1));
    System.out.println(findSmallestInRotatedSortedArray(arr2));
  }
}
