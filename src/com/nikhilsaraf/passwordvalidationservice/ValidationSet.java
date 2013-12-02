/**
 * 
 */
package com.nikhilsaraf.passwordvalidationservice;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * This defines a set of PasswordValidators (cannot be repeated as it is a set) against which we run validation.
 * 
 * This uses the design pattern of Composition to allow us to build complex validation steps (unordered, for now).
 * 
 * This runs validations across all the defined rules and returns the PasswordValidationResult after combining
 * the results of all sub-validators
 * 
 * @author nikhilsaraf
 */
class ValidationSet implements PasswordValidator {
	private final Set<PasswordValidator> validators;

	public ValidationSet(Set<PasswordValidator> validators) {
		this.validators = validators;
	}
	
	/**
	 * Responsible for combining validation rules (or other validationSets or PasswordValidators etc.) into a single validation result
	 * 
	 * @return {@link PasswordValidationResult} combined from all sub-validators
	 */
	@Override
	public PasswordValidationResult validate(String password) {
		// use a LinkedList because we don't know the size before hand as we cannot predict how many errors, and is better for memory in this case
		final List<String> validationErrors = new LinkedList<String>();
		
		// since validators is a set, we are guaranteed that it will not be repeated.
		for (PasswordValidator validator : validators) {
			final PasswordValidationResult result = validator.validate(password);
			
			// if was not valid, then add all errors to our master list.
			if (!result.isValid()) {
				// if we want, we can augment errors here to show the hierarchy of PasswordValidators if needed, but not necessary
				validationErrors.addAll(result.getValidationErrors());
			}
		}
		
		return new PasswordValidationResult(password, validationErrors);
	}

	/**
	 * Helps build the ValidationSet without having to define the PasswordValidator all in one go
	 * @author nikhilsaraf
	 */
	static class Builder {
		private final Set<PasswordValidator> validators;
		
		public Builder() {
			// default to 4 validators by default to conserve memory 
			this.validators = new HashSet<PasswordValidator>(4);
		}
		
		public void add(PasswordValidator validator) {
			validators.add(validator);
		}
		
		/**
		 * Builds the ValidationSet to be used.
		 * Can continue to build using the same builder once we have called build without any effect on previously built validators
		 * 
		 * @return ValidationSet
		 */
		ValidationSet build() {
			// create a copy of the validators so that we can continue to build using the same builder
			return new ValidationSet(Collections.unmodifiableSet(new HashSet<PasswordValidator>(validators)));
		}
	}
}
