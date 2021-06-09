package in.casekartin.service;

import java.util.List;

import in.casekartin.dao.CartManagerDAO;
import in.casekartin.exception.DBException;
import in.casekartin.exception.ServiceException;
import in.casekartin.exception.ValidationException;
import in.casekartin.model.CartManager;
import in.casekartin.util.StringNumberUtil;

public class CartManagerService {
	private CartManagerService() {
		//default Constructor
	}
	private static CartManagerDAO cartDAO=new CartManagerDAO();
	public static void addCartToBookedDetails(CartManager cart,String userName) throws ServiceException {
		
		try {
			StringNumberUtil.positiveNumberUtil(cart.getNoOfCases());
			cartDAO.save(cart,userName);
		} catch (ValidationException e) {
			throw new ServiceException(e.getMessage(),e);
		}
		
	}

	public static List<CartManager> listByUserName(String userName) throws ServiceException {
		List<CartManager> cartDetails=null;
		try {
			cartDetails=cartDAO.getDetailsByUserName(userName);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage(),e);
		}
		return cartDetails;
	}

}