/**
 * 
 */
package com.nikhilsaraf.passwordvalidationservice;

import org.junit.Test;

/**
 * Tests the OnlyLowercaseOrNumericalCharactersRule rule
 * 
 * @author nikhilsaraf
 */
public class OnlyLowercaseOrNumericalCharactersRuleTest extends BaseRuleTest {
	@Override
	protected Class<? extends ValidationRule> ruleBeingTested() {
		return OnlyLowercaseOrNumericalCharactersRule.class;
	}

	@Test
	public void testOnlyUppercaseRejected() throws Exception {
		// test with only uppercase
		commonTestHelper("ASLKFJA", OnlyLowercaseOrNumericalCharactersRule.errorMessage);
	}
	
	@Test
	public void testOnlyLowercaseAccepted() throws Exception {
		// test with only uppercase
		commonTestHelper("asdhfakshfka", null);
	}

	@Test
	public void testOnlyNumbersAccepted() throws Exception {
		commonTestHelper("23498170324124097", null);
	}
	
	@Test
	public void testLowercaseAndNumbersAccepted() throws Exception {
		commonTestHelper("ukahfask907asf9asf79asdf", null);
	}
	
	@Test
	public void testSomeUppercaseRejected() throws Exception {
		commonTestHelper("suJKHGGLkah21e3123kh31k23hKJH", OnlyLowercaseOrNumericalCharactersRule.errorMessage);
	}
	
	@Test
	public void testFunkyCharactersRejected() throws Exception {
		commonTestHelper("2^10", OnlyLowercaseOrNumericalCharactersRule.errorMessage);
	}
}
