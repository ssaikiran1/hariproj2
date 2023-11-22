package com.ilp.ims.Service;

import java.sql.SQLException;

import com.ilp.ims.Bean.Officer;
import com.ilp.ims.DAO.RegisterDAO;

public class RegistrationService {
	private RegisterDAO registerDAO;

	public RegistrationService() {
		this.registerDAO = new RegisterDAO(); // Instantiate the DAO
	}

	public boolean registerUser(String name, String password, String userType) {
		// You can add business logic here if needed

		Officer off = new Officer();
		off.setUserName(name);
		off.setPassword(password);
		off.setOfficerType(userType);
		// Call DAO to insert data into the database
		try {
			return registerDAO.registerUser(off);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
