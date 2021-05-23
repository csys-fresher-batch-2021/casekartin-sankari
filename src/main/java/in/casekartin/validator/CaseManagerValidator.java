package in.casekartin.validator;

import java.util.Set;

import javax.xml.bind.ValidationException;
import in.casekartin.model.CaseManager;
import in.casekartin.service.CaseManagerService;

public class CaseManagerValidator {
	private CaseManagerValidator()
	{
		//default constructor
	}

	/**
	 * check whether the case name has minimum 3 character and alphabets and it may has number
	 * @param caseName
	 * @return
	 * @throws ValidationException 
	 */

	public static boolean isCharAllowed(String caseName) throws ValidationException {
		boolean isValid=false;
		int i = 0;
		while ((i <= caseName.length() - 1)) {
			
			if (((caseName.charAt(i) >= 'A' && caseName.charAt(i) <= 'Z') 
					|| (caseName.charAt(i) >= 'a' && caseName.charAt(i) <= 'z') || caseName.charAt(i) == ' ')&&
					((caseName.length() >= 3))) 
			{
				isValid = true;
			}
			else
			{
				throw new ValidationException("Invalid Case Name");
			}
			i++;
		}
		
		return isValid;
	}
	/**
	 * check whether case name is already exist or not
	 * return caseName
	 * @param caseName
	 * @return
	 * @throws ValidationException 
	 */
	public static boolean isCaseNameNotExist(String caseName) throws ValidationException,Exception {
		Set<CaseManager> caseTypes = CaseManagerService.getCaseTypes();
		boolean searchCase =true;
		for (CaseManager cases : caseTypes) {
			if (cases.getCaseType().equalsIgnoreCase(caseName)) {
				searchCase=false;
				throw new ValidationException("Case Name is Already Exist");
			}
		}
	return searchCase;
	}
	/**
	 * check whether case name is already exist or not
	 * return caseName
	 * @param caseName
	 * @return
	 */
	public static boolean isCaseNameExist(String caseName) throws Exception{
		Set<CaseManager> caseTypes = CaseManagerService.getCaseTypes();
		boolean searchCase =false;
			for (CaseManager cases : caseTypes) {
				if (cases.getCaseType().equalsIgnoreCase(caseName)) {
					searchCase=true;
					return searchCase;
				}
			}
		return searchCase;
	}
}
