package arrays;

/**
 * Find the smallest positive number missing from an unsorted array
 * You are given an unsorted array with both positive and negative elements. You have to find the smallest positive
 * number missing from the array in O(n) time using constant extra space. You can modify the original array.
 * Examples
 * --------
 * Input:  {2, 3, 7, 6, 8, -1, -10, 15}
 * Output: 1
 * <p>
 * Input:  { 2, 3, -7, 6, 8, 1, -10, 15 }
 * Output: 4
 * <p>
 * Input: {1, 1, 0, -1, -2}
 * Output: 2
 */
public class FindSmallest {

    private static int findSmallestUnsorted(int[] arr) {
        int smallestPositive = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num > 0 && num < smallestPositive) {
                smallestPositive = num;
            }
        }
        return smallestPositive;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 6, 8, -1, -10, 15};
        System.out.println(findSmallestUnsorted(arr));
    }
}
