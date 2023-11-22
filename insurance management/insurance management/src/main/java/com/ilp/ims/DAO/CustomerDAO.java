package com.ilp.ims.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.ilp.ims.Bean.Customer;
import com.ilp.ims.Util.DBConnection;

public class CustomerDAO {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// ******************************* REGISTER CUSTOMER *****************************

	public int registerCustomer(Customer customer) throws SQLException {

		int result = 0;
		java.util.Date utilDate = new java.util.Date();

		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(
					"INSERT INTO customer_details(Customer_Name, DOB, Email_Id, Address, Contact_No, PhotoId_Proof, PhotoId_Number, Address_Proof, Registration_Date, AddressId_Number) VALUES ( ?,?,?,?,?,?,?,?,?,?) RETURNING customer_id");
			ps.setString(1, customer.getCustomerName());
			ps.setDate(2, new java.sql.Date(customer.getDob().getTime()));
			ps.setString(3, customer.getEmail());
			ps.setString(4, customer.getAddress());
			ps.setLong(5, customer.getContactNo());
			ps.setString(6, customer.getPhotoIdProof());
			ps.setString(7, customer.getPhotoIdNo());
			ps.setString(8, customer.getAddressProof());
			ps.setDate(9, new java.sql.Date(utilDate.getTime()));
			ps.setString(10, customer.getAddressproofid());

			// Execute the INSERT statement and get the generated customer_id
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt("customer_id");
			}

			con.commit();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConnection(con);
		}
		return result;
	}

	// ************************** CHECK EMAIL ID EXISTENCE ***********************

	public boolean checkEmail(String email) throws SQLException {

		boolean check = false;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT EMAIL_ID FROM customer_details");
			ResultSet rs = ps.executeQuery();
			String s = null;

			while (rs.next()) {
				s = rs.getString("EMAIL_ID");
				if (s.equalsIgnoreCase(email))
					check = true;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConnection(con);
		}
		return check;
	}

	// ********************************* GET CUSTOMER DETAILS **************************

	public Customer getCustomerDetails(int customerId) {

		Customer customer = new Customer();
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(
					"SELECT CUSTOMER_ID,CUSTOMER_NAME,DOB,EMAIL_ID,ADDRESS,CONTACT_NO,PHOTOID_PROOF,PHOTOID_NUMBER,ADDRESS_PROOF,ADDRESSID_NUMBER,REGISTRATION_DATE FROM customer_details WHERE CUSTOMER_ID =?");
			ps.setInt(1, customerId);
			rs = ps.executeQuery();
			while (rs.next()) {
				customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
				customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
				customer.setDob(rs.getDate("DOB"));
				customer.setEmail(rs.getString("EMAIL_ID"));
				customer.setAddress(rs.getString("ADDRESS"));
				customer.setContactNo(rs.getLong("CONTACT_NO"));
				customer.setPhotoIdProof(rs.getString("PHOTOID_PROOF"));
				customer.setPhotoIdNo(rs.getString("PHOTOID_NUMBER"));
				customer.setAddressProof(rs.getString("ADDRESS_PROOF"));
				customer.setRegistrationDate(rs.getDate("REGISTRATION_DATE"));
				customer.setAddressproofid(rs.getString("ADDRESSID_NUMBER"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return customer;
	}

	// ****************************** UPDATE CUSTOMER DETAILS ***********************************

	public boolean updateCustomerDetails(Customer customer) throws SQLException {

		boolean update = false;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(
					"UPDATE customer_details SET CUSTOMER_NAME=?,DOB=?,EMAIL_ID=?,ADDRESS=?,CONTACT_NO=?,PHOTOID_PROOF=?,PHOTOID_NUMBER=?,ADDRESS_PROOF=?,addressid_NUMBER=?  WHERE CUSTOMER_ID =?");

			ps.setString(1, customer.getCustomerName());
			ps.setDate(2, new java.sql.Date(customer.getDob().getTime()));
			ps.setString(3, customer.getEmail());
			ps.setString(4, customer.getAddress());
			ps.setLong(5, customer.getContactNo());
			ps.setString(6, customer.getPhotoIdProof());
			ps.setString(7, customer.getPhotoIdNo());
			ps.setString(8, customer.getAddressProof());
			ps.setString(9, customer.getAddressproofid());
			ps.setInt(10, customer.getCustomerId());

			if (ps.executeUpdate() > 0) {
				System.out.println("Updation in DAO");
				update = true;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			DBConnection.closeStatement(ps);
			DBConnection.closeConnection(con);
		}
		return update;
	}

	// ****************************** VIEW CUSTOMER DETAILS *******************************

	public ArrayList<Customer> viewCustomerDetails(Date startDate, Date endDate) throws SQLException {

		ArrayList<Customer> custList = new ArrayList<Customer>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM customer_details WHERE REGISTRATION_DATE BETWEEN ? AND ? ");

			ps.setDate(1, new java.sql.Date(startDate.getTime()));
			ps.setDate(2, new java.sql.Date(endDate.getTime()));
			rs = ps.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getInt("CUSTOMER_ID"));
				customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
				customer.setDob(rs.getDate("DOB"));
				customer.setEmail(rs.getString("EMAIL_ID"));
				customer.setAddress(rs.getString("ADDRESS"));
				customer.setContactNo(rs.getLong("CONTACT_NO"));
				customer.setPhotoIdProof(rs.getString("PHOTOID_PROOF"));
				customer.setPhotoIdNo(rs.getString("PHOTOID_NUMBER"));
				customer.setAddressProof(rs.getString("ADDRESS_PROOF"));
				customer.setAddressproofid(rs.getString("ADDRESSID_number"));
				customer.setRegistrationDate(rs.getDate("REGISTRATION_DATE"));
				custList.add(customer);

			}
			System.out.println(custList.size());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			DBConnection.closeStatement(ps);
			DBConnection.closeConnection(con);
		}

		return custList;

	}

	// ******************************* DELETE CUSTOMER *************************************

	public boolean checkPolicyStatus(int customerId) throws SQLException {

		boolean status = true;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(
					"SELECT POLICY_STATUS FROM(SELECT INSURANCE.POLICY_STATUS, customer_details.CUSTOMER_ID FROM INSURANCE INNER JOIN customer_details ON customer_details.CUSTOMER_ID=INSURANCE.CUSTOMER_ID) WHERE CUSTOMER_ID=?");
			ps.setInt(1, customerId);
			System.out.println("Customer to be deleted: " + customerId);
			ResultSet rs = ps.executeQuery();
			String s = null;
			while (rs.next()) {
				s = rs.getString("POLICY_STATUS");
				System.out.println("POLICY STATUS: " + s);
				if (s.equalsIgnoreCase("ACTIVE")) {
					status = false;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeStatement(ps);
			DBConnection.closeConnection(con);
		}
		System.out.println(status);
		return status;
	}

	public boolean removeCustomer(int customerId) throws SQLException {

		PreparedStatement dps = null;
		Customer customer = getCustomerDetails(customerId);
		java.util.Date utilDate = new java.util.Date();

		boolean remove = false;
		try {
			con = DBConnection.getConnection();

			dps = con.prepareStatement("DELETE FROM customer_details WHERE CUSTOMER_ID=?");
			dps.setInt(1, customerId);

			remove = dps.execute();
			con.commit();
			dps.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			DBConnection.closeStatement(ps);
			DBConnection.closeConnection(con);
		}
		System.out.println(remove);
		if (!remove)
			return true;
		else
			return false;
	}

	// ************************** CHECK CUSTOMER ID EXISTENCE ***********************

	public boolean checkCustomerId(int customerId) throws SQLException {
		boolean check = false;
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement("SELECT CUSTOMER_ID FROM customer_details");
			ResultSet rs = ps.executeQuery();
			int s = 0;

			while (rs.next()) {
				s = rs.getInt(1);
				if (s == customerId) {
					check = true;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(ps);
			DBConnection.closeConnection(con);
		}
		return check;
	}
}
