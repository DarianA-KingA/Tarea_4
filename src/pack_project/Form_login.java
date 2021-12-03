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

public class Form_login extends forms implements ActionListener
{
	public static JFrame frame;
	public static JButton boton2;
	public static JButton boton3;
	public  static Form_login instance= new Form_login();
	
	public Form_login()
	{
		//label
		Userlabel = new JLabel("Usuario");
		Userlabel.setBounds(10,20,80, 25);
		
		Passwordlabel = new JLabel("Contraseña");
		Passwordlabel.setBounds(10,50,80, 25);
		
		mensaje= new JLabel("");
		mensaje.setBounds(10,100,200,50);

		//textbox 
		Usertext = new JTextField(20);
		Usertext.setBounds(100,20,165,25);
		
		Passwordtext = new JPasswordField(20);
		Passwordtext.setBounds(100,50,165,25);
		
		boton2 = new JButton("SingUp");
		boton2.setBounds(185, 80, 80, 25);
		boton2.addActionListener((ActionListener) this);
		
		boton3 = new JButton("login");
		boton3.setBounds(100, 80, 80, 25);
		boton3.addActionListener((ActionListener) this);
		
		//panel
		panel = new JPanel();	
		panel.setLayout(null);
		panel.add(Userlabel);
		panel.add(Usertext);
		panel.add(Passwordlabel);
		panel.add(Passwordtext);
		panel.add(boton2);
		panel.add(boton3);
		panel.add(mensaje);
		
		//Frame
		frame = new JFrame();
		frame.setSize(350,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Registro");
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object fuente= e.getSource();
		if (fuente==boton)
		{
			System.out.print("todo OK");
			frame.setVisible(false);
			login.logIn();
		}
		if(fuente==boton2)
		{
			frame.setVisible(false);
			Form_Register.frame.setVisible(true);
		}
		if(fuente==boton3)
		{
			//login.set(this.Usertext.getText(),1);
			login.set(this.Passwordtext.getText());
			login.logIn();	
			
			
		}
		

	 
	}

}
