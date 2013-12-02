/**
 * 
 */
package com.nikhilsaraf.passwordvalidationservice;

import java.util.regex.Pattern;

/**
 * Tests that we only have lowercase or numerical characters (and no other characters)
 * 
 * @author nikhilsaraf
 *
 */
public class OnlyLowercaseOrNumericalCharactersRule extends PatternMatchingRule {	
	private static final Pattern pattern = Pattern.compile("[0-9a-z]+");
	protected static final String errorMessage = "Password must contain lowercase or numerical characters only";
	
	@Override
	protected Pattern getPattern() {
		return pattern;
	}
	
	@Override
	protected String getErrorMessage() {
		return errorMessage;
	}
}
