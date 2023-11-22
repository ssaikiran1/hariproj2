package com.ilp.ims.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ilp.ims.Bean.Officer;
import com.ilp.ims.Util.DBConnection;

public class RegisterDAO {

	public static boolean registerUser(Officer officer) throws SQLException, ClassNotFoundException {
		PreparedStatement ps = null;
		Connection con = null;

		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("INSERT INTO Login (NAME, PASSWORD, OFFICER_TYPE) VALUES (?, ?, ?)");

			ps.setString(1, officer.getUserName());
			ps.setString(2, officer.getPassword());
			ps.setString(3, officer.getOfficerType());

			int rowsAffected = ps.executeUpdate();

			// Return true if at least one row was affected (success)
			return rowsAffected > 0;
		} finally {
			// Close resources in a finally block to ensure they are closed even if an
			// exception occurs
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}
}
