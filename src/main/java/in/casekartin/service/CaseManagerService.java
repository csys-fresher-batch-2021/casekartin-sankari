package in.casekartin.service;

import in.casekartin.dao.CaseManagerDAO;
public class CaseManagerService {

	/**
	 * method for add the case name
	 * 
	 * @param caseName
	 * @param cost
	 * @return
	 */
	public static boolean addCaseType(String caseName, String cost) {
		boolean isAdded=false;
		if(CaseManagerDAO.addCase(caseName,cost))
		{
			isAdded=true;		
		}
		return isAdded;
	}
	/**
	 * method for delete the case name
	 * 
	 * @param caseName
	 * @param cost
	 * @return
	 */
	public static boolean deleteCaseType(String caseName) {
		boolean isDeleted = false;
		if(CaseManagerDAO.deleteCase(caseName))
		{
			isDeleted=true;
		}
		return isDeleted;

	}

}
