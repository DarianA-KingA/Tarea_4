package pack_project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class crud
{
	public static crud instance= new crud();
	public crud()
	{
	}
	public static void update(String campoA, String datoA, String user)
	{
		try 
		{	Statement sql = SqlConnection.getConnection().createStatement();
			String consulta="update usuarios set "+ campoA+ "="+ " '" +datoA+ "' where nombre_de_usuario ="+"'"+ user+"'";
			ResultSet resultado= sql.executeQuery(consulta);
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}
	public static void delete(String nombre)
	{
		try 
		{	Statement sql = SqlConnection.getConnection().createStatement();
			String consulta="delete from usuarios where nombre_de_usuario ="+"'"+nombre+"'";
			ResultSet resultado= sql.executeQuery(consulta);
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}
}
