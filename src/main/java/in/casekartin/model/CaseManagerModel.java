package in.casekartin.model;

//create a service class
public class CaseManagerModel {
	public String getCaseType() {
		return caseType;
	}

	public Float getCost() {
		return cost;
	}

	private String caseType;
	private Float cost;

	//Create constructor for service class
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
