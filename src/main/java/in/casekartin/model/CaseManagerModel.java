package in.casekartin.model;

public class CaseManagerModel {
	public String caseType;
	public Float cost;

	public CaseManagerModel(String caseType, Float cost) {
		super();
		this.caseType = caseType;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "CaseModel [caseType=" + caseType + ", cost=" + cost + "]";
	}
	
	

}
