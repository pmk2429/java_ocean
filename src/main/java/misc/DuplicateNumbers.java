package misc;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class DuplicateNumbers {

	/**
	 * <h1>findDuplicateNumber(int[] numbers)</h1> A method that counts the
	 * Duplicate elements from an array by just scanning the entire array from
	 * start to end.
	 * 
	 * <p>
	 * First, the method Sorts the array elements in Ascending order which makes
	 * all the repeated elements placed adjacent to each other. After the
	 * sorting is done, the method will loop through the end of array and will
	 * check if two juxtaposed element are same or not! If the match is found
	 * then the duplicate element will be stored in a variable and will be
	 * returned.
	 * </p>
	 * 
	 * @param numbers
	 * @return
	 */
	public int findDuplicateNumber(int[] numbers) {
		int[] duplicateArray = numbers;
		int duplicateNumber = 0;
		Arrays.sort(duplicateArray);
		if (duplicateArray.length > 0) {
			for (int i = 0; i < duplicateArray.length; i++) {
				if (duplicateArray[i] == duplicateArray[i + 1]) {
					duplicateNumber = duplicateArray[i];
					break;
				} else {
					System.out.println("No duplicate found");
				}
			}
		}
		return duplicateNumber;
	}

	/**
	 * findAnotherDuplicateNumber(int[] numbers) method checks for the duplicate
	 * numbers by using a HashSet. It will create a Set of Integer type and will
	 * assign a HashSet to it. As we know, HashSet does not allow duplicate
	 * entries neither null values, it will simply remove the duplicate entries
	 * from the set. So while adding the array elements on to a Set, we will
	 * check whether the Set contains that value or not. If it does, then we
	 * will simply add that value to a variable and will return the variable.
	 * 
	 * @param numbers
	 * @return
	 */
	public List<Integer> findDuplicateNumberUsingSet(int[] numbers) {
		ArrayList<Integer> duplicateNos = new ArrayList<Integer>();
		Set<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (s.contains(numbers[i])) {
				if (!duplicateNos.contains(numbers[i]))
					duplicateNos.add(numbers[i]);
			} else {
				s.add(numbers[i]);
			}
		}
		return duplicateNos;
	}

	public static void main(String a[]) {

		int[] duplicateArray2 = { 2, 6, 7, 19, 55, 7, 2, 55, 8, 10, 2, 6, 7, 19, 55, 14, 3, 2, 8, 9, 47, 54, 65, 87,
				48, 16, 5, 4, 1, 161, 15, 1, 51, 5121, 1584, 84, 15, 1, 15, 1, 61, 61, 616, 1, };

		int[] duplicateArray = { 3, 5, 2, 6, 8, 9, 7, 6 };
		DuplicateNumbers dns = new DuplicateNumbers();

		List<Integer> duplicate1 = dns.findDuplicateNumberUsingSet(duplicateArray);
		System.out.println("\nDuplicate number using HashSet: " + duplicate1);

		/*	
		 * final long duration = System.nanoTime() - startTime;
		 * 
		 * long msDuration = TimeUnit.MILLISECONDS.convert(duration,
		 * TimeUnit.NANOSECONDS); long secDuration =
		 * TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS); // Print
		 * out the running time of program.
		 * System.out.println("\n-----------------------------------\n");
		 * System.out.println("Running time: " + msDuration + " milliseconds");
		 * System.out.println("Running time: " + secDuration + " seconds");
		 */
	}
}
