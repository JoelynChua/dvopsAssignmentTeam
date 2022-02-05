<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Reviews</h3>
			<hr>
			<%@ include file="header.jsp" %>
			<div class="container text-left">
				<!-- Add new review button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>/review.jsp"
					class="btn btn-success">Add New Review</a>
			</div>
			<br>
			<!-- Create a table to list out all current reviews information -->
			<table class="table">
				<thead>
					<tr>
						<th>Review ID</th>
						<th>User ID</th>
						<th>Rating (1 of 5)</th>
						<th>Review</th>
					</tr>
				</thead>
				<!-- Pass in the list of reviews receive via the Servlet’s response to a loop -->
				<tbody>
					<c:forEach var="review" items="${listReviews}">
						<!-- For each review in the database, display their information accordingly -->
						<tr>
							<td><c:out value="${review.reviewID}" /></td>
							<td><c:out value="${review.userID}" /></td>
							<td><c:out value="${review.rating}" /></td>
							<td><c:out value="${review.review}" /></td>
							<!-- For each review in the database, Edit/Delete buttons which invokes the edit/delete functions -->
							<td><a href="edit?reviewID=<c:out value='${review.reviewID}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?reviewID=<c:out value='${review.reviewID}' />">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>