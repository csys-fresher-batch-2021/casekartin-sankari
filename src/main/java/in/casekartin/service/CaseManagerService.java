package in.casekartin.service;

import java.util.Set;
import in.casekartin.dao.CaseManagerDAO;
import in.casekartin.exception.DBException;
import in.casekartin.exception.NumberException;
import in.casekartin.exception.ServiceException;
import in.casekartin.exception.StringException;
import in.casekartin.exception.ValidationException;
import in.casekartin.model.CaseManager;
import in.casekartin.util.StringNumberUtil;
import in.casekartin.validator.CaseManagerValidator;

public class CaseManagerService {
	
	private CaseManagerService() {
		// default constructor
	}

	/**
	 * method for add the case name
	 * 
	 * @param caseName
	 * @param cost
	 * @return 
	 * @throws ServiceException 
	 */
	public static boolean addCaseType(String caseName, String cost) throws ServiceException {
		boolean isAdded=false;
		Float price = Float.parseFloat(cost);
		try {
			StringNumberUtil.stringUtil(caseName);
			StringNumberUtil.positiveNumberUtil(price);
			CaseManagerValidator.isCharAllowed(caseName);
			CaseManagerValidator.isCaseNameNotExist(caseName);
			CaseManagerDAO.addCase(caseName, price);
			isAdded = true;
			
		} catch (StringException | NumberException | ValidationException e) {
			
			throw new ServiceException(e.getMessage(), e);
		}catch(DBException e){
			e.printStackTrace();
		}
		return isAdded;
	}

	/**
	 * method for delete the case name
	 * 
	 * @param caseName
	 * @param cost
	 * @return
	 * @throws Exception 
	 */
	public static boolean deleteCaseType(String caseName)  {
		boolean isDeleted = false;
		try {
			 
			if (CaseManagerValidator.isCaseNameExist(caseName)) {
				CaseManagerDAO.deleteCase(caseName);
				isDeleted = true;
			}
			
		} catch (DBException e) {
			e.printStackTrace();
		}
		return isDeleted;

	}
	/**
	 * Return the case Types
	 * 
	 * @return
	 * @return
	 * @throws Exception 
	 */
	public static Set<CaseManager> getCaseTypes()  {
		Set<CaseManager> caseTypes = null;
		try {
			caseTypes = CaseManagerDAO.listAllCases();
		} catch (DBException e) {
			e.printStackTrace();
		}
		return caseTypes;
	}

}
