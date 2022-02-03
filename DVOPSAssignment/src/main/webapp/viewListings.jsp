<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All listings</title>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
</head>
<body>
	<div class="row">
		<div class="container">
			<h3 class="text-center">All Listings</h3>
			<br>
			<form action="UserServlet" method="post">
					Sort By: 
					<select name="forma" onchange="location = this.value;">
						<option value="">Price</option>
						<option value="<%=request.getContextPath()%>/ListingServlet/sortPrice">Price asc</option> 
					</select>
				</form>
				<br>

<div class="card-deck">
			<c:forEach var="listing" items="${viewAllListing}">
				<div class="card" style="width: 18rem;">
					<img class="card-img-top" src="${listing.listingImage}"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">
							<c:out value="${listing.listingName}" />
						</h5>
						<ul class="card-text">
							<li>Price: <c:out value="${listing.listingPrice}" /></li>
							<li>Country of origin: <c:out
									value="${listing.listingCountry}" /></li>
							<li>Remarks: <c:out value="${listing.listingRemarks}" /></li>
						</ul>
						<a href="details?listingId=<c:out value='${listing.listingId}'/>" class="btn btn-info">Details</a>
										&nbsp;&nbsp;&nbsp;&nbsp;
					</div>
				</div>
				<br>
			</c:forEach>
</div>
		</div>
	</div>



</body>
</html>