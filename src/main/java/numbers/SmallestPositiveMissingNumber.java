package numbers;

public class SmallestPositiveMissingNumber {

  private static int findSmallestPositiveMissingNumberPositiveArray(int[] arr) {
    return -1;
  }

  /* Utility function that puts all non-positive
     (0 and negative) numbers on left side of
     arr[] and return count of such numbers */
  private static int[] segregate(int arr[]) {
    int j = 0; // for negative nos
    int size = arr.length;
    for (int i = 0; i < size; i++) {
      if (arr[i] < 0) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        j++;
      }
    }
    return arr;
  }

  /**
   * Input:  {2, 3, 7, 6, 8, -1, -10, 15}
   * Output: 1
   * <p>
   * Input:  { 2, 3, -7, 6, 8, 1, -10, 15 }
   * Output: 4
   * <p>
   * Input: {1, 1, 0, -1, -2}
   * Output: 2
   *
   * @param arr
   * @return
   */
  private static int findSmallestPositiveMissingNumberUnsortedArray(int[] arr) {
    int smallestPositiveNum = -1;
    int[] updatedArr = segregate(arr);
    for (int i = 0; i < updatedArr.length; i++) {
      if (updatedArr[i] > 0) {
        return updatedArr[i];
      }
    }
    return smallestPositiveNum;
  }

  public static void main(String[] args) {
    int[] arr = {2, 3, 7, 6, 8, -1, -10, 15};
    System.out.println(findSmallestPositiveMissingNumberUnsortedArray(arr));
  }
}
