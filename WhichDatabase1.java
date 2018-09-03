import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
import javax.swing.plaf.FontUIResource;

class WhichDatabase1 extends JFrame
{
	
	WhichDatabase1()
	{
		Container cp=getContentPane();
		setLayout(new BorderLayout());
		cp.add(new MyHeading1(),BorderLayout.NORTH);
		cp.add(new DbName1(),BorderLayout.CENTER);
		cp.add(new SureButton1(),BorderLayout.SOUTH);
	}
}

class MyHeading1 extends JPanel
{
	Font f;
	JLabel jl;
	MyHeading1()
	{
		jl=new JLabel("Where to find?");
		f=new Font("Tahoma",Font.PLAIN,30);
		jl.setFont(f);
		jl.setForeground(new Color(103,186,7));
		add(jl);
	}
}

class DbName1 extends JPanel
{
	JLabel jl1;
	static Choice ch0;
	DbName1()
	{
		jl1=new JLabel("Specify the Database:");
		jl1.setForeground(new Color(103,186,7));
		jl1.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,17));
		
		ch0=new Choice();
		
		ch0.add("AVENGER");
		ch0.add("DISCOVER");
		ch0.add("XCD");
		ch0.add("PULSAR");
		ch0.add("PLATINA");		
		ch0.add("VIKRANT");
		
		ch0.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		
		ch0.setForeground(new Color(10,118,188));
		
		setLayout(new GridLayout(1,2));
		add(jl1);
		add(ch0);
	}
}

class SureButton1 extends JPanel implements ActionListener
{
	JButton jb1;
	SureButton1()
	{
		jb1=new JButton("Yes, Sure");
		jb1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jb1.addActionListener(this);
		jb1.setForeground(new Color(255,255,255));
		jb1.setBackground(new Color(10,118,188));
		add(jb1);
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		InventoryManager im=new InventoryManager();
		im.table=DbName1.ch0.getItem(DbName1.ch0.getSelectedIndex());
		
		
		//InventoryStatus is table class
		JFrame jrf=new InventoryStatus();
		jrf.setVisible(true);
		jrf.setLocation(170,300);
		jrf.setSize(400,400);
	}
}