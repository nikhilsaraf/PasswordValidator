/**
 * 
 */
package com.nikhilsaraf.passwordvalidationservice;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Tests the LengthRule password validation rule
 * 
 * 4 total test cases, whether password length is caught if too short, or if too long. Also tests that
 * the shortest allowable password works and the longest alloweable password works
 * 
 * @author nikhilsaraf
 */
public class LengthRuleTest {
	
	/**
	 * Helper method that creates the test object, performs validation and verifies output is as expected 
	 * 
	 * @param inputPassword
	 * @param expectedErrorMessage
	 */
	private void commonTestHelper(final String inputPassword, final String expectedErrorMessage) {
		final ValidationRule rule = new LengthRule();
		final String resultingError = rule.performValidation(inputPassword);
		Assert.assertEquals("The error message did not match as expected", expectedErrorMessage, resultingError);
	}
	
	@Test
	public void testTooShortPasswordRejected() {
		commonTestHelper("1234", LengthRule.tooShortErrorMessage);
	}
	
	@Test
	public void testTooLongPasswordRejected() {
		commonTestHelper("1234567890123", LengthRule.tooLongErrorMessage);
	}
	
	@Test
	public void testShortestLengthPasswordAccepted() {
		commonTestHelper("12345", null);
	}
	
	@Test
	public void testLongestLengthPasswordAccepted() {
		commonTestHelper("123456789012", null);
	}
}
