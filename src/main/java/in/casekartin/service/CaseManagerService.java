package in.casekartin.service;

import java.util.HashSet;

import java.util.Set;

import in.casekartin.model.CaseManager;

public class CaseManagerService {

	private CaseManagerService() {
		// default constructor
	}

	/**
	 * Create the hash set for storing case types hash set is used to ignore the
	 * duplicate case types
	 */
	private static final Set<CaseManager> caseTypes = new HashSet<>();
	static {

		// add the case types with to the hash Map
		CaseManager case1 = new CaseManager("POLYCARBONATE", 300.0f);
		caseTypes.add(case1);
		CaseManager case2 = new CaseManager("LEATHER", 500.0f);
		caseTypes.add(case2);
		CaseManager case3 = new CaseManager("SILICONE", 200.0f);
		caseTypes.add(case3);
		CaseManager case4 = new CaseManager("HARD", 499.0f);
		caseTypes.add(case4);
		CaseManager case5 = new CaseManager("FRIENDS NAME TAG GLASS", 600.0f);
		caseTypes.add(case5);
		CaseManager case6 = new CaseManager("CSK CUSTOM", 599.0f);
		caseTypes.add(case6);
		CaseManager case7 = new CaseManager("NEON SAND GLOW", 749.0f);
		caseTypes.add(case7);

	}

	/**
	 * Return the case Types
	 * 
	 * @return
	 * @return
	 */
	public static Set<CaseManager> getCaseTypes() {
		return caseTypes;

	}

}
