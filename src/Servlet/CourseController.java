package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DBConnection;

/**
 * Servlet implementation class CourseController
 */
@WebServlet("/CourseController")
public class CourseController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseController() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DBConnection con = new DBConnection();
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try (Connection c = con.getConnection(); CallableStatement stmt = c.prepareCall("{call sp_insertCourse (?, ?, ?)}"))
		{ 
			stmt.setString(1, request.getParameter("courseCode"));
			stmt.setString(2, request.getParameter("title"));
			stmt.setString(3, request.getParameter("courseDes"));
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