package in.casekartin.util;

import in.casekartin.Exception.NumberException;
import in.casekartin.Exception.StringException;

public class StringNumberUtil {
	private StringNumberUtil() {
		// default constructor
	}

	/**
	 * validate if name is null or not & if name is empty space or not
	 * 
	 * @param caseName
	 * @return
	 * @throws StringException
	 */
	public static boolean stringUtil(String name) throws StringException {
		boolean isValid = false;
		if (!name.equals("null") && !name.trim().equals("")) {
			isValid = true;
			return isValid;
		} else {
			throw new StringException("Invalid Case Name");
		}

	}

	/**
	 * check whether cost is greater than 0
	 * 
	 * @param cost
	 * @return
	 */
	public static boolean positiveNumberUtil(Float cost) throws NumberException {
		boolean isValid;
		if (cost > 0) {
			isValid = true;
			return isValid;
		} else {
			throw new NumberException("Invalid Cost");
		}
	}
}
