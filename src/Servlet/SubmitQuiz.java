package Servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DBConnection;
import Model.User;

/**
 * Servlet implementation class SubmitQuiz
 */
@WebServlet("/SubmitQuiz")
public class SubmitQuiz extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	DBConnection db = new DBConnection();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubmitQuiz() 
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String course =  (String) request.getSession().getAttribute("quizCourse");
		User currentUser = (User) request.getSession().getAttribute("user");
		ArrayList<String> questionsFromJsp = (ArrayList<String>) request.getSession().getAttribute("questions");
		int marks = 0;
		String sql = "SELECT AnswerText FROM QUESTION WHERE QuestionText = ?";
		try (Connection con = db.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) 
		{
			for (String question : questionsFromJsp) 
			{
				stmt.setString(1, question);
								
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) 
				{
					if (rs.getString("AnswerText").equals(request.getParameter(question)))
						marks++;
				}
			}
			stmt.close();
			con.close();
			
			if (request.getSession().getAttribute("questionTotal") == null)
				request.getSession().setAttribute("questionTotal", questionsFromJsp.size());
			if (request.getSession().getAttribute("marks") == null)
				request.getSession().setAttribute("marks", marks);
			if (request.getSession().getAttribute("currentUser") == null)
				request.getSession().setAttribute("currentUser", currentUser.getId());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		response.sendRedirect("QuizResults.jsp");
		doGet(request, response);
	}

}
