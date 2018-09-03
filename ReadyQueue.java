import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class ReadyQueue extends JFrame
{
	JFrame jrf;
	public ReadyQueue()
	{
		jrf=new JFrame();
		setLayout(new BorderLayout());
		jrf.add(new UpperLabel(),BorderLayout.NORTH);
		jrf.add(new DetailLabel(),BorderLayout.CENTER);
		jrf.add(new Details(),BorderLayout.SOUTH);
		jrf.setVisible(true);
		jrf.setLocation(200,50);
		jrf.setSize(500,660);
		jrf.setResizable(false);
	}
}

class UpperLabel extends JPanel
{
	ImageIcon ii;
	UpperLabel()
	{
		ii=new ImageIcon("myLab.png");
		add(new JLabel(ii));
		setBackground(new Color(102,206,255));
	}
}

class DetailLabel extends JPanel
{
	ImageIcon ii;
	DetailLabel()
	{
		ii=new ImageIcon("102 206 255.gif");
		add(new JLabel(ii));
		setBackground(new Color(102,206,255));
	}
}

class Details extends JPanel
{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11,jl12,jl13,jl14,jl15,jl16;
	ImageIcon wall;
	Details()
	{
		wall=new ImageIcon("little_.jpg");
		setBackground(new Color(102,206,255));
		try
		{
			ServiceQueue obj=new ServiceQueue();
			ResultSet rs=obj.showSpecific();
			if(rs!=null)
			{			
				String id="";
				String nm="";
				String re="";
				String mk="";
				String mt="";
				String en="";
				String c1="";			
				String c2="";				
				
				while(rs.next())
				{
					id=rs.getString(1);
					if(id.length()==0)
					{
						JOptionPane.showMessageDialog(this,"","",JOptionPane.ERROR_MESSAGE,wall);
					}
					else
					{
					nm=rs.getString(2);
					re=rs.getString(3);
					mk=rs.getString(4);
					mt=rs.getString(5);
					en=rs.getString(6);
					c1=rs.getString(7);
					c2=rs.getString(8);
					
					jl1=new JLabel("ID:");
					jl2=new JLabel("NAME:");
					jl3=new JLabel("REGISTRATION:");
					jl4=new JLabel("MAKE:");
					jl5=new JLabel("METER:");
					jl6=new JLabel("ENGINE:");
					jl7=new JLabel("CONTACT 1:");
					jl8=new JLabel("CONTACT 2:");
					jl9=new JLabel(id);
					jl10=new JLabel(nm);
					jl11=new JLabel(re);
					jl12=new JLabel(mk);
					jl13=new JLabel(mt);
					jl14=new JLabel(en);
					jl15=new JLabel(c1);
					jl16=new JLabel(c2);
			
					setLayout(new GridLayout(8,2,20,20));
					jl1.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,20));
					jl2.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,20));
					jl3.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,20));
					jl4.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,20));
					jl5.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,20));
					jl6.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,20));
					jl7.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,20));
					jl8.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,20));
					jl9.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,20));
					jl10.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,20));
					jl11.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,20));
					jl12.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,20));
					jl13.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,20));
					jl14.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,20));
					jl15.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,20));
					jl16.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,20));
					
					add(jl1);
					add(jl9);					
					add(jl2);
					add(jl10);
					add(jl3);
					add(jl11);
					add(jl4);
					add(jl12);
					add(jl5);
					add(jl13);
					add(jl6);
					add(jl14);
					add(jl7);
					add(jl15);
					add(jl8);
					add(jl16);
				}
			}
			}			
		}

		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,e.toString());
		}		
	}
}