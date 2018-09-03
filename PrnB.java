import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.SQLException.*;
import java.awt.print.*;
import java.sql.*;

class CheckIfExists extends JPanel
{
	static String tk="",nm="",re="",mk="";
	CheckIfExists()
	{
		try
		{
			ServiceQueue obj=new ServiceQueue();
			ResultSet rs=obj.tokenExists();
			if(rs!=null)
			{			
				while(rs.next())
				{
					tk=rs.getString(1);
					nm=rs.getString(2);
					re=rs.getString(3);
					mk=rs.getString(4);					
				}
			}			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,e.toString());
		}		
	}
}

class PrnB extends JFrame
{
	public PrnB()
	{
		new CheckIfExists();
		Container cp=getContentPane();
		setLayout(new BorderLayout());
		cp.add(new MyReciept(),BorderLayout.NORTH);
		cp.add(new MyPrint(),BorderLayout.CENTER);
	}
}

class MyReciept extends JPanel
{
	static JTextArea jl;
	String n=CheckIfExists.nm,r=CheckIfExists.re,m=CheckIfExists.mk,msg="";
	static String partschanged="";
	public MyReciept()
	{
		Font f=new Font("Tahoma",Font.PLAIN,17);
		Formatter fmt=new Formatter();
		Calendar cal=Calendar.getInstance();
		fmt=new Formatter();
		fmt.format("%td %tB %tY",cal,cal,cal);
		if(Fields.tap>0)
		{
			msg+="\nTapid: "+Fields.tap;	
		}
		if(Fields.cha>0)
		{
			msg+="\nChain timing: "+Fields.cha;	
		}
		if(Fields.eng>0)
		{
			msg+="\nEngine Oil: "+Fields.eng;	
		}
		if(Fields.gea>0)
		{
			msg+="\nGear/Transmission Play: "+Fields.gea;	
		}
		if(Fields.car>0)
		{
			msg+="\nCarburater: "+Fields.car;	
		}
		if(Fields.tun>0)
		{
			msg+="\nTune up: "+Fields.tun;	
		}
		if(Fields.ali>0)
		{
			msg+="\nAlignment: "+Fields.ali;
		}
		if(Fields.hea>0)
		{
			msg+="\nHead/Tail lamp: "+Fields.hea;	
		}
		if(Fields.oil>0)
		{
			msg+="\nOiling/Greasing: "+Fields.oil;
		}
		if(Fields.fue>0)
		{
			msg+="\nFuel line: "+Fields.fue;
		}
		if(Fields.bra>0)
		{
			msg+="\nBrakes paly: "+Fields.bra;	
		}
		if(Fields.fuel>0)
		{
			msg+="\nFuel effeciency "+Fields.fuel;
		}
		if(Fields.noi>0)
		{
			msg+="\nNoise check: "+Fields.noi;	
		}
		if(Fields.pol>0)
		{
			msg+="\nPollution check: "+Fields.pol;
		}
		if(Fields.ful>0)
		{
			msg+="\nFull body wash "+Fields.ful;
		}
		if(Fields.poli>0)
		{
			msg+="\nPolish: "+Fields.poli;
		}
		if(partschanged.equals(""))
		{
			msg+="\n\nParts changed: NONE\n";
		}
		else
		{
			msg+="\n\nParts changed:\n"+partschanged;
		}
		jl=new JTextArea("                  BAJAJ SERVICE CENTER  \nLaal Jhandi Chauraha, Station Road, KOTDWARA-211003\n           Contact-9453526685, 7408904000" +"\n\nName: "+n +"\nRegistration.: "+r +"\nMake: "+m +"\n" +msg +"\nTOTAL: "+Fields.total +"\n\n"+fmt +"\n\nTHIS IS A COMPUTER GENERATED INVOICE\nNO SIGNATURE REQUIRED");
	
		
		//jl.setEditable(false);
		add(jl);
		jl.setFont(f);		
		add(jl);
			
		
	}
	public static void printit()
	{
		partschanged="";
		Fields.total=0;
		Fields.tap=0;Fields.eng=0;Fields.car=0;Fields.ali=0;Fields.oil=0;
		Fields.bra=0;Fields.noi=0;Fields.ful=0;Fields.cha=0;Fields.gea=0;
		Fields.tun=0;Fields.hea=0;Fields.fue=0;Fields.fuel=0;Fields.pol=0;
		Fields.poli=0;
		
		/*REMOVING THE TOKEN FROM THE CURRENT QUEUE 
		AS THE BILL HAS BEEN PREPARED*/		
		ServiceQueue sq=new ServiceQueue();
		sq.ttd=Integer.parseInt(CheckIfExists.tk);
		sq.delFromCurQueue();
		
		
		try
		{
			jl.print();
		}
		catch (PrinterException pe) 
		{
			System.err.println("Error printing: " + pe.getMessage());
		}
	}
}

class MyPrint extends JPanel
{
	ImageIcon ii;
	public MyPrint()
	{
		ii=new ImageIcon("Icon-Print.gif");
		JButton button = new JButton(ii);		
		add(button);
		
		ActionListener printAction = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				MyReciept.printit();
			}
		};
		button.addActionListener(printAction);
	}
}