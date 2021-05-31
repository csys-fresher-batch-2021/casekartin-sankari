package in.casekartin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import in.casekartin.exception.DBException;
import in.casekartin.model.RegisterManager;
import in.casekartin.util.ConnectionUtil;

public class RegisterManagerDAO {
	
	/**
	 * Add the user details to table
	 * @param regDetails
	 * @return
	 * @throws DBException
	 */
	public boolean addRegDetails(RegisterManager regDetails) throws DBException{
		Connection connection=null;
		PreparedStatement pst = null;
		regDetails.setCreatedDate(LocalDate.now());
		regDetails.setModifiedDate(LocalDateTime.now());
		// Get Connection
		boolean inserted = false;
		try {
			connection = ConnectionUtil.getConnection();
			// prepare data
			String sql = "insert into userdetails (name,username,password,mobilenumber,createddate,modifieddate,email,address) values (?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1,regDetails.getName());
			pst.setString(2,regDetails.getUserName());
			pst.setString(3,regDetails.getPassword());
			pst.setLong(4,Long.parseLong(regDetails.getMobileNum()));
			pst.setDate(5,Date.valueOf(regDetails.getCreatedDate()));
			pst.setTimestamp(6,Timestamp.valueOf(regDetails.getModifiedDate()));
			pst.setString(7, regDetails.getEmail());
			pst.setString(8, regDetails.getAddress());
			
			// Execute Query
			int rows = pst.executeUpdate();
			if(rows==1)
			{
				inserted=true;
			}
		} catch (ClassNotFoundException |SQLException e) {
			throw new DBException("Unable to add Details");
		} finally {
			
				ConnectionUtil.close(connection, pst);
			
		}
		return inserted;
		
	}
	/**
	 * Retrieve all data from database table 
	 * @return
	 * @throws SQLException 
	 * @throws Exception
	 */
	public List<RegisterManager> getAllDetails() throws DBException {
		List<RegisterManager> listUserDetails = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs=null;
		try {
			connection = ConnectionUtil.getConnection();
			// Retrieve data from table
			String sql = "select * from userdetails";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				int id=rs.getInt("id");
				String name = rs.getString("name");
				String userName=rs.getString("username");
				String password=rs.getString("password");
				String mobileNum = String.valueOf(rs.getLong("mobilenumber"));
				LocalDate createdDate=rs.getDate("createddate").toLocalDate();
				LocalDateTime modifiedDate=rs.getTimestamp("modifieddate").toLocalDateTime();
				String email=rs.getString("email");
				String address=rs.getString("address");

				// Store the data in model
				RegisterManager userDetails = new RegisterManager(id,name,userName,password,mobileNum,createdDate,modifiedDate,email,address);
				// Store all products in list
				listUserDetails.add(userDetails);
			}
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to display case",e);
		}
		finally {
		
			ConnectionUtil.close(connection, pst, rs);
		}
		return listUserDetails;
	}
	
	public boolean isLoginVerified(String userName, String password) throws DBException {
		Connection connection=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		boolean isValidUser=false;
		try {
			connection = ConnectionUtil.getConnection();
			String query="select username from userdetails where username='?' and password='?";
			pst=connection.prepareStatement(query);
			pst.setString(1,userName);
			pst.setString(2,password);
			rs = pst.executeQuery();
			String userNameRs=rs.getString("username");
			if(userName.equals(userNameRs))
			{
				isValidUser=true;
				return isValidUser;
			}
		}catch(ClassNotFoundException |SQLException e){
			throw new DBException("Unable to retrive details");
		}finally {
			ConnectionUtil.close(connection,pst,rs);
		}
		return isValidUser;
		
	}
	

}
