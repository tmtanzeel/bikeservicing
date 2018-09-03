import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class InventoryStatus extends JFrame implements ActionListener
{
	public InventoryStatus()
	{
		super("INVENTORY DATABASE");
		Container cp=getContentPane();
		cp.setLayout(new GridLayout(1,1));
		Object head[]={"DISPLACEMENT","COMPONENT","IN STOCK"};
		Object rec[][]={{null,null,null}};
		JTable tbl=new JTable();
		DefaultTableModel model=new DefaultTableModel();
		tbl.setModel(model);
		model.setColumnIdentifiers(head);
		try
		{
			InventoryManager obj=new InventoryManager();
			ResultSet rs=obj.showCurrentInventoryStatus();						
			if(rs!=null)
			{				
				String disp="";
				String pn="";
				String pq="";
				while(rs.next())
				{
					disp=rs.getString(1);
					pn=rs.getString(2);
					pq=rs.getString(3);
					model.addRow(new Object[]{disp,pn,pq});
				}
			}
		}

		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,e.toString());
		}
		
		JScrollPane jsp=new JScrollPane(tbl);
		JButton jb=new JButton("Change status");
		jb.addActionListener(this);
		jb.setForeground(new Color(255,255,255));
		jb.setBackground(new Color(10,118,188));	
		cp.setLayout(new BorderLayout());
		cp.add(jsp);
		cp.add(jb,BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent ae)
	{
		SwingUtilities.invokeLater(new Runnable(){public void run(){new UpdateStatus();}});
	
		
	}
}