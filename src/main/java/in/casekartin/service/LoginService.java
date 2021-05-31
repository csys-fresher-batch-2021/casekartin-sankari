package in.casekartin.service;

import java.util.Map;

import in.casekartin.dao.RegisterManagerDAO;
import in.casekartin.exception.DBException;
import in.casekartin.exception.ServiceException;
import in.casekartin.exception.ValidationException;
import in.casekartin.validator.LoginValidator;

public class LoginService {
	private LoginService(){
		//default constructor
	}
	private static RegisterManagerDAO regDAO=new RegisterManagerDAO();
	/**
	 * check logged user name and password is valid
	 * @param userName
	 * @param password
	 * @return
	 * @throws ServiceException 
	 */
	public static boolean isloginSuccess(String userName, String password) throws ServiceException {
		boolean isLoginSuccess=false;
		try {
			Map <String,String> loginList=regDAO.getUserNamePassword();
			LoginValidator.isLoginVerified(loginList,userName,password);
			isLoginSuccess=true;
			return isLoginSuccess;
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(),e);
		}catch (DBException e) {
			e.printStackTrace();
		}
		return isLoginSuccess;
		
	}

}
