import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

class FindBox extends JFrame
{
	JFrame jrf;
	FindBox()
	{
		jrf=new JFrame();
		jrf.setVisible(true);
		setLayout(new BorderLayout());		
		jrf.add(new MySearchBanner(),BorderLayout.NORTH);
		jrf.add(new MyFields(),BorderLayout.CENTER);
		jrf.setSize(800,170);
		jrf.setLocation(200,300);
		jrf.setTitle("Search my details");
		jrf.setVisible(true);
	}
}

class MySearchBanner extends JPanel
{
	Font f;
	JLabel jl;
	MySearchBanner()
	{
		jl=new JLabel("Provide at least one of the following");
		f=new Font("Tahoma",Font.PLAIN,30);
		jl.setFont(f);
		jl.setForeground(new Color(103,186,7));
		add(jl);
	}
}

class MyFields extends JPanel implements ActionListener
{
	JLabel jl1,jl2,jl3,jl4,jl5;
	JButton jb;
	static JTextField jt1,jt2,jt3;
	MyFields()
	{
		setLayout(new GridLayout(3,2));
		jl1=new JLabel("ID");
		jl2=new JLabel("Registration");
		jl3=new JLabel("Engine No");
		jl4=new JLabel("OR");
		jl5=new JLabel("OR");

		jb=new JButton("Search");
		jb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jb.addActionListener(this);
		jb.setForeground(new Color(255,255,255));
		jb.setBackground(new Color(10,118,188));
				
		jt1=new JTextField(10);
		jt1.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		jt1.setText("12345");
		
		jt2=new JTextField(10);
		jt2.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		jt2.setText("UP 70 AW 4862");

		jt3=new JTextField(10);
		jt3.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		jt3.setText("KGUBZU02004");

		add(jl1);
		add(jt1);
		add(jl4);
		add(jl2);
		add(jt2);
		add(jl5);
		add(jl3);
		add(jt3);
		add(jb);
	}

	public void actionPerformed(ActionEvent ae)
	{
		ServiceQueue obj=new ServiceQueue();
		obj.idnumber=Integer.parseInt(MyFields.jt1.getText());
		obj.regnumber=MyFields.jt2.getText();
		obj.enginenumber=MyFields.jt3.getText();
		new ShowByField();
	}
}