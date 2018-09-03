import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.plaf.FontUIResource;

public class BillPaymentForm extends JFrame
{
	public BillPaymentForm()
	{
		Container cp=getContentPane();
		setLayout(new BorderLayout());
		cp.add(new Fields(),BorderLayout.EAST);
		cp.add(new LabelPad(),BorderLayout.WEST);
	}
}

class LabelPad extends JPanel
{
	LabelPad()
	{
		ImageIcon ii=new ImageIcon("icon-admin.png");
		add(new JLabel(ii));
	}
}

class Fields extends JPanel implements ActionListener, ItemListener
{
	static int tap=0,eng=0,car=0,ali=0,oil=0,bra=0,noi=0,ful=0,cha=0,gea=0,tun=0,hea=0,fue=0,fuel=0,pol=0,poli=0;
	int ctap=0,ccha=0,ceng=0,cgea=0,ccar=0,ctun=0,cali=0,chea=0,coil=0,cfue=0,cbra=0,cfuel=0,cnoi=0,cpol=0,cful=0,cpoli=0;
	static int total=0;
	JButton jb1,jb2;
	ImageIcon ii;
	JCheckBox jcb1,jcb2,jcb3,jcb4,jcb5,jcb6,jcb7,jcb8,jcb9,jcb10,jcb11,jcb12,jcb13,jcb14,jcb15,jcb16;
	public Fields()
	{
		ii=new ImageIcon("jake.png");
		jb1=new JButton("PARTS CHANGED?");
		jb1.addActionListener(this);
		jb2=new JButton("NO! THATS IT");
		jb2.addActionListener(this);
		
		jb1.setBackground(new Color(10,118,188));
		jb1.setForeground(new Color(255,255,255));
		jb1.setFont(new Font("Tahoma",Font.BOLD,15));
		jb2.setBackground(new Color(10,118,188));
		jb2.setForeground(new Color(255,255,255));
		jb2.setFont(new Font("Tahoma",Font.BOLD,15));
			
		jcb1=new JCheckBox("Tapid ");
		jcb2=new JCheckBox("Chain timing ");
		jcb3=new JCheckBox("Engine Oil ");
		jcb4=new JCheckBox("Gear/Transmission play ");
		jcb5=new JCheckBox("Carburator ");
		jcb6=new JCheckBox("Tune up ");
		jcb7=new JCheckBox("Alignment ");
		jcb8=new JCheckBox("Head/Tail Lamps & Electronics ");
		jcb9=new JCheckBox("Oiling/Greasing ");
		jcb10=new JCheckBox("Fuel line ");		
		jcb11=new JCheckBox("Brake play ");
		jcb12=new JCheckBox("Fuel effeciency ");
		jcb13=new JCheckBox("Noise check ");
		jcb14=new JCheckBox("Pollution check ");
		jcb15=new JCheckBox("Full body wash ");
		jcb16=new JCheckBox("Polish ");
		
		jcb1.addItemListener(this);
		jcb2.addItemListener(this);		
		jcb3.addItemListener(this);
		jcb4.addItemListener(this);
		jcb5.addItemListener(this);
		jcb6.addItemListener(this);		
		jcb7.addItemListener(this);
		jcb8.addItemListener(this);
		jcb9.addItemListener(this);
		jcb10.addItemListener(this);		
		jcb11.addItemListener(this);
		jcb12.addItemListener(this);
		jcb13.addItemListener(this);
		jcb14.addItemListener(this);		
		jcb15.addItemListener(this);
		jcb16.addItemListener(this);
		
		jcb1.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb2.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb3.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb4.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb5.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb6.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb7.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb8.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb9.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb10.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb11.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb12.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb13.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb14.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb15.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
		jcb16.setFont(new Font("Arial Rounded MT PLAIN",Font.PLAIN,18));
	
		jcb1.setForeground(new Color(103,186,7));
		jcb2.setForeground(new Color(103,186,7));
		jcb3.setForeground(new Color(103,186,7));
		jcb4.setForeground(new Color(103,186,7));
		jcb5.setForeground(new Color(103,186,7));
		jcb6.setForeground(new Color(103,186,7));
		jcb7.setForeground(new Color(103,186,7));
		jcb8.setForeground(new Color(103,186,7));
		jcb9.setForeground(new Color(103,186,7));
		jcb10.setForeground(new Color(103,186,7));
		jcb11.setForeground(new Color(103,186,7));
		jcb12.setForeground(new Color(103,186,7));
		jcb13.setForeground(new Color(103,186,7));
		jcb14.setForeground(new Color(103,186,7));
		jcb15.setForeground(new Color(103,186,7));
		jcb16.setForeground(new Color(103,186,7));

		setLayout(new GridLayout(9,2,5,5));
		add(jcb1);
		add(jcb2);
		add(jcb3);
		add(jcb4);
		add(jcb5);
		add(jcb6);
		add(jcb7);
		add(jcb8);
		add(jcb9);
		add(jcb10);
		add(jcb11);
		add(jcb12);
		add(jcb13);
		add(jcb14);
		add(jcb15);
		add(jcb16);
		add(jb1);
		add(jb2);
		}
	
	public void actionPerformed(ActionEvent ae)
	{
		String tob=ae.getActionCommand();
		if(tob.equals("PARTS CHANGED?"))
		{
			new PartsChanged();
		}
		else
		{
			add();
			UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Tahoma",Font.PLAIN,18)));
			JOptionPane.showMessageDialog(this,"CLIENT IS LEAVING!" +"\nYou are required to take "+total +" INR from him","Gate Pass",JOptionPane.ERROR_MESSAGE,ii);
			JFrame jrf=new PrnB();
			jrf.setVisible(true);
			jrf.setSize(500,600);
		}
	}
	
	public void itemStateChanged(ItemEvent ie)
	{
		Object source=ie.getItemSelectable();
		if(source==jcb1)
		{
			ctap++;
			if(ctap%2==0)
			tap=0;
			
			else
			tap+=20;
		}

		if(source==jcb2)
		{
			ccha++;
			if(ccha%2==0)
			cha=0;
			
			else
			cha+=20;
		}

		if(source==jcb3)
		{
			ceng++;
			if(ceng%2==0)
			eng=0;

			else
			eng+=175;
		}

		if(source==jcb4)
		{
			cgea++;
			if(cgea%2==0)
			gea=0;

			else
			gea+=50;
		}
		
		if(source==jcb5)
		{
			ccar++;
			if(ccar%2==0)
			car=0;
			
			else
			car+=100;
		}

		if(source==jcb6)
		{
			ctun++;
			if(ctun%2==0)
			tun=0;
			
			else
			tun+=10;
		}

		if(source==jcb7)
		{
			cali++;
			if(cali%2==0)
			ali=0;

			else
			ali+=20;
		}

		if(source==jcb8)
		{
			chea++;
			if(chea%2==0)
			hea=0;

			else
			hea+=10;
		}
		
		if(source==jcb9)
		{
			coil++;
			if(coil%2==0)
			oil=0;
			
			else
			oil+=50;
		}

		if(source==jcb10)
		{
			cfue++;
			if(cfue%2==0)
			fue=0;
			
			else
			fue+=50;
		}

		if(source==jcb11)
		{
			cbra++;
			if(cbra%2==0)
			bra=0;

			else
			bra+=10;
		}

		if(source==jcb12)
		{
			cfuel++;
			if(cfuel%2==0)
			fuel=0;

			else
			fuel=20;
		}
		
		if(source==jcb13)
		{
			cnoi++;
			if(cnoi%2==0)
			noi=0;
			
			else
			noi+=20;
		}

		if(source==jcb14)
		{
			cpol++;
			if(cpol%2==0)
			pol=0;
			
			else
			pol+=20;
		}

		if(source==jcb15)
		{
			cful++;
			if(cful%2==0)
			ful=0;

			else
			ful+=50;
		}

		if(source==jcb16)
		{
			cpoli++;
			if(cpoli%2==0)
			poli=0;

			else
			poli+=20;
		}
	}

	public void add()
	{
		total+=tap+cha+eng+gea+car+tun+ali+hea+oil+fue+bra+fuel+noi+pol+ful+poli;
	}	
}