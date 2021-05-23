package in.casekartin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import in.casekartin.model.CaseManager;
import in.casekartin.util.ConnectionUtil;

public class CaseManagerDAO {
	private CaseManagerDAO(){
		//default constructor
	}
	/**
	 * add the case name and price to database
	 * @param caseName
	 * @param price
	 * @return
	 * @throws Exception
	 */
	public static boolean addCase(String caseName, Float price) throws Exception {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			// Get Connection
			connection = ConnectionUtil.getConnection();
			// prepare data
			String sql = "insert into caseTypes(casename,price) values (?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, caseName);
			pst.setFloat(2, price);

			// Execute Query
			int rows = pst.executeUpdate();
			boolean inserted = false;
			if(rows==1)
			{
				inserted=true;
			}
			return inserted;
		} catch (Exception e) {
			throw new Exception("Unable to add case");
		} finally {
			ConnectionUtil.close(connection, pst);
		}
	}
	/**
	 * Retrieve all data from database table 
	 * @return
	 * @throws Exception
	 */
	public static Set<CaseManager> listAllCases() throws Exception {
		Set<CaseManager> caseTypes = new HashSet<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = ConnectionUtil.getConnection();
		// Retrieve data from table
		String sql = "select casename,price from caseTypes";
		preparedStatement = connection.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			String caseName = rs.getString("casename");
			Float price = rs.getFloat("price");

			// Store the data in model
			CaseManager product = new CaseManager(caseName, price);
			// Store all products in list
			caseTypes.add(product);
		}
		ConnectionUtil.close(connection, preparedStatement, rs);
		return caseTypes;
	}
	/**
	 * Delete specific data in database
	 * @param caseName
	 * @return
	 * @throws Exception
	 */
	public static boolean deleteCase(String caseName) throws Exception {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			// Get Connection
			connection = ConnectionUtil.getConnection();
			// prepare data
			String sql = "delete from caseTypes where casename=?";
			
			// Execute Query
			pst = connection.prepareStatement(sql);
			pst.setString(1, caseName);
			int rows = pst.executeUpdate();
			boolean deleted = false;
			if(rows==1)
			{
				deleted=true;
			}
			return deleted;
		} catch (Exception e) {
			throw new Exception("Unable to delete case");
		}
		finally {
			ConnectionUtil.close(connection, pst);
		}
		
	}
}
