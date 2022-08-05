package arrays;

/**
 * Find the only repeating element in a sorted array of size n
 * Given a sorted array of n elements containing elements in range from 1 to n-1 i.e. one element occurs twice,
 * the task is to find the repeating element in an array.
 * <p>
 * Eg
 * Input :  arr[] = { 1, 2 , 3 , 4 , 4}
 * Output :  4
 * <p>
 * Input :  arr[] = { 1 , 1 , 2 , 3 , 4}
 * Output :  1
 */
public class OnlyRepeatingInSortedArray {

    private static int findRepeatingElement(int[] arr, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        // Check if the mid-element is the repeating one
        if (arr[mid] != mid + 1) {
            if (mid > 0 && arr[mid - 1] == arr[mid]) {
                return mid;
            }

            // If mid-element is not at its position that means the repeated element is in left
            return findRepeatingElement(arr, low, mid - 1);
        }
        // If mid is at proper position then repeated one is in  right.
        return findRepeatingElement(arr, mid + 1, high);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int index = findRepeatingElement(arr, 0, arr.length - 1);
        System.out.println(arr[index]);
    }
}
