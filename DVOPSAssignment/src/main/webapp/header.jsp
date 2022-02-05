<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
    </head>
    <body>
          <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">

      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/ListingServlet/viewListings">Your Listings</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/ReviewServlet/dashboard">Your Reviews</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Your Bookings</a>
      </li>
    </ul>
  </div>
    </body>
</html>