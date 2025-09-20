package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private final String serverName = "DESKTOP-0UI0TDB\\SQLEXPRESS";
	private final String dbName = "LAPTRINHWEB";
	private final String portNumber = "1433";
	private final String instance = "";
//	private final String userID = "";
//	private final String password = "";
	
	// Kết nối SQL Server với Windows Authentication
	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName
				+ ";encrypt=true;trustServerCertificate=true;integratedSecurity=true;databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + 	";encrypt=true;trustServerCertificate=true;integratedSecurity=true;databaseName="
					+ dbName;
		// DriverManager.registerDriver(new
		// com.mic
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url);
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(new DBConnect().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
