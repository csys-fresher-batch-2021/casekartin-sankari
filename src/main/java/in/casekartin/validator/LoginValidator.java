package in.casekartin.validator;

import in.casekartin.exception.ValidationException;

public class LoginValidator {
	private LoginValidator() {
		//default Constructor
	}
	/**
	 * this method check user name & password is valid or not
	 * @param userName
	 * @param password
	 * @return
	 * @throws ValidationException
	 */
	public static boolean isLoginVerified(String userName, String password) throws ValidationException {
		boolean isValid=false;
		if(userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("pass123*"))
		{
			isValid=true;
		}
		else {
			throw new ValidationException("Invalid Login Credentials");
		}
		return isValid;
	}
	

}
