package numbers;

public class FindMissingNumber {

	/**
	 * findMissingNumber(int [], int, int) method is used to find the
	 * missing number from an array of integers.
	 * It does the finding by adding all the numbers in a specific range
	 * and then it will add all the numbers in the actual array. 
	 * Finally the difference between the actual sum i.e. the total of
	 * all the numbers in the actual array(start to end) and the total
	 * of all the numbers in the array yields the missing number.
	 * 
	 * @param missingArray
	 * @param start
	 * @param end
	 * @return
	 */
	private int findMissingNumber(int[] missingArray, int start, int end) {
		int actualSum = 0, arrayTotal = 0;
		for (int i = start; i <= end; i++) {
			actualSum = actualSum + i;
		}
		for (int i = 0; i < missingArray.length; i++) {
			arrayTotal = arrayTotal + missingArray[i];
		}

		int missingNumber = actualSum - arrayTotal;
		return missingNumber;
	}

	public static void main(String[] args) {
		int[] missingArray = { 1, 2, 3, 4, 6, 7, 8, 9, 10 };
		FindMissingNumber fnm = new FindMissingNumber();
		int startNum = 1;
		int endNum = 10;
		int missingNum = fnm.findMissingNumber(missingArray, startNum, endNum);
		System.out.println("Missing number from an array of " + startNum
				+ " to " + endNum + " is: " + missingNum);
	}

}
