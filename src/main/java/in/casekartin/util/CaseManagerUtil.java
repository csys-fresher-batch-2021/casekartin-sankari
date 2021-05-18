package in.casekartin.util;

public class CaseManagerUtil {
	private CaseManagerUtil()
	{
		//default constructor
	}
	/**
	 * validate if name is null or not & if name is empty space or not
	 * 
	 * @param caseName
	 * @return
	 */
	public static boolean isValidCaseName(String name) {
		boolean isValid = false;
		if (!name.equals("null") && !name.trim().equals("")) {
			isValid = true;
		}
		return isValid;
	}
	/**
	 * check whether the case name has minimum 3 character and alphabets and it may has number
	 * @param caseName
	 * @return
	 */

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
}
