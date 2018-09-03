import java.sql.*;

public class ServiceQueue
{
	Connection con;
	Statement st;
	static String name="",reg="",make="",engine="",cn1="",cn2="",fuel="",enginenumber="",regnumber="",forslot="",timeslot="";
	static int meter, myid,token=1,idnumber,qtoken;
	static int ttd;//token to be deleted
	/////////for parts module//////////
	static String table="",mypart="";
	static int mydisp;
	///////////////////
	
	public ServiceQueue()
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

	public int insert()
	{
		int x=0;		
		try
		{
			if(st!=null)
			{
				String str1="insert into customerdatabase values("+myid+",'"+name+"','"+reg+"','"+make+"',"+meter+",'"+fuel+"','"+engine+"','"+cn1+"','"+cn2+"',"+"to_date(sysdate,'dd-mm-yyyy')"+")";
				String str2="insert into currentqueue values("+token+",'"+name+"','"+reg+"','"+make+"','"+cn1+"','"+cn2+"')";
				x=st.executeUpdate(str1);
				x=st.executeUpdate(str2);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return(x);
	}

	public int insertAppoint()
	{
		int x=0;
		try
		{
			if(st!=null)
			{
				String str="insert into apreg values("+myid+",'"+name+"','"+reg+"','"+make+"',"+meter+",'"+fuel+"','"+engine+"','"+cn1+"','"+cn2+"',"+"to_date(sysdate,'dd-mm-yyyy')"+",'"+forslot+"')";
				x=st.executeUpdate(str);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return(x);
	}

	public ResultSet returnCount()
	{
		ResultSet rs=null;
		try
		{
			if(st!=null)
			{
				String str="select count(myid) from AppointmentRegister where forslot= '"+timeslot+"'";
				rs=st.executeQuery(str);
			}
		}
		catch(Exception e)
		{
			System.out.println("OOPS! SOMETHING WENT WRONG: " +e);
		}
		return(rs);
	}

	public ResultSet showAll()
	{
		ResultSet rs=null;
		try
		{
			if(st!=null)
			{
				String str="select myid,name,reg,make,meter,fuel,eng,cn1,cn2,to_char(visit,'dd-mm-yy')  from CustomerDataBase";
				rs=st.executeQuery(str);
			}
		}
		catch(Exception e)
		{
			System.out.println("OOPS! SOMETHING WENT WRONG: " +e);
		}
		return(rs);
	}

	public ResultSet partPrice()
	{
		ResultSet rs=null;
		try
		{
			if(st!=null)
			{
				if(table.equals("AVENGER"))
				{
					//String str="select * from '"+table+"' where disp="+mydisp+" and part='"+mypart+"'";
					String str="select * from avenger where disp="+mydisp+" and part='"+mypart+"'";
					rs=st.executeQuery(str);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("OOPS! SOMETHING WENT WRONG: " +e);
		}
		return(rs);
	}

	public ResultSet showTheQueue()
	{
		ResultSet rs=null;
		try
		{
			if(st!=null)
			{
				String str="select * from currentqueue order by token";
				rs=st.executeQuery(str);
			}
		}
		catch(Exception e)
		{
			System.out.println("OOPS! SOMETHING WENT WRONG: " +e);
		}
		return(rs);
	}

	public ResultSet showSpecific()
	{
		ResultSet rs=null;
		try
		{
			if(st!=null)
			{
				String str="select * from CustomerDataBase where myid="+idnumber+" or reg='"+regnumber+"' or eng='"+enginenumber+"'" ;
				rs=st.executeQuery(str);
			}
		}
		catch(Exception e)
		{
			System.out.println("OOPS! SOMETHING WENT WRONG: " +e);
		}
		return(rs);
	}

	public ResultSet lastToken()
	{
		ResultSet rs=null;
		try
		{
			if(st!=null)
			{
				String str="select max(token) from currentqueue";
				rs=st.executeQuery(str);
			}
		}
		catch(Exception e)
		{
			System.out.println("OOPS! SOMETHING WENT WRONG: " +e);
		}
		return(rs);
	}

	public ResultSet tokenExists()
	{
		ResultSet rs=null;
		try
		{
			
			if(st!=null)
			{
				String str="select * from currentqueue where token="+qtoken;
				rs=st.executeQuery(str);
			}
		}
		catch(Exception e)
		{
			System.out.println("OOPS! SOMETHING WENT WRONG: " +e);
		}
		return(rs);
	}

	public ResultSet tokenRemaining()
	{
		ResultSet rs=null;
		try
		{
			
			if(st!=null)
			{
				String str="select token from currentqueue";
				rs=st.executeQuery(str);
			}
		}
		catch(Exception e)
		{
			System.out.println("OOPS! SOMETHING WENT WRONG: " +e);
		}
		return(rs);
	}
	
	public int delFromCurQueue()
	{
		int x=0;
		try
		{
			if(st!=null)
			{
				String str="delete from currentqueue where token="+ttd;
				x=st.executeUpdate(str);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return(x);
	}
		
}