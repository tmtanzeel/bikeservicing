import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class CurrentQueueStatus extends JFrame implements ActionListener
{
	public CurrentQueueStatus()
	{
		super("CUSTOMER DATABASE");
		Container cp=getContentPane();
		cp.setLayout(new GridLayout(1,1));
		Object head[]={"TOKEN","NAME","REGISTRATION","MAKE","CONTACT 1","CONTACT 2"};
		Object rec[][]={{null,null,null,null,null,null}};
		JTable tbl=new JTable();
		DefaultTableModel model=new DefaultTableModel();
		tbl.setModel(model);
		model.setColumnIdentifiers(head);
		
		try
		{
			ServiceQueue obj=new ServiceQueue();
			ResultSet rs=obj.showTheQueue();
						
			if(rs!=null)
			{				
				String tk="";
				String nm="";
				String re="";
				String mk="";
				String c1="";			
				String c2="";				
				
				while(rs.next())
				{
					tk=rs.getString(1);
					nm=rs.getString(2);
					re=rs.getString(3);
					mk=rs.getString(4);
					c1=rs.getString(5);
					c2=rs.getString(6);
										
					model.addRow(new Object[]{tk,nm,re,mk,c1,c2});
				}
			}
		}

		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,e.toString());
		}
		
		JScrollPane jsp=new JScrollPane(tbl);
		JButton jb=new JButton("Prepare Bill");
		jb.addActionListener(this);
		jb.setForeground(new Color(255,255,255));
		jb.setBackground(new Color(10,118,188));	
		cp.setLayout(new BorderLayout());
		cp.add(jsp);
		cp.add(jb,BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent ae)
	{
		new DoneServicing();
	}
}