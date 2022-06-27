package arrays;

public class FindPeakElement {
    private static int peakElement(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            else if (arr[mid - 1] < arr[mid]) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 4, 3, 0};
        System.out.println("Index - " + peakElement(a));
        System.out.println(a[peakElement(a)]);
    }
}
