package app;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import in.casekartin.service.CaseManager;

public class CaseManagerTest {

	/**
	 * checking the number of case types equals the expected value
	 */
	@Test
	public void numberOfCaseTypesTest() {
		HashMap<String, Float> caseTypes = CaseManager.getCaseTypes();
		assertEquals(7,caseTypes.size());
	}

}
