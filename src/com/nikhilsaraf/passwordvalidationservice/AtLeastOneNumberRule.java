/**
 * 
 */
package com.nikhilsaraf.passwordvalidationservice;

import java.util.regex.Pattern;

/**
 * Validates that we have at least one numerical character in the password
 * 
 * @author nikhilsaraf
 */
public class AtLeastOneNumberRule extends PatternMatchingRule {	
	private static final Pattern pattern = Pattern.compile(".*[0-9].*");
	protected static final String errorMessage = "Password must contain at least one numerical character";
	
	@Override
	protected Pattern getPattern() {
		return pattern;
	}
	
	@Override
	protected String getErrorMessage() {
		return errorMessage;
	}
}
