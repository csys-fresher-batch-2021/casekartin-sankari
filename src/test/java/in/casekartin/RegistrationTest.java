package in.casekartin;

import static org.junit.Assert.*;

import org.junit.Test;

import in.casekartin.exception.ValidationException;
import in.casekartin.util.LoginRegisterUtil;
import in.casekartin.validator.RegisterManagerValidator;

public class RegistrationTest {

	@Test
	public void testWithNullName() {
		try {
			RegisterManagerValidator.isAlphaCharAllowed("    ");
			fail();
		} catch (ValidationException e) {
			assertEquals("Invalid Name",e.getMessage());
		}
	}
	@Test
	public void testWithCorrectNamingCharacter() {
		try {
			boolean isValid=RegisterManagerValidator.isAlphaCharAllowed("selva Sankari.G");
			assertTrue(isValid);
		} catch (ValidationException e) {
			fail();
		}
	}
	@Test
	public void testWithValidUserName()
	{
		try {
			boolean isValid=LoginRegisterUtil.isUserNameCharAllowed("selva2k");
			assertTrue(isValid);
		} catch ( ValidationException e) {
			fail();
		}
	}
	@Test
	public void testWithInValidUserName()
	{
		try {
			LoginRegisterUtil.isUserNameCharAllowed("      ");
			fail();
		} catch ( ValidationException e) {
			assertEquals("Invalid Character",e.getMessage());
		}
	}
	@Test
	public void testWithInCorrectMobileNumber()
	{
		try {
			
			 RegisterManagerValidator.isMobileNumValid("600000000");
			fail();
		} catch ( ValidationException e) {
			assertEquals("Invalid Mobile Number",e.getMessage());
		}
	}
	@Test
	public void testWithCorrectMobileNumber()
	{
		try {
			
			 boolean isValid=RegisterManagerValidator.isMobileNumValid("9003349584");
			assertTrue(isValid);
		} catch ( ValidationException e) {
			fail();
		}
	}
	@Test
	public void testWithValidEmail()
	{
		try {
			boolean isValid=RegisterManagerValidator.isEmailValid("abc123@gmail.com");
			assertTrue(isValid);
		} catch (ValidationException e) {
			fail();
		}
	}
	@Test
	public void testWithInValidEmail()
	{
		try {
			RegisterManagerValidator.isEmailValid("abc123gmail.com");
			fail();
		} catch (ValidationException e) {
			assertEquals("Invalid Email Id",e.getMessage());
		}
	}
	@Test
	public void testWithInValidAddress()
	{
		try {
			
			RegisterManagerValidator.isAddressValid("4/2 * perumal kovil west street,Thachanallur,Tirunelveli-627 358");
			fail();
		} catch (ValidationException e) {
			assertEquals("Invalid Address",e.getMessage());
		}
	}
	@Test
	public void testWithValidAddress()
	{
		try {
			
			boolean isValid=RegisterManagerValidator.isAddressValid("4/2  perumal kovil west street,Thachanallur,Tirunelveli-627 358");
			assertTrue(isValid);
		} catch (ValidationException e) {
			fail();
		}
	}
}
