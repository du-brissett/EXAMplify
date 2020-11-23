<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<style type="text/css">
	<%@include file="bootstrap/css/bootstrap.min.css" %>
	<%@include file="css/signin-style.css" %>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/boot strap/4.4.1/js/bootstrap.min.js"></script>
</style>
<title>Sign In</title>
</head>
<body>
<div class="container-fluid">
<div class = "card text-center">	
	<div class="card-body">
	<img src="img/logo.png" alt="...">
	<form class="form-signin" action="LoginServlet" method="post">
  	  <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
	  <label for="inputEmail" class="sr-only">Email address</label>
	  <input type="text" id="inputEmail" class="form-control" placeholder="Username" name="user" required autofocus>
	  <label for="inputPassword" class="sr-only">Password</label>
	  <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="pass" required>
	  <div class="checkbox mb-3">
	  	New user? &nbsp;<a href="index.jsp">Register here</a><br>
	  	Forgot password? &nbsp;<a href="ForgotPassword.jsp">Reset password</a><br>
	  </div>
	  <input class="btn btn-lg btn-primary btn-block" type="submit" value="Sign in">
</form>
</div>
</div>
</div>
</body>
</html>