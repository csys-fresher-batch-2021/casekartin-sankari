package in.casekartin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionUtil {
	private ConnectionUtil()
	{
		//default constructor
	}

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
			throw new Exception("Unable to connect database");
		} 
		return connection;
	}
	public static void close(Connection connection,PreparedStatement preparedStatement,ResultSet result) throws Exception
	{
		
		try {
			if(result!=null)
			{
				result.close();
			}
			if(preparedStatement!=null)
			{
				preparedStatement.close();
			}
			if(connection!=null)
			{
				connection.close();
			}
		} catch (Exception e) {
			throw new Exception("Connection is not closed");
		}
	}
	public static void close(Connection connection,PreparedStatement preparedStatement) throws Exception
	{
		try {
			if(preparedStatement!=null)
			{
				preparedStatement.close();
			}
			if(connection!=null)
			{
				connection.close();
			}
		} catch (Exception e) {
			throw new Exception("Connection is not closed");
		}	
	}

}
