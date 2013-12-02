/**
 * 
 */
package com.nikhilsaraf.passwordvalidationservice;

import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nikhilsaraf
 */
public abstract class BaseValidationSetTest {
	private static final ApplicationContext context = new ClassPathXmlApplicationContext("PasswordValidationServiceBeansContext.xml");
	
	protected void commonTestHelper(final String inputPassword, final Set<String> expectedErrorMessages) throws InstantiationException, IllegalAccessException {
		final String validationSetId = getValidationSetName();
		final ValidationSet validationSet = (ValidationSet) context.getBean(validationSetId);
		final PasswordValidationResult result = validationSet.validate(inputPassword);
		Assert.assertTrue("The error message(s) did not match as expected. Expected: " + expectedErrorMessages + " | Actual: " + result.getValidationErrors(), expectedErrorMessages.equals(new HashSet<String>(result.getValidationErrors())));
	}
	
	/**
	 * Provides the basic validation set name against which to test
	 */
	protected abstract String getValidationSetName();
}
