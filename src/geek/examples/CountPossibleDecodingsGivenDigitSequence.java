package geek.examples;

public class CountPossibleDecodingsGivenDigitSequence {
	// Given a digit sequence of length n, returns count of possible
	// decodings by replacing 1 with A, 2 woth B, ... 26 with Z
	static int countDecoding(char[] digits, int n) {
		// base cases
		if (n == 0 || n == 1)
			return 1;

		int count = 0; // Initialize count

		// If the last digit is not 0, then last digit must add to
		// the number of words
		if (digits[n - 1] > '0')
			count = countDecoding(digits, n - 1);

		// If the last two digits form a number smaller than or equal to 26,
		// then consider last two digits and recur
		if (digits[n - 2] < '2'
				|| (digits[n - 2] == '2' && digits[n - 1] < '7'))
			count += countDecoding(digits, n - 2);

		return count;
	}

	// Driver program to test above function
	public static void main(String args[]) {
		char digits[] = "1234".toCharArray();
		int n = digits.length;
		System.out.println("Count is " + countDecoding(digits, n));
		System.out.println("Count is " + countDecodingDP(digits, n));

	}

	static int countDecodingDP(char[] digits, int n) {
		int count[] = new int[n + 1]; // A table to store results of subproblems
		count[0] = 1;
		count[1] = 1;

		for (int i = 2; i <= n; i++) {
			count[i] = 0;

			// If the last digit is not 0, then last digit must add to
			// the number of words
			if (digits[i - 1] > '0')
				count[i] = count[i - 1];

			// If second last digit is smaller than 2 and last digit is
			// smaller than 7, then last two digits form a valid character
			if (digits[i - 2] < '2'
					|| (digits[i - 2] == '2' && digits[i - 1] < '7'))
				count[i] += count[i - 2];
		}
		return count[n];
	}

}
