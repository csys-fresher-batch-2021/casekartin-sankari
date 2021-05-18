package in.casekartin.validator;

import java.util.Set;

import in.casekartin.dao.CaseManagerDAO;
import in.casekartin.model.CaseManager;

public class CaseManagerValidator {
	private CaseManagerValidator()
	{
		//default constructor
	}

	/**
	 * check whether case name is already exist or not
	 * 
	 * @param caseName
	 * @return
	 */
	public static boolean isCaseNameNotExist(String caseName) {
		Set<CaseManager> caseTypes = CaseManagerDAO.getCaseTypes();
		boolean isValid = true;

		for (CaseManager cases : caseTypes) {
			if (cases.getCaseType().equalsIgnoreCase(caseName)) {
				isValid = false;
			}
		}

		return isValid;

	}
}