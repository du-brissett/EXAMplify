<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*, java.util.*, java.text.*,Model.User " errorPage="" %>

<%
	DateFormat df=new SimpleDateFormat("EEEE, dd MMMM, yyyy");
	String date=df.format(new java.util.Date());
	out.print(" | " + date + " | ");
	String flag = (String)session.getAttribute("flag");
	if("yes".equals(flag))
	{ 
		User u =(User)session.getAttribute("user");
		out.print(u.getFname());
	}
%>
