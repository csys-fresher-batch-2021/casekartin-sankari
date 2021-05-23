package in.casekartin.validator;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
			fail();
		} catch (ValidationException e) {
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
			fail();
		} catch (StringException e) {

		}
	}

	/**
	 * test case for correct case name as input
	 * 
	 * @throws StringException
	 */
	@Test
	public void caseNameWithCorrectInput() {
		String caseName = "led case";
		boolean isNameValid;
		try {
			isNameValid = StringNumberUtil.stringUtil(caseName);
			assertTrue(isNameValid);
		} catch (StringException e) {
			fail();
		}
		
	}

	/**
	 * test case for case name is not added due to existing case name
	 * 
	 * @throws Exception
	 */
	@Test
	public void isExistingCaseNameAdded() {
		String caseName = "leather Case";
		String cost = "50";
		try {
			CaseManagerService.addCaseType(caseName, cost);
			fail();
		} catch (ServiceException e) {
			assertEquals("Case Name is Already Exist",e.getMessage());
		}
	}

	/**
	 * test case for case name is added due to not existing case name
	 * 
	 * @throws Exception
	 * @throws ServiceException
	 */
	@Test
	public void isNotExistingCaseNameAdded() {
		String caseName = "led";
		String cost = "50";

		boolean isAdded;
		try {
			isAdded = CaseManagerService.addCaseType(caseName, cost);
			assertTrue(isAdded);
		} catch (ServiceException e) {
			fail();
		}
		

	}

	/**
	 * test case for checking case cost is greater than 0
	 */
	@Test
	public void caseCostWithWrongInput() {
		Float cost = 0f;
		try {
			StringNumberUtil.positiveNumberUtil(cost);
			fail();
		} catch (NumberException e) {
		}
	}

	/**
	 * test case for checking case cost with correct input(greater than 0)
	 * 
	 * @throws NumberException
	 */
	@Test
	public void caseCostWithCorrectInput() {
		Float cost = 50f;
		boolean isNameValid;
		try {
			isNameValid = StringNumberUtil.positiveNumberUtil(cost);
			assertTrue(isNameValid);
		} catch (NumberException e) {
			fail();
		}
		
	}

	/**
	 * test case for checking case name is not already exist
	 * 
	 * @throws Exception
	 */
	@Test
	public void IscaseNameNotExist(){
		String caseName = "Real 3D Cases";
		boolean isExist;
		try {
			isExist = CaseManagerValidator.isCaseNameExist(caseName);
			assertFalse(isExist);
		} catch (Exception e) {
			fail();
		}
		
	}

	/**
	 * test case for checking case name is already exist
	 * 
	 * @throws Exception
	 */
	@Test
	public void IscaseNameExist(){
		String caseName = "leather case";
		boolean isExist;
		try {
			isExist = CaseManagerValidator.isCaseNameExist(caseName);
			assertTrue(isExist);
		} catch (Exception e) {
			fail();
		}
		
	}

	/**
	 * test case for checking case name is deleted
	 * 
	 * @throws Exception
	 */
	@Test
	public void IsCaseNameDeleted(){
		String caseName = "led";
		boolean isNameValid = CaseManagerService.deleteCaseType(caseName);
		assertTrue(isNameValid);
	}
}
