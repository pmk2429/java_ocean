package misc;

import java.util.Hashtable;

/**
 * 
 * FindNumber Class is used to find the missing number from one array by looking
 * at the another array.
 * 
 * @author Pavitra
 * 
 */
public class FindNumber {
	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, 4, 5 };
		int[] array2 = { 2, 3, 1, 0, 5 };

		FindNumber fn = new FindNumber();
		int num = fn.findNumberInArray(array1, array2);
		System.out.println("Number not in 2nd array: " + num);
	}

	/**
	 * findNumberInArray(int[], int[]) method adds the contents of the second
	 * array into a Hashtable. For every entry in the first array, it will look
	 * for the missing entry in the Hashtable. It will store the missing number
	 * in the int identifier and will return the int value.
	 * 
	 * @param array1
	 * @param array2
	 * @return int
	 */
	private int findNumberInArray(int[] array1, int[] array2) {
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		int missingNumber = 0;
		for (int i = 0; i < array2.length; i++) {
			ht.put(array2[i], i);
		}
		for (int i = 0; i < array1.length; i++) {
			if (!ht.containsKey(array1[i])) {
				missingNumber = array1[i];
			}
		}
		if (missingNumber == 0) {
			missingNumber = 0;
		}
		return missingNumber;
	}
}
