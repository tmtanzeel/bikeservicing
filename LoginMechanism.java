import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.plaf.FontUIResource;

public class LoginMechanism extends JFrame
{
	JFrame jrf;
	public LoginMechanism()
	{
		jrf=new JFrame();
		jrf.setVisible(true);
		jrf.setSize(400,300);
		jrf.setLocation(500,150);
		setLayout(new BorderLayout());
		jrf.add(new AdminLabel(),BorderLayout.NORTH);
		jrf.add(new UserIdPass(),BorderLayout.CENTER);
		jrf.add(new SignInButton(),BorderLayout.SOUTH);
	}
}

class AdminLabel extends JPanel
{
	ImageIcon ii;
	AdminLabel()
	{
		ii=new ImageIcon("unlock_icon.png");
		add(new JLabel(ii));
	}
}

class UserIdPass extends JPanel
{
	static JTextField id;
	static TextField jpf;
	JLabel x,y;
	
	public UserIdPass()
	{

		Font f=new Font("Arial Rounded MT Bold",Font.PLAIN,15);
		
		x=new JLabel("Login ID: ");
		y=new JLabel("Password: ");
		x.setForeground(new Color(103,186,7));
		y.setForeground(new Color(103,186,7));

		id=new JTextField(12) ;
		jpf=new TextField(12) ;
			
		x.setFont(f);
		y.setFont(f);
		id.setFont(f);
		jpf.setFont(f);
		jpf.setEchoChar('*');
		
		setLayout(new GridLayout(2,2,10,10));
		add(x);
		add(id);
		add(y);
		add(jpf);		
	}
}


class SignInButton extends JPanel implements ActionListener
{
	JButton jb;
	int maxtry=3;
	public SignInButton()
	{
		jb=new JButton("Sign In");
		add(jb);
		jb.addActionListener(this);
		jb.setBackground(new Color(10,118,188));
		jb.setForeground(new Color(255,255,255));
		jb.setFont(new Font("Tahoma",Font.BOLD,15));
	}
	
	public void actionPerformed(ActionEvent ae)
	{			
		String userid=UserIdPass.id.getText();
		String password=UserIdPass.jpf.getText();		
		
		String tob=ae.getActionCommand();
		ImageIcon customH=new ImageIcon("hacker-512.png");
		ImageIcon customS1=new ImageIcon("sad.png");		
		ImageIcon customS=new ImageIcon("mabel.png");		
		if(tob.equals("Sign In"))
		{
			if(userid.equals("") && password.equals(""))
			{
				UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Tahoma",Font.PLAIN,18)));		
				JOptionPane.showMessageDialog(this,"PERMISSION GRANTED","Authorized user",JOptionPane.ERROR_MESSAGE,customH);
				JFrame jrf=new AdminControls();		
				jrf.setVisible(true);
				jrf.setLocation(350,200);
				jrf.setTitle("Main Frame");
				jrf.pack();
			}
			else
			{
				maxtry--;
				if(maxtry>0)
				{
					UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Tahoma",Font.PLAIN,18)));		
					JOptionPane.showMessageDialog(this,"Wrong Passcode! Trials remaining "+maxtry,"Intruder Alert!",JOptionPane.ERROR_MESSAGE,customS1);
				}					
				else
				{
					UIManager.put("OptionPane.messageFont",new FontUIResource(new Font("Tahoma",Font.PLAIN,18)));		
					JOptionPane.showMessageDialog(this,"OOH ENOUGH GARBAGE! Misspelled passcodes are Garbage\nOPEN YOUR MOUTH AND TAKE THEM BACK","Intruder Alert!",JOptionPane.ERROR_MESSAGE,customS);
				}
			}
		}
	}
}