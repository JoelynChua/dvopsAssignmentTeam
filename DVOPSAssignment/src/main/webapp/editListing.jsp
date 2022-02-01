<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Edit listing </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/ListingServlet/viewListings"
				class="nav-link">Back</a></li>
		</ul>
	</nav>

	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
			
			<!-- Submit part -->
			   <c:if test="${listing != null}">
					<form action="update" method="post">
				</c:if>
				
				<c:if test="${listing == null}">
					<form action="insert" method="post">
				</c:if>				
				
				<!-- save the changes -->
				 <c:if test="${listing != null}">
					<input type="hidden" name="orilistingId" value="<c:out value= '${listing.listingId}'/>" >
				</c:if> 
				
				
				<fieldset class="form-group">
					<label>Listing Name</label> 
					<input type="text"
						value="<c:out value='${listing.listingName}' />" class="form-control" name="listingName" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Listing Price</label> 
					<input type="text" value="<c:out value='${listing.listingPrice}' />" class="form-control" name="listingPrice">
				</fieldset>

				<fieldset class="form-group">
					<label> Listing's country of origin </label> 
					<input type="text" value="<c:out value='${listing.listingCountry}' />" class="form-control" name="listingCountry" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label> Remarks </label> 
					<input type="text" value="<c:out value='${listing.listingRemarks}' />" class="form-control" name="listingRemarks">
				</fieldset>
				
				<fieldset class="form-group">
					<label> Listing Image </label> 
					<input type="text" value="<c:out value='${listing.listingImage}' />" class="form-control" name="listingImage">
				</fieldset>
				
				<fieldset class="form-group">
					<label> Author </label> 
					<input type="text" value="<c:out value='${listing.userId}' />" class="form-control" name="userId">
				</fieldset>

				<button type="submit" class="btn btn-success">Save Changes</button>
				</form>
		  </div>		
		</div>
	</div>


</body>
</html>