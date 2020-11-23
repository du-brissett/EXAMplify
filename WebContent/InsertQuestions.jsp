<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.util.*" %>

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
<title>Add To Question Bank</title>
</head>
<body>
<div class="container-fluid">
<div class="card">
  <div class="card-header text-center">
  ADD TO QUESTION BANK
  </div>
  <div class="card-body">
<form action="QuestionController" method="post">
<div class="form-row">
    <div class="col-md-4 mb-3">
      <div class="input-group">
        <select class="form-control" name="course">
	      <option value="" selected disabled>Select course. . .</option>
      <%
      	 String url = "jdbc:sqlserver://localhost\\SPECTRE:1433;database=EXAMplify;username=admin;password=Welcome2";
      	 String sql = "SELECT courseCode, courseName FROM COURSE";
         try
         {
       	  		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       	  		Connection con = DriverManager.getConnection(url);
 		      	Statement stmt = con.createStatement();
 		      	
 		      	ResultSet rs = stmt.executeQuery(sql);
 		      	while (rs.next())
 		      	{
	  	  %>
	     	<option value="<%=rs.getString("courseCode")%>"><%=rs.getString("courseName")%></option>
	     <%
 		      	}
 		 %>
    	</select>
    	<%
	    	rs.close();
	        stmt.close();
	        con.close();
         }
         catch(Exception e)
         {
      	 	e.printStackTrace();
         }
    	%>
      </div>
    </div>
</div>
<div class="form-row">
    <div class="col-md-4 mb-3">
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroupPrepend2"><img src="bootstrap/icons/pencil-square.svg" alt="" width="22" height="24" title="Person"></span>
        </div>
        <textarea name="question" class="form-control" placeholder="Enter question text" rows="3" required></textarea>
      </div>
    </div>
</div>
<div class="form-row">
    <div class="col-md-4 mb-3">
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroupPrepend2"><img src="bootstrap/icons/pencil-square.svg" alt="" width="22" height="24" title="Person"></span>
        </div>
        <input type="text" class="form-control" placeholder="Enter answer text" name="answer">
      </div>
    </div>
</div>
<div class="form-row">
    <div class="col-md-4 mb-3">
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroupPrepend2"><img src="bootstrap/icons/pencil-square.svg" alt="" width="22" height="24" title="Person"></span>
        </div>
        <input type="text" class="form-control" placeholder="Enter question option" name="option1">
      </div>
    </div>
</div>
<div class="form-row">
    <div class="col-md-4 mb-3">
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroupPrepend2"><img src="bootstrap/icons/pencil-square.svg" alt="" width="22" height="24" title="Person"></span>
        </div>
        <input type="text" class="form-control" placeholder="Enter question option" name="option2">
      </div>
    </div>
</div>
<div class="form-row">
    <div class="col-md-4 mb-3">
      <div class="input-group">
        <div class="input-group-prepend">
          <span class="input-group-text" id="inputGroupPrepend2"><img src="bootstrap/icons/pencil-square.svg" alt="" width="22" height="24" title="Person"></span>
        </div>
        <input type="text" class="form-control" placeholder="Enter question option" name="option3">
      </div>
    </div>
</div>
<input class="btn btn-primary" type="submit" value="Submit Question">
</form>
</div>
 </div>
</div>
</body>
</html>