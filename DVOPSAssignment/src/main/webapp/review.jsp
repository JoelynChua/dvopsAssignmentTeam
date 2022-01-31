<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddReviewServlet" method="post">
	UserID: <input type= "text" name="userID">
	Rating (1-5): <input type= "text" name="rating">
	Review: <input type= "text" name="review">
	<input type="submit" value="Add review"/>
</form>
</body>
</html>