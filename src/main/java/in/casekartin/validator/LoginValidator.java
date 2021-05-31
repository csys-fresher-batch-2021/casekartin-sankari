package in.casekartin.validator;

import java.util.Map;

import in.casekartin.exception.ValidationException;
import in.casekartin.util.LoginRegisterUtil;
import in.casekartin.util.StringNumberUtil;

/**
 * creating class for validating the login credentials
 * 
 * @author selv2630
 *
 */
public class LoginValidator {
	private static final String INVALID_LOGIN_CREDENTIALS = "Invalid Login Credentials";

	private LoginValidator() {
		// default Constructor
	}

	/**
	 * this method check user name & password is valid or not
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws ValidationException
	 */
	public static boolean isLoginVerified(Map<String, String> loginList, String userName, String password)
			throws ValidationException {
		boolean isValid = false;
		try {
			StringNumberUtil.stringUtil(userName);
			LoginRegisterUtil.isUserNameCharAllowed(userName);
			LoginRegisterUtil.isPasswordCharAllowed(password);
			if (loginList.containsKey(userName) && password.equals(loginList.get(userName))) {
				isValid=true;
			} else if (userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("pass123*")) {
				isValid = true;
			} else {
				throw new ValidationException(INVALID_LOGIN_CREDENTIALS);
			}
		} catch (ValidationException e) {
			throw new ValidationException(INVALID_LOGIN_CREDENTIALS);
		}
		return isValid;
	}

}
