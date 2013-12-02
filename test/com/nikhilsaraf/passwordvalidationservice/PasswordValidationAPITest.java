package com.nikhilsaraf.passwordvalidationservice;

import java.util.HashSet;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Basic tests around the API
 * 
 * @author nikhilsaraf
 */
public class PasswordValidationAPITest {
	@Test
	public void testDefaultValidationSetWithValidPassword() {
		PasswordValidationAPI api = new PasswordValidationAPI();
		final String passwordBeingValidated = "1tworks";
		PasswordValidationResult result = api.validatePassword(passwordBeingValidated);
		Assert.assertTrue("The input was a valid password and should be considered valid by the validator", result.isValid());
		Assert.assertEquals("The password was not saved correctly in the result", result.getPasswordAttempted(), passwordBeingValidated);
	}
	
	@SuppressWarnings("serial")
	@Test
	public void testDefaultValidationSetWithInvalidPassword() {
		PasswordValidationAPI api = new PasswordValidationAPI();
		final String passwordBeingValidated = "ItWontWorkWithThis";
		PasswordValidationResult result = api.validatePassword(passwordBeingValidated);
		Assert.assertFalse("The input was NOT a valid password and should NOT be considered valid by the validator", result.isValid());
		Assert.assertEquals("The password was not saved correctly in the result", result.getPasswordAttempted(), passwordBeingValidated);
		
		final HashSet<String> expectedErrorMessages = new HashSet<String>() {{
			add(AtLeastOneNumberRule.errorMessage);
			add(OnlyLowercaseOrNumericalCharactersRule.errorMessage);
			add(LengthRule.tooLongErrorMessage);
		}};
		
		Assert.assertTrue("The error message(s) did not match as expected. Expected: " + expectedErrorMessages + " | Actual: " + result.getValidationErrors(), expectedErrorMessages.equals(new HashSet<String>(result.getValidationErrors())));
	}
	
	/**
	 * This will be considered valid, because we are specifying the rule to check against, which allows it.
	 * @see {@link #testDefaultValidationSetWithInvalidPassword()} for similar input 
	 */
	@Test
	public void testRepeatingValidationSetWithValidPasswordForCustomAPICall() {
		PasswordValidationAPI api = new PasswordValidationAPI();
		// this will actually work here
		final String passwordBeingValidated = "ItWontWorkWithThis";
		PasswordValidationResult result = api.validatePasswordUsingNamedPasswordValidatorBean(passwordBeingValidated, "NoRepeatingSequenceRule");
		Assert.assertTrue("The input was a valid password for the provied rule and should be considered valid by the validator", result.isValid());
		Assert.assertEquals("The password was not saved correctly in the result", result.getPasswordAttempted(), passwordBeingValidated);
	}
	
	/*
	 * Ideally, with enough time, this would be even more thoroughly tested along with all the other components of this framework/API.
	 */
}
