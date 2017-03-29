package org.tutorial.javajasperreport.conn;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Get connection
 * 
 * @author DatLT
 *
 */
public class ConnectionUtils {

	/**
	 * Get connection
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		// Get Oracle connection
		return OracleConnUtils.getOracleConnection();

		// Get MySql connection
		// return MySQLConnUtils.getMySQLConnection();
	}

	// Test connection
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("Get connection ... ");
		// Get connection from Database
		Connection conn = ConnectionUtils.getConnection();
		System.out.println("Get connection " + conn);
		System.out.println("Done!");
	}
}
