<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0);
%>
<%
if(request.getSession(false).getAttribute("type")==null)
{
%>
<jsp:forward page="Login.jsp"></jsp:forward>
<%} %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="	 charset=utf-8" />
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="icon" href="images/favicon.ico" type="image/x-icon" />
</head>

<body>
	<jsp:directive.include file="header.jsp" />

	<div class="content">
		<br />
		<% if(request.getSession(false).getAttribute("type").toString().equalsIgnoreCase("INSURANCE OFFICER"))
        { %>

		<div class="welcome_row_sub">
			<h2>Policy</h2>
			<table width="282" style="margin-top: -23px;">
				<tr>
					<td><a href="addHealthPolicy.jsp">Add Health Policy</a></td>
				</tr>
				<tr>
					<td><a href="updatePolicy.jsp">Update Policy</a></td>
				</tr>
				<tr>
					<td><a href="viewPolicy.jsp">View Policy</a></td>
				</tr>
				<tr>
					<td><a href="terminatePolicy.jsp">Terminate Policy</a></td>
				</tr>
			</table>
		</div>

		<div class="row">
			<div class="welcome_row_sub">
				<h2>Customer</h2>
				<table width="282" style="margin-top: -23px;">
					<tr>
						<td><a href="addCustomer.jsp">Register Customer</a></td>
					</tr>
					<tr>
						<td><a href="updateCustomer.jsp">Update Customer</a></td>
					</tr>
					<tr>
						<td><a href="viewCustomer.jsp">View Customer</a></td>
					</tr>
					<tr>
						<td><a href="removeCustomer.jsp">Remove Customer</a></td>
					</tr>
				</table>
			</div>

			<div class="row_1">
				<div class="welcome_row_sub">
					<h2>Claim</h2>
					<table width="282" style="margin-top: -23px;">
						<tr>
							<td><a href="approveClaim.jsp">Approve/Reject Claim</a></td>
						</tr>
						<tr>
							<td><a href="ViewClaim.jsp">View Claim</a></td>
						</tr>
					</table>
				</div>
			</div>
			<%} 
   else{
   %>

			<div class="basic-grey" style="text-align: center;">
				<table width="282" style="margin-top: -23px; display: inline-block;">
					<tr>
						<td>
							<form action="InsuranceController?test=-1" method="post">
								<input type="submit" value="View All Policies">
							</form>
						</td>
					</tr>
				</table>
			</div>

			<div class="basic-grey" style="text-align: center;">
				<table width="282" style="margin-top: -23px; display: inline-block;">
					<tr>
						<td>
							<form action="applyClaim.jsp" method="post">
								<input type="submit" value="Apply Claim">
							</form>
						</td>
					</tr>
				</table>
			</div>

			<div class="basic-grey" style="text-align: center;">
				<table width="282" style="margin-top: -23px; display: inline-block;">
					<tr>
						<td>
							<form action="updateClaim.jsp" method="post">
								<input type="submit" value="Update Claim">
							</form>
						</td>
					</tr>
				</table>
			</div>



			<%} %>

		</div>
		<jsp:directive.include file="footer.jsp" />
</body>
</html>