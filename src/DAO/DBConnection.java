package DAO;
import java.sql.*;

public class DBConnection 
{
	public Connection getConnection()
	{
		String url = "jdbc:sqlserver://localhost\\SPECTRE:1433;database=EXAMplify;username=admin;password=Welcome2";
		Connection c = null;
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			c = DriverManager.getConnection(url);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return c;
	}
}
