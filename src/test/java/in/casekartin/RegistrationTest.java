package in.casekartin;

import static org.junit.Assert.*;

import org.junit.Test;

import in.casekartin.exception.ValidationException;
import in.casekartin.util.LoginRegisterUtil;
import in.casekartin.validator.RegisterManagerValidator;

public class RegistrationTest {

	@Test
	public void testIsNameCharAllowed() {
		try {
			RegisterManagerValidator.isAlphaCharAllowed("    ");
			fail();
		} catch (ValidationException e) {
			assertEquals("Invalid Name",e.getMessage());
		}
	}
	@Test
	public void testIsUserNameValid()
	{
		try {
			boolean isValid=false;
			isValid=LoginRegisterUtil.isUserNameCharAllowed("selva2k");
			assertTrue(isValid);
		} catch ( ValidationException e) {
			fail();
		}
	}
	@Test
	public void testIsUserNameNotValid()
	{
		try {
			LoginRegisterUtil.isUserNameCharAllowed("      ");
			fail();
		} catch ( ValidationException e) {
			assertEquals("Invalid Character",e.getMessage());
		}
	}
	@Test
	public void testIsMobileNumValid()
	{
		try {
			
			 RegisterManagerValidator.isMobileNumValid("600000000");
			fail();
		} catch ( ValidationException e) {
			assertEquals("Invalid Mobile Number",e.getMessage());
		}
	}
	@Test
	public void testIsEmailValid()
	{
		try {
			boolean isValid;
			isValid=RegisterManagerValidator.isEmailValid("abc123@gmail.com");
			assertTrue(isValid);
		} catch (ValidationException e) {
			fail();
		}
	}
	@Test
	public void testIsAddressValid()
	{
		try {
			
			assertTrue(RegisterManagerValidator.isAddressValid("4/2 * perumal kovil west street,Thachanallur,Tirunelveli-627 358"));
			fail();
		} catch (ValidationException e) {
			assertEquals("Invalid Address",e.getMessage());
		}
	}
}
