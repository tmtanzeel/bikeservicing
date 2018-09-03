import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.sql.*;

class DoneServicing extends JFrame
{
	JFrame jrf;
	DoneServicing()
	{
		jrf=new JFrame();
		jrf.setVisible(true);
		setLayout(new BorderLayout());		
		jrf.add(new MyIconLabel(),BorderLayout.WEST);
		jrf.add(new MyToken(),BorderLayout.EAST);
		jrf.setSize(500,205);
		jrf.setLocation(200,300);
		jrf.setTitle("Enter token number");
		jrf.setVisible(true);
	}
}

class MyIconLabel extends JPanel
{
	ImageIcon ii;
	JLabel jl1;
	MyIconLabel()
	{
		ii=new ImageIcon("unnamed.png");
		jl1=new JLabel(ii);
		add(jl1);
	}
}
		
class MyToken extends JPanel implements ActionListener
{
	Font f,f1;
	JLabel jl1,jl2,jl3;	
	JSpinner jsp;
	SpinnerModel sm;
	int max,i=0;
	JButton jb;
	int a[]=new int[80];
	MyToken()
	{
		f=new Font("Tahoma",Font.PLAIN,20);
		f1=new Font("Tahoma",Font.PLAIN,16);
		jl1=new JLabel("Token");
		jl2=new JLabel("5 vehicles can be mounted at a time.");
		jl3=new JLabel("Only first 5 tokens will be accepted.");
		jl2.setForeground(new Color(26,162,96));
		jl3.setForeground(new Color(26,162,96));
		jb=new JButton("Yes! This one");
		jb.setFont(new Font("Tahoma",Font.BOLD,15));
		jb.addActionListener(this);
		jb.setForeground(new Color(255,255,255));
		jb.setBackground(new Color(10,118,188));
		add(jb);
		ServiceQueue obj=new ServiceQueue();
		ResultSet rs=obj.tokenRemaining();
		try
		{
			if(rs!=null)
			{
				while(rs.next())
				{
					String tkn=rs.getString(1);
					int val=Integer.parseInt(tkn);
					a[i]=val;					
					//System.out.println(a[i]);
					i++;
				}
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,e.toString());
		}
		//jsp=new JSpinner(new SpinnerListModel(new String[]{"2015-2016","2016-2017","2017-2018","2018-2019","2019-2020"}));
		jsp=new JSpinner(new SpinnerListModel(new Integer[]{a[0],a[1],a[2],a[3],a[4]}));
		//System.out.println(a[3]);
		//max=a[3];
		//sm=new SpinnerNumberModel(1,1,100,1);
		//jsp=new JSpinner(sm);
		jsp.setFont(f);
		jsp.setForeground(new Color(10,118,188));
		
		jl1.setFont(f);
		jl1.setForeground(new Color(10,118,188));
		jl2.setFont(f1);
		jl3.setFont(f1);
		
		setLayout(new GridLayout(5,1,10,10));
		add(jl1);	
		add(jl2);
		add(jl3);		
		add(jsp);
		add(jb);
	}
	
	public void actionPerformed(ActionEvent ae)
	{	
		ServiceQueue obj=new ServiceQueue();
		Object sp;
		sp=jsp.getValue();
		obj.qtoken=Integer.parseInt(sp.toString());
		JFrame jrf=new BillPaymentForm();
		jrf.setSize(850,330);
		//jrf.setResizable(false);
		jrf.setTitle("CHECK LIST");
		jrf.setLocation(170,50);
		jrf.setVisible(true);
	}
}