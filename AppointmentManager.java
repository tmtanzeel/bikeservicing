import java.sql.*;

public class AppointmentManager
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
	
	public AppointmentManager()
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

	public int insertOnlyinCurrentQueue()
	{
		int x=0;
		try
		{
			if(st!=null)
			{
				String str="insert into currentqueue values("+token+",'"+name+"','"+reg+"','"+make+"','"+cn1+"','"+cn2+"')";
				x=st.executeUpdate(str);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return(x);
	}
	
	public int insertOnlyInCustomerDatabase()
	{
		int x=0;
		try
		{
			if(st!=null)
			{
				String str="insert into customerdatabase values("+myid+",'"+name+"','"+reg+"','"+make+"',"+meter+",'"+fuel+"','"+engine+"','"+cn1+"','"+cn2+"',"+"to_date(sysdate,'dd-mm-yyyy')"+")";
				x=st.executeUpdate(str);
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
				String str="select count(myid) from apreg where forslot= '"+timeslot+"'";
				rs=st.executeQuery(str);
			}
		}
		catch(Exception e)
		{
			System.out.println("OOPS! SOMETHING WENT WRONG: " +e);
		}
		return(rs);
	}
	
	public ResultSet showAllApp()
	{
		ResultSet rs=null;
		try
		{
			if(st!=null)
			{
				String str="select myid,name,reg,make,meter,fuel,eng,cn1,cn2,to_char(taken,'dd-mm-yy'),forslot from apreg";
				rs=st.executeQuery(str);
			}
		}
		catch(Exception e)
		{
			System.out.println("OOPS! SOMETHING WENT WRONG: " +e);
		}
		return(rs);
	}
	
	public ResultSet variablesForCurque()
	{
		ResultSet rs=null;
		try
		{
			if(st!=null)
			{
				String str="select name,reg,make,cn1,cn2 from apreg where myid="+myid;
				rs=st.executeQuery(str);
			}
		}
		catch(Exception e)
		{
			System.out.println("OOPS! SOMETHING WENT WRONG: " +e);
		}
		return(rs);
	}
	
	public ResultSet fetchAllDefaults()
	{
		//System.out.println(myid);
		ResultSet rs=null;
		try
		{
			if(st!=null)
			{
				String str="select name,reg,make,eng,cn1,cn2 from customerdatabase where myid="+myid;
				rs=st.executeQuery(str);
			}
		}
		catch(Exception e)
		{
			System.out.println("OOPS! SOMETHING WENT WRONG: " +e);
		}
		return(rs);
	}
	
	
	public ResultSet seeIfThereIsId()
	{
		ResultSet rs=null;
		System.out.println(myid);
		try
		{
			if(st!=null)
			{
				String str="select count(myid) from customerdatabase where myid="+myid;
				rs=st.executeQuery(str);
			}
		}
		catch(Exception e)
		{
			System.out.println("OOPS! SOMETHING WENT WRONG: " +e);
		}
		return(rs);
	}
	
	public ResultSet searchInApReg()
	{
		ResultSet rs=null;
		System.out.println(myid);
		try
		{
			if(st!=null)
			{
				String str="select count(myid) from apreg where myid="+myid;
				rs=st.executeQuery(str);
			}
		}
		catch(Exception e)
		{
			System.out.println("OOPS! SOMETHING WENT WRONG: " +e);
		}
		return(rs);
	}
}