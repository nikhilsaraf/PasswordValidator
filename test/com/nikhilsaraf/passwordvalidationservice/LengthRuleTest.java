/**
 * 
 */
package com.nikhilsaraf.passwordvalidationservice;

import org.junit.Test;

/**
 * Tests the LengthRule password validation rule
 * 
 * 4 total test cases, whether password length is caught if too short, or if too long. Also tests that
 * the shortest allowable password works and the longest alloweable password works
 * 
 * @author nikhilsaraf
 */
public class LengthRuleTest extends BaseRuleTest {
	@Override
	protected Class<? extends ValidationRule> ruleBeingTested() {
		return LengthRule.class;
	}
	
	@Test
	public void testTooShortPasswordRejected() throws Exception {
		commonTestHelper("1234", LengthRule.tooShortErrorMessage);
	}
	
	@Test
	public void testTooLongPasswordRejected() throws Exception {
		commonTestHelper("1234567890123", LengthRule.tooLongErrorMessage);
	}
	
	@Test
	public void testShortestLengthPasswordAccepted() throws Exception {
		commonTestHelper("12345", null);
	}
	
	@Test
	public void testLongestLengthPasswordAccepted() throws Exception {
		commonTestHelper("123456789012", null);
	}
}
