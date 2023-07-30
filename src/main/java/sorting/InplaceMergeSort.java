package sorting;

import java.util.Arrays;

/**
 * Approach:
 * ---------
 * Maintain two pointers which point to start of the segments which have to be merged.
 * Compare the elements at which the pointers are present.
 * If element1 < element2 then element1 is at right position, simply increase pointer1.
 * Else place element2 in its right position and all the elements at the right of element2 will be shifted right
 * by one position. Increment all the pointers by 1.
 */
public class InplaceMergeSort {

    static void merge(int[] arr, int start, int mid, int end) {
        int start2 = mid + 1;

        // If the direct merge is already sorted
        if (arr[mid] <= arr[start2]) {
            return;
        }

        // Two pointers to maintain start of both arrays to merge
        while (start <= mid && start2 <= end) {
            // If element 1 is in right place
            if (arr[start] <= arr[start2]) {
                start++;
            }
            else {
                int value = arr[start2];
                int index = start2;

                // Shift all the elements between element 1 element 2, right by 1.
                while (index != start) {
                    arr[index] = arr[index - 1];
                    index--;
                }
                arr[start] = value;

                // Update all the pointers
                start++;
                mid++;
                start2++;
            }
        }
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            // Same as (l + r) / 2, but avoids overflow for large l and r
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    private static void printArray(int[] A) {
        Arrays.stream(A).mapToObj(result -> result + " ").forEach(System.out::print);
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        int arr_size = arr.length;
        mergeSort(arr, 0, arr_size - 1);
        printArray(arr);

        int[] arr2 = {2, 0, 2, 1, 1, 0};
        int arr2_size = arr2.length;
        mergeSort(arr2, 0, arr2_size - 1);
        printArray(arr2);
    }
}
