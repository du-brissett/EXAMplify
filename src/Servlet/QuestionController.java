package Servlet;
import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuestionController
 */
@WebServlet("/QuestionController")
public class QuestionController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionController() 
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
		String url = "jdbc:sqlserver://localhost\\SPECTRE:1433;database=EXAMplify;username=admin;password=Welcome2";
		
		try 
		{ 
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url); 
			String sql = "{call sp_insertQuestionChoices (?, ?, ?, ?, ?, ?, ?)}";
			CallableStatement stmt = con.prepareCall(sql);
			stmt.setString(1, request.getParameter("question"));
			stmt.setString(2, request.getParameter("option1"));
			stmt.setString(3, request.getParameter("option2"));
			stmt.setString(4, request.getParameter("option3"));
			stmt.setString(5, request.getParameter("answer"));
			stmt.setString(6, request.getParameter("answer"));
			stmt.setString(7, request.getParameter("course"));
			
			stmt.execute();
			stmt.close();
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		response.sendRedirect("Admin.jsp");
		doGet(request, response);
	}
}
