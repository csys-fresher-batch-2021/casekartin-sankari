package in.casekartin.service;

import java.util.List;

import in.casekartin.dao.RegisterManagerDAO;
import in.casekartin.exception.DBException;
import in.casekartin.exception.ServiceException;
import in.casekartin.exception.ValidationException;
import in.casekartin.model.RegisterManager;
import in.casekartin.util.LoginRegisterUtil;
import in.casekartin.validator.RegisterManagerValidator;

public class RegisterManagerService {
	private RegisterManagerService(){
		//default Constructor
	}
	private static RegisterManagerDAO regDAO=new RegisterManagerDAO();
	/**
	 * get user details from servlet
	 * validate the details
	 * passed the details to D.A.O
	 * @param regDetails
	 * @return
	 * @throws ServiceException
	 */	
	public static boolean addRegDetails(RegisterManager regDetails) throws ServiceException {
		
		try {
			RegisterManagerValidator.isAlphaCharAllowed(regDetails.getName());
			RegisterManagerValidator.isEmailValid(regDetails.getEmail());
			RegisterManagerValidator.isMobileNumValid(regDetails.getMobileNum());
			RegisterManagerValidator.isAddressValid(regDetails.getAddress());
			LoginRegisterUtil.isUserNameCharAllowed(regDetails.getUserName());
			LoginRegisterUtil.isPasswordCharAllowed(regDetails.getPassword());
			regDAO.addRegDetails(regDetails);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(),e);
		}catch(DBException e)
		{
			e.printStackTrace();
		}
		return true;			
	}
	/**
	 * list all user details 
	 * @return
	 */
	public static List<RegisterManager> listAllDetails() {
		List<RegisterManager> userDetails=null;
		try {
			userDetails=regDAO.getAllDetails();
		}catch(DBException e){
			e.printStackTrace();
		}
		return userDetails;
				
	}
	/**
	 * List the details while user logged in
	 * @param userName
	 * @return
	 * @throws ServiceException
	 */
	public static RegisterManager listByUserName(String userName) throws ServiceException{
		List<RegisterManager> regDetails=null;
		RegisterManager user=null;
		try {
			regDetails=regDAO.getAllDetails();
			for(RegisterManager userDetails: regDetails) {
				if(userDetails.getUserName().equals(userName)) {
					System.out.println("username"+userDetails.getUserName());
					System.out.println("id"+userDetails.getId());
					System.out.println("password"+userDetails.getPassword());
					user=new RegisterManager(userDetails.getId(),userDetails.getName(),userDetails.getUserName(),userDetails.getPassword(),userDetails.getMobileNum(),userDetails.getCreatedDate(),userDetails.getModifiedDate(),userDetails.getEmail(),userDetails.getAddress());
				}
			}
		}catch(DBException e){
			e.printStackTrace();
		}
		return user;				
	}
	
}