/**
 * 
 */
package com.nikhilsaraf.passwordvalidationservice;

import org.junit.Test;

/**
 * @author nikhilsaraf
 *
 */
public class NoRepeatingSequenceRuleTest extends BaseRuleTest {
	@Override
	protected Class<? extends ValidationRule> ruleBeingTested() {
		return NoRepeatingSequenceRule.class;
	}
	
	/**
	 * Note how uppercase is ok, because this rule does not define any character restraints but only repeating
	 * character rules.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRepeatedSubsequenceRejected() throws Exception {
		commonTestHelper("ABCABC", NoRepeatingSequenceRule.constructErrorMessage(3, 5));
	}
	
	/**
	 * Note how uppercase is ok, because this rule does not define any character restraints but only repeating
	 * character rules.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testNonRepeatedSubsequenceAccepted() throws Exception {
		commonTestHelper("ABCAB", null);
	}
}