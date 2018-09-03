import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.plaf.FontUIResource;

public class NewArrOrReVisit extends JFrame
{
	public NewArrOrReVisit()
	{
		Container cp=getContentPane();
		setLayout(new BorderLayout());
		cp.add(new Boxes(),BorderLayout.EAST);
		cp.add(new QuestionLabel(),BorderLayout.WEST);
		cp.add(new UnBu(),BorderLayout.SOUTH);
	}
}

class QuestionLabel extends JPanel
{
	QuestionLabel()
	{
		ImageIcon ii=new ImageIcon("answer - Copy.png");
		add(new JLabel(ii));
	}
}

class Boxes extends JPanel implements ItemListener
{
	JCheckBox jcb1,jcb2,jcb3,jcb4;
	static String tocb="";
	ButtonGroup grp;
	public Boxes()
	{		
		grp=new ButtonGroup();
		jcb1=new JCheckBox("A fresh visit");
		jcb2=new JCheckBox("Visited someday, have an ID");
		jcb3=new JCheckBox("Appointments of the month");
		jcb4=new JCheckBox("Load to the queue");
		
		grp.add(jcb1);
		grp.add(jcb1);
		grp.add(jcb3);
		grp.add(jcb4);
	
		jcb1.addItemListener(this);
		jcb2.addItemListener(this);		
		jcb3.addItemListener(this);
		jcb4.addItemListener(this);		
		
		jcb1.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb2.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb3.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb4.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		
		jcb1.setForeground(new Color(103,186,7));
		jcb2.setForeground(new Color(103,186,7));
		jcb3.setForeground(new Color(103,186,7));
		jcb4.setForeground(new Color(103,186,7));
		
		setLayout(new GridLayout(5,1,5,5));
		add(jcb1);
		add(jcb2);
		add(jcb3);
		add(jcb4);
	}
	
	public void itemStateChanged(ItemEvent ie)
	{
		Object source=ie.getItemSelectable();
		if(source==jcb1)
		{
			tocb="fresh";
		}
		else if(source==jcb2)
		{
			tocb="revisit";
		}
		else if(source==jcb3)
		{
			tocb="showme";
		}
		else if(source==jcb4)
		{
			tocb="load";
		}
	}
}
	
	
	class UnBu extends JPanel implements ActionListener
	{
	JButton jb1;	
	UnBu()
	{
		jb1=new JButton("Take me In");
		jb1.addActionListener(this);
		jb1.setBackground(new Color(10,118,188));
		jb1.setForeground(new Color(255,255,255));
		jb1.setFont(new Font("Tahoma",Font.BOLD,15));
		add(jb1);		
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(Boxes.tocb.equals("fresh"))
		{
			new NewCustomerAppoint();
		}
		else if(Boxes.tocb.equals("revisit"))
		{
			new SearchBox();
		}
		else if(Boxes.tocb.equals("showme"))
		{
			JFrame jrf=new ShowAllAppointments();
			jrf.setVisible(true);
			jrf.setLocation(170,300);
			jrf.setSize(1060,400);
		}
		else if(Boxes.tocb.equals("load"))
		{
			new LoadId();
		}
	}
	}