package in.casekartin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import in.casekartin.exception.DBException;
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
	public static boolean addCase(String caseName, Float price) throws SQLException,DBException {
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
			throw new SQLException("Unable to add case");
		} finally {
			ConnectionUtil.close(connection, pst);
		}
	}
	/**
	 * Retrieve all data from database table 
	 * @return
	 * @throws Exception
	 */
	public static Set<CaseManager> listAllCases() throws DBException,SQLException {
		Set<CaseManager> caseTypes = new HashSet<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs=null;
		try {
			connection = ConnectionUtil.getConnection();
			// Retrieve data from table
			String sql = "select casename,price from caseTypes";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String caseName = rs.getString("casename");
				Float price = rs.getFloat("price");

				// Store the data in model
				CaseManager product = new CaseManager(caseName, price);
				// Store all products in list
				caseTypes.add(product);
			}
		} catch (Exception e) {
			throw new SQLException("Unable to display case");
		}
		finally {
		ConnectionUtil.close(connection, pst, rs);
		}
		return caseTypes;
	}
	/**
	 * Delete specific data in database
	 * @param caseName
	 * @return
	 * @throws Exception
	 */
	public static boolean deleteCase(String caseName) throws DBException,SQLException {
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
			throw new SQLException("Unable to delete case");
		}
		finally {
			ConnectionUtil.close(connection, pst);
		}
		
	}
}
