<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.text.*" %>

<!DOCTYPE html>
<html lang="en">
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
<title>Quiz Results</title>
</head>
<body>
<div class="container-fluid">
<div class="jumbotron">
  <h1 class="display-4">The results are in....</h1>
  <p class="lead"> <%= request.getSession().getAttribute("currentUser")%>, </p>
  <hr class="my-4">
<%
	DecimalFormat df = new DecimalFormat("#.##");
	double score = Double.parseDouble(request.getSession().getAttribute("marks").toString()) / Double.parseDouble(request.getSession().getAttribute("questionTotal").toString()) * 100;
%>
  <p>You scored <%=score %>% </p>
</div>
</div>
</body>
</html>