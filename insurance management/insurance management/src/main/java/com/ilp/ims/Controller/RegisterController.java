package com.ilp.ims.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilp.ims.Service.RegistrationService;

@WebServlet("/RegisterController")

public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterController() {
		super();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Retrieve form parameters
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");

		// Create a service instance and call the method to handle registration
		RegistrationService registrationService = new RegistrationService();
		boolean registrationSuccess = registrationService.registerUser(name, password, userType);

		// Redirect to a page based on registration success or failure
		if (registrationSuccess) {
			response.sendRedirect("registration-success.jsp");
		} else {
			response.sendRedirect("registration-failure.jsp");
		}
	}
}
