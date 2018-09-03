import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class ShowAllAppointments extends JFrame
{
	public ShowAllAppointments()
	{
		super("CUSTOMER DATABASE");
		Container cp=getContentPane();
		cp.setLayout(new GridLayout(1,1));
		Object head[]={"ID","NAME","REGISTRATION","MAKE","METER","ENGINE NO","CONTACT 1","CONTACT 2","APPOINTMENT ON","TIME"};
		Object rec[][]={{null,null,null,null,null,null,null,null,null,null}};
		JTable tbl=new JTable();
		DefaultTableModel model=new DefaultTableModel();
		tbl.setModel(model);
		model.setColumnIdentifiers(head);
		try
		{
			AppointmentManager obj=new AppointmentManager();
			ResultSet rs=obj.showAllApp();
			
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
				String ao="";
				String ti="";
				
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
					ao=rs.getString(10);
					ti=rs.getString(11);
										
					model.addRow(new Object[]{id,nm,re,mk,mt,en,c1,c2,ao,ti});
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