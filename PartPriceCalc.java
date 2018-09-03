import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class PartPriceCalc
{

	static int price;
	PartPriceCalc()
	{
		
		try
		{
			ServiceQueue obj=new ServiceQueue();
			ResultSet rs=obj.partPrice();
			if(rs!=null)
			{			
				String cost="";
				String compo="";
				
				while(rs.next())
				{
					cost=rs.getString(3);
					compo=rs.getString(2);
					price=Integer.parseInt(cost.toString());
				}
			}			
		}
		catch(Exception e)
		{
			System.out.println("Locha hoyla");
		}		
	}
}