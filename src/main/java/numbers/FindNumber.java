package numbers;

import java.util.Hashtable;

/**
 * FindNumber Class is used to find the missing number from one array by looking
 * at the another array.
 */
public class FindNumber {
    /**
     * findNumberInArray(int[], int[]) method adds the contents of the second
     * array into a Hashtable. For every entry in the first array, it will look
     * for the missing entry in the Hashtable. It will store the missing number
     * in the int identifier and will return the int value.
     */
    private int findNumberInArray(int[] array1, int[] array2) {
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        int missingNumber = 0;
        for (int i = 0; i < array2.length; i++) {
            ht.put(array2[i], i);
        }
        for (int j : array1) {
            if (!ht.containsKey(j)) {
                missingNumber = j;
            }
        }
        return missingNumber;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {2, 3, 1, 0, 5};

        FindNumber fn = new FindNumber();
        int num = fn.findNumberInArray(array1, array2);
        System.out.println("Number not in 2nd array: " + num);
    }
}
