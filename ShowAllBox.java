import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class ShowAllBox extends JFrame
{
	public ShowAllBox()
	{
		super("CUSTOMER DATABASE");
		Container cp=getContentPane();
		cp.setLayout(new GridLayout(1,1));
		Object head[]={"ID","NAME","REGISTRATION","MAKE","METER","ENGINE NO","CONTACT 1","CONTACT 2","VISISTED ON"};
		Object rec[][]={{null,null,null,null,null,null,null,null,null}};
		JTable tbl=new JTable();
		DefaultTableModel model=new DefaultTableModel();
		tbl.setModel(model);
		model.setColumnIdentifiers(head);
		
		try
		{
			ServiceQueue obj=new ServiceQueue();
			ResultSet rs=obj.showAll();
			
			if(rs!=null)
			{				
				String id="";
				String nm="";
				String re="";
				String mk="";
				String mt="";
				String fuel="";
				String en="";				
				String c1="";
				String c2="";
				String vs="";
				
				while(rs.next())
				{
					id=rs.getString(1);
					nm=rs.getString(2);
					re=rs.getString(3);
					mk=rs.getString(4);
					mt=rs.getString(5);
					fuel=rs.getString(6);
					en=rs.getString(7);
					c1=rs.getString(8);
					c2=rs.getString(9);
					vs=rs.getString(10);
										
					model.addRow(new Object[]{id,nm,re,mk,mt,en,c1,c2,vs});
				}
			}
		}

		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,e.toString());
		}
		
		JScrollPane jsp=new JScrollPane(tbl);
		cp.add(jsp);
	}
}