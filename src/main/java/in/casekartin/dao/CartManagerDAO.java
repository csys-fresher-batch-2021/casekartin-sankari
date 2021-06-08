package in.casekartin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import in.casekartin.exception.DBException;
import in.casekartin.model.CartManager;
import in.casekartin.util.ConnectionUtil;
public class CartManagerDAO {
	Connection connection = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private static JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	//Single Object Created 
	private static final CartManagerDAO cartManagerDAO = new CartManagerDAO();

	// I will return always same instance of the dao class
	public static CartManagerDAO getInstance() {
		return cartManagerDAO;
	}
	public boolean save(CartManager cartDetails,String userName) {
		System.out.println(jdbcTemplate);
		int userId = findIdByUserName(userName);
		Object[] params = { cartDetails.getCaseName(),cartDetails.getMobileBrand(),cartDetails.getMobileModel(),cartDetails.getNoOfCases(),userId,cartDetails.getPrice()};
		int rows = jdbcTemplate.update("insert into cart(casename,mobilebrand,mobilemodel,noofcases,user_id,price) values ( ?,?,?,?,?,?) ", params );
		return rows==1;
		
	}
	public List<CartManager> getDetailsByUserName(String userName) throws DBException {
		List<CartManager> listCartDetails= new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			int userId = findIdByUserName(userName);
			// Retrieve data from table
			String sql = "select * from cart as c inner join userdetails as u on c.user_id=u.id where u.id=?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1,userId);
			rs = pst.executeQuery();
			while (rs.next()) {
				// Store the data in model
				CartManager cartDetails =new CartManager();
				// Store all products in list
				cartDetails.setCaseName(rs.getString("casename"));
				cartDetails.setPrice(rs.getFloat("price"));
				cartDetails.setMobileBrand(rs.getString("mobilebrand"));
				cartDetails.setMobileModel(rs.getString("mobilemodel"));
				cartDetails.setNoOfCases(rs.getInt("noofcases"));
				listCartDetails.add(cartDetails);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to display details");
		} finally {

			ConnectionUtil.close(connection, pst, rs);
		}
		return listCartDetails;
	}
	private static int findIdByUserName(String userName) {
		String sql = "select id from userdetails where username = ?";
		Integer userId =jdbcTemplate.queryForObject(sql,Integer.class,userName);
		return userId;
	}
}
