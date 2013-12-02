/**
 * 
 */
package com.nikhilsaraf.passwordvalidationservice;

/**
 * Rule Implementation to validate password length
 * 
 * @author nikhilsaraf
 */
public class LengthRule extends ValidationRule {
	private static final int shortestLength = 5;
	private static final int longestLength = 12;
	private static final String commonErrorMessage = "must be between 5 and 12 characters in length";
	protected static final String tooShortErrorMessage = "Length of password too short, " + commonErrorMessage;
	protected static final String tooLongErrorMessage = "Length of password too long, " + commonErrorMessage;
	
	public LengthRule() {
		super();
	}
	
	/**
	 * Validates password length. For a given password, it has an idempotent repeatable output.
	 * That is, it can either be too short, too long, or valid.
	 */
	@Override
	protected String performValidation(String password) {
		int length = password.length();
		
		if (length < shortestLength) {
			return tooShortErrorMessage;
		} else if (length > longestLength) {
			return tooLongErrorMessage;
		} else {
			return null;
		}
	}
}
