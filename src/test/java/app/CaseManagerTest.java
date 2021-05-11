package app;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Set;

import org.junit.Test;

import in.casekartin.model.CaseManagerModel;
import in.casekartin.service.CaseManagerService;

public class CaseManagerTest {

	/**
	 * checking the number of case types equals the expected value
	 */
	@Test
	public void numberOfCaseTypesTest() {
		Set<CaseManagerModel> caseTypes = CaseManagerService.getCaseTypes();
		assertEquals(7,caseTypes.size());
	}

}
