import java.sql.*;

class CheckIfExists extends JPanel
{
	CheckIfExists()
	{
		try
		{
			ServiceQueue obj=new ServiceQueue();
			ResultSet rs=obj.tokenExists();
			if(rs!=null)
			{			
				String tk="";
				String nm="";
				String re="";
				String mk="";
				
				while(rs.next())
				{
					tk=rs.getString(1);
					nm=rs.getString(2);
					re=rs.getString(3);
					mk=rs.getString(4);					
				}
			}			
		}

		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,e.toString());
		}		
	}
}