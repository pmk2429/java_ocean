package numbers;

import java.util.Arrays;

/**
 * ~!@#HARD:REVISE
 */
public class RemoveDuplicatesSortedArray {
    private static int removeDuplicatesO1(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++; // the order of incrementing `i` here matters
                arr[i] = arr[j];
            }
        }
        //Arrays.copyOfRange(arr, j, i);
        return i + 1;
    }

    private static int[] removeDuplicatesO1Arr(int[] arr) {
        int i = 0;
        int length = arr.length;
        for (int j = 1; j < length; j++) {
            if (arr[i] != arr[j]) {
                i++; // the order of incrementing `i` here matters
                arr[i] = arr[j];
            }
        }
        return Arrays.copyOf(arr, i + 1);
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 5};
        System.out.println(removeDuplicatesO1(arr));
        int[] arr1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 5};
        System.out.println(Arrays.toString(removeDuplicatesO1Arr(arr1)));
    }
}
