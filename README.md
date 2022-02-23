# dvopsAssignmentTeam


Basic environment setup:
Tomcat Server port is 8090,
Jenkins Server port is 8080,
phpMyAdmin port is 3306.
everyone is using database named ecommerce.


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
Author: Kenneth
DB name: ecommerce
table name: booking

fields for the users table:
name(PK)
card
cvCode
date
phone
location 

#
Author: Joelyn Chua
DB name: ecommerce
table name: proxylisting

fields for the users table:
listingId(PK, AI) - int
listingName - varchar 50
listingPrice - decimal
listingCountry - text
listingRemarks - text
listingImage - varchar (2048)
userId(FK) - int
#

Starting Home Page: http://localhost:8090/DVOPSAssignment

Navigate link: 
login page: http://localhost:8090/DVOPSAssignment/login
register page: http://localhost:8090/DVOPSAssignment/
profile page: http://localhost:8090/DVOPSAssignment/user -- ONLY CAN ACCESS WHEN THE USER LOGS IN.

create listing: http://localhost:8090/DVOPSAssignment/createListing.jsp
view listing: http://localhost:8090/DVOPSAssignment/ListingServlet/viewListings 
(update, delete and sort listing can be navigate from view listing page)

view bookings: http://localhost:8090/DVOPSAssignment/BookingManagementServlet/dashboard
create booking: http://localhost:8090/DVOPSAssignment/Booking.jsp

view reviews: http://localhost:8090/DVOPSAssignment/ReviewServlet/dashboard
add review: http://localhost:8090/DVOPSAssignment/ReviewServlet/dashboard


