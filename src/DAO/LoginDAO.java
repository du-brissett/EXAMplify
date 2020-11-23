package DAO;
import java.sql.*;

import Model.Login;
import Model.User;

public class LoginDAO 
{
	static String url = "jdbc:sqlserver://localhost\\SPECTRE:1433;database=EXAMplify;username=admin;password=Welcome2";
	public boolean authenticate(Login login) throws ClassNotFoundException 
	{
		boolean valid =  false;
	
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND Passcode = ?";
				
		try 
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, login.getUsername());
			stmt.setString(2, login.getPassword());
			
			ResultSet rs = stmt.executeQuery();
			valid = rs.next();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return valid;
	}
	
	public User getUser(Login login) throws ClassNotFoundException 
	{
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
				User u = null;

		 		String fname = "";
		 		String lname= "";
		 		String email= "";
		 		String id= "";
		 		String dob= "";
		 		String gender= "";
		 		String phone= "";
		 		String password= "";
		 		int group= 0;
		try 
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, login.getUsername());
			
			ResultSet rs = stmt.executeQuery();
			
		
				while(rs.next())
				{
					String pass= rs.getString("Passcode");
				 	if( pass.equals(login.getPassword())) {
				 		
				 		 fname = rs.getString("FirstName");
				 		 lname = rs.getString("LastName");
				 		 email = rs.getString("Email");
				 		id = rs.getString("ID");
				 		 dob = rs.getString("DOB");
				 		 gender = rs.getString("Gender");
				 		 phone =  rs.getString("ContactNo");
				 		 password = rs.getString("Passcode");
				 		 group = rs.getInt("GroupID");
				 		
				 	
					}		
				}
				u = new User(fname, lname, email, id, dob, gender, phone, password, group);
				
			}catch(Exception e)
			{
				e.printStackTrace();	
			}
			return u;
	}
	
	public String getUserProfile(Login login)
	{
		String user = "";
		String sql = "{call sp_authenticateUser (?, ?, ?)}";
		DBConnection con = new DBConnection();
		
		try (Connection c = con.getConnection(); CallableStatement stmt = c.prepareCall(sql))
		{
			stmt.setString(1, login.getUsername());
			stmt.setString(2, login.getPassword());
			stmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			
			stmt.execute();
			
			user = stmt.getString("group");			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}
}
