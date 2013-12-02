/**
 * 
 */
package com.nikhilsaraf.passwordvalidationservice;

import java.util.regex.Pattern;

/**
 * Validates that we have at least one lowercase character in the password
 * 
 * @author nikhilsaraf
 */
public class AtLeastOneLowercaseRule extends PatternMatchingRule {	
	private static final Pattern pattern = Pattern.compile(".*[a-z].*");
	protected static final String errorMessage = "Password must contain at least one lowercase character";

	@Override
	protected Pattern getPattern() {
		return pattern;
	}
	
	@Override
	protected String getErrorMessage() {
		return errorMessage;
	}
}
