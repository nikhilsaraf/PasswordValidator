package com.nikhilsaraf.passwordvalidationservice;

import junit.framework.Assert;

/**
 * Common test stuff for Testing of ValidationRules
 * 
 * @author nikhilsaraf
 */
public abstract class BaseRuleTest {
	/**
	 * Helper method that creates the test object, performs validation and verifies output is as expected 
	 * 
	 * @param inputPassword
	 * @param expectedErrorMessage
	 * 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	protected void commonTestHelper(final String inputPassword, final String expectedErrorMessage) throws InstantiationException, IllegalAccessException {
		final Class<? extends ValidationRule> ruleClass = ruleBeingTested();
		final ValidationRule rule = ruleClass.newInstance();
		final String resultingError = rule.performValidation(inputPassword);
		Assert.assertEquals("The error message did not match as expected", expectedErrorMessage, resultingError);
	}
	
	/**
	 * Returns the rule being tested
	 * 
	 * @return
	 */
	protected abstract Class<? extends ValidationRule> ruleBeingTested();
}
