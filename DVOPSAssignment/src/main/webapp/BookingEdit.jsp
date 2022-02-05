<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Booking Management Application </a>
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
				<c:if test="${booking != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${booking == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${booking != null}">
Edit Booking
</c:if>
						<c:if test="${booking == null}">
Add New Booking
</c:if>
					</h2>
				</caption>
				<c:if test="${booking != null}">
					<input type="hidden" name="oriName"
						value="<c:out
value='${booking.name}' />" />
				</c:if>
				<fieldset class="form-group">
					<label> Name</label> <input type="text"
						value="<c:out
value='${booking.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Debit/credit card</label> <input type="text"
						value="<c:out
value='${booking.card}' />" class="form-control"
						name="card">
				</fieldset>
				<fieldset class="form-group">
					<label>cv Code</label> <input type="text"
						value="<c:out
value='${booking.cvCode}' />" class="form-control"
						name="cvCode">
				</fieldset>
				<fieldset class="form-group">
					<label>Date</label> <input type="text"
						value="<c:out
value='${booking.date}' />" class="form-control"
						name="date">
				</fieldset>
				<fieldset class="form-group">
					<label>Phone</label> <input type="text"
						value="<c:out
value='${booking.phone}' />" class="form-control"
						name="phone">
				</fieldset>
				<fieldset class="form-group">
					<label>Location</label> <input type="text"
						value="<c:out
value='${booking.location}' />"
						class="form-control" name="location">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>