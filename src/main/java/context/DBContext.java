package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
	private final static String serverName = "localhost";
	private final static String porNumber = "3306";
	private final static String databaseName = "ShoppingDB";
	private final static String userID = "DBC";
	private final static String password = "Nh@t0608";
	
	
	public static Connection getConnection() throws Exception  {
		String url = "jdbc:mysql://" + serverName + ":" + porNumber + "/" + databaseName;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, userID, password);
	}
	
}
