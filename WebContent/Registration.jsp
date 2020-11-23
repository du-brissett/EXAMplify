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
<div class="container-fluid" >
<div class="card" style="background-color:#CEE3F6;">
  <div class="card-header text-center">
  REGISTRATION
  </div>
  <div class="card-body">
<form action="regController" method="post" oninput='conpword.setCustomValidity(conpword.value != pword.value ? "Passwords do not match." : "")'>
<div class="form-row">
    <div class="col-md-4 mb-3">
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroupPrepend2"><img src="bootstrap/icons/person-lines-fill.svg" alt="" width="22" height="24" title="Person"></span>
        </div>
        <input type="text" class="form-control" id="validationDefaultUsername" placeholder="First name" name="fname" required>
      </div>
    </div>
</div>
<div class="form-row">
    <div class="col-md-4 mb-3">
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroupPrepend2"><img src="bootstrap/icons/person-lines-fill.svg" alt="" width="22" height="24" title="Person"></span>
        </div>
        <input type="text" class="form-control" id="validationDefaultUsername" placeholder="Last name" name="lname" required>
      </div>
    </div>
</div>
<div class="form-row">
    <div class="col-md-4 mb-3">
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroupPrepend2"><img src="bootstrap/icons/envelope-fill.svg" alt="" width="22" height="24" title="Person"></span>
        </div>
        <input type="email" class="form-control" id="validationDefaultUsername" placeholder="Email" name="email" required>
      </div>
    </div>
</div>
<div class="form-row">
    <div class="col-md-4 mb-3">
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroupPrepend2"><img src="bootstrap/icons/card-heading.svg" alt="" width="22" height="24" title="Person"></span>
        </div>
        <input type="text" class="form-control" id="validationDefaultUsername" placeholder="College ID" name="id" required>
      </div>
    </div>
</div>
<div class="form-row">
    <div class="col-md-4 mb-3">
      <div class="input-group">
        <select class="form-control" id="selectRole" name="role">
	      <option value="" selected disabled>Select role. . .</option>
	      <option value="1">Student</option>
	      <option value="2">Instructor</option>
    	</select>
      </div>
    </div>
</div>
<div class="form-row">
    <div class="col-md-4 mb-3">
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroupPrepend2"><img src="bootstrap/icons/calendar-fill.svg" alt="" width="22" height="24" title="Person"></span>
        </div>
        <input type="text" class="form-control" id="validationDefaultDate" placeholder="DOB" name="dob" required>
      </div>
    </div>
</div>
<div class="form-row">
    <div class="col-md-4 mb-3">
      <div class="input-group">
        <select class="form-control" id="exampleFormControlSelect1" name="gender">
	      <option value="" selected disabled>Select gender. . .</option>
	      <option value="M">Male</option>
	      <option value="F">Female</option>
    	</select>
      </div>
    </div>
</div>
<div class="form-row">
    <div class="col-md-4 mb-3">
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroupPrepend2"><img src="bootstrap/icons/phone.svg" alt="" width="22" height="24" title="Person"></span>
        </div>
        <input type="text" class="form-control" id="validationDefaultUsername" placeholder="Contact #" name="phone" required>
      </div>
    </div>
</div>
<div class="form-row">
    <div class="col-md-4 mb-3">
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroupPrepend2"><img src="bootstrap/icons/pencil-square.svg" alt="" width="22" height="24" title="Person"></span>
        </div>
        <input type="password" class="form-control" id="validationDefaultUsername" placeholder="Password" name="pword" required>
      </div>
    </div>
</div>
<div class="form-row">
    <div class="col-md-4 mb-3">
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroupPrepend2"><img src="bootstrap/icons/pencil-square.svg" alt="" width="22" height="24" title="Person"></span>
        </div>
        <input type="password" class="form-control" id="validationDefaultUsername" placeholder="Confirm password" name="conpword">
      </div>
    </div>
</div>
<input class="btn btn-primary" type="submit" value="Register">
</form>
</div>
 </div>
</div>
</body>
</html>