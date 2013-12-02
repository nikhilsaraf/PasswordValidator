package com.nikhilsaraf.passwordvalidationservice;

import java.util.HashSet;

import org.junit.Test;

@SuppressWarnings("serial")
public class LowercaseAndNumericalCharactersOnlyWithAtLeastOneEachValidationSetTest extends BaseValidationSetTest {
	@Override
	protected String getValidationSetName() {
		return "LowercaseAndNumericalCharactersOnlyWithAtLeastOneEachValidationSet";
	}

	@Test
	public void testOnlyNumbersRejected() throws Exception {
		commonTestHelper("123456", new HashSet<String>(3){{ add(AtLeastOneLowercaseRule.errorMessage); }});
	}
	
	@Test
	public void testOnlyLowercaseRejected() throws Exception {
		commonTestHelper("asjkhfkahf", new HashSet<String>(3){{ add(AtLeastOneNumberRule.errorMessage); }});
	}
	
	/**
	 * Note, length is too short, but it is accepted as length is not a part of this bean
	 * @throws Exception
	 */
	@Test
	public void testLowercaseAndNumericalCharactersOnlyWithAtLeastOneEachAccepted() throws Exception {
		commonTestHelper("as3", new HashSet<String>(1));
	}
}
