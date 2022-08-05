package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Find duplicates in O(n) time and O(1) extra space | Set 1
 * Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing
 * any number of times. Find these repeating numbers in O(n) and using only constant memory space.
 * <p>
 * For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.
 */
public class RepeatingElementsMaster {

    // using binary search and DP
    private static int findRepeating(int[] arr, int low, int high) {
        // low = 0 , high = n-1;
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        // Check if the mid element is the repeating one
        if (arr[mid] != mid + 1) {
            if (mid > 0 && arr[mid] == arr[mid - 1]) {
                return mid;
            }

            // If mid element is not at its position that means the repeated element is in left
            return findRepeating(arr, low, mid - 1);
        }

        // If mid is at proper position then repeated one is in right.
        return findRepeating(arr, mid + 1, high);
    }

    // works when max(arr) is > size(arr) and Auxiliary space is not O(1)
    private static void findNonRepeatingElement(int[] arr) {
        int count = 1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], count + 1);
            }
            else {
                map.put(arr[i], count);
            }
        }
        if (map.containsValue(1)) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    System.out.println(entry.getKey());
                }
            }
        }
    }

    // works only if max(arr[]) < size(arr[])
    private static void findRepeating(int[] arr) {
        int size = arr.length;
        int i;
        System.out.println("The repeating elements are : ");
        for (i = 0; i < size; i++) {
            if (arr[Math.abs(arr[i])] > 0) {
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            }
            else {
                System.out.print(Math.abs(arr[i]) + " ");
            }
        }
    }

    // works only if max(arr[]) < size(arr[])
    private static void findRepeatingSameSpace(int[] arr) {
        // First check all the values that are present in an array then go to that values as indexes and increment by
        // the size of array
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int index = arr[i] % n;
            arr[index] += n;
        }

        // Now check which value exists more than once by dividing with the size of array
        for (int i = 0; i < n; i++) {
            if ((arr[i] / n) > 1) {
                System.out.print(i + " ");
            }
        }
    }

    // applies to max(arr) > size(arr) and O(N) - O(1) space complexity
    private static void findRepeatingMaxElementSameSpace(int[] arr) {
        // we have to sort the array in order to find the max element
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int i = 0, j = 1;
        while (i < arr.length) {
            if (j != arr.length) {
                if (arr[i] == arr[j]) {
                    // we are removing duplicate elements from an array
                    arr[i] = -2429;
                }
                j++;
            }
            i++;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 1, 3, 6, 5};
        //findRepeating(arr);
        int[] arr1 = {1, 6, 3, 1, 3, 6, 6, 24, 25, 24};
        //findRepeatingSameSpace(arr1);
        int[] arr2 = {4, 2, 4, 5, 2, 3, 1, 27, 29, 27};
        //findNonRepeatingElement(arr2);
        int[] arr3 = {4, 2, 4, 5, 2, 3, 1, 27, 29, 27};
        findRepeatingMaxElementSameSpace(arr3);

//    int[] bx = {1, 2, 3, 4, 5, 6, 6, 7};
//    int index = findRepeating(bx, 0, bx.length - 1);
//    if (index != -1) {
//      System.out.println(bx[index]);
//    }
    }
}
