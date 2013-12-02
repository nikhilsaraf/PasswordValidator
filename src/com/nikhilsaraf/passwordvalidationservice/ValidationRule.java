/**
 * 
 */
package com.nikhilsaraf.passwordvalidationservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Defines the most atomic unit of password validation. A rule can only have one validation constraint and implements
 * the performValidation method.
 * 
 * @author nikhilsaraf
 * 
 * @see ValidationSet
 */
abstract class ValidationRule implements PasswordValidator {
	// default constructor, does nothing
	public ValidationRule() {}
	
	/**
	 * Implements the interface's validate() method.
	 * Avoids having to repeat code around converting the result of a Rule's validation to the interface's specification.
	 */
	@Override
	public PasswordValidationResult validate(String password) {
		final String result = performValidation(password);
		final List<String> errors = new ArrayList<String>(1);
		
		if (result != null) {
			errors.add(result); 
		}
		
		return new PasswordValidationResult(password, Collections.unmodifiableList(errors));
	}
	
	/**
	 * Rules can only generate one error, and are supposed to be atomic in that sense.
	 * If you wish to have a more complex "rule", then you should look at {@link ValidationSet}
	 * 
	 * @param password
	 * @return a String with the associated validation error; null if password is valid
	 */
	protected abstract String performValidation(String password);
}
