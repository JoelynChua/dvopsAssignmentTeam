<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
<title>Booking </title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Booking Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/BookingManagementServlet/dashboard"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
<form action = "BookingServlet" method ="post">
    <fieldset class="form-group">
	Name: <input type = "text" class="form-control" name ="name">
	</fieldset>
	<fieldset class="form-group">
	Debit/Credit Card: <input type = "number" class="form-control" name = "card">
	</fieldset>
	<fieldset class="form-group">
	CV Code: <input type = "number" class="form-control" name = "cvCode" >
	</fieldset>
	<fieldset class="form-group">
	Date: <input type = "Date" class="form-control" name = "date">
	</fieldset>
	<fieldset class="form-group">
	Contact Number: <input type = "number" class="form-control" name = "phone">
	</fieldset>
	<fieldset class="form-group">
	location: <input type = "text" class="form-control" name = "location">
	</fieldset>
	<input type ="submit" class="btn btn-success" value="Book Now" />
</form>
</div>
</div>
</div>
</body>
</html>