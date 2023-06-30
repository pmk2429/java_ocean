package numbers;

public class RemoveDuplicatesSortedArray {
    private static int removeDuplicatesO1(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++; // the order of incrementing `i` here matters
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 5};
        System.out.println(removeDuplicatesO1(arr));
    }
}
