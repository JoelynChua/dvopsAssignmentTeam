<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> <c:out value='${listing.listingName}'/>'s Details </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/ListingServlet/viewListings"
				class="nav-link">Back</a></li>
		</ul>
	</nav>

	<div class="container col-md-12">
		<div class="card">
			<div class="card-body">	
			<div class="text-center">
					<h3>Name: <c:out value='${listing.listingName}'/></h1>
					<h4>Price (per time):<c:out value='${listing.listingPrice}' /></h3>
					<h4>Country of origin: <c:out value='${listing.listingCountry}' /></h3>
					<p>Remarks: <c:out value='${listing.listingRemarks}' /></p>	
					<img class="rounded" src="${listing.listingImage}" >
				</div>
			</div>
			<div class="text-center">
			<a href=# class="btn btn-danger btn-lg btn-block">Order Now!</a></td>
			<div>
		</div>
	</div>

</body>
</html>