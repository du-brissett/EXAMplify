package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;
import java.security.SecureRandom;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DBConnection;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private static final String ALPHABET_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    
    private static SecureRandom rand = new SecureRandom();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPassword() 
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
		boolean valid =  false;
		DBConnection con = new DBConnection();
		String tempPass = "";
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try (Connection c = con.getConnection(); CallableStatement stmt = c.prepareCall("{call sp_verifyUser (?, ?)}"))
		{ 
			stmt.setString(1, request.getParameter("id"));
			stmt.setString(2, request.getParameter("email"));			
				
			valid = stmt.execute();
			
			stmt.close();
			c.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		if (valid)
		{
			tempPass = generateCombination(12, ALPHABET_CAPS + ALPHABET + NUMBERS);
			try (Connection c = con.getConnection(); CallableStatement stmt = c.prepareCall("{call sp_updatePassword (?, ?)}"))
			{ 
				stmt.setString(1, request.getParameter("id"));
				stmt.setString(2, tempPass);			
					
				stmt.execute();
				
				stmt.close();
				c.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			Properties properties = new Properties();
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.socketFactory.port", "465");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.port", "465");
			
			Session session = Session.getDefaultInstance(properties, 
					new javax.mail.Authenticator() 
					{    
		           		protected PasswordAuthentication getPasswordAuthentication() 
		           		{    
		           			return new PasswordAuthentication("com.examplify@gmail.com", "alpha_C0ders");  
		           		}    
					}
			);
			
			try 
			{
				MimeMessage message = new MimeMessage(session);
				message.addRecipient(Message.RecipientType.TO, new InternetAddress("com.examplify@gmail.com"));
				message.setSubject(request.getParameter("Temporary Password for user " + request.getParameter("id")));
				message.setText("Hello " + request.getParameter("id") + ", "
						+ "\n" + "Your password has been updated! Your temporary password is " + tempPass + "." 
						+ "\n\n" + "We recommend you change your password after logging." 
						+ "\n\n" + "Regards, " + "\n" + "The EXAMplify Team"  
				);
				Transport.send(message);			
			}
			catch (MessagingException m)
			{
				m.printStackTrace();
			}
			response.sendRedirect("PasswordReset.jsp");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Invalid user id or email');");
			out.println("location='ForgetPassword.jsp';");
			out.println("</script>");
		}
		doGet(request, response);
	}
	
	public static String generateCombination(int length, String characters)
	{
		String pass = "";
		
		for (int i = 0; i < length; i++) 
		{
		    int j = rand.nextInt(characters.length());
		    pass += characters.charAt(j);
		}
		return pass;
	}
}
