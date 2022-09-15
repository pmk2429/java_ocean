package arrays;

import java.util.PriorityQueue;

/**
 * Given two sorted arrays of size m and n respectively, find the element that would be at the k’th position of the
 * final sorted array.
 * <p>
 * Example 1:
 * ----------
 * Input :
 * Array 1 - 2 3 6 7 9
 * Array 2 - 1 4 8 10
 * k = 5
 * Output :
 * 6
 * Explanation:
 * The final sorted array would be -
 * 1, 2, 3, 4, 6, 7, 8, 9, 10
 * The 5th element of this array is 6.
 * <p>
 * Example 2:
 * ----------
 * Input :
 * Array 1 - 100 112 256 349 770
 * Array 2 - 72 86 113 119 265 445 892
 * k = 7
 * Output :
 * 256
 * Explanation:
 * Final sorted array is -
 * 72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
 * 7th element of this array is 256.
 */
public class KthElementOfTwoSortedArrays {

    /**
     * Algo
     * - Merge two sorted arrays using PriorityQueue
     * - Loop from reverse to find the kth element
     */
    private static int kthElement(int[] a, int[] b, int k) {
        PriorityQueue<Integer> sortedElements = new PriorityQueue<>();

        for (int elem : a) {
            sortedElements.offer(elem);
        }

        for (int elem : b) {
            sortedElements.offer(elem);
        }

        for (int i = 0; i < sortedElements.size(); i++) {
            if (sortedElements.size() > k) {
                sortedElements.poll();
            }
        }

        return sortedElements.peek();
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};

        int k = 5;

        System.out.println(kthElement(arr1, arr2, k));
    }
}
