package in.casekartin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.casekartin.exception.DBException;


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
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Connection connection=null;

			
			//Step 1: Load the database driver in memory
			Class.forName(DRIVER_CLASS_NAME);
			
			//Step 2: Get the connection from database
			connection =  DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);

		return connection;
	}
	public static void close(Connection connection,PreparedStatement preparedStatement,ResultSet result) throws SQLException
	{

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
	}
	public static void close(Connection connection,PreparedStatement preparedStatement) throws SQLException
	{
			if(preparedStatement!=null)
			{
				preparedStatement.close();
			}
			if(connection!=null)
			{
				connection.close();
			}
	}

}
