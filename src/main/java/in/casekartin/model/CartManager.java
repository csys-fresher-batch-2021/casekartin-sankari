package in.casekartin.model;
import java.io.Serializable;

import lombok.Data;
@Data
public class CartManager implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -151346536930669831L;
	

	private String caseName;
	private String mobileBrand;
	private String mobileModel;
	private Float price;
	private String friendsName;
	private int noOfCases;
	private int orderId;

	

}
