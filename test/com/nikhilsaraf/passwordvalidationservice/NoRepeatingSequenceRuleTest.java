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
	public void testRepeatedSubsequenceRejected1() throws Exception {
		commonTestHelper("ABCABC", NoRepeatingSequenceRule.constructErrorMessage(3, 5));
	}
	
	@Test
	public void testRepeatedSubsequenceRejected2() throws Exception {
		commonTestHelper("ABCDABABC", NoRepeatingSequenceRule.constructErrorMessage(6, 7));
	}
	
	@Test
	public void testRepeatedSubsequenceRejected3() throws Exception {
		commonTestHelper("THISWILLREPEAT", NoRepeatingSequenceRule.constructErrorMessage(7, 7));
	}
	
	@Test
	public void testRepeatedSubsequenceRejected4() throws Exception {
		commonTestHelper("THISDIDREPEATHISDIDREPEAT", NoRepeatingSequenceRule.constructErrorMessage(12, 23));
	}
	
	
	/**
	 * Note how uppercase is ok, because this rule does not define any character restraints but only repeating
	 * character rules.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testNonRepeatedSubsequenceAccepted1() throws Exception {
		commonTestHelper("ABCAB", null);
	}
	
	@Test
	public void testNonRepeatedSubsequenceAccepted2() throws Exception {
		commonTestHelper("ABCABD", null);
	}
	
	@Test
	public void testNonRepeatedSubsequenceAccepted3() throws Exception {
		commonTestHelper("ABCDABC", null);
	}
}