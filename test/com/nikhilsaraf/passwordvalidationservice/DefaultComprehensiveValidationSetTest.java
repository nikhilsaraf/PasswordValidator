package com.nikhilsaraf.passwordvalidationservice;

import java.util.HashSet;

import org.junit.Test;

@SuppressWarnings("serial")
public class DefaultComprehensiveValidationSetTest extends BaseValidationSetTest {
	@Override
	protected String getValidationSetName() {
		return "DefaultComprehensiveValidationSet";
	}

	@Test
	public void testOnlyNumbersRejected() throws Exception {
		commonTestHelper("123456", new HashSet<String>(3){{
			add(AtLeastOneLowercaseRule.errorMessage);
		}});
	}
	
	@Test
	public void testOnlyLowercaseRejected() throws Exception {
		commonTestHelper("asjkhfkahf", new HashSet<String>(3){{
			add(AtLeastOneNumberRule.errorMessage);
		}});
	}
	
	@Test
	public void testOnlyUppercaseRejected() throws Exception {
		commonTestHelper("KLJLN", new HashSet<String>(3){{
			add(AtLeastOneNumberRule.errorMessage);
			add(AtLeastOneLowercaseRule.errorMessage);
			add(OnlyLowercaseOrNumericalCharactersRule.errorMessage);
		}});
	}
	
	@Test
	public void testSomeUppercaseRejected() throws Exception {
		commonTestHelper("KLJlkjsfaf", new HashSet<String>(3){{
			add(AtLeastOneNumberRule.errorMessage);
			add(OnlyLowercaseOrNumericalCharactersRule.errorMessage);
		}});
	}
	
	@Test
	public void testLowercaseAndNumericalCharactersOnlyWithAtLeastOneEachAccepted() throws Exception {
		commonTestHelper("as3jkhfkahf", new HashSet<String>(1));
	}
	
	@Test
	public void testLowercaseAndNumericalCharactersButTooShortRejected() throws Exception {
		commonTestHelper("as3j", new HashSet<String>() {{
			add(LengthRule.tooShortErrorMessage);
		}});
	}
	
	@Test
	public void testLowercaseAndNumericalCharactersButTooLongRejected() throws Exception {
		commonTestHelper("as3jkhfkahf3k4h1k34", new HashSet<String>() {{
			add(LengthRule.tooLongErrorMessage);
		}});
	}
	
	@Test
	public void testLowercaseAndNumericalCharactersWithRepitionRejected() throws Exception {
		commonTestHelper("as3js3jkahf", new HashSet<String>(1) {{
			add(NoRepeatingSequenceRule.constructErrorMessage(4, 6));
		}});
	}
	
	/**
	 * One of the many tests that demonstrates that we do catch multiple error messages as well
	 * @throws Exception
	 */
	@Test
	public void testLowercaseAndNumericalCharactersWithRepitionAndTooLongRejected() throws Exception {
		commonTestHelper("as3js3jkahf55", new HashSet<String>(1) {{
			add(NoRepeatingSequenceRule.constructErrorMessage(4, 6));
			add(LengthRule.tooLongErrorMessage);
		}});
	}
}
