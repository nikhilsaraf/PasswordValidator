/**
 * 
 */
package com.nikhilsaraf.passwordvalidationservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Encapsulates the result from a Password Validation. Serves as a fundamental part of the Password Validation API
 * 
 * Can expand this class to provide information about the password, like whether the validator
 * considers this as a strong password or a weak password with the help of, say, an enum.
 * Can add any additional information like whether the password validation was completed or whether
 * it was interrupted by an internal server error or anything of that sort.
 * 
 * @author nikhilsaraf
 */
public class PasswordValidationResult {
	/**
	 * Represents the password against which validation was attempted
	 */
	private final String passwordAttempted;
	
	/**
	 * Holds a list of validation errors that occurred during validation
	 */
	private final List<String> validationErrors;
	
	/**
	 * Constructor to set final values on this object, which encapsulates the result from a password validation attempt
	 * 
	 * @param passwordAttempted
	 * @param validationErrors
	 */
	public PasswordValidationResult(final String passwordAttempted, final List<String> validationErrors) {
		this.passwordAttempted = passwordAttempted;
		this.validationErrors = (validationErrors == null) ? new ArrayList<String>(0) : validationErrors;
	}
	
	/**
	 * @return the passwordAttempted
	 */
	public String getPasswordAttempted() {
		return passwordAttempted;
	}

	/**
	 * We do not want anyone modifying the validation errors variable so we pass an unmodifiable list
	 * 
	 * @return the validationErrors
	 */
	public List<String> getValidationErrors() {
		return Collections.unmodifiableList(validationErrors);
	}

	/**
	 * Returns whether the password was deemed valid or not
	 * 
	 * @return true if valid, false if not
	 */
	public boolean isValid() {
		return validationErrors.isEmpty();
	}
}