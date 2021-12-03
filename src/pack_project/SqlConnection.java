package pack_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SqlConnection 
{
	public static Connection getConnection()
	{
		
		String conexionURL= "jdbc:sqlserver://localhost:1433;"
				+"database=Users;"
				+"user=sa;"
				+"password=1234;"
				+"loginTimeout=10;";
		try
		{
			Connection con= DriverManager.getConnection(conexionURL);
			return con;
		}
		catch(SQLException ex)
		{
			System.out.println(ex.toString());
			return null;
		}
	}
}
