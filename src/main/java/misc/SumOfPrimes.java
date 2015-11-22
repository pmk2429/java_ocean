package misc;

/**
 * SumOfPrimes is used to find sum of all prime numbers given the range between
 * which sum of prime needs to be found.
 * 
 * @author Pavitra
 * 
 */

public class SumOfPrimes {
	public static void main(String[] args) {
		int range = 10;
		int start = 0;
		SumOfPrimes primeObj = new SumOfPrimes();
		int total = primeObj.sumOfPrimes(start, range);
		System.out.println("\nSum of all primes: " + total);
	}

	private int sumOfPrimes(int start, int range) {
		int sum = 0;
		int number = 0;
		boolean isPrime = false;
		for (int i = start; i <= range; i++) {
			number = i;
			for (int j = 2; j < number; j++) {
				if (number % j == 0) {
					isPrime = false;
					break;
				} else {
					isPrime = true;
				}
			}
			if (isPrime == true) {
				sum += number;
			}
		}
		sum = sum + 3;
		return sum;
	}
}
