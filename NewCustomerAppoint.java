import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
import javax.swing.plaf.FontUIResource;

class NewCustomerAppoint extends JFrame
{
	JFrame jrf;
	NewCustomerAppoint()
	{
		jrf=new JFrame();
		jrf.setVisible(true);
		setLayout(new BorderLayout());
		jrf.add(new MyLabelAppoint(),BorderLayout.NORTH);
		jrf.add(new MyNRDAppoint(),BorderLayout.CENTER);
		jrf.add(new MyFormAppoint(),BorderLayout.SOUTH);
		jrf.setSize(800,395);
		jrf.setLocation(200,300);
		jrf.setTitle("JOB CARD");
		jrf.setVisible(true);
	}
}

class MyLabelAppoint extends JPanel
{
	Font f;
	JLabel jl;
	MyLabelAppoint()
	{
		jl=new JLabel("Fill up this form please");
		f=new Font("Tahoma",Font.PLAIN,30);
		jl.setFont(f);
		jl.setForeground(new Color(103,186,7));
		add(jl);
	}
}

class MyNRDAppoint extends JPanel implements ActionListener
{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	static JTextField jt1,jt2,jt3,jt4,jt5,jt6;
	static JSpinner jsp,jsp1;
	Calendar cl;
	GregorianCalendar gcl;
	int day,year,time,amtopm,temp;
	JButton jb;
	String months[]={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"},month="",fordatetime="";
	MyNRDAppoint()
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
		jb=new JButton("Validate");
		jb.setForeground(new Color(255,255,255));
		jb.setBackground(new Color(10,118,188));	
		jb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jb.addActionListener(this);
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

		setLayout(new GridLayout(4,4));
		add(jl1);
		add(jt1);
		add(jt2);
		add(jt3);
		
		add(jl2);
		add(jt4);
		add(jt5);
		add(jt6);

		add(jl3);
		add(jsp);
		add(jl4);
		add(jl5);
		add(jl6);
		add(jsp1);
		add(jl7);
		add(jb);
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

class MyFormAppoint extends JPanel implements ActionListener
{
	static JTextField jt1,jt2,jt3,jt4,jt5,jt6;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JButton jb1,jb2;
	MyFormAppoint()
	{
		jl1=new JLabel("Make:");
		jl2=new JLabel("Meter:");
		jl3=new JLabel("Engine No:");
		jl4=new JLabel("Fuel Present (Ltr):");
		jl5=new JLabel("Contact 1:");
		jl6=new JLabel("Contact 2:");
		
		jb1=new JButton("Submit");
		jb2=new JButton("Cancel");
		jb1.setForeground(new Color(255,255,255));
		jb1.setBackground(new Color(10,118,188));	
		jb2.setForeground(new Color(255,255,255));
		jb2.setBackground(new Color(10,118,188));	
		
		jb1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jb2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		jt1=new JTextField(10);
		jt1.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		jt1.setText("Pulsar 220");

		jt2=new JTextField(10);
		jt2.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		jt2.setText("12345");
	
		jt3=new JTextField(10);
		jt3.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		jt3.setText("KGUBZU02004");

		jt4=new JTextField(10);
		jt4.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		jt4.setText("2.5");

		jt5=new JTextField(10);
		jt5.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		jt5.setText("");

		jt6=new JTextField(10);
		jt6.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		jt6.setText("");
		
		setLayout(new GridLayout(8,1));
		add(jl1);
		add(jt1);
		add(jl2);
		add(jt2);
		add(jl3);
		add(jt3);
		add(jl4);
		add(jt4);
		add(jl5);
		add(jt5);
		add(jl6);
		add(jt6);
			
		add(jb1);
		add(jb2);

		jb1.addActionListener(this);
	}

	@Override
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
		if(tob.equals("Submit"))
		{
			obj.name=MyNRDAppoint.jt1.getText() +" " +MyNRDAppoint.jt2.getText() +" " +MyNRDAppoint.jt3.getText();
			obj.reg=MyNRDAppoint.jt4.getText() +" " +MyNRDAppoint.jt5.getText() +" " +MyNRDAppoint.jt6.getText();
			obj.make=MyFormAppoint.jt1.getText();
			obj.meter=Integer.parseInt(MyFormAppoint.jt2.getText());
			obj.engine=MyFormAppoint.jt3.getText();
			obj.fuel=MyFormAppoint.jt4.getText();
			obj.cn1=MyFormAppoint.jt5.getText();
			obj.cn2=MyFormAppoint.jt6.getText();
			n1=r1.nextInt(1000);
			n2=r2.nextInt(2000);
			n3=r3.nextInt(3000);
			id=Integer.parseInt(MyNRDAppoint.jt6.getText())+obj.meter+n1+n2+n3;
			obj.myid=id;
			int x=obj.insertAppoint();
			if(x>0)
			{
				UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Tahoma",Font.PLAIN,18)));
				JOptionPane.showMessageDialog(this,"RECORD SUCCESSFULLY ADDED\nToken No: " +obj.token +"\nYour unique ID is:"+id,"Remember but dont share your ID",JOptionPane.ERROR_MESSAGE,customH);
				x=obj.insertOnlyInCustomerDatabase();
			}
			else
			{
				UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Tahoma",Font.PLAIN,18)));
				JOptionPane.showMessageDialog(this,"OOPS! HAPPENS WHEN FIELDS ARE PROVIDED WITH BIAS INFO","Something went wrong!",JOptionPane.ERROR_MESSAGE,customS);
			}
		}
	}
}