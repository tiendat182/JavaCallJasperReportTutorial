package org.tutorial.javajasperreport.conn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Get connection from Oracle
 * 
 * @author DatLT
 *
 */
public class OracleConnUtils {

	/**
	 * Get oracle connection
	 * 
	 * @return Connection
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static Connection getOracleConnection() throws ClassNotFoundException, SQLException {
		String hostName = "localhost";
		String sid = "orcl";
		String userName = "learningsql";
		String password = "1234";

		return getOracleConnection(hostName, sid, userName, password);
	}

	/**
	 * Get oracle connection
	 * 
	 * @param hostName
	 * @param sid
	 * @param userName
	 * @param password
	 * @return Connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getOracleConnection(String hostName, String sid, String userName, String password)
			throws ClassNotFoundException, SQLException {
		String connectionUrl = "jdbc:oracle:thin:@" + hostName + ":1522:" + sid;
		Connection conn = DriverManager.getConnection(connectionUrl, userName, password);

		return conn;
	}
}
