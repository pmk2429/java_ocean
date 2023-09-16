package binarysearch;

/**
 * Find an element in Bitonic array
 * Given a bitonic sequence of n distinct elements, write a program to find a given element x in the bitonic sequence
 * in O(log n) time. A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a
 * point strictly decreasing.
 * <p>
 * Examples:
 * ---------
 * Input :  arr[] = {-3, 9, 8, 20, 17, 5, 1};
 * key = 20
 * Output : Found at index 3
 * <p>
 * Example 2:
 * ---------
 * Input :  arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
 * key = 30
 * Output : Not Found
 */
public class BitonicArray {

    private static int ascendingBinarySearch(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int descendingBinarySearch(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (arr[mid] < key) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // finding Bitonic point
    private static int findBitonicPoint(int[] arr, int l, int r) {
        int mid;

        mid = (r + l) / 2;
        if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
            findBitonicPoint(arr, l, mid);
        }
        else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
            findBitonicPoint(arr, mid, r);
        }
        return mid;
    }

    private static int findElement(int[] arr, int n, int key, int index) {
        if (key > arr[index]) {
            return -1;
        }
        else if (key == arr[index]) {
            return index;
        }
        else {
            int temp = ascendingBinarySearch(arr, 0, index - 1, key);
            if (temp != -1) {
                return temp;
            }

            // Search in right of k
            return descendingBinarySearch(arr, index + 1, n - 1, key);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {-3, 9, 8, 20, 17, 5, 1};
        int[] arr2 = {5, 6, 7, 8, 9, 10, 1, 2, 3};

        int key = 1;
        int n, l, r;
        n = arr1.length;
        l = 0;
        r = n - 1;
        int index;
        index = findBitonicPoint(arr1, l, r);
        System.out.println(arr1[index]);

        int x = findElement(arr1, n, key, index);
    }
}
