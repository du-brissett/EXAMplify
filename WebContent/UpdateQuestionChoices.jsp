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
<title>Update Questions</title>
</head>
<body>
<div class="container-fluid">
<div class="card">
  <div class="card-header text-center">
  UPDATE QUESTIONS
  </div>
  <div class="card-body">
  <form action="selectController" method="post">
  <div class="form-row">
    <div class="col-md-10 mb-3">
      <div class="input-group">
        <select class="form-control" name="question">
	      <option value="" selected disabled>Select question. . .</option>
<%
	String url = "jdbc:sqlserver://localhost\\SPECTRE:1433;database=EXAMplify;username=admin;password=Welcome2";
	String sql = "SELECT QuestionText FROM QUESTION WHERE courseCode = '" + request.getSession().getAttribute("courseCode") + "'";
	try
    {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	Connection con = DriverManager.getConnection(url);
		Statement stmt = con.createStatement();
		      	
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next())
		{
%>
			<option value="<%=rs.getString("QuestionText")%>"><%=rs.getString("QuestionText")%></option>
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
<input class="btn btn-primary" type="submit" value="Select question">
</form>
</div>
</div>
</div>
</body>
</html>