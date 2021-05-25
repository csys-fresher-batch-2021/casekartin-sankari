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
	private static final String NULL_CONNECION = "Connecion is null";
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
	public static boolean addCase(String caseName, Float price) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
			// Get Connection
			boolean inserted = false;
			try {
				connection = ConnectionUtil.getConnection();
				// prepare data
				String sql = "insert into caseTypes(casename,price) values (?,?)";
				pst = connection.prepareStatement(sql);
				pst.setString(1, caseName);
				pst.setFloat(2, price);

				// Execute Query
				int rows = pst.executeUpdate();
				if(rows==1)
				{
					inserted=true;
				}
			} catch (ClassNotFoundException |SQLException e) {
				e.printStackTrace();
				throw new DBException("Unable to add case");
			} finally {
				try {
					ConnectionUtil.close(connection, pst);
				} catch (SQLException e) {
					throw new DBException(NULL_CONNECION,e);
				}
			}
			return inserted;
	}
	/**
	 * Retrieve all data from database table 
	 * @return
	 * @throws Exception
	 */
	public static Set<CaseManager> listAllCases() throws DBException {
		Set<CaseManager> caseTypes = new HashSet<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs=null;
		try {
			connection = ConnectionUtil.getConnection();
			// Retrieve data from table
			String sql = "select casename,price from caseTypes where status='active'";
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
		} catch (ClassNotFoundException |SQLException e) {
			throw new DBException("Unable to display case",e);
		}
		finally {
		try {
			ConnectionUtil.close(connection, pst, rs);
		} catch (SQLException e) {
			throw new DBException(NULL_CONNECION,e);
		}
		}
		return caseTypes;
	}
	/**
	 * Delete specific data in database
	 * @param caseName
	 * @return
	 * @throws Exception
	 */
	public static boolean deleteCase(String caseName) throws DBException {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			// Get Connection
			connection = ConnectionUtil.getConnection();
			// prepare data
			String sql = "update caseTypes set status='inactive' WHERE casename=?";
			
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
		} catch (ClassNotFoundException |SQLException e) {
			throw new DBException("Unable to delete case",e);
		}
		finally {
			try {
				ConnectionUtil.close(connection, pst);
			} catch (SQLException e) {
				throw new DBException(NULL_CONNECION,e);
			}
		}
		
	}
}
