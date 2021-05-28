package in.casekartin.util;

import java.util.regex.Pattern;

import in.casekartin.exception.StringException;
/**
 * Check user name has correct characters
 * @author selv2630
 *
 */
public class LoginRegisterUtil {
	private LoginRegisterUtil(){
		//default Constructor
	}
	public static boolean isUserNameCharAllowed(String userName)throws StringException {
		boolean isValid = false;
		int i = 0;
			while ((i <= userName.length() - 1) && (userName.length() >= 5 && userName.length() <= 10)) {
				if ((userName.charAt(i) >= 'A' && userName.charAt(i) <= 'Z')
						|| (userName.charAt(i) >= 'a' && userName.charAt(i) <= 'z') ) {
					isValid = true;
				}
				else {
					throw new StringException("Invalid User Name");
				}
				i++;
			}
	 
		return isValid;
	}
	/**
	 * Check password has correct characters
	 * @param password
	 * @return
	 * @throws StringException
	 */
	public static boolean isPasswordCharAllowed(String password) throws StringException {
		boolean isValid = false;
		int i = 0;
		while ((i <= password.length() - 1)) {
			String passwordPattern="[a-zA-Z0-9*&$#@!]{5,10}";
			if (Pattern.matches(passwordPattern,password))
			{
				isValid = true;
			}
			else {
				throw new StringException("Invalid Password");
			}
			i++;
		}
		return isValid;
	}

}
