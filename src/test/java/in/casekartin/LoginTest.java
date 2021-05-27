package in.casekartin;

import static org.junit.Assert.*;

import org.junit.Test;

import in.casekartin.exception.ValidationException;
import in.casekartin.validator.LoginValidator;

public class LoginTest {
	/**
	 * Test Case for valid login
	 */
	@Test
	public void testWithCorrectUserNameAndCorrectPassword() {
		try {
			boolean isValid=LoginValidator.isLoginVerified("admin", "pass123");
			assertTrue(isValid);
		} catch (ValidationException e) {
			fail();
		}
	}
		/**
		 * Test Case for invalid login
		 */
		@Test
		public void testWithWrongUserNameAndCorrectPassword() {
			try {
				LoginValidator.isLoginVerified("admi", "pass123");
				fail();
			} catch (ValidationException e) {
				assertEquals("Invalid Login Credentials",e.getMessage());
			}
	}
		/**
		 * Test Case for invalid login
		 */
		@Test
		public void testWithCorrectUserNameAndWrongPassword() {
			try {
				LoginValidator.isLoginVerified("admin", "pass12");
				fail();
			} catch (ValidationException e) {
				assertEquals("Invalid Login Credentials",e.getMessage());
			}
	}
		/**
		 * Test Case for valid login
		 */
		@Test
		public void testWithWrongUserNameAndWrongPassword() {
			try {
				LoginValidator.isLoginVerified("admin", "pass12");
				fail();
			} catch (ValidationException e) {
				assertEquals("Invalid Login Credentials",e.getMessage());
			}
		}

}
