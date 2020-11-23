<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<style type="text/css">
	<%@include file="bootstrap/css/bootstrap.min.css" %>
	<%@include file="css/index-style.css" %>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</style>
<title>Success</title>
</head>
<body>
<div class="card">
  <div class="card-header">
    Success!
  </div>
  <div class="card-body">
    <h5 class="card-title">Login test</h5>
    <p class="card-text">More work to be done</p>
    Logged in as a <%=request.getSession().getAttribute("profile") %>
  </div>
</div>
</body>
</html>