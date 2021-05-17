package in.casekartin.validator;

import java.util.Set;

import in.casekartin.model.CaseManager;
import in.casekartin.service.CaseManagerService;

public class CaseManagerValidator {
	private CaseManagerValidator() {
		// default constructor
	}

	/**
	 * validate if case name is null or not & if case name is empty space or not
	 * check whether the case name has minimum 3 character,alphabets & numbers if
	 * case name is already exist or not
	 * 
	 * @param caseName
	 * @return
	 */
	public static boolean isValidCaseName(String caseName) {
		boolean isValid = false;
		if (!caseName.equals("null") && !caseName.trim().equals("") && isCharAllowed(caseName)) {
			isValid = true;
		}
		return isValid;
	}

	public static boolean isCharAllowed(String caseName) {
		boolean isValid = false;
		int i = 0;
		while ((i <= caseName.length() - 1) && (caseName.length() >= 3)) {
			if ((caseName.charAt(i) >= 'A' && caseName.charAt(i) <= 'Z')
					|| (caseName.charAt(i) >= 'a' && caseName.charAt(i) <= 'z') || caseName.charAt(i) == ' ') {
				isValid = true;
			}
			i++;
		}
		return isValid;
	}

	/**
	 * check whether cost is greater than 0
	 * 
	 * @param cost
	 * @return
	 */
	public static boolean isValidCost(Float cost) {
		boolean isValid = false;
		if (cost > 0) {
			isValid = true;
		}
		return isValid;
	}

	/**
	 * check whether case name is already exist or not
	 * 
	 * @param caseName
	 * @return
	 */
	public static boolean isCaseNameNotExist(String caseName) {
		Set<CaseManager> caseTypes = CaseManagerService.getCaseTypes();
		boolean isValid = true;

		for (CaseManager cases : caseTypes) {
			if (cases.getCaseType().equalsIgnoreCase(caseName)) {
				isValid = false;
			}
		}

		return isValid;

	}
}