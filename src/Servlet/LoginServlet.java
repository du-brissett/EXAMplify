package Servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.LoginDAO;
import Model.Login;
import Model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO logindao;

	public void init() {
		logindao = new LoginDAO();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");

		Login login = new Login();

		login.setUsername(user);
		login.setPassword(pass);

		try {
			if (logindao.authenticate(login)) {
				User currentuser = logindao.getUser(login);
				if (request.getSession().getAttribute("profile") == null) {
					// request.getSession().setAttribute("profile", logindao.getUserProfile(login));
					request.getSession().setAttribute("user", currentuser);
					request.getSession().setAttribute("flag", "yes");
				}
				if (currentuser.getGroup() == 3) {
					response.sendRedirect("Admin.jsp");
				} else {
					response.sendRedirect("SelectCourseQuiz.jsp");
				}
			} else {
				response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
