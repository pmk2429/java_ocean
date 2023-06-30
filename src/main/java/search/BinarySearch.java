package search;

import java.util.Arrays;

public class BinarySearch {

    private static int bst(int[] arr, int key, int start) {
        int L = start;
        int R = arr.length - 1;
        int index = -1;

        while (L <= R) {
            int M = (L + R) / 2;
            if (arr[M] < key) {
                L = M + 1;
            }
            else if (arr[M] > key) {
                R = M - 1;
            }
            else if (arr[M] == key) {
                index = M;
                break;
            }
        }
        return index;
    }

    // Returns index of x if it is present in arr[l..r], else return -1
    private static int myBinarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return myBinarySearch(arr, l, mid - 1, x);

            // Else the element can only be present in right subarray
            return myBinarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present in array
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 9, 8, 4, 15, 17};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(bst(arr, 7, 0));
    }
}
