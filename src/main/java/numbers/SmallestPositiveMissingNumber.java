package numbers;

public class SmallestPositiveMissingNumber {

    private static int findSmallestPositiveMissingNumberPositiveArray(int[] arr) {
        return -1;
    }

    /* Utility function that puts all non-positive
       (0 and negative) numbers on left side of arr[]*/
    private static int[] segregate(int[] arr) {
        int j = 0; // for negative nos
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (arr[i] < 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return arr;
    }

    /**
     * Input:  {2, 3, 7, 6, 8, -1, -10, 15}
     * Output: 1
     * <p>
     * Input:  { 2, 3, -7, 6, 8, 1, -10, 15 }
     * Output: 4
     * <p>
     * Input: {1, 1, 0, -1, -2}
     * Output: 2
     * This problem is similar to {@link hard.FirstMissingPositive}
     */
    private static int findSmallestPositiveMissingNumberUnsortedArray(int[] arr) {
        int possibleMaxNum = arr.length;
        for (int i = 0; i < possibleMaxNum; i++) {
            // if value is negative or greater than array size, then it cannot
            // be marked in array. So move to next element.
            int index = arr[i];
            if (index <= 0 || index > possibleMaxNum) {
                continue;
            }
            // traverse the array until we reach at an element which is already marked or which could not be marked.
            while (arr[index - 1] != index) {
                // inplace sorting using index based technique that can be done in O(n) time
                int temp = arr[index - 1];
                arr[index - 1] = index;
                index = temp;
                if (index <= 0 || index > possibleMaxNum) {
                    break;
                }
            }
        }

        // find first array index which is not marked which is also the smallest positive missing number.
        for (int i = 0; i < possibleMaxNum; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        // if all indices are marked, then smallest missing positive number is array_size + 1.
        return possibleMaxNum + 1;
    }

    /**
     * Utility function that puts all non-positive(0 and negative) numbers on left side of
     * arr[] and return count of such numbers
     */
    private static int segregate(int[] arr, int size) {
        int i, j = 0;
        for (i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                // increment count of non-positive integers
                j++;
            }
        }

        return j;
    }

    /**
     * Find the smallest positive missing number in an array that containn all positive integers
     */
    private static int findMissingPositive(int[] arr, int size) {
        int i;

        // Mark arr[i] as visited by making
        // arr[arr[i] - 1] negative. Note that
        // 1 is subtracted because index start
        // from 0 and positive numbers start from 1
        for (i = 0; i < size; i++) {
            int x = Math.abs(arr[i]);
            if (x - 1 < size && arr[x - 1] > 0) {
                arr[x - 1] = -arr[x - 1];
            }
        }

        // Return the first index value at which is positive
        for (i = 0; i < size; i++) {
            if (arr[i] > 0) {
                return i + 1;  // 1 is added because indexes
            }
        }
        // start from 0

        return size + 1;
    }

    /**
     * Find the smallest positive missing number in an array that contains both positive and negative integers
     */
    private static int findMissing(int[] arr, int size) {
        // First separate positive and negative numbers
        int shift = segregate(arr, size);
        int[] arr2 = new int[size - shift];
        int j = 0;
        for (int i = shift; i < size; i++) {
            arr2[j] = arr[i];
            j++;
        }
        // Shift the array and call
        // findMissingPositive for
        // positive part
        return findMissingPositive(arr2, j);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 6, 8, -1, -10, 15, 1};
        System.out.println(findSmallestPositiveMissingNumberUnsortedArray(arr));
    }
}
