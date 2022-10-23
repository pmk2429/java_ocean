package arrays;

/**
 * Count frequencies of all elements in array in O(1) extra space and O(n) time
 * <p>
 * Given an unsorted array of n integers which can contain integers from 1 to n.
 * Some elements can be repeated multiple times and some other elements can be absent from the array.
 * Count frequency of all elements that are present and print the missing elements.
 */
public class FrequencyOfElements {

    /*
    The idea is to traverse the given array, use elements as index and store their counts at the index.
    For example, when we see element 7, we go to index 6 and store the count.
    There are few problems to handle, one is the counts can get mixed with the elements,
    this is handled by storing the counts as negative. Other problem is loosing the element which is replaced by count,
    this is handled by first storing the element to be replaced at current index.
     */
    private static void frequency(int[] arr) {
        int length = arr.length;
        int i = 0;

        while (i < length) {
            if (arr[i] <= 0) {
                i++;
                continue;
            }

            // Find index corresponding to this element
            // For example, index for 5 is 4, 3 is 2 and so on...
            int elementIndex = arr[i] - 1;

            // If the elementIndex has an element that is not
            // processed yet, then first store that element
            // to arr[i] so that we don't lose anything.
            if (arr[elementIndex] > 0) {
                arr[i] = arr[elementIndex];

                // After storing arr[elementIndex], change it
                // to store initial count of 'arr[i]'
                arr[elementIndex] = -1;
            }
            else {
                // If this is NOT first occurrence of arr[i],
                // then increment its count.
                arr[elementIndex]--;

                // And initialize arr[i] as 0 means the element
                // 'i+1' is not seen so far
                arr[i] = 0;
                i++;
            }
        }
        System.out.println("Below are counts of all elements");
        for (int j = 0; j < length; j++)
            System.out.println(j + 1 + "->" + Math.abs(arr[j]));
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 3, 2, 4, 5, 2};
        frequency(arr);
    }
}
