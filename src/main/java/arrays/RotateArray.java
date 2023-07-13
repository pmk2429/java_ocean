package arrays;

import java.util.Arrays;

/**
 * WAP to rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 * For Eg
 * arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2
 * rotatedArr = [3, 4, 5, 6, 7, 1, 2]
 * <p>
 * Method 2: A Juggling Algorithm
 * ------------------------------
 * This is an extension of method 2. Instead of moving one by one, divide the array in different sets
 * where number of sets is equal to GCD of n and d and move the elements within sets.
 * If GCD is 1 as is for the above example array (n = 7 and d =2), then elements will be moved within one set only,
 * we just start with temp = arr[0] and keep moving arr[I+d] to arr[I] and finally store temp at the right place.
 */
public class RotateArray {

    private static void rightRotate(int[] arr, int distance) {

    }

    private static void leftRotate(int[] arr, int distance) {

    }

    private static void reverse(int[] arr, int left, int right) {
        if (arr == null || arr.length <= 0) {
            return;
        }

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private static int[] rotate(int[] arr, int degree) {
        if (arr == null || arr.length <= 0 || degree <= 0) {
            throw new IllegalArgumentException("Array Invalid");
        }

        if (degree > arr.length) {
            degree = degree % arr.length;
        }

        int partition = arr.length - degree - 1;

        reverse(arr, 0, partition - 1);
        reverse(arr, partition, arr.length - 1);
        reverse(arr, 0, arr.length - 1);

        return arr;
    }

    private static void rotateArray(int[] arr, int distance) {
        // distance iteration
        for (int i = 0; i < distance; i++) {
            // arr iteration
            int temp = arr[0];
            int length = arr.length;
            for (int d = 0; d < length - 1; d++) {
                arr[d] = arr[d + 1];
            }
            arr[length - 1] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        rotateArray(arr, 2);
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(rotate(arr1, 2)));
    }
}
