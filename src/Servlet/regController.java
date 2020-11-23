package Servlet;
import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DBConnection;
import Model.User;

/**
 * Servlet implementation class regController
 */
@WebServlet("/regController")
public class regController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public regController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sql = "{call sp_registerUser (?, ?, ?, ?, ?, ?, ?, ?, ?)}";
		DBConnection con = new DBConnection();

		try (Connection c = con.getConnection(); CallableStatement stmt = c.prepareCall(sql)) {
			stmt.setString(1, request.getParameter("fname"));
			stmt.setString(2, request.getParameter("lname"));
			stmt.setString(3, request.getParameter("email"));
			stmt.setString(4, request.getParameter("id"));
			stmt.setString(5, request.getParameter("role"));
			stmt.setString(6, request.getParameter("dob"));
			stmt.setString(7, request.getParameter("gender"));
			stmt.setString(8, request.getParameter("phone"));
			stmt.setString(9, request.getParameter("pword"));

			stmt.execute();
			stmt.close();
			c.close();

			User registeredUser = new User(request.getParameter("fname"), request.getParameter("lname"),
					request.getParameter("email"), request.getParameter("id"), request.getParameter("dob"),
					request.getParameter("gender"), request.getParameter("phone"), request.getParameter("pword"),
					Integer.parseInt(request.getParameter("role")));

			HttpSession session = request.getSession();
			session.setAttribute("flag", "yes");
			session.setAttribute("user", registeredUser);
			response.sendRedirect("SelectCourseQuiz.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}
}
