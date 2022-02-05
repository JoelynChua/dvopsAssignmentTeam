<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>


<html>

<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Welcome Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="css/account.css"/>

<link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.13.0/css/all.css"
      integrity="sha384-Bfad6CLCknfcloXFOyFnlgtENryhrpZCe29RTifKEixXQZ38WheV+i/6YWSzkz3V"
      crossorigin="anonymous"
    />
</head>

<body>

<%@ include file="header.jsp" %>

<div class="container">

 <div class="profile-content">
 
 <div class="profile-image">
 <i class="fas fa-user"></i>
 </div>
    <form action="user/update" method="post">
    <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" value="${currentUser.email}" name="email" aria-describedby="emailHelp" placeholder="Enter email">
    
    </div>
    <div class="form-group">
    <label for="exampleInputPassword1">Username</label>
    <input type="text" size="50" class="form-control" name="username" value="${currentUser.username}" placeholder="username">
    </div>
     <button type="submit" class="btn btn-primary" value="Call Servlet">Update</button>
</form>  
   <form action="user/logout" method="post">
   <button style="margin-top: 2%;" type="submit" class="btn btn-danger" value="Call Servlet">Logout</button>
   </form>

   </div>
     
     


</div>
</body>
<!--   
<div class="well">
    <ul class="nav nav-tabs">
      <li class="active"><a href="#home" data-toggle="tab">Profile</a></li>
      <li><a href="#profile" data-toggle="tab">Password</a></li>
    </ul>
    <div id="myTabContent" class="tab-content">
      <div class="tab-pane active in" id="home">
        <form id="tab">
          
            <label>Time Zone</label>

          	<div>
        	    <button class="btn btn-primary">Update</button>
        	</div>
        </form>
      </div>
      <div class="tab-pane fade" id="profile">
    	<form id="tab2">
        	<label>New Password</label>
        	<input type="password" class="input-xlarge">
        	<div>
        	    <button class="btn btn-primary">Update</button>
        	</div>
    	</form>
      </div>
  </div>
  
   </div>

    </div>
-->





</html>