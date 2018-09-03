import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.awt.print.*;
import java.util.*;

/*public class ShowMe extends JFrame
{
	public ShowMe()
	{
		//Container cp=getContentPane();
		setLayout(new FlowLayout());
		add(new MyData());
		add(new LoadButton());
	}
}*/

class  MyData extends JFrame
{
	JButton jb;
	public MyData()
	{
		Object head[]={"ID","NAME","REGISTRATION","MAKE","METER","ENGINE NO","CONTACT 1","CONTACT 2"};
		Object rec[][]={{null,null,null,null,null,null,null,null}};
		JTable tbl=new JTable();
		DefaultTableModel model=new DefaultTableModel();
		tbl.setModel(model);
		model.setColumnIdentifiers(head);
		
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
					nm=rs.getString(2);
					re=rs.getString(3);
					mk=rs.getString(4);
					mt=rs.getString(5);
					en=rs.getString(6);
					c1=rs.getString(7);
					c2=rs.getString(8);
										
					model.addRow(new Object[]{id,nm,re,mk,mt,en,c1,c2});
				}
			}
		}

		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,e.toString());
		}		
		JScrollPane jsp=new JScrollPane(tbl);
		add(jsp);		
	}
}

class  LoadButton extends JPanel implements ActionListener
{
	public  LoadButton()
	{
		JButton button = new JButton("Work on");		
		add(button);
		button.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae){}
}