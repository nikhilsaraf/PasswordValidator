/**
 * 
 */
package com.nikhilsaraf.passwordvalidationservice;

import org.junit.Test;


/**
 * Tests the AtLeastOneLowercaseRule rule
 * 
 * @author nikhilsaraf
 */
public class AtLeastOneLowercaseRuleTest extends BaseRuleTest {
	@Override
	protected Class<? extends ValidationRule> ruleBeingTested() {
		return AtLeastOneLowercaseRule.class;
	}

	@Test
	public void testOnlyUppercaseRejected() throws Exception {
		// test with only uppercase
		commonTestHelper("ASLKFJA", AtLeastOneLowercaseRule.errorMessage);
	}
	
	@Test
	public void testOnlyNumbersRejected() throws Exception {
		commonTestHelper("982791324", AtLeastOneLowercaseRule.errorMessage);
	}
	
	@Test
	public void testOneLowercaseAccepted() throws Exception {
		commonTestHelper("ASLgKFJA", null);
	}
	
	@Test
	public void testManyLowercaseAccepted() throws Exception {
		commonTestHelper("ASLgKFksahfJsfaA", null);
	}
	
	@Test
	public void testOnlyLowercaseAccepted() throws Exception {
		commonTestHelper("askuhfkahkaknclakshfa", null);
	}
}
