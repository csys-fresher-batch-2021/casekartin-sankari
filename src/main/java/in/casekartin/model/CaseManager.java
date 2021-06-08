package in.casekartin.model;

//create a service class
public class CaseManager {
	public String getCaseType() {
		return caseType;
	}

	public Float getCost() {
		return cost;
	}

	private String caseType;
	private Float cost;
	private String status;

	public String getStatus() {
		return status;
	}

	// Create constructor for service class
	public CaseManager(String caseType, Float cost,String status) {
		super();
		this.caseType = caseType;
		this.cost = cost;
		this.status=status;
	}

}
