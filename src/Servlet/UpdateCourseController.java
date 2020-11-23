package Servlet;
import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DBConnection;

/**
 * Servlet implementation class UpdateCourseController
 */
@WebServlet("/UpdateCourseController")
public class UpdateCourseController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCourseController() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Course updated successfully');");
		out.println("location='UpdateCourse.jsp';");
		out.println("</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String sql = "{call sp_updateCourse (?, ?, ?)}";
		DBConnection con = new DBConnection();
		
		try (Connection c = con.getConnection(); CallableStatement stmt = c.prepareCall(sql))
		{ 
			stmt.setString(1, request.getParameter("course"));
			stmt.setString(2, request.getParameter("name"));
			stmt.setString(3, request.getParameter("description"));
				
			stmt.execute();
			stmt.close();
			c.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		response.sendRedirect("Admin.jsp");
		doGet(request, response);
	}
}
