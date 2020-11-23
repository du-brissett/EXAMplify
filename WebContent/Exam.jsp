<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.util.*" %>

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
<body>
<div class="container">
   <div class="row">
      <div class="col-xl-8 offset-xl-2 py-5">
      <h1>Exam</h1>
      <form id="contact-form" action="SubmitQuiz" method="post" role="form">
      <div class="row">
      <div class="col-md-6">
          <div class="form-group">
          <%
          session = request.getSession();
          String course = (String)session.getAttribute("quizCourse");
          System.out.print(course);
          String url = "jdbc:sqlserver://localhost\\SPECTRE:1433;database=EXAMplify;username=admin;password=Welcome2";
          String sql = "SELECT DISTINCT q.QuestionText FROM COURSE c INNER JOIN QUESTION q ON (c.courseCode = q.courseCode) INNER JOIN CHOICE ch ON (q.QuestionID = ch.QuestionID) WHERE c.courseCode = '" + session.getAttribute("quizCourse") + "'";
          try
          {
        	  	ArrayList<String> questions =  new ArrayList<>();
          		
        	  	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	  	Connection con = DriverManager.getConnection(url);
  		      	Statement stmt = con.createStatement();
  		      	
  		      	ResultSet rs = stmt.executeQuery(sql);
  		      	while (rs.next())
  		      	{
  		      		questions.add(rs.getString("QuestionText"));
  		      	}
  		      	 request.getSession().setAttribute("questions",questions);
	  	  		Iterator<String> it = questions.iterator();
	  	  		 
	  	  		while(it.hasNext())
	  	  		{
	  	  			String quest = it.next();
	  	  %>
	  	  			<label> <%=quest %> </label>
	  	  			<br>
	  	  <%
	  				Connection c = DriverManager.getConnection(url);
	  	  			PreparedStatement ps = c.prepareStatement("SELECT ch.ChoiceText FROM COURSE c INNER JOIN QUESTION q ON (c.courseCode = q.courseCode) INNER JOIN CHOICE ch ON (q.QuestionID = ch.QuestionID) WHERE q.QuestionText = ?");
	  	  			ps.setString(1, quest);
	  	  			ResultSet res = ps.executeQuery();
	  	  		
	  	  			while (res.next())
	  	  			{	  	
	  	  %>
	  	  			<label><input type="radio" required name="<%=quest %>" value="<%=res.getString("ChoiceText")%>"> <%=res.getString("ChoiceText")%></label>
	  	  			<br>
	  	  <%	
  		      		}
	  	  		}
          %>              
          </div>
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
            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Submit Quiz">
      </form>

      </div>
   </div>
</div>
</body>
</html>