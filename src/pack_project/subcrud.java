package pack_project;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class subcrud extends forms

{
	public static JFrame frame;
	public static JTextField text;
	public static JTextField text2;
	public static JTextField text3;
	private static subcrud instance= new subcrud();
	public subcrud()
	{	
		//textbox
		text=new JTextField(20);
		text.setBounds(72,10,200,20);
		
		text2 =  new JTextField(20);
		text2.setBounds(72,40,200,20);
		
		text3 =  new JTextField(20);
		text3.setBounds(72,70,200,20);
		//panel
		panel=  new JPanel();
		panel.setLayout(null);
		panel.add(text);
		panel.add(text2);
		panel.add(text3);

		
		//frame
		frame = new JFrame();
		frame.setSize(350,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("SubCrud");
		frame.add(panel);
		frame.setLocationRelativeTo(null);
	}
	public static subcrud getInstance() {
		return instance;
	}
	public static void setInstance(subcrud instance) {
		subcrud.instance = instance;
	}
	
}
