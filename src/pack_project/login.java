package pack_project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public  class login 
{
	private static String User;
	private static String Password;
	public static login instance = new login();
	private login()
	{
		
	}
	
	public  static void logIn()
	{
		
		String campo2="";
		User= Form_login.instance.Usertext.getText();

		if (User.isEmpty() || Password.isEmpty())
		{
			System.out.print("ingrese el usuario o contraseña");
		}
		else 
		{	
			if(set(User,1)==true) 
			{
				JOptionPane.showMessageDialog(null, "No se aceptan numeros en el usuario");
			}
			else
			{
				try
				{	;
					Statement sql = SqlConnection.getConnection().createStatement();
					String consulta2= "SELECT contraseña from  usuarios WHERE nombre_de_usuario="+"'"+User+"'";
					ResultSet resultado2 = sql.executeQuery(consulta2);
					while(resultado2.next())
					{
						campo2+=resultado2.getString(1);
					}
					if(Password.equals(campo2)==true)
					{	
						System.out.println("jesus");
						//Form_crud.insertar();
						Form_login.frame.setVisible(false);
						Form_crud.frame.setVisible(true);
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "usuario o clave no encontrado");
					}

				}
				catch(SQLException ex)
				{
					JOptionPane.showMessageDialog(null, ex.toString());
				}

			}
			}

	}
	//polimorfismo
	public static void set(String cadena)
	{
		Password=cadena;
	}
    public static boolean set(String cadena, int i) 
    {

        boolean resultado;

        try 
        {
            Integer.parseInt(cadena);
            resultado = true;
        } 
        catch (NumberFormatException excepcion) 
        {
            resultado = false;
        }

        return resultado;
    }
}
