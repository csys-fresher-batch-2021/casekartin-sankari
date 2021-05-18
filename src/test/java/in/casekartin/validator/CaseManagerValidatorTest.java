package in.casekartin.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import in.casekartin.dao.CaseManagerDAO;
import in.casekartin.model.CaseManager;
import in.casekartin.util.CaseManagerUtil;
public class CaseManagerValidatorTest {

	/**
	 * checking the number of case types equals the expected value
	 */
	@Test
	public void numberOfCaseTypesTest() {
		Set<CaseManager> caseTypes = CaseManagerDAO.getCaseTypes();
		assertEquals(7, caseTypes.size());
	}

	
	/**
	 * test case for case name with wrong length 
	 */
	@Test
	public void caseNameWithWrongLength() {
		String caseName = "le";
		boolean isNameValid = CaseManagerUtil.isCharAllowed(caseName);
		assertEquals(false, isNameValid);
	}
	/**
	 * test case for case name with empty
	 */
	@Test
	public void caseNameWithEmpty() {
		String caseName = "  ";
		boolean isNameValid = CaseManagerUtil.isValidCaseName(caseName);
		assertFalse(isNameValid);
	}
	/**
	 * test case for case name with null
	 */
	@Test
	public void caseNameWithNull() {
		String caseName = "null";
		boolean isNameValid = CaseManagerUtil.isValidCaseName(caseName);
		assertFalse(isNameValid);
	}
	
	/**
	 * test case for correct case name as input 
	 */
	@Test
	public void caseNameWithCorrectInput() {
		String caseName = "led case";
		boolean isNameValid = CaseManagerUtil.isValidCaseName(caseName);
		assertTrue(isNameValid);
	}

	/**
	 * test case for checking case cost is greater than 0
	 */
	@Test
	public void caseCostWithWrongInput() {
		Float cost = 0f;
		boolean isNameValid = CaseManagerUtil.isValidCost(cost);
		assertFalse(isNameValid);
	}

	/**
	 * test case for checking case cost with correct input(greater than 0)
	 */
	@Test
	public void caseCostWithCorrectInput() {
		Float cost = 50f;
		boolean isNameValid = CaseManagerUtil.isValidCost(cost);
		assertTrue(isNameValid);
	}

	/**
	 * test case for checking case name is not already exist
	 */
	@Test
	public void IscaseNameNotExist() {
		String caseName = "led";
		boolean isNameValid = CaseManagerValidator.isCaseNameNotExist(caseName);
		assertTrue(isNameValid);
	}
	/**
	 * test case for checking case name is deleted 
	 */
	@Test
	public void IsCaseNameDeleted() {
		String caseName = "leather";
		boolean isNameValid = CaseManagerDAO.deleteCase(caseName);
		assertTrue(isNameValid);
	}
}
