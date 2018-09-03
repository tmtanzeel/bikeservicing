import java.sql.*;
import java.io.*;

public class InventoryManager
{
	Connection con;
	Statement st;
	static String table="",part="";
	static int disp,unileft,nquan,npric;
		
	public InventoryManager()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:data1","system","root");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public ResultSet showCurrentPartPrice()
	{
		ResultSet rs=null;
		table=table.toLowerCase();
		try
		{
			if(st!=null)
			{
				System.out.println(table);
				String str="select disp,part,pric from "+table +" order by part";
				rs=st.executeQuery(str);
			}
		}
		catch(Exception e)
		{
			System.out.println("OOPS! SOMETHING WENT WRONG: " +e);
		}
		return(rs);
	}
	
	public ResultSet showCurrentInventoryStatus()
	{
		ResultSet rs=null;
		table=table.toLowerCase();
		try
		{
			if(st!=null)
			{
				System.out.println(table);
				String str="select disp,part,quan from "+table +" order by part";
				rs=st.executeQuery(str);
			}
		}
		catch(Exception e)
		{
			System.out.println("OOPS! SOMETHING WENT WRONG: " +e);
		}
		return(rs);
	}
	
	public int deleteAUnit()
	{
		int x=0;
		table=table.toLowerCase();
		System.out.println(table);
		System.out.println(disp);
		System.out.println(part);
		try
		{
			if(st!=null)
			{
				String str="update  "+table +" set quan=quan-1 where disp=" +disp +"and part='"+part+"'";
				x=st.executeUpdate(str);
				System.out.println(x);
			}
		}
		catch(Exception e)
		{
			System.out.println("yahan pe" +e);
		}
		return(x);
	}
	
	public ResultSet seeIfThere()
	{
		int x=0;
		table=table.toLowerCase();
		System.out.println(table);
		System.out.println(disp);
		System.out.println(part);
		ResultSet rs=null;
		try
		{
			if(st!=null)
			{
				String str="select max(quan) from "+table +" where disp=" +disp +"and part='"+part+"'";
				rs=st.executeQuery(str);
				//System.out.println(x);
			}
		}
		catch(Exception e)
		{
			System.out.println("yahan pe " +e);
		}
		return(rs);
	}
	
	public int updateInvStatus()
	{
		int x=0;
		table=table.toLowerCase();
		System.out.println("value: " +table);
		System.out.println("value: " +disp);
		System.out.println("value: " +part);
		System.out.println("value: " +nquan);
		try
		{
			if(st!=null)
			{
				String str="update  "+table +" set quan="+nquan +" where disp=" +disp +"and part='"+part+"'";
				x=st.executeUpdate(str);
				System.out.println(x);
			}
		}
		catch(Exception e)
		{
			System.out.println("yahan pe" +e);
		}
		return(x);
	}
	
	public int updateInvPrices()
	{
		int x=0;
		table=table.toLowerCase();
		System.out.println("value: " +table);
		System.out.println("value: " +disp);
		System.out.println("value: " +part);
		System.out.println("value: " +nquan);
		try
		{
			if(st!=null)
			{
				String str="update  "+table +" set pric="+npric +" where disp=" +disp +"and part='"+part+"'";
				x=st.executeUpdate(str);
				System.out.println(x);
			}
		}
		catch(Exception e)
		{
			System.out.println("yahan pe" +e);
		}
		return(x);
	}
}