import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MyMainFrame extends JFrame
{
	JFrame jrf;
	MyMainFrame()
	{
		jrf=new JFrame();
		/*SplashScreen splash = new SplashScreen(5000);
    
		splash.showSplashAndExit();*/
		setLayout(new BorderLayout());
		jrf.add(new MyBanner(),BorderLayout.NORTH);
		jrf.add(new MyBannerTop(),BorderLayout.CENTER);
		jrf.add(new MyJobs(),BorderLayout.SOUTH);
		jrf.setSize(1060,680);
		jrf.setResizable(false);
		jrf.setLocation(170,50);
		jrf.setVisible(true);
		jrf.setBackground(Color.RED);
		jrf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String cla[])
	{
		new MyMainFrame();
	}
}

class MyBannerTop extends JPanel
{
	Color cl=new Color(38,38,38);
	MyBannerTop()
	{
		ImageIcon ii=new ImageIcon("as.gif");
		add(new JLabel(ii));
		setBackground(cl);
	}
}

class MyBanner extends JPanel
{
	Color cl=new Color(38,38,38);
	MyBanner()
	{
		ImageIcon ii=new ImageIcon("Image.gif");
		add(new JLabel(ii));
		setBackground(cl);
	}
}

class MyJobs extends JPanel implements ActionListener
{
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7;
	ImageIcon ii1,ii2,ii3,ii4,ii5,ii6,ii7,cons;
	MyJobs()
	{
		setBackground(Color.BLACK);
		
		ii1=new ImageIcon("1.png");
		ii2=new ImageIcon("2.png");
		ii3=new ImageIcon("3.png");
		ii4=new ImageIcon("4.png");
		ii5=new ImageIcon("5.png");
		ii6=new ImageIcon("6.png");
		ii7=new ImageIcon("7.png");
				
		cons=new ImageIcon("UnderConstruction.png");
	
		setLayout(new GridLayout(1,7,2,2));
		jb1=new JButton(ii1);
		jb2=new JButton(ii2);
		jb3=new JButton(ii3);
		jb4=new JButton(ii4);
		jb5=new JButton(ii5);
		jb6=new JButton(ii6);
		jb7=new JButton(ii7);

		jb1.setBackground(new Color(255,201,14));
		jb2.setBackground(new Color(255,201,14));
		jb3.setBackground(new Color(255,201,14));
		jb4.setBackground(new Color(255,201,14));
		jb5.setBackground(new Color(255,201,14));
		jb6.setBackground(new Color(255,201,14));
		jb7.setBackground(new Color(255,201,14));

		jb1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jb2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jb3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jb4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jb5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jb6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jb7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		jb1.setActionCommand("New");
		jb2.setActionCommand("Update");
		jb3.setActionCommand("Admin");
		jb4.setActionCommand("Drop");
		jb5.setActionCommand("Find");
		jb6.setActionCommand("Queue");
		jb7.setActionCommand("Appoint");

		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);		
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		jb7.addActionListener(this);

		add(jb1);
		add(jb2);
		add(jb3);
		add(jb4);		
		add(jb5);
		add(jb6);
		add(jb7);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String tob=ae.getActionCommand();
		if(tob.equals("New"))
		{
			SwingUtilities.invokeLater(new Runnable(){public void run(){new NewCustomer();}});	
		}
		else if(tob.equals("Admin"))
		{
			SwingUtilities.invokeLater(new Runnable(){public void run(){new LoginMechanism();}});
		}
		else if(tob.equals("Drop"))
		{
			JOptionPane.showMessageDialog(this,"","",JOptionPane.ERROR_MESSAGE,cons);
		}
		else if(tob.equals("Find"))
		{
			SwingUtilities.invokeLater(new Runnable(){public void run(){new FindBox();}});
		}
		else if(tob.equals("Appoint"))
		{
			JFrame jrf=new NewArrOrReVisit();
			jrf.setSize(500,200);
			jrf.setResizable(false);
			jrf.setLocation(170,50);
			jrf.setVisible(true);
		}		
		else if(tob.equals("Queue"))
		{
			SwingUtilities.invokeLater(new Runnable(){public void run(){JFrame jrf=new CurrentQueueStatus();jrf.setVisible(true);jrf.setSize(1000,400);jrf.setLocation(200,100);}});
		}
		else if(tob.equals("Update"))
		{
			JOptionPane.showMessageDialog(this,"You can update NAME and CONTACT numbers only","TOP SECRET",JOptionPane.ERROR_MESSAGE,new ImageIcon("Folder.png"));
			JFrame jrf=new NewArrOrReVisit();
			jrf.setSize(500,200);
			jrf.setResizable(false);
			jrf.setLocation(170,50);
			jrf.setVisible(true);
		}
	}
}