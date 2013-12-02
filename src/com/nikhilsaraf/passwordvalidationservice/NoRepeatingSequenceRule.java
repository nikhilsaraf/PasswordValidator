/**
 * 
 */
package com.nikhilsaraf.passwordvalidationservice;

/**
 * Rule validates that we have no repeating sequence in the password
 * 
 * @author nikhilsaraf
 *
 */
public class NoRepeatingSequenceRule extends ValidationRule {
	private static final String errorMessage = "Password should not have repeated sub-sequences";
	
	@Override
	protected String performValidation(String password) {
		// O(N^2) algorithm
		for (int i = 0; i < password.length(); i++) {
			for (int j = i-1; j >= 0; j-=2) {
				int midIndex = (i+j)/2 + 1;
				final String firstSubsequence = password.substring(j, midIndex);
				final String secondSubsequence = password.substring(midIndex, i + 1);
				
				// compare subsequences for equality
				if (firstSubsequence.equals(secondSubsequence)) {
					return NoRepeatingSequenceRule.constructErrorMessage(midIndex, i);
				}
			}
		}
		
		// if control reaches here then we are good.
		return null;
	}

	/**
	 * Helps to construct the error message, taken out so we can test using this method to verify error message
	 * 
	 * ABCABC should return [3,5] 
	 * 
	 * @param startIndexOfRepeatedSubsequence
	 * @param endIndexOfRepeatedSubsequence
	 * @return computed error message string
	 */
	protected static String constructErrorMessage(int startIndexOfRepeatedSubsequence, int endIndexOfRepeatedSubsequence) {
		return errorMessage + ". Repeated Subsequence (inclusive): [" + startIndexOfRepeatedSubsequence + ", " + endIndexOfRepeatedSubsequence + "]";
	}
}