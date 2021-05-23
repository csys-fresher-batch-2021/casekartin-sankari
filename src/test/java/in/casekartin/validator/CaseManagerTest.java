package in.casekartin.validator;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import javax.xml.bind.ValidationException;
import org.junit.Test;

import in.casekartin.Exception.NumberException;
import in.casekartin.Exception.ServiceException;
import in.casekartin.Exception.StringException;
import in.casekartin.service.CaseManagerService;
import in.casekartin.util.StringNumberUtil;

public class CaseManagerTest {

	/**
	 * test case for case name with wrong length
	 */
	@Test
	public void caseNameWithWrongLength() {
		String caseName = "le";
		try {
			CaseManagerValidator.isCharAllowed(caseName);
		} catch (ValidationException e) {
			assertEquals("Invalid Case Name", e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * test case for case name with special character
	 */
	@Test
	public void caseNameWithSpecialChar() {
		String caseName = "le@d";
		try {
			CaseManagerValidator.isCharAllowed(caseName);
		} catch (ValidationException e) {
			assertEquals("Invalid Case Name", e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * test case for case name with empty
	 */
	@Test
	public void caseNameWithEmpty() {
		String caseName = "  ";
		try {
			StringNumberUtil.stringUtil(caseName);
		} catch (StringException e) {
			assertEquals("Invalid Case Name", e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * test case for case name with null
	 */
	@Test
	public void caseNameWithNull() {
		String caseName = "null";
		try {
			StringNumberUtil.stringUtil(caseName);
		} catch (StringException e) {
			assertEquals("Invalid Case Name", e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * test case for correct case name as input
	 * 
	 * @throws StringException
	 */
	@Test
	public void caseNameWithCorrectInput() throws StringException {
		String caseName = "led case";
		boolean isNameValid = StringNumberUtil.stringUtil(caseName);
		assertTrue(isNameValid);
	}

	/**
	 * test case for case name is not added due to existing case name
	 * 
	 * @throws Exception
	 */
	@Test
	public void isExistingCaseNameAdded() throws Exception {
		String caseName = "leather Case";
		String cost = "50";
		try {
			CaseManagerService.addCaseType(caseName, cost);
		} catch (ServiceException e) {
			assertEquals("Case Name is Already Exist", e.getMessage());
		}
	}

	/**
	 * test case for case name is added due to not existing case name
	 * 
	 * @throws Exception
	 * @throws ServiceException
	 */
	@Test
	public void isNotExistingCaseNameAdded() throws ServiceException, Exception {
		String caseName = "led";
		String cost = "50";

		boolean isAdded = CaseManagerService.addCaseType(caseName, cost);
		assertTrue(isAdded);

	}

	/**
	 * test case for checking case cost is greater than 0
	 */
	@Test
	public void caseCostWithWrongInput() {
		Float cost = 0f;
		try {
			StringNumberUtil.positiveNumberUtil(cost);
		} catch (NumberException e) {
			assertEquals("Invalid Cost", e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * test case for checking case cost with correct input(greater than 0)
	 * 
	 * @throws NumberException
	 */
	@Test
	public void caseCostWithCorrectInput() throws NumberException {
		Float cost = 50f;
		boolean isNameValid = StringNumberUtil.positiveNumberUtil(cost);
		assertTrue(isNameValid);
	}

	/**
	 * test case for checking case name is not already exist
	 * 
	 * @throws Exception
	 */
	@Test
	public void IscaseNameNotExist() throws Exception {
		String caseName = "Real 3D Cases";
		boolean isExist = CaseManagerValidator.isCaseNameExist(caseName);
		assertFalse(isExist);
	}

	/**
	 * test case for checking case name is already exist
	 * 
	 * @throws Exception
	 */
	@Test
	public void IscaseNameExist() throws Exception {
		String caseName = "leather case";
		boolean isExist = CaseManagerValidator.isCaseNameExist(caseName);
		assertTrue(isExist);
	}

	/**
	 * test case for checking case name is deleted
	 * 
	 * @throws Exception
	 */
	@Test
	public void IsCaseNameDeleted() throws Exception {
		String caseName = "led";
		boolean isNameValid = CaseManagerService.deleteCaseType(caseName);
		assertTrue(isNameValid);
	}
}
