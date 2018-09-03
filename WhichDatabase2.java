import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
import javax.swing.plaf.FontUIResource;

class WhichDatabase2 extends JFrame
{
	
	WhichDatabase2()
	{
		Container cp=getContentPane();
		setLayout(new BorderLayout());
		cp.add(new MyHeading2(),BorderLayout.NORTH);
		cp.add(new DbName2(),BorderLayout.CENTER);
		cp.add(new SureButton2(),BorderLayout.SOUTH);
	}
}

class MyHeading2 extends JPanel
{
	Font f;
	JLabel jl;
	MyHeading2()
	{
		jl=new JLabel("Where to find?");
		f=new Font("Tahoma",Font.PLAIN,30);
		jl.setFont(f);
		jl.setForeground(new Color(103,186,7));
		add(jl);
	}
}

class DbName2 extends JPanel
{
	JLabel jl;
	static Choice ch0;
	DbName2()
	{
		jl=new JLabel("Specify the Database:");
		jl.setForeground(new Color(103,186,7));
		jl.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,17));
		
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
		add(jl);
		add(ch0);
	}
}

class SureButton2 extends JPanel implements ActionListener
{
	JButton jb;
	SureButton2()
	{
		jb=new JButton("Yes, Sure");
		jb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jb.addActionListener(this);
		jb.setForeground(new Color(255,255,255));
		jb.setBackground(new Color(10,118,188));
		add(jb);
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		InventoryManager im=new InventoryManager();
		im.table=DbName2.ch0.getItem(DbName2.ch0.getSelectedIndex());	
		
		//InventoryStatus is table class
		JFrame jrf=new InventoryPrices();
		jrf.setVisible(true);
		jrf.setLocation(170,300);
		jrf.setSize(450,400);
	}
}