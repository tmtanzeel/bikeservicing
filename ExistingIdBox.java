import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
import javax.swing.plaf.FontUIResource;

public class ExistingIdBox extends JFrame
{
	JFrame jrf;
	public ExistingIdBox()
	{
		jrf=new JFrame();
		jrf.setVisible(true);
		setLayout(new BorderLayout());
		jrf.add(new PreloadedDetails(),BorderLayout.NORTH);
		jrf.add(new MyValidatorClass(),BorderLayout.CENTER);
		jrf.add(new AllSet(),BorderLayout.SOUTH);
		jrf.setSize(800,395);
		jrf.setLocation(200,300);
		jrf.setTitle("Preloaded details");
		jrf.setVisible(true);
	}
}

class GetMeInfo extends JPanel
{
	static String nm="";
	static String re="";
	static String mk="";			
	static String en="";				
	static String c1="";
	static String c2="";
	GetMeInfo()
	{
		try
		{
			AppointmentManager obj=new AppointmentManager();
			ResultSet rs=obj.fetchAllDefaults();			
			if(rs!=null)
			{				
											
				while(rs.next())
				{
				
					nm=rs.getString(1);System.out.println(nm);
					re=rs.getString(2);
					mk=rs.getString(3);
					en=rs.getString(4);
					c1=rs.getString(5);
					c2=rs.getString(6);
				}
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,e.toString());
		}
	}
}

class PreloadedDetails extends JPanel
{
	GetMeInfo gi=new GetMeInfo();
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl11,jl22,jl33,jl44;
	static JTextField jtf1,jtf2,jtf3,jtf4;
	Font f;
	PreloadedDetails()
	{
		f=new Font("Tahoma",Font.PLAIN,20);
		jl1=new JLabel("Name: ");
		jl1.setFont(f);
		jl1.setForeground(new Color(10,118,188));
		
		jl11=new JLabel();
		jl11.setFont(f);
		jl11.setForeground(new Color(26,162,96));
		//System.out.println(gi.nm);
		jl11.setText(""+gi.nm);
		
		jl2=new JLabel("Registration: ");
		jl2.setFont(f);
		jl2.setForeground(new Color(10,118,188));
		
		jl22=new JLabel();
		jl22.setFont(f);
		jl22.setForeground(new Color(26,162,96));
		jl22.setText(""+gi.re);
		
		jl3=new JLabel("Make: ");
		jl3.setFont(f);
		jl3.setForeground(new Color(10,118,188));
		
		jl33=new JLabel();
		jl33.setFont(f);
		jl33.setForeground(new Color(26,162,96));
		jl33.setText(""+gi.mk);
		
		jl4=new JLabel("Engine: ");
		jl4.setFont(f);
		jl4.setForeground(new Color(10,118,188));
		
		jl44=new JLabel();
		jl44.setFont(f);
		jl44.setForeground(new Color(26,162,96));
		jl44.setText(""+gi.en);
		
		jl5=new JLabel("Fuel: ");
		jl5.setFont(f);
		jl5.setForeground(new Color(10,118,188));
		
		jl6=new JLabel("Contact 1: ");
		jl6.setFont(f);
		jl6.setForeground(new Color(10,118,188));
		
		jl7=new JLabel("Contact 2: ");
		jl7.setFont(f);
		jl7.setForeground(new Color(10,118,188));
		
		jl8=new JLabel("Meter: ");
		jl8.setFont(f);
		jl8.setForeground(new Color(10,118,188));
		
		jtf4=new JTextField(10);
		jtf4.setFont(f);
		jtf4.setForeground(new Color(26,162,96));
				
		jtf1=new JTextField(10);
		jtf1.setFont(f);
		jtf1.setForeground(new Color(26,162,96));
		
		jtf2=new JTextField(10);
		jtf2.setFont(f);
		jtf2.setForeground(new Color(26,162,96));
		jtf2.setText(""+gi.c1);
		
		jtf3=new JTextField(10);
		jtf3.setFont(f);
		jtf3.setForeground(new Color(26,162,96));
		jtf3.setText(""+gi.c2);
		
		setLayout(new GridLayout(8,2));
		add(jl1);
		add(jl11);
		add(jl2);
		add(jl22);
		add(jl3);
		add(jl33);
		add(jl4);
		add(jl44);
		add(jl8);
		add(jtf4);	
		add(jl5);
		add(jtf1);
		add(jl6);
		add(jtf2);
		add(jl7);
		add(jtf3);
				
	}
}

class MyValidatorClass extends JPanel implements ActionListener
{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	static JTextField jt1,jt2,jt3,jt4,jt5,jt6;
	static JSpinner jsp,jsp1;
	Calendar cl;
	GregorianCalendar gcl;
	int day,year,time,amtopm,temp;
	JButton jb1,jb2;
	String months[]={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"},month="",fordatetime="";
	MyValidatorClass()
	{
		cl=Calendar.getInstance();
		gcl=new GregorianCalendar();
		day=cl.get(Calendar.DATE)+1; 
		month=months[cl.get(Calendar.MONTH)];
		year=cl.get(Calendar.YEAR); 
		if(gcl.isLeapYear(year))
		{
			if(month.equals("FEB"))
			{
				SpinnerModel sm=new SpinnerNumberModel(day,day,29,1);
				jsp=new JSpinner(sm);
			}
			else if(month.equals("JAN") || month.equals("MAR") || month.equals("MAY") || month.equals("JUL") || month.equals("AUG") || month.equals("OCT") || month.equals("DEC"))
			{
				SpinnerModel sm=new SpinnerNumberModel(day,day,31,1);
				jsp=new JSpinner(sm);
			}
			else
			{
				SpinnerModel sm=new SpinnerNumberModel(day,day,30,1);
				jsp=new JSpinner(sm);
			}
		}
		else
		{
			if(month.equals("FEB"))
			{
				SpinnerModel sm=new SpinnerNumberModel(day,day,28,1);
				jsp=new JSpinner(sm);
			}
			else if(month.equals("JAN") || month.equals("MAR") || month.equals("MAY") || month.equals("JUL") || month.equals("AUG") || month.equals("OCT") || month.equals("DEC"))
			{
				SpinnerModel sm=new SpinnerNumberModel(day,day,31,1);
				jsp=new JSpinner(sm);
			}
			else
			{
				SpinnerModel sm=new SpinnerNumberModel(day,day,30,1);
				jsp=new JSpinner(sm);
			}
		}
		jb1=new JButton("Validate");
		jb1.setForeground(new Color(255,255,255));
		jb1.setBackground(new Color(10,118,188));	
		jb1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jb1.addActionListener(this);
		
		jb2=new JButton("Submit");
		jb2.setForeground(new Color(255,255,255));
		jb2.setBackground(new Color(10,118,188));	
		jb2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jb2.addActionListener(this);
		
		jsp.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		SpinnerModel sm1=new SpinnerNumberModel(10,10,14,1);
		jsp1=new JSpinner(sm1);
		jsp1.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		
		jl1=new JLabel("Name:");
		jl2=new JLabel("Registration:");
		jl3=new JLabel("Appointment on:");
		jl4=new JLabel(""+month+" "+year);
		jl4.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		jl5=new JLabel("");
		jl6=new JLabel("At [10 AM - 2 PM]:");
		jl7=new JLabel("Hrs  [24 HOUR FORMAT]");
		jl7.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));

		jt1=new JTextField(10);
		jt1.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		jt1.setText("first name");
		
		jt2=new JTextField(10);
		jt2.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		jt2.setText("middle name");

		jt3=new JTextField(10);
		jt3.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		jt3.setText("last name");

		jt4=new JTextField(10);
		jt4.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		jt4.setText("UP");

		jt5=new JTextField(10);
		jt5.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		jt5.setText("70 AW");

		jt6=new JTextField(10);
		jt6.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		jt6.setText("1234");

		setLayout(new GridLayout(2,4));
	

		add(jl3);
		add(jsp);
		add(jl4);
		add(jl5);
		add(jl6);
		add(jsp1);
		add(jl7);
		add(jb1);
		
	}

	public void actionPerformed(ActionEvent ae)
	{
		Object sp,sp1;
		sp=jsp.getValue();
		sp1=jsp1.getValue();
		int time=Integer.parseInt(sp1.toString());
		AppointmentManager obj1=new AppointmentManager();
		if(time>12)
		{
			amtopm=time-12;
			fordatetime=sp.toString()+" " +month +" " +year +" " +amtopm +":00" +" " +"PM";
			obj1.timeslot=fordatetime;
		}
		else
		{
			fordatetime=sp.toString()+" " +month +" " +year +" " +time +":00" +" " +"AM";
			obj1.timeslot=fordatetime;
		}
		ImageIcon ii=new ImageIcon("twitter_512x512x32.png");		
		ImageIcon ii1=new ImageIcon("12446887174.png");
		ResultSet rs=obj1.returnCount();
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
			obj1.forslot=obj1.timeslot;
			//obj1.insertAppoint();
			UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Tahoma",Font.PLAIN,18)));
			JOptionPane.showMessageDialog(this,"AVAILABLE!\n"+fordatetime,"Appointment fixed",JOptionPane.ERROR_MESSAGE,ii);
		}
		else
		{
			UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Tahoma",Font.PLAIN,18)));
			JOptionPane.showMessageDialog(this,"NOT AVAILABLE! Date-time clash and contradiction\n"+fordatetime,"Appointment cannot be fixed",JOptionPane.ERROR_MESSAGE,ii1);
		}
	}		
}

class AllSet extends JPanel implements ActionListener
{
	JButton jb1;
	AllSet()
	{
		jb1=new JButton("Submit");
		jb1.setForeground(new Color(255,255,255));
		jb1.setBackground(new Color(10,118,188));	
		jb1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jb1.addActionListener(this);		
		add(jb1);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String tob=ae.getActionCommand();
		AppointmentManager obj=new AppointmentManager();
		ImageIcon customS=new ImageIcon("tumblr.gif");
		ImageIcon customH=new ImageIcon("8cACopy.png");
		Random r1=new Random();
		Random r2=new Random();
		Random r3=new Random();
		int id,n1,n2,n3;
		GetMeInfo gmi=new GetMeInfo();
		if(tob.equals("Submit"))
		{
			obj.name=gmi.nm;
			obj.reg=gmi.re;
			obj.make=gmi.mk;
			obj.meter=Integer.parseInt(PreloadedDetails.jtf4.getText());
			obj.engine=gmi.en;
			obj.fuel=PreloadedDetails.jtf1.getText();
			obj.cn1=PreloadedDetails.jtf2.getText();
			obj.cn2=PreloadedDetails.jtf3.getText();
			n1=r1.nextInt(1000);
			n2=r2.nextInt(2000);
			n3=r3.nextInt(3000);
			/*id=Integer.parseInt("12431")+obj.meter+n1+n2+n3;
			obj.myid=id;*/
			int x=obj.insertAppoint();
			if(x>0)
			{
				UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Tahoma",Font.PLAIN,18)));
				//JOptionPane.showMessageDialog(this,"RECORD SUCCESSFULLY ADDED\nToken No: " +obj.token +"\nYour unique ID is:"+id,"Remember but dont share your ID",JOptionPane.ERROR_MESSAGE,customH);
			}
			else
			{
				UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Tahoma",Font.PLAIN,18)));
				JOptionPane.showMessageDialog(this,"OOPS! HAPPENS WHEN FIELDS ARE PROVIDED WITH BIAS INFO","Something went wrong!",JOptionPane.ERROR_MESSAGE,customS);
			}
		}
	}
}
