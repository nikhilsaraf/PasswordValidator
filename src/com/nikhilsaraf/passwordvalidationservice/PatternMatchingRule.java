/**
 * 
 */
package com.nikhilsaraf.passwordvalidationservice;

import java.util.regex.Pattern;

/**
 * Common class to validate rules provided a given pattern.
 * 
 * The subclass is responsible for providing the pattern to be matched and the error message 
 * 
 * @author nikhilsaraf
 */
public abstract class PatternMatchingRule extends ValidationRule {
	@Override
	protected String performValidation(String password) {
		final Pattern pattern = getPattern();
		final boolean patternMatched = pattern.matcher(password).find();
		
		if (patternMatched) {
			return null;
		} else {
			return getErrorMessage();
		}
	}
	
	/**
	 * Gets the pattern to be matched
	 * 
	 * @return
	 */
	protected abstract Pattern getPattern();
	
	/**
	 * Gets the error message to be returned in the case of an error
	 * 
	 * @return
	 */
	protected abstract String getErrorMessage();
}
