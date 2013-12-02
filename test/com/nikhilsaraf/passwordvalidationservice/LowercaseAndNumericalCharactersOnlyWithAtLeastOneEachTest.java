package com.nikhilsaraf.passwordvalidationservice;

import java.util.HashSet;

import org.junit.Test;

@SuppressWarnings("serial")
public class LowercaseAndNumericalCharactersOnlyWithAtLeastOneEachTest extends BaseValidationSetTest {
	@Override
	protected String getValidationSetName() {
		return "LowercaseAndNumericalCharactersOnlyWithAtLeastOneEach";
	}

	@Test
	public void testOnlyNumbersRejected() throws Exception {
		commonTestHelper("123456", new HashSet<String>(3){{ add(AtLeastOneLowercaseRule.errorMessage); }});
	}
	
	@Test
	public void testOnlyLowercaseRejected() throws Exception {
		commonTestHelper("asjkhfkahf", new HashSet<String>(3){{ add(AtLeastOneNumberRule.errorMessage); }});
	}
	
	@Test
	public void testLowercaseAndNumericalCharactersOnlyWithAtLeastOneEachAccepted() throws Exception {
		commonTestHelper("as3jkhfkahf", new HashSet<String>(1));
	}
}
