import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
import javax.swing.plaf.FontUIResource;

class PartsChanged extends JFrame
{
	JFrame jrf;
	PartsChanged()
	{
		jrf=new JFrame();
		jrf.setVisible(true);
		setLayout(new BorderLayout());		
		jrf.add(new ServiceLabel(),BorderLayout.NORTH);
		jrf.add(new MyBikePart(),BorderLayout.CENTER);
		jrf.add(new MyButton(),BorderLayout.SOUTH);
		jrf.setSize(300,380);
		jrf.setLocation(200,300);
		jrf.setTitle("JOB CARD");
		jrf.setVisible(true);
	}
}

class ServiceLabel extends JPanel
{
	ImageIcon ii;
	JLabel jl;
	ServiceLabel()
	{
		ii=new ImageIcon("piston.gif");
		jl=new JLabel(ii);
		add(jl);
		setBackground(Color.WHITE);
	}
}

class MyBikePart extends JPanel
{
	JLabel jl1,jl2,jl3;
	static Choice ch0,ch1,ch2;
	MyBikePart()
	{
		jl1=new JLabel("MAKE:");
		jl2=new JLabel("DISPLACEMENT:");
		jl3=new JLabel("PART:");;
		jl1.setForeground(new Color(103,186,7));
		jl2.setForeground(new Color(103,186,7));
		jl3.setForeground(new Color(103,186,7));		
		jl1.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,17));
		jl2.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,17));
		jl3.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,17));
		
		ch0=new Choice();
		ch1=new Choice();
		ch2=new Choice();
		
		ch0.add("AVENGER");
		ch0.add("DISCOVER");
		ch0.add("XCD");
		ch0.add("PULSAR");
		ch0.add("PLATINA");		
		ch0.add("VIKRANT");
		
		ch1.add("150");
		ch1.add("100");
		ch1.add("110");
		ch1.add("135");		
		ch1.add("180");
		ch1.add("220");
		
		ch2.add("Crank");
		ch2.add("Saddle");
		ch2.add("Jiggly");
		ch2.add("Cowls");		
		ch2.add("Indicator");
		ch2.add("Piston");
		ch2.add("Sprocket");
		ch2.add("Visor");	
		ch2.add("Exhaust");
		ch2.add("Lamp Covers");
		ch2.add("Lamp Head");
		ch2.add("Lamp Tail");
		ch2.add("Mud Guard Front");
		ch2.add("Mud Guard Rear");
		ch2.add("Piston Ring");
		ch2.add("Self Start");		
		ch2.add("Suspension Front");
		ch2.add("Suspension Rear");
		
		ch0.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		ch1.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		ch2.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		
		ch0.setForeground(new Color(10,118,188));
		ch1.setForeground(new Color(10,118,188));
		ch2.setForeground(new Color(10,118,188));
		
		setLayout(new GridLayout(3,2));
		add(jl1);
		add(ch0);
		add(jl2);
		add(ch1);
		add(jl3);
		add(ch2);
	}
}

class MyButton extends JPanel implements ActionListener
{
	JButton jb1,jb2;
	MyButton()
	{
		jb1=new JButton("ADD TO CART");
		jb1.setForeground(new Color(255,255,255));
		jb1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jb1.addActionListener(this);
		jb1.setForeground(new Color(255,255,255));
		jb1.setBackground(new Color(10,118,188));
		jb2=new JButton("DONE");
		jb2.setForeground(new Color(255,255,255));
		jb2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jb2.addActionListener(this);
		jb2.setForeground(new Color(255,255,255));
		jb2.setBackground(new Color(10,118,188));
		add(jb1);
		add(jb2);
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		ServiceQueue obj=new ServiceQueue();
		obj.table=MyBikePart.ch0.getItem(MyBikePart.ch0.getSelectedIndex());
		String temp=MyBikePart.ch1.getItem(MyBikePart.ch1.getSelectedIndex());
		obj.mydisp=Integer.parseInt(temp);
		obj.mypart=MyBikePart.ch2.getItem(MyBikePart.ch2.getSelectedIndex());
		
		
		//CHECKING IF THERE ARE UNITS OF THAT PART LEFT OR NOT
		//CrossCheckInventory cci=new CrossCheckInventory();
		InventoryManager im=new InventoryManager();
		im.table=MyBikePart.ch0.getItem(MyBikePart.ch0.getSelectedIndex());
		temp=MyBikePart.ch1.getItem(MyBikePart.ch1.getSelectedIndex());
		im.disp=Integer.parseInt(temp);
		im.part=MyBikePart.ch2.getItem(MyBikePart.ch2.getSelectedIndex());
		ResultSet rs=im.seeIfThere();
		try
		{
			if(rs!=null)
			{
				while(rs.next())
				{
					String units=rs.getString(1);
					im.unileft=Integer.parseInt(units);
				}
			}
		}
		catch(Exception e)
		{
			//JOptionPane.showMessageDialog(this,e.toString());
		}
		
		if(im.unileft==0)
		{
			UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Tahoma",Font.PLAIN,18)));
			ImageIcon customS=new ImageIcon("toolb.png");
			JOptionPane.showMessageDialog(this,"We don't have this part right now","Whooops",JOptionPane.ERROR_MESSAGE,customS);
		}
		else
		{
		
		//DELETING ONE UNIT OF THIS PART FROM THE INVENTORY
		//InventoryManager im=new InventoryManager();		
		im.deleteAUnit();
		
		PartPriceCalc ppc=new PartPriceCalc();
		System.out.println(ppc.price);
		
		MyReciept mr=new MyReciept();
		mr.partschanged+=obj.mypart +": " +ppc.price +"\n";
		
		Fields fi=new Fields();
		fi.total+=ppc.price;
		System.out.println("grand is now: " +fi.total);
		}
		/*obj.name=MyNRD.jt1.getText() +" " +MyNRD.jt2.getText() +" " +MyNRD.jt3.getText();
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
		*/
		
		}
}
