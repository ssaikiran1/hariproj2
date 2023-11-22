<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>home</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="icon" href="images/favicon.ico" type="image/x-icon" />
<script type="text/javascript" src="js/validate.js"></script>
<link href="css/js-image-slider.css" rel="stylesheet" type="text/css" />
<script src="js/js-image-slider.js" type="text/javascript"></script>
<link href="css/generic.css" rel="stylesheet" type="text/css" />

</head>
<body>

	<jsp:directive.include file="header.jsp" />
	<div class="content_home">
		
		<br>
		<div class="row">
			<div class="home_row_1" >

				<div id="slider">
					<img
						src="images/image-slider-1.jpg" /> <img src="images/banner5.jpg" />
					<img src="images/insurance-comparison.jpg" /> <img
						src="images/1.jpg" /> <img src="images/4.jpg" />
				</div>
			</div>
			<div class="home_row_2" >
			<form method="post" name="register" action="RegisterController"
					class="home-registerForm" onsubmit="return validateForm()">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        
        <label for="userType">User Type:</label>
        <select id="userType" name="userType" required>
            <option value="Hospital Admin">Field User</option>
            <option value="Insurance Officer">Insurance Officer</option>
            <option value="Customer">User</option>
        </select><br>
        
        <input type="submit" value="Register">
    </form>
			</div>
			</div>
			
	</div>

	<br>

	<jsp:directive.include file="footer.jsp" />
</body>
</html>