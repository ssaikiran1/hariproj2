package com.ilp.ims.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	static final String DRIVER_NAME = "org.postgresql.Driver";
	static final String URL = "jdbc:postgresql://192.168.110.48/plf_training";
	static final String USERNAME = "plf_training_admin";
	static final String PASSWORD = "pff123";

	public static void closeConnection(Connection con) throws SQLException {
		if (con != null)
			con.close();
	}

	public static void closeStatement(PreparedStatement ps) throws SQLException {
		if (ps != null)
			ps.close();
	}

	public static void closeResultSet(ResultSet rs) throws SQLException {
		if (rs != null)
			rs.close();
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_NAME);
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return con;
	}

}
