package in.casekartin.validator;

import java.util.Set;
import java.util.regex.Pattern;

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
	public static boolean caseNameValidator(String caseName) {
		boolean isValid = false;
		if (!caseName.equals("null") && !caseName.trim().equals("") && Pattern.matches("[a-zA-Z0-9]{3,}", caseName)) {
			isValid = true;
		}
		return isValid;
	}

	/**
	 * check whether cost is greater than 100
	 * 
	 * @param cost
	 * @return
	 */
	public static boolean costValidator(Float cost) {
		boolean isValid = false;
		if (cost >0) {
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
	public static boolean isNotExist(String caseName) {
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