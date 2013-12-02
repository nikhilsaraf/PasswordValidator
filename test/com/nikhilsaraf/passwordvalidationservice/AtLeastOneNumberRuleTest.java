/**
 * 
 */
package com.nikhilsaraf.passwordvalidationservice;

import org.junit.Test;


/**
 * Tests the AtLeastOneNumberRule rule
 * 
 * @author nikhilsaraf
 */
public class AtLeastOneNumberRuleTest extends BaseRuleTest {
	@Override
	protected Class<? extends ValidationRule> ruleBeingTested() {
		return AtLeastOneNumberRule.class;
	}

	@Test
	public void testOnlyUppercaseRejected() throws Exception {
		// test with only uppercase
		commonTestHelper("ASLKFJA", AtLeastOneNumberRule.errorMessage);
	}
	
	@Test
	public void testOnlyLowercaseRejected() throws Exception {
		// test with only uppercase
		commonTestHelper("asdhfakshfka", AtLeastOneNumberRule.errorMessage);
	}
	
	@Test
	public void testOneNumberAccepted() throws Exception {
		commonTestHelper("ASsfaLg1KFJA", null);
	}
	
	@Test
	public void testManyNumbersAccepted() throws Exception {
		commonTestHelper("suJKHGGLkah21e3123kh31k23hKJH", null);
	}
	
	@Test
	public void testOnlyNumbersAccepted() throws Exception {
		commonTestHelper("23498170324124097", null);
	}
}
