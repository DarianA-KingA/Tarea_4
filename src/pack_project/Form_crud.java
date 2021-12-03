package pack_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Form_crud extends forms implements ActionListener
{	
	public static DefaultTableModel model = new DefaultTableModel();
	private static String[] dato = new String[5];
	public static JFrame frame;
	public static JTable table;
	public static JButton boton2;
	public static JButton boton3;
	public static JButton boton4;
	public  static Form_crud instance = new Form_crud();
	public Form_crud()
	{	
		//modelo de tabla
		model.addColumn("Usuario");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("telefono");
		model.addColumn("correo");
		
		//boton
		boton = new JButton("update");
		boton.setBounds(100, 80, 80, 25);
		boton.addActionListener((ActionListener) this);
		
		boton2 = new JButton("delete");
		boton2.setBounds(185, 80, 80, 25);
		boton2.addActionListener((ActionListener) this);
		
		boton3 = new JButton("Sing Out");
		boton3.setBounds(185, 80, 80, 25);
		boton3.addActionListener((ActionListener) this);
		
		boton4 = new JButton("Campos");
		boton4.setBounds(185, 120, 80, 25);
		boton4.addActionListener((ActionListener) this);
		
		//table
		table=new JTable();
		table.setModel(model);
		table.setBounds(20,50,100,100);

		//panel
		panel = new JPanel();	
		//panel.setLayout(null);
		panel.add(table);
		panel.add(boton);
		panel.add(boton2);
		panel.add(boton3);
		panel.add(boton4);
		
		//frame
		frame = new JFrame();
		frame.setSize(400,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(false);
		frame.setTitle("Crud");
		frame.add(panel);
		frame.setLocationRelativeTo(null);
	} 
	public static void insertar()
	{
		try
		{
		Statement sql = SqlConnection.getConnection().createStatement();
		String consulta= "select nombre_de_usuario, nomnbre ,apellido,telefono,correo from usuarios ";
		ResultSet resultado = sql.executeQuery(consulta);	
		while(resultado.next())
		{
			dato[0]=resultado.getString(1);
			dato[1]=resultado.getString(2);
			dato[2]=resultado.getString(3);
			dato[3]=resultado.getString(4);
			dato[4]=resultado.getString(5);
			model.addRow(dato);
		}
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}
	public static void vaciar ()
	{
		for (int i=0; i<=4; i++ )
		{
			dato[i]="";
		}
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object fuente= e.getSource();
		if (fuente==boton)
		{
			JOptionPane.showMessageDialog(null, "En caso de update, insertar el que CAMPO A ALTERAR, VALOR A ASIGNAR, USURIO ");
			crud.update(subcrud.text.getText(), subcrud.text2.getText(), subcrud.text3.getText());
			vaciar();
			insertar();
		}
		if (fuente==boton2)
		{
			JOptionPane.showMessageDialog(null,"En caso de delete, insertar el nombre en el primer textBox");
			crud.delete(subcrud.text.getText());
			vaciar();
			insertar();
		}
		if (fuente==boton3)
		{
			subcrud.frame.setVisible(false);
			Form_crud.frame.setVisible(false);
			Form_login.frame.setVisible(true);
		}
		if(fuente==boton4)
		{
			subcrud.frame.setVisible(true);
		}
		
	}

}
