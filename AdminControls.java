import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.plaf.FontUIResource;

public class AdminControls extends JFrame
{
	public AdminControls()
	{
		Container cp=getContentPane();
		setLayout(new BorderLayout());
		cp.add(new ControlLabel(),BorderLayout.NORTH);
		cp.add(new Controls(),BorderLayout.SOUTH);
	}
}

class ControlLabel extends JPanel
{
	ControlLabel()
	{
		ImageIcon ii=new ImageIcon("oficcial-512.png");
		add(new JLabel(ii));
	}
}

class Controls extends JPanel implements ActionListener, ItemListener
{
	JButton jb;
	JCheckBox jcb1,jcb2,jcb3,jcb4,jcb5,jcb6,jcb7,jcb8,jcb9,jcb10;
	public Controls()
	{
		ButtonGroup gp=new ButtonGroup();
		jb=new JButton("GRANT");
		jb.addActionListener(this);
		
		jb.setBackground(new Color(10,118,188));
		jb.setForeground(new Color(255,255,255));
		jb.setFont(new Font("Tahoma",Font.BOLD,15));
				
		jcb1=new JCheckBox("Change Password ");
		jcb2=new JCheckBox("Customer Database");
		jcb3=new JCheckBox("Update Database");
		jcb4=new JCheckBox("Disconnect Data source");
		jcb5=new JCheckBox("Flush a record");
		jcb6=new JCheckBox("Drop Database");
		jcb7=new JCheckBox("Create Backup");
		jcb8=new JCheckBox("Drop Backup");
		jcb9=new JCheckBox("What is in the stock");
		jcb10=new JCheckBox("Inventory rate list");
		
		gp.add(jcb1);
		gp.add(jcb2);
		gp.add(jcb3);
		gp.add(jcb4);
		gp.add(jcb5);
		gp.add(jcb6);
		gp.add(jcb7);
		gp.add(jcb8);
		gp.add(jcb9);
		gp.add(jcb10);

		jcb1.addItemListener(this);
		jcb2.addItemListener(this);		
		jcb3.addItemListener(this);
		jcb4.addItemListener(this);
		jcb5.addItemListener(this);
		jcb6.addItemListener(this);		
		jcb7.addItemListener(this);
		jcb8.addItemListener(this);
		jcb9.addItemListener(this);
		jcb10.addItemListener(this);		
				
		jcb1.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb2.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb3.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb4.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb5.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb6.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb7.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb8.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb9.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb10.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));			

		jcb1.setForeground(new Color(103,186,7));
		jcb2.setForeground(new Color(103,186,7));
		jcb3.setForeground(new Color(103,186,7));
		jcb4.setForeground(new Color(103,186,7));
		jcb5.setForeground(new Color(103,186,7));
		jcb6.setForeground(new Color(103,186,7));
		jcb7.setForeground(new Color(103,186,7));
		jcb8.setForeground(new Color(103,186,7));
		jcb9.setForeground(new Color(103,186,7));
		jcb10.setForeground(new Color(103,186,7));
		

		setLayout(new GridLayout(5,2));
		add(jcb1);
		add(jcb2);
		add(jcb3);
		add(jcb4);
		add(jcb5);
		add(jcb6);
		add(jcb7);
		add(jcb8);
		add(jcb9);
		add(jcb10);
		//add(jb);
		
		}
	
	public void actionPerformed(ActionEvent ae)
	{
		//blank
	}
	
	public void itemStateChanged(ItemEvent ie)
	{
		Object source=ie.getItemSelectable();
		if(source==jcb2)
		{
			JOptionPane.showMessageDialog(this,"You're about to view a highly confidential information\nHope you understand the risk involved","TOP SECRET",JOptionPane.ERROR_MESSAGE,new ImageIcon("Folder.png"));
			System.out.println("inside jcb2");
			JFrame jrf=new ShowAllBox();
			jrf.setVisible(true);
			jrf.setLocation(170,300);
			jrf.setSize(1060,400);
		}
		if(source==jcb9)
		{
			System.out.println("inside jcb9");
			JFrame jrf=new WhichDatabase1();
			jrf.setVisible(true);
			jrf.setLocation(350,200);
			jrf.setTitle("Where to look");
			jrf.pack();
		}
		if(source==jcb10)
		{
			System.out.println("inside jcb10");
			JFrame jrf=new WhichDatabase2();
			jrf.setVisible(true);
			jrf.setLocation(350,200);
			jrf.setTitle("Where to look");
			jrf.pack();
		}
	}
}