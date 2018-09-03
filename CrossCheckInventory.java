import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class CrossCheckInventory
{
	public CrossCheckInventory()
	{
		InventoryManager im=new InventoryManager();
		ResultSet rs=im.seeIfThere();
		try
		{
			if(rs!=null)
			{
				while(rs.next())
				{
					String units=rs.getString(1);
					im.unileft=Integer.parseInt(units);
				}
			}
		}
		catch(Exception e)
		{
			//JOptionPane.showMessageDialog(this,e.toString());
		}		
	}
}