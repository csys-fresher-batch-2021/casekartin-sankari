package in.casekartin.model;

public class CaseManagerModel {
	public String caseType;
	public Float cost;
	//Create constructor for domain class
	public CaseManagerModel(String caseType, Float cost) {
		super();
		this.caseType = caseType;
		this.cost = cost;
	}
	
	//to string method is used to return the case Types
	@Override
	public String toString() {
		return "CaseManagerModel [caseType=" + caseType + ", cost=" + cost + "]";
	}

}
