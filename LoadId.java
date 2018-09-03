import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
import javax.swing.plaf.FontUIResource;


class LoadId extends JFrame
{
	JFrame jrf;
	LoadId()
	{
		jrf=new JFrame();
		jrf.setVisible(true);
		setLayout(new BorderLayout());		
		jrf.add(new MySrIcon(),BorderLayout.WEST);
		jrf.add(new TellMyId(),BorderLayout.EAST);
		jrf.setSize(500,205);
		jrf.setLocation(200,300);
		jrf.setTitle("Search Box");
		jrf.setVisible(true);
	}
}

class MySrIcon extends JPanel
{
	ImageIcon ii;
	JLabel jl1;
	MySrIcon()
	{
		ii=new ImageIcon("unnamed.png");
		jl1=new JLabel(ii);
		add(jl1);
	}
}

class GetMeFields extends JPanel
{
	static String nm="";
	static String re="";
	static String mk="";			
	static String en="";				
	static String c1="";
	static String c2="";
	GetMeFields()
	{
		try
		{
			AppointmentManager obj=new AppointmentManager();
			ResultSet rs=obj.variablesForCurque();			
			if(rs!=null)
			{				
											
				while(rs.next())
				{				
					nm=rs.getString(1);System.out.println("ye hai" +nm);
					re=rs.getString(2);
					mk=rs.getString(3);
					c1=rs.getString(4);
					c2=rs.getString(5);
				}
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,e.toString());
		}
	}
}
		
class TellMyId extends JPanel implements ActionListener
{
	Font f,f1;
	JLabel jl1,jl2,jl3;	
	static JSpinner jsp;
	SpinnerModel sm;
	int max,i=0,temp;
	JButton jb;
	int a[]=new int[80];
	TellMyId()
	{
		f=new Font("Tahoma",Font.PLAIN,20);
		f1=new Font("Tahoma",Font.PLAIN,16);
		jl1=new JLabel("ID PLEASE");
		jl2=new JLabel("We gave you an ID on your last visit");
		jl3=new JLabel("You need to tell me that");
		jl2.setForeground(new Color(26,162,96));
		jl3.setForeground(new Color(26,162,96));
		jb=new JButton("Yes! This one");
		jb.setFont(new Font("Tahoma",Font.BOLD,15));
		jb.addActionListener(this);
		jb.setForeground(new Color(255,255,255));
		jb.setBackground(new Color(10,118,188));
		add(jb);
		
		//jsp=new JSpinner(new SpinnerListModel(new String[]{"2015-2016","2016-2017","2017-2018","2018-2019","2019-2020"}));
		SpinnerNumberModel snm = new SpinnerNumberModel(
                new Integer(0),
                new Integer(0),
                new Integer(99999),
                new Integer(1)
        );
        jsp = new JSpinner(snm);
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
		
		ImageIcon ii1=new ImageIcon("12446887174.png");
		AppointmentManager obj=new AppointmentManager();
		Object sp;
		sp=jsp.getValue();
		obj.myid=Integer.parseInt(sp.toString());
		ResultSet rs=obj.searchInApReg();
		try
		{
			if(rs!=null)
			{
				while(rs.next())
				{
					String count=rs.getString(1);
					temp=Integer.parseInt(count);
				}
			}
		}
		catch(Exception e)
		{}
		if(temp==0)
		{
			UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Tahoma",Font.PLAIN,18)));
			JOptionPane.showMessageDialog(this,"No such ID exists in my knowledge!","Make a fresh visit",JOptionPane.ERROR_MESSAGE,ii1);
		}
		else
		{
			//fields
			GetMeFields gmf=new GetMeFields();
			obj.name=gmf.nm;
			obj.reg=gmf.re;
			obj.make=gmf.mk;
			obj.cn1=gmf.c1;
			obj.cn2=gmf.c2;
			
			//token
			ServiceQueue sq=new ServiceQueue();
			ResultSet rs1=sq.lastToken();
			try
			{
				if(rs1!=null)
				{
					while(rs1.next())
					{
						String tkn=rs1.getString(1);
						obj.token=Integer.parseInt(tkn)+1;
					}
				}
			}
			catch(Exception e)
			{
				//JOptionPane.showMessageDialog(this,e.toString());
			}			
			obj.insertOnlyinCurrentQueue();
		}
	}
}