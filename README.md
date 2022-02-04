# dvopsAssignmentTeam

Working CRUD for reviews.

Change line 56 in "AddReviewServlet.java" to own localhost.
Change line 25 in ReviewServlet.java" to own localhost.
#
Author: Koh Gerick
DB name: ecommerce
table name: reviews

fields for reviews table: 
reviewID(PK, AI) - int 50
userID - int 50
rating - int 1
review - varchar 255
#
Author: Pyae Sone
DB name: ecommerce
table name: users

fields for the users table:
user_id(PK, AI)
username
email
password
#
Author: Joelyn Chua
DB name: ecommerce
table name: proxylisting

fields for the users table:
listingId(PK, AI)
listingName
listingPrice
listingCountry
listingRemarks
listingImage
userId(FK)

Navigate link: 
create listing: http://localhost:8090/DVOPSAssignment/createListing.jsp
view listing: http://localhost:8090/DVOPSAssignment/ListingServlet/viewListings 
(update, delete and sort listing can be navigate from view listing page)



