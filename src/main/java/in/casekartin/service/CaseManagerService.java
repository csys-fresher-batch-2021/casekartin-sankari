package in.casekartin.service;

import java.util.Set;
import javax.xml.bind.ValidationException;
import in.casekartin.Exception.NumberException;
import in.casekartin.Exception.ServiceException;
import in.casekartin.Exception.StringException;
import in.casekartin.dao.CaseManagerDAO1;
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
	public static boolean addCaseType(String caseName, String cost) throws ServiceException,Exception {
		boolean isAdded;
		Float price = Float.parseFloat(cost);
		try {
			StringNumberUtil.stringUtil(caseName);
			StringNumberUtil.positiveNumberUtil(price);
			CaseManagerValidator.isCharAllowed(caseName);
			CaseManagerValidator.isCaseNameNotExist(caseName);
			CaseManagerDAO1.addCase(caseName, price);
			isAdded = true;
			return isAdded;
		} catch (StringException | NumberException | ValidationException e) {
			
			throw new ServiceException(e.getMessage(), e);

		}
	}

	/**
	 * method for delete the case name
	 * 
	 * @param caseName
	 * @param cost
	 * @return
	 * @throws Exception 
	 */
	public static boolean deleteCaseType(String caseName) throws Exception {
		boolean isDeleted = false; 
		if (CaseManagerValidator.isCaseNameExist(caseName)) {
			CaseManagerDAO1.deleteCase(caseName);
			isDeleted = true;
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
	public static Set<CaseManager> getCaseTypes() throws Exception {
		Set<CaseManager> caseTypes = CaseManagerDAO1.listAllCases();
		return caseTypes;

	}

}
