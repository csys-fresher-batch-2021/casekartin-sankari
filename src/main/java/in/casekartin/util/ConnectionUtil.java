package in.casekartin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionUtil {

	private static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
	private static final String DATABASE_NAME = "case";
	private static final String DB_USERNAME = "postgres";
	private static final String DB_PASSWORD = "Gsskh2k*";
	private static final String HOST = "localhost";
	private static final int PORT = 5433;
	private static final String DB_URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE_NAME;
	
	public static Connection getConnection() throws Exception{
		Connection connection=null;
		
		try {
			
			//Step 1: Load the database driver in memory
			Class.forName(DRIVER_CLASS_NAME);
			
			//Step 2: Get the connection from database
			connection =  DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect database");
		} 
		return connection;
	}
	public static void close(Connection connection,PreparedStatement pst,ResultSet rs) throws Exception
	{
		rs.close();
		pst.close();
		connection.close();
	}
	public static void close(Connection connection,PreparedStatement pst) throws Exception
	{
		pst.close();
		connection.close();
	}

}
