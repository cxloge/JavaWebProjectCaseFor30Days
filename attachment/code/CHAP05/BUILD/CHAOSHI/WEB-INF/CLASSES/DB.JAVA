package wyf.hxl;
import java.sql.*;
import java.util.*;
import javax.sql.*;
import javax.naming.*;
public class DB
{
	private static int quantity=2;
	public static void setQuantity(int n)
	{
		quantity=n;
	}
	public static int getQuantity()
	{
		return quantity;
	}
	public static boolean selectMsg(String sql)
	{
		boolean flag = false;
		try
		{	
			Context initial = new InitialContext();//初始化上下文  
            //其中mysql为数据源jndi名称      	
            DataSource ds = (DataSource)initial.lookup("java:comp/env/jdbc/marketds");
            Connection con=ds.getConnection();//得到连接
            Statement st = con.createStatement();//声明语句
            ResultSet rs = st.executeQuery(sql); //执行语句得到结果集
            if(rs.next())
            {
            	flag = true;
            }			
            rs.close();//关闭结果集
            st.close();//关闭语句
            con.close();//归还连接
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	public static String selectAmount(String sql)
	{
		String flag ="";
		try
		{	
			Context initial = new InitialContext();//初始化上下文  
            //其中mysql为数据源jndi名称      	
            DataSource ds = (DataSource)initial.lookup("java:comp/env/jdbc/marketds");
            Connection con=ds.getConnection();//得到连接
            Statement st = con.createStatement();//声明语句
            ResultSet rs = st.executeQuery(sql); //执行语句得到结果集
            if(rs.next())
            {
            	String flagq = rs.getString(1);
            	flag = new String(flagq.getBytes("ISO-8859-1"),"gb2312");
            }			
            rs.close();//关闭结果集
            st.close();//关闭语句
            con.close();//归还连接
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	public static double selectPrice(String sql)
	{
		double flag =0.00;
		try
		{	
			Context initial = new InitialContext();//初始化上下文  
            //其中mysql为数据源jndi名称      	
            DataSource ds = (DataSource)initial.lookup("java:comp/env/jdbc/marketds");
            Connection con=ds.getConnection();//得到连接
            Statement st = con.createStatement();//声明语句
            ResultSet rs = st.executeQuery(sql); //执行语句得到结果集
            if(rs.next())
            {
            	flag = rs.getDouble(1);
            }			
            rs.close();//关闭结果集
            st.close();//关闭语句
            con.close();//归还连接
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	public static int updateMeg(String sql)
	{
		int flag = 0;
		try
		{	
			Context initial = new InitialContext();//初始化上下文    
            //其中mysql为数据源jndi名称      	
            DataSource ds = (DataSource)initial.lookup("java:comp/env/jdbc/marketds");
            Connection con=ds.getConnection();//得到连接
            Statement st = con.createStatement();//声明语句
            flag = st.executeUpdate(sql);//更新表
            st.close();//关闭语句
            con.close();//归还连接		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	public static Vector<String> getStr(String sql)
	{
		Vector<String> vclass = new Vector<String>();
		try
		{
			
			Context initial = new InitialContext();//初始化上下文    
            //其中mysql为数据源jndi名称      	
            DataSource ds = (DataSource)initial.lookup("java:comp/env/jdbc/cartds");
            Connection con=ds.getConnection();//得到连接  
            Statement st = con.createStatement();//声明语句
            ResultSet rs = st.executeQuery(sql);//执行语句得到结果集
            while(rs.next())
            {
            	String str = rs.getString(1);
            	str = new String(str.getBytes("ISO-8859-1"),"gb2312");
            	vclass.add(str);
            }
            rs.close();//关闭结果集
            st.close();//关闭语句
            con.close();//归还连接
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return vclass;
	}			
	public static Vector<String[]> getMessage(String sql)
	{
		Vector<String[]> vtemp = new Vector<String[]>();
		try
		{
			//初始化上下文
			Context initial = new InitialContext();    
            //其中mysql为数据源jndi名称      	
            DataSource ds = (DataSource)initial.lookup("java:comp/env/jdbc/marketds");
            //得到连接
            Connection con=ds.getConnection();
            //声明语句
            Statement st = con.createStatement();
            //执行语句得到结果集
            ResultSet rs = st.executeQuery(sql);
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //得到结果集中的总列数
            int count = rsmd.getColumnCount();
            while(rs.next())
            {
            	String[] str = new String[count];
            	for(int i=0;i<count;i++)
            	{
            		str[i] = rs.getString(i+1);
            		str[i] = new String(str[i].getBytes("ISO-8859-1"),"gb2312");
            	}
            	vtemp.add(str);
            }
            rs.close();
            st.close();
            con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return vtemp;
	}
	public static int totolPage(String sql)
	{ 
		int totolPage = 0; 
		try
		{			
			Context initial = new InitialContext();//初始化上下文    
            //其中mysql为数据源jndi名称      	
            DataSource ds = (DataSource)initial.lookup("java:comp/env/jdbc/marketds");
            Connection con=ds.getConnection();//得到连接
            Statement st = con.createStatement();//声明语句      
            ResultSet rs = st.executeQuery(sql);//执行语句得到结果集
            ResultSetMetaData rsmd = rs.getMetaData();//获取结果集的元数据
           	rs.last();//将游标移到最后一行
           	int lastRow=rs.getRow();//获取最后一行的行号
            totolPage=(lastRow%quantity==0)?(lastRow/quantity):(lastRow/quantity+1);
            rs.close();
            st.close();
            con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return totolPage;
	}
	public static Vector<String[]> selectPageMeg(int page,String sql)
	{
		Vector <String[]> vv=new Vector <String[]>();
		try
		{
			Context initial = new InitialContext();//初始化上下文    
		    //其中mysql为数据源jndi名称      	
		    DataSource ds = (DataSource)initial.lookup("java:comp/env/jdbc/marketds");
		    Connection con=ds.getConnection();//得到连接
		    Statement st=con.createStatement();//声明语句		    
		    ResultSet rs=st.executeQuery(sql);
		    ResultSetMetaData rsmd = rs.getMetaData();//获取结果集的元数据
		    int col= rsmd.getColumnCount();
		    int first = (page-1)*quantity;
            if(first!=0)
            {
            	rs.absolute(first);
            }
			int temp=0;
		    while(rs.next()&&temp<quantity)
		    {
		    	temp++;
		    	String[] v=new String[col];
			    for(int i=0;i<col;i++)
			    {
			       v[i]=rs.getString(i+1); 
			       v[i] =new String(v[i].getBytes("ISO-8859-1"),"gb2312");  
			    }
			    vv.add(v);
		    }
		    
		    rs.close();
		    st.close();
		    con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return vv;
	}
	public static boolean getAmount(String sql)
	{
		boolean id = false;
		try
		{
			//初始化上下文
			Context initial = new InitialContext();    
            //其中mysql为数据源jndi名称      	
            DataSource ds = (DataSource)initial.lookup("java:comp/env/jdbc/marketds");
            //得到连接
            Connection con=ds.getConnection();
            //声明语句
            Statement st = con.createStatement();
            //执行语句得到结果集
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
            	int i = rs.getInt(1);
            	if(i<0)
            	{
            		id=true;
            	}            	
            }
            rs.close();
            st.close();
            con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return id;
	}
	public static int getSelectId(String sql)
	{
		int id = 0;
		try
		{
			//初始化上下文
			Context initial = new InitialContext();    
            //其中mysql为数据源jndi名称      	
            DataSource ds = (DataSource)initial.lookup("java:comp/env/jdbc/marketds");
            //得到连接
            Connection con=ds.getConnection();
            //声明语句
            Statement st = con.createStatement();
			sql = new String(sql.getBytes(),"ISO-8859-1");
			//执行语句得到结果集
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            id = rs.getInt(1);
            rs.close();
            st.close();
            con.close();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return id;
	}
	public static int getID(String tname,String colname)
	{
		int id = 0;
		try
		{
			//初始化上下文
			Context initial = new InitialContext();    
            //其中mysql为数据源jndi名称      	
            DataSource ds = (DataSource)initial.lookup("java:comp/env/jdbc/marketds");
            //得到连接
            Connection con=ds.getConnection();
            //声明语句
            Statement st = con.createStatement();
            String sql = "select Max("+colname+") from "+tname;
            //执行语句得到结果集
            ResultSet rs = st.executeQuery(sql);
            if(rs.next())
            {
            	id = rs.getInt(1);
            }
            id++;
            rs.close();
            st.close();
            con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return id;
	}
	public static String[] getString(String sql)
	{
		String[] vtemp=null;
		try
		{
			//初始化上下文
			Context initial = new InitialContext();    
            //其中mysql为数据源jndi名称      	
            DataSource ds = (DataSource)initial.lookup("java:comp/env/jdbc/marketds");
            //得到连接
            Connection con=ds.getConnection();
            //声明语句
            Statement st = con.createStatement();
            //执行语句得到结果集
            ResultSet rs = st.executeQuery(sql);
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //得到结果集中的总列数
            int count = rsmd.getColumnCount();
            vtemp = new String[count];
            while(rs.next())
            {            	
            	for(int i=0;i<count;i++)
            	{
            		vtemp[i] = rs.getString(i+1);
            		vtemp[i] = new String(vtemp[i].getBytes("ISO-8859-1"),"gb2312");
            	}
            }
            rs.close();
            st.close();
            con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return vtemp;
	}
}