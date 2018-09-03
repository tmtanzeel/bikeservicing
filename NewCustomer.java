import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
import javax.swing.plaf.FontUIResource;

class NewCustomer extends JFrame
{
	JFrame jrf;
	NewCustomer()
	{
		jrf=new JFrame();
		jrf.setVisible(true);
		setLayout(new BorderLayout());		
		jrf.add(new MyLabel(),BorderLayout.NORTH);
		jrf.add(new MyNRD(),BorderLayout.CENTER);
		jrf.add(new MyForm(),BorderLayout.SOUTH);
		jrf.setSize(800,340);
		jrf.setLocation(200,300);
		jrf.setTitle("JOB CARD");
		jrf.setVisible(true);
	}
}

class MyLabel extends JPanel
{
	Font f;
	JLabel jl;
	MyLabel()
	{
		jl=new JLabel("Fill up this form please");
		f=new Font("Tahoma",Font.PLAIN,30);
		jl.setFont(f);
		jl.setForeground(new Color(103,186,7));
		add(jl);
	}
}

class MyNRD extends JPanel
{
	JLabel jl1,jl2;
	static JTextField jt1,jt2,jt3,jt4,jt5,jt6;
	MyNRD()
	{
		setLayout(new GridLayout(2,4));
		jl1=new JLabel("Name:");
		jl2=new JLabel("Registration:");
				
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

		add(jl1);
		add(jt1);
		add(jt2);
		add(jt3);
		
		add(jl2);
		add(jt4);
		add(jt5);
		add(jt6);
	}
}

class MyForm extends JPanel implements ActionListener
{
	static JTextField jt1,jt2,jt3,jt4,jt5,jt6;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JButton jb1,jb2;
	MyForm()
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
		ServiceQueue obj=new ServiceQueue();
		ImageIcon customS=new ImageIcon("tumblr.gif");
		ImageIcon customH=new ImageIcon("8cACopy.png");
		Random r1=new Random();
		Random r2=new Random();
		Random r3=new Random();
		int id,n1,n2,n3;
		if(tob.equals("Submit"))
		{
			obj.name=MyNRD.jt1.getText() +" " +MyNRD.jt2.getText() +" " +MyNRD.jt3.getText();
			obj.reg=MyNRD.jt4.getText() +" " +MyNRD.jt5.getText() +" " +MyNRD.jt6.getText();
			obj.make=MyForm.jt1.getText();
			obj.meter=Integer.parseInt(MyForm.jt2.getText());
			obj.engine=MyForm.jt3.getText();
			obj.fuel=MyForm.jt4.getText();
			obj.cn1=MyForm.jt5.getText();
			obj.cn2=MyForm.jt6.getText();
			n1=r1.nextInt(1000);
			n2=r2.nextInt(2000);
			n3=r3.nextInt(3000);
			id=Integer.parseInt(MyNRD.jt6.getText())+obj.meter+n1+n2+n3;
			obj.myid=id;
			ResultSet rs=obj.lastToken();
			try
			{
				if(rs!=null)
				{
					while(rs.next())
					{
						String tkn=rs.getString(1);
						obj.token=Integer.parseInt(tkn)+1;
					}
				}
			}
			catch(Exception e)
			{
				//JOptionPane.showMessageDialog(this,e.toString());
			}		
						
			int x=obj.insert();
			if(x>0)
			{
				UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Tahoma",Font.PLAIN,18)));
				JOptionPane.showMessageDialog(this,"RECORD SUCCESSFULLY ADDED\nToken No: " +obj.token +"\nYour unique ID is:"+id,"Remember but dont share your ID",JOptionPane.ERROR_MESSAGE,customH);
			}
			else
			{
				UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Tahoma",Font.PLAIN,18)));
				JOptionPane.showMessageDialog(this,"OOPS! HAPPENS WHEN FIELDS ARE PROVIDED WITH BIAS INFO","Something went wrong!",JOptionPane.ERROR_MESSAGE,customS);
			}
		}
	}
}