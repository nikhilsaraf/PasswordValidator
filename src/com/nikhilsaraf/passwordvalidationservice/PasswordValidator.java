/**
 * 
 */
package com.nikhilsaraf.passwordvalidationservice;

/**
 * Provides the basic interface for any Password Validator. See implementing classes for more information
 * 
 * @author nikhilsaraf
 * 
 * @see {@link Rule}
 * @see {@link ValidationSet}
 */
interface PasswordValidator {
	/**
	 * This method should perform validation on the provided password and return a corresponding
	 * PasswordValidationResult. The method itself is allowed to maintain state within it's own
	 * call (in the case when it may have multiple steps) but will be stateless across calls to
	 * validate from outside this method itself.
	 * 
	 * @param password
	 * @return PasswordValidationResult representing whether the passed in password is valid or not
	 * 									and any associated errors etc.
	 */
	PasswordValidationResult validate(String password);
}
