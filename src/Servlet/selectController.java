package Servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class selectController
 */
@WebServlet("/selectController")
public class selectController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectController() 
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
		if (request.getSession().getAttribute("courseCode") == null)
			request.getSession().setAttribute("courseCode", request.getParameter("course"));
		response.sendRedirect("UpdateQuestion.jsp");
		response.setContentType("text/javascript");
		PrintWriter out = response.getWriter();
		out.print("<script type=\"text/javascript\">");
		out.print("document.getElementById(\"cour\").style.display = \"none\";");
		out.print("</script>");
		doGet(request, response);
	}
}
