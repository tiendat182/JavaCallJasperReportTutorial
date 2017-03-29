package org.tutorial.javajasperreport.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Get connection information from MySql
 * 
 * @author DatLT
 */
public class MySQLConnUtils {

	/**
	 * Get MySql connection
	 * 
	 * @return connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
		String hostName = "localhost";
		String dbName = "learningsql";
		String userName = "root";
		String password = "18021988";

		return getMySQLConnection(hostName, dbName, userName, password);
	}

	/**
	 * Get MySql connection
	 * 
	 * @param hostName
	 * @param dbName
	 * @param userName
	 * @param password
	 * @return connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password)
			throws ClassNotFoundException, SQLException {
		String connectionUrl = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		Connection conn = DriverManager.getConnection(connectionUrl, userName, password);

		return conn;
	}
}
