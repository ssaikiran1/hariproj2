<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.ilp.ims.Bean.*,java.util.ArrayList"%>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0);
if(request.getSession(false).getAttribute("type")==null){ %>
<jsp:forward page="Login.jsp" ></jsp:forward>
<% } %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About Us</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="icon" href="images/favicon.ico" type="image/x-icon" />
<script type="text/javascript" src="js/validate.js"></script>

</head>
<body>
<jsp:directive.include file="header.jsp" />
<jsp:directive.include file="navigation.jsp" />
<div class="content_about">

<h1>About Us</h1>
India Assurance Co. Ltd. facilitates the comparison of health insurance products to ensure that you can make informed decisions about your financial security. We have partnered with leading financial institutions offering health insurance plans in India, allowing you to receive free insurance quotes and compare plans based on various features. Our platform serves as your comprehensive resource for evaluating health insurance options in the country.

Health insurance is crucial for safeguarding your well-being, and our platform specializes in comparing different health insurance plans. You can explore and compare various health insurance or mediclaim plans offered by major insurance companies. We provide a one-stop solution for assessing and selecting the most suitable health insurance plan to meet your specific needs.

We understand the importance of comprehensive coverage, and our focus is specifically on health insurance. Our platform allows you to analyze and compare health insurance plans based on factors such as pricing, services, coverage duration, and more. By offering unbiased comparisons of health insurance products, we empower you to make well-informed decisions about your financial and health security.

We encourage you to take advantage of our platform to compare health insurance plans thoroughly. By doing so, you gain a better understanding of the offerings available in the market and can choose the health insurance plan that best aligns with your requirements. Our commitment to online systems and integrations with insurance companies ensures a seamless and cost-effective experience, making us one of the largest destinations for health insurance and financial services in the country.

Move ahead with confidence, as your financial and health security is just a few clicks away!
</div>

<br>

<jsp:directive.include file="footer.jsp" />
</body>
</html>