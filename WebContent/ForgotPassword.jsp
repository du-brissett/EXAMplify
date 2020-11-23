<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<title>Register</title>
</head>
<body >
<div class="container-fluid" style="Margin-top:30px;">
<div class="card" style="width:1070px; margin-top:100px;
  margin-left:200px;">
  <div class="card-header text-center" style="width:1070px;" >
  ENTER VALID USER ID AND EMAIL
  </div>
  <div class="card-body" style="background-image: url(img/pas.jpg); background-repeat:no-repeat;background-size: contain;background-attachment:fixed; height:460px; width:100%;">
<form action="ForgotPassword" method="post">
<div class="form-row">
    <div class="col-md-4 mb-3">
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" style="margin-top:100px;" id="inputGroupPrepend2"><img src="bootstrap/icons/person-lines-fill.svg" alt="" width="22" height="24" title="Person"></span>
        </div>
        <input type="text" class="form-control" style="margin-top:100px;"   placeholder="Enter user ID" name="id" required>
      </div>
    </div>
</div>
<div class="form-row">
    <div class="col-md-4 mb-3">
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroupPrepend2"><img src="bootstrap/icons/person-lines-fill.svg" alt="" width="22" height="24" title="Person"></span>
        </div>
        <input type="email" class="form-control" placeholder="Enter email" name="email" required>
      </div>
    </div>
</div>
<input class="btn btn-primary" type="submit" style="background-color:#A4A4A4;" value="Submit">
</form>
</div>
 </div>
</div>
<div 
> </div>


</body>
</html>