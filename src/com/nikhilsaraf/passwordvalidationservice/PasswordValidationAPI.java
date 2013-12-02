/**
 * 
 */
package com.nikhilsaraf.passwordvalidationservice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This is the API which the production user will use.
 * 
 * One should use the validatePassword(...) method unless they want to use a specific
 * set of rules (or rule). This can be any custom rules that they have created as well.
 * 
 * See javadocs of methods for more info.
 * 
 * @author nikhilsaraf
 */
public class PasswordValidationAPI {
	private static final ApplicationContext context = new ClassPathXmlApplicationContext("PasswordValidationServiceBeansContext.xml");
	
	/**
	 * Uses the "DefaultComprehensiveValidationSet" as is defined in the PasswordValidationServiceBeansContext.xml file
	 * using composition of all the other beans (PasswordValidators)
	 * 
	 * @param password
	 * @return {@link PasswordValidationResult}
	 */
	public PasswordValidationResult validatePassword(String password) {
		return validatePasswordUsingNamedPasswordValidatorBean(password, "DefaultComprehensiveValidationSet");
	}
	
	/**
	 * Uses a named PasswordValidator. This needs to be defined as a bean in the PasswordValidationServiceBeansContext.xml file.
	 * You can add custom validation rules and play around with it a little to try and see how the password validation is affected
	 * by adding your own custom validation sets.
	 * 
	 * @param password
	 * @return {@link PasswordValidationResult}
	 * @throws IllegalArgumentException throws when password is null (to avoid having each rule be sensitive to this, we handle it at the api level
	 * 								
	 */
	public PasswordValidationResult validatePasswordUsingNamedPasswordValidatorBean(String password, String beanId) throws IllegalArgumentException {
		if (password == null) {
			throw new IllegalArgumentException("Cannot validate a null password string");
		}
		
		final PasswordValidator validator = (PasswordValidator) context.getBean(beanId);
		final PasswordValidationResult result = validator.validate(password);
		return result;
	}
}