<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sorted by Price</title>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<div class="row">
		<div class="container">
			<h3 class="text-center">Price in ascending order</h3>
			<br>

			<div class="card text-center">
				<c:forEach var="listing" items="${listingPriceSorted}">
					<div class="card-header card-title">
						<c:out value="${listing.listingName}" />
					</div>
					<div class="card-body">
						<img class="bg obj-fit-cover rounded mx-auto d-block col-md-6 row" src="${listing.listingImage}"
							alt="...">
						<ul class="card-text remove">
							<li>Price: <c:out value="${listing.listingPrice}" /></li>
							<li>Country of origin: <c:out
									value="${listing.listingCountry}" /></li>
							<li>Remarks: <c:out value="${listing.listingRemarks}" /></li>
						</ul>
					</div>
					<div class="card-footer text-muted">
					<a href="details?listingId=<c:out value='${listing.listingId}'/>" class="btn btn-info">Details</a>
										&nbsp;&nbsp;&nbsp;&nbsp;
					</div>
					<br>
				</c:forEach>
			</div>

		</div>
	</div>
</body>
</html>