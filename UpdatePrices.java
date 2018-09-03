import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.sql.*;
import javax.swing.plaf.FontUIResource;

class UpdatePrices extends JFrame
{
	JFrame jrf;
	UpdatePrices()
	{
		jrf=new JFrame();
		jrf.setVisible(true);
		setLayout(new BorderLayout());		
		jrf.add(new InfoLabel1(),BorderLayout.NORTH);
		jrf.add(new ThreeParts1(),BorderLayout.CENTER);
		jrf.add(new ChangeButton1(),BorderLayout.SOUTH);
		jrf.setSize(300,380);
		jrf.setLocation(200,300);
		jrf.setTitle("JOB CARD");
		jrf.setVisible(true);
	}
}

class InfoLabel1 extends JPanel
{
	ImageIcon ii;
	JLabel jl;
	InfoLabel1()
	{
		ii=new ImageIcon("piston.gif");
		jl=new JLabel(ii);
		add(jl);
		setBackground(Color.WHITE);
	}
}

class ThreeParts1 extends JPanel
{
	JLabel jl1,jl2,jl3;
	static Choice ch1,ch2;
	static JSpinner jsp;
	ThreeParts1()
	{
		jl1=new JLabel("PART:");
		jl2=new JLabel("DISPLACEMENT:");
		jl3=new JLabel("NEW VALUE:");;
		jl1.setForeground(new Color(103,186,7));
		jl2.setForeground(new Color(103,186,7));
		jl3.setForeground(new Color(103,186,7));		
		jl1.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,17));
		jl2.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,17));
		jl3.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,17));
		
		ch1=new Choice();
		ch2=new Choice();
		SpinnerNumberModel snm = new SpinnerNumberModel(
                new Integer(0),
                new Integer(0),
                new Integer(3000),
                new Integer(5)
        );
        jsp = new JSpinner(snm);
		
		ch1.add("Crank");
		ch1.add("Saddle");
		ch1.add("Jiggly");
		ch1.add("Cowls");		
		ch1.add("Indicator");
		ch1.add("Piston");
		ch1.add("Sprocket");
		ch1.add("Visor");	
		ch1.add("Lamp Covers");
		ch1.add("Lamp Head");
		ch1.add("Lamp Tail");
		ch1.add("Mud Guard Front");
		ch1.add("Mud Guard Rear");
		ch1.add("Piston Ring");
		ch1.add("Self Start");		
		ch1.add("Suspension Front");
		ch1.add("Suspension Rear");
		
		ch2.add("150");
		ch2.add("100");
		ch2.add("110");
		ch2.add("135");		
		ch2.add("180");
		ch2.add("220");		
		
		ch1.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		ch2.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		jsp.setFont(new Font("Arial Rounded MT PLAIN",Font.BOLD,14));
		
		ch1.setForeground(new Color(10,118,188));
		ch2.setForeground(new Color(10,118,188));
		jsp.setForeground(new Color(10,118,188));
		
		setLayout(new GridLayout(3,2));
		add(jl1);
		add(ch1);
		add(jl2);
		add(ch2);
		add(jl3);
		add(jsp);
	}
}

class ChangeButton1 extends JPanel implements ActionListener
{
	JButton jb1;
	ChangeButton1()
	{
		jb1=new JButton("Yes I'm sure");
		jb1.setForeground(new Color(255,255,255));
		jb1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jb1.setBackground(new Color(10,118,188));
		jb1.addActionListener(this);
		add(jb1);
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		InventoryManager im =new InventoryManager();
		im.part=ThreeParts1.ch1.getItem(ThreeParts1.ch1.getSelectedIndex());
		String temp=ThreeParts1.ch2.getItem(ThreeParts1.ch2.getSelectedIndex());
		im.disp=Integer.parseInt(temp);		
		Object sp;
		sp=ThreeParts1.jsp.getValue();
		im.npric=Integer.parseInt(sp.toString());
		im.updateInvPrices();
	}
}