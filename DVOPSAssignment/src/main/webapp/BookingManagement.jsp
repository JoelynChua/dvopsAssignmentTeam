<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>List of all Bookings</title>
</head>
<body>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Bookings</h3>
			<hr>
			<%@ include file="header.jsp" %>
			<div class="container text-left">
				<!-- Add new booking button redirects to the booking.jsp page -->
				<a href="<%=request.getContextPath()%>/Booking.jsp"
					class="btn btn-success">Place new Booking</a>
			</div>
			<br>
			<!-- Create a table to list out all current users information -->
			<table class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>card</th>
						<th>cvCode</th>
						<th>date</th>
						<th>phone</th>
						<th>location</th>
						<th>Actions</th>
					</tr>
				</thead>
				<!-- Pass in the list of users receive via the Servlet’s response to a loop
-->
				<tbody>
					<c:forEach var="booking" items="${listBookings}">
						<!-- For each user in the database, display their
information accordingly -->
						<tr>
							<td><c:out value="${booking.name}" /></td>
							<td><c:out value="${booking.card}" /></td>
							<td><c:out value="${booking.cvCode}" /></td>
							<td><c:out value="${booking.date}" /></td>
							<td><c:out value="${booking.phone}" /></td>
							<td><c:out value="${booking.location}" /></td>
							<!-- For each user in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
							<td><a href="edit?name=<c:out value='${booking.name}'
/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?name=<c:out
value='${booking.name}' />">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>