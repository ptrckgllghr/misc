public class PrimesImprovement {
	public static void main(String[] args) {

		// This code should print out the prime numbers.
		// task: Fix and improve the algorithm

		System.out.println("Printing primes from 1 to 100");
		int i;
		for (i = 1; i <= 100; i++) {
			if (isPrime(i))
				System.out.print(i + " ");
		}
	}

	/**
	 * Takes in an int input and tests if it is prime, returns true on prime
	 * number
	 * 
	 * This algorithm works well until
	 * 
	 * @param n
	 */
	public static boolean isPrime(int n) {

		// This algorithm works well for numbers below 5500, but higher than
		// that it begins to get very sluggish, but for the purposes of 1 - 100
		// it works well

		// rule out 1 as a prime number
		if (n < 2)
			return false;
		// tests if a number is even, then tests with tests of increments of 1
		// until i^2 = n
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false; // number is divisible by 2 or 3 or 4 or ..., so
								// its not prime
			}
		}
		return true; // number passes the tests and is prime
	}

}
