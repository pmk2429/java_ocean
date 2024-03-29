package sorting.sortingAlgorithms;

/**
 * QuickSortDemo provides an implementation of QuickSort algorithm This
 * algorithm performs sorting operations in O(N Log N) time complexity making it
 * the faster than Merge sort implementation. In addition, QuickSort is used as
 * "in-place" sorting algorithm where elements in an array are sorted without
 * creating a duplicate array.
 *
 * @author Pavitra
 */
public class QuickSortDemo {
    private final int[] sortArray;

    public void quickSort(int start, int end) {
        int i = start;
        int j = end;
        // determine the PIVOT
        int pivot = sortArray[start + (end - start) / 2];
        while (i <= j) {
            while (sortArray[i] < pivot) {
                i++;
            }
            while (sortArray[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeItems(i, j);
                i++;
                j--;
            }
        }
        if (start < j) {
            quickSort(start, j);
        }
        if (i < end) {
            quickSort(i, end);
        }
    }

    public void exchangeItems(int i, int j) {
        int temp = sortArray[i];
        sortArray[i] = sortArray[j];
        sortArray[j] = temp;
    }

    public QuickSortDemo(int[] sortArray) {
        if (sortArray == null || sortArray.length == 0) {
            System.out.println("Undefined Array!!!");
        }
        this.sortArray = sortArray;
        int length = sortArray.length;
        quickSort(0, length - 1);
    }

    public static void main(String[] args) {
        int[] arraySort = {24, 2, 45, 20, 56, 75, 4, 56, 99, 33, 12};
        QuickSortDemo quickSort = new QuickSortDemo(arraySort);
        for (int i : arraySort) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
