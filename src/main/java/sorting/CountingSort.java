package sorting;

import java.util.Arrays;

public class CountingSort {

    public static void countingSort(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();

        int[] count = new int[max + 1];
        for (int i : array) {
            count[i]++;
        }

        int index = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < count[i]; j++) {
                array[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 1, 0, 9, 6, 16};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
