<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "BookingServlet" method ="post">
	Name: <input type = "text" name ="name">
	Debit/Credit Card: <input type = "number" name = "card">
	CV Code: <input type = "number" name = "cvCode" >
	Date: <input type = "Date" name = "date">
	Contact Number: <input type = "number" name = "phone">
	location: <input type = "text" name = "location">
	<input type ="submit" value="Call Servlet" />
</form>

</body>
</html>