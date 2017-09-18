package wyf.cgq;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
public class LoginDB
{
	public static String[] login(String uid,String pwd)
	{
		String[] impinfo=new String[2];//impinfo[0]:0表示没有这个用户，1表示是人事部的人，2表示不是人事部的人
		impinfo[0]="0";
		String impId=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			String sql="select impRight,impId from userinfo where impId=? and pwd=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,uid);
			pstmt.setString(2,pwd);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				impinfo[0]=rs.getInt("impRight")+"";
				impinfo[1]=rs.getString("impId");
			}
			else
			{
				impinfo[0]="0";
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn!=null){conn.close();}
				if(pstmt!=null){pstmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return impinfo;
	}
	public static Connection getConnection()
	{														//获得数据库连接的方法
		Connection conn=null;								//声明数据库连接引用
		try
		{
			Context initial=new InitialContext();			//获得上下文
			DataSource ds=(DataSource)initial.lookup("java:comp/env/rsglxt");
			conn=ds.getConnection();						//通过数据源获得数据库连接
		}
		catch(NamingException e){e.printStackTrace();}		//异常的捕获处理语句
		catch(SQLException e){e.printStackTrace();}			//异常的捕获处理语句
		return conn;										//返回数据库连接
	}
}