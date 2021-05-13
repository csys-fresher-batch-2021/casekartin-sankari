package in.casekartin.validator;

import java.util.Set;
import java.util.regex.Pattern;

import in.casekartin.model.CaseManager;
import in.casekartin.service.CaseManagerService;

public class CaseManagerValidator {
	/**
	 * validate if case name is null or not & if case name is empty space or not 
	 * check whether the case name has minimum 3 character,alphabets & numbers 
	 * if case name is already exist or not
	 * 
	 * @param caseName
	 * @return
	 */
	public static boolean caseNameValidator(String caseName) {
		if (!caseName.equals("null") && !caseName.trim().equals("") && Pattern.matches("[a-zA-Z0-9]{3,}", caseName)) {
			return true;
		}
		return false;
	}

	/**
	 * check whether cost is greater than 100
	 * 
	 * @param cost
	 * @return
	 */
	public static boolean costValidator(Float cost) {
		if (cost >= 100) {
			return true;
		}
		return false;
	}

	/**
	 * check whether case name is already exist or not
	 * 
	 * @param caseName
	 * @return
	 */
	public static boolean isNotExist(String caseName) {
		Set<CaseManager> caseTypes = CaseManagerService.getCaseTypes();
		for (CaseManager cases : caseTypes) {
			if (cases.getCaseType().equalsIgnoreCase(caseName)) {
				throw new RuntimeException("Case Name is Already Exist");
			}
		}
		return true;
	}
}