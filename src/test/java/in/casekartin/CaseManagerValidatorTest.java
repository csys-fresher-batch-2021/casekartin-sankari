package in.casekartin;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import in.casekartin.model.CaseManager;
import in.casekartin.service.CaseManagerService;
import in.casekartin.validator.CaseManagerValidator;

public class CaseManagerValidatorTest {

	/**
	 * checking the number of case types equals the expected value
	 */
	@Test
	public void numberOfCaseTypesTest() {
		Set<CaseManager> caseTypes = CaseManagerService.getCaseTypes();
		assertEquals(7, caseTypes.size());
	}

	
	/**
	 * test case for case name length validation 
	 */
	@Test
	public void caseNameWithWrongLength() {
		String caseName = "le";
		boolean isNameValid = CaseManagerValidator.caseNameValidator(caseName);
		assertEquals(false, isNameValid);
	}
	
	/**
	 * test case for correct case name as input 
	 */
	@Test
	public void caseNameWithCorrectInput() {
		String caseName = "led case";
		boolean isNameValid = CaseManagerValidator.caseNameValidator(caseName);
		assertEquals(true, isNameValid);
	}

	/**
	 * test case for checking case cost is greater than 100
	 */
	@Test
	public void caseCostValidation() {
		Float cost = 0f;
		boolean isNameValid = CaseManagerValidator.costValidator(cost);
		assertEquals(false, isNameValid);
	}

	/**
	 * test case for checking case name is already exist or not
	 */
	@Test
	public void caseNameIsNotExist() {
		String caseName = "led";
		boolean isNameValid = CaseManagerValidator.isNotExist(caseName);
		assertEquals(true, isNameValid);
	}
}
