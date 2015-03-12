package timeComplexity;

//Big O notation is a way to measure how well a
//computer algorithm scales as the amount of data
//involved increases. It is not always a measure
//of speed as you'll see below

//This is a rough overview of Big O and doesn't 
//cover topics such as asymptotic analysis, which
//covers comparing algorithms as data approaches
//infinity

//What we are defining is the part of the algorithm 
//that has the greatest effect. For example
//45n^3 + 20n^2 + 19 = 84 (n=1)
//45n^3 + 20n^2 + 19 = 459 (n=2) Does 19 matter?
//45n^3 + 20n^2 + 19 = 47019 (n=10) 
//Does the 20n^2 matter if 45n^3 = 45,000?
//Has an O(n^3) Order of n-cubed

public class BigOhNotation {

	private int[] theArray;

	private int arraySize;

	private int itemsInArray = 0;

	static long startTime;

	static long endTime;

	public static void main(String[] args) {

		/*
		 * 0(1) Test BigOhNotation testAlgo = new BigOhNotation(10);
		 * 
		 * testAlgo.addItemToArray(10);
		 * 
		 * System.out.println(Arrays.toString(testAlgo.theArray));
		 */

		BigOhNotation testAlgo2 = new BigOhNotation(100000);
		testAlgo2.generateRandomArray();

		BigOhNotation testAlgo3 = new BigOhNotation(200000);
		testAlgo3.generateRandomArray();

		BigOhNotation testAlgo4 = new BigOhNotation(30000);
		testAlgo4.generateRandomArray();

		BigOhNotation testAlgo5 = new BigOhNotation(400000);
		testAlgo5.generateRandomArray();

		/*
		 * O(N) Test
		 * 
		 * testAlgo2.linearSearchForValue(20);
		 * 
		 * testAlgo3.linearSearchForValue(20);
		 * 
		 * testAlgo4.linearSearchForValue(20);
		 * 
		 * testAlgo5.linearSearchForValue(20);
		 */

		// O(N^2) Test
		/*
		 * testAlgo2.bubbleSort();
		 * 
		 * testAlgo3.bubbleSort();
		 * 
		 * testAlgo4.bubbleSort();
		 * 
		 * // 0 (log N) Test
		 * 
		 * testAlgo2.binarySearchForValue(20);
		 * testAlgo3.binarySearchForValue(20);
		 */

		// O (n log n) Test

		startTime = System.currentTimeMillis();

		testAlgo2.quickSort(0, testAlgo2.itemsInArray);

		endTime = System.currentTimeMillis();

		System.out.println("Quick Sort Took " + (endTime - startTime));

	}

	// O(1) An algorithm that executes in the same
	// time regardless of the amount of data
	// This code executes in the same amount of
	// time no matter how big the array is

	public void addItemToArray(int newItem) {

		theArray[itemsInArray++] = newItem;

	}

	// 0(N) An algorithm thats time to complete will
	// grow in direct proportion to the amount of data
	// The linear search is an example of this

	// To find all values that match what we
	// are searching for we will have to look in
	// exactly each item in the array

	// If we just wanted to find one match the Big O
	// is the same because it describes the worst
	// case scenario in which the whole array must
	// be searched

	public void linearSearchForValue(int value) {

		boolean valueInArray = false;
		String indexsWithValue = "";

		startTime = System.currentTimeMillis();

		for (int i = 0; i < arraySize; i++) {

			if (theArray[i] == value) {
				valueInArray = true;
				indexsWithValue += i + " ";
			}

		}

		System.out.println("Value Found: " + valueInArray);

		endTime = System.currentTimeMillis();

		System.out.println("Linear Search Took " + (endTime - startTime));

	}

	// O(N^2) Time to complete will be proportional to
	// the square of the amount of data (Bubble Sort)
	// Algorithms with more nested iterations will result
	// in O(N^3), O(N^4), etc. performance

	// Each pass through the outer loop (0)N requires us
	// to go through the entire list again so N multiplies
	// against itself or it is squared

	public void bubbleSort() {

		startTime = System.currentTimeMillis();

		for (int i = arraySize - 1; i > 1; i--) {

			for (int j = 0; j < i; j++) {

				if (theArray[j] > theArray[j + 1]) {

					swapValues(j, j + 1);

				}
			}
		}

		endTime = System.currentTimeMillis();

		System.out.println("Bubble Sort Took " + (endTime - startTime));
	}

	// O (log N) Occurs when the data being used is decreased
	// by roughly 50% each time through the algorithm. The
	// Binary search is a perfect example of this.

	// Pretty fast because the log N increases at a dramatically
	// slower rate as N increases

	// O (log N) algorithms are very efficient because increasing
	// the amount of data has little effect at some point early
	// on because the amount of data is halved on each run through

	public void binarySearchForValue(int value) {

		startTime = System.currentTimeMillis();

		int lowIndex = 0;
		int highIndex = arraySize - 1;

		int timesThrough = 0;

		while (lowIndex <= highIndex) {

			int middleIndex = (highIndex + lowIndex) / 2;

			if (theArray[middleIndex] < value)
				lowIndex = middleIndex + 1;

			else if (theArray[middleIndex] > value)
				highIndex = middleIndex - 1;

			else {

				System.out.println("\nFound a Match for " + value
						+ " at Index " + middleIndex);

				lowIndex = highIndex + 1;

			}

			timesThrough++;

		}

		// This doesn't really show anything because
		// the algorithm is so fast

		endTime = System.currentTimeMillis();

		System.out.println("Binary Search Took " + (endTime - startTime));

		System.out.println("Times Through: " + timesThrough);

	}

	// O (n log n) Most sorts are at least O(N) because
	// every element must be looked at, at least once.
	// The bubble sort is O(N^2)
	// To figure out the number of comparisons we need
	// to make with the Quick Sort we first know that
	// it is comparing and moving values very
	// efficiently without shifting. That means values
	// are compared only once. So each comparison will
	// reduce the possible final sorted lists in half.
	// Comparisons = log n! (Factorial of n)
	// Comparisons = log n + log(n-1) + .... + log(1)
	// This evaluates to n log n

	public void quickSort(int left, int right) {

		if (right - left <= 0)
			return;

		else {

			int pivot = theArray[right];

			int pivotLocation = partitionArray(left, right, pivot);

			quickSort(left, pivotLocation - 1);
			quickSort(pivotLocation + 1, right);

		}

	}

	public int partitionArray(int left, int right, int pivot) {

		int leftPointer = left - 1;
		int rightPointer = right;

		while (true) {

			while (theArray[++leftPointer] < pivot)
				;

			while (rightPointer > 0 && theArray[--rightPointer] > pivot)
				;

			if (leftPointer >= rightPointer) {

				break;

			} else {

				swapValues(leftPointer, rightPointer);

			}

		}

		swapValues(leftPointer, right);

		return leftPointer;

	}

	BigOhNotation(int size) {

		arraySize = size;

		theArray = new int[size];

	}

	public void generateRandomArray() {

		for (int i = 0; i < arraySize; i++) {

			theArray[i] = (int) (Math.random() * 1000) + 10;

		}

		itemsInArray = arraySize - 1;

	}

	public void swapValues(int indexOne, int indexTwo) {

		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;

	}

}