package pack_project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class register 
{
	//singleton
	public static register instance=new register();
	//constructor
	public register()
	{
	}
	//variables
	private static String User;
	private static String nombre;
	private static String apellido;
	private static String telefono;
	private static String correo;
	private static String contraseña;
	private static String contraseña2;
	public static void registrar()
	{
		if(telefono==null)
		{
			JOptionPane.showMessageDialog(null,"error:clase register: telefono empty: metodo register");
		}
		else
		{
			try
			{
				Statement sql = SqlConnection.getConnection().createStatement();
				String consulta= "INSERT into usuarios Values"+"("+ "'" + User+ "'" + "," + "'" + nombre + "'" + "," + "'" + apellido+ "'" + "," + "'" + telefono+ "'" + "," + "'" + correo+ "'" + "," + "'" + contraseña+ "'" + ")";
				ResultSet resultado = sql.executeQuery(consulta);
			}
			catch(SQLException ex)
			{
				JOptionPane.showMessageDialog(null, ex.toString());
			}
		}

	}
	public static void set(String string, char caso)
	{
		boolean resultado;

        try {
            Integer.parseInt(string);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        if (caso=='u')
        {
            if(resultado==true)
            {
            	JOptionPane.showMessageDialog(null, "error:metodo get: clase register (no se aceptan numeros): caso usuario"); 
            }
            else
            {
            	User=string;
            }
        }
        else if (caso=='n')
        {
        	if(resultado == true)
        	{
        		JOptionPane.showMessageDialog(null, "error:metodo get: clase register (no se aceptan numeros): caso nombre"); 
        	}
        	else 
        	{
        	nombre=string;
        	}
        }
        else if (caso=='a')
        {
        	if(resultado ==true)
        	{
        		JOptionPane.showMessageDialog(null, "error:metodo get: clase register (no se aceptan numeros): caso apellido"); 
        	}
        	else
        	{
        	apellido=string;
        	}
        }
        else if (caso=='t')
        {	
        	if (resultado ==false)
        	{
        		JOptionPane.showMessageDialog(null, "error:metodo get: clase register (solo se aceptan numeros): caso telefono"); 
        	}
        	else 
        	{
        	telefono=string;
        	}
        }
        else if (caso=='c')
        {
        	correo=string;
        }
        else if (caso=='p')
        {
        	contraseña=string;
        }
        else if (caso=='k')
        {
        	contraseña2=string;
        }


	}
}
