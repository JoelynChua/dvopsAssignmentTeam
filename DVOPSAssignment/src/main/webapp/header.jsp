<nav class="navbar navbar-expand-lg navbar-light bg-transparent">
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">

			<li class="nav-item"><a class="nav-link"
				href="<%=request.getContextPath()%>/ListingServlet/viewListings">
					Listings</a></li>
			<li class="nav-item"><a class="nav-link" id="ToReviews"
				href="<%=request.getContextPath()%>/ReviewServlet/dashboard">
					Reviews</a></li>
			<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/BookingManagementServlet/dashboard">
					Bookings</a></li>
			<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/user">
					Profile</a></li>
		</ul>
	</div>

</nav>