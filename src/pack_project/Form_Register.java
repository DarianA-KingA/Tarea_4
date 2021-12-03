package pack_project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Form_Register  extends forms implements ActionListener
{
	public static Form_Register instance= new Form_Register();

	private static JLabel Nombrelabel;
	private static JLabel Apellidolabel;
	private static JLabel Telefonolabel;
	private static JLabel Correolabel;
	public static  JLabel Password2label;
	public static JTextField Nombretext;
	public static JTextField Apellidotext;
	public static JTextField Correotext;
	public static JTextField Telefonotext;
	public static JPasswordField Passwordtext2;
	private static JButton boton2;
	public static JFrame frame;
	public Form_Register()
	{
		//label
		Userlabel = new JLabel("Usuario");
		Userlabel.setBounds(10,20,80, 25);
		
		Nombrelabel = new JLabel("Nombre");
		Nombrelabel.setBounds(10,50,80, 25);
		
		Apellidolabel = new JLabel("Apellido");
		Apellidolabel.setBounds(10,80,80, 25);
		
		Telefonolabel = new JLabel("Telefono");
		Telefonolabel.setBounds(10,110,80, 25);
		
		Correolabel = new JLabel("Correo");
		Correolabel.setBounds(10,140,80, 25);
		
		Passwordlabel = new JLabel("Contraseña");
		Passwordlabel.setBounds(10,170,80, 25);
		
		Password2label = new JLabel("Confirmacion");
		Password2label.setBounds(10,200,80,25 );
		
		mensaje= new JLabel("");
		mensaje.setBounds(10,260,200,50);

		//textbox 
		Usertext = new JTextField(20);
		Usertext.setBounds(100,20,165,25);
		
		Nombretext = new JTextField(20);
		Nombretext.setBounds(100,50,165,25);
		
		Apellidotext = new JTextField(20);
		Apellidotext.setBounds(100,80,165,25);
		
		Telefonotext = new JTextField(20);
		Telefonotext.setBounds(100,110,165,25);
		
		Correotext = new JTextField(20);
		Correotext.setBounds(100,140,165,25);
		
		Passwordtext = new JPasswordField(20);
		Passwordtext.setBounds(100,170,165,25);
		
		Passwordtext2 = new JPasswordField(20);
		Passwordtext2.setBounds(100,200,165,25);
		
		//boton
		boton = new JButton("Registrarse");
		boton.setBounds(10, 230, 80, 25);
		boton.addActionListener(this);
		
		boton2 = new JButton("Volver");
		boton2.setBounds(10, 260, 80, 25);
		boton2.addActionListener(this);
		
		
		//panel
		panel = new JPanel();	
		panel.setLayout(null);
		panel.add(boton);
		panel.add(Userlabel);
		panel.add(Usertext);
		panel.add(Passwordlabel);
		panel.add(Passwordtext);
		panel.add(boton);
		panel.add(boton2);
		panel.add(mensaje);
		panel.add(Nombrelabel);
		panel.add(Apellidolabel);
		panel.add(Telefonolabel);
		panel.add(Correolabel);
		panel.add(Passwordlabel);
		panel.add(Password2label);
		panel.add(Nombretext);
		panel.add(Apellidotext);
		panel.add(Telefonotext);
		panel.add(Correotext);
		panel.add(Passwordtext2);
		//Frame
		frame = new JFrame();
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Registro");
		frame.add(panel);
		frame.setLocationRelativeTo(null);
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object fuente= e.getSource();
		if (fuente==boton)
		{
			if(Usertext.getText().isEmpty() || Nombretext.getText().isEmpty() || Apellidotext.getText().isEmpty() || Telefonotext.getText().isEmpty() || Correotext.getText().isEmpty() || Passwordtext.getText().isEmpty() ||Passwordtext2.getText().isEmpty()) 
			{
				JOptionPane.showMessageDialog(null, "error:metodo actionPerfomerd : clase ForM_register (algun campo vacio): caso register.set");
			}
			else if (Passwordtext.getText().equals(Passwordtext2.getText())==false)
			{	
				JOptionPane.showMessageDialog(null, "error:metodo actionPerfomerd : clase ForM_register (campos diferentes): caso register.set");
			}
			else 
			{
			register.set(Usertext.getText(), 'u');
			register.set(Nombretext.getText(),'n');
			register.set(Apellidotext.getText(),'a');
			register.set(Telefonotext.getText(),'t');
			register.set(Correotext.getText(),'c');
			register.set(Passwordtext.getText(),'p');
			register.registrar();
			System.out.print("registro exitoso");
			}
		}
		else if(fuente==boton2)
		{
			frame.setVisible(false);
			Form_login.frame.setVisible(true);
		}

	}
}
