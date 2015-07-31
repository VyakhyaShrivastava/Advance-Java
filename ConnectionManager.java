

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager
{
	static Connection conn;

	public static Connection getConnection()
	{
		try
		{
			String url = "jdbc:mysql://localhost:8080/";
			String dbName ="mydata"; // here "come2niks" is the name of Database.
			String uname = "root";
			String pwd = "";

			Class.forName("com.mysql.jdbc.Driver");
			try
			{
                                  conn = DriverManager.getConnection(url+dbName, "root", "");
			}
			catch (SQLException ex)
			{
				ex.printStackTrace();
			}
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		return conn;
	}

}
