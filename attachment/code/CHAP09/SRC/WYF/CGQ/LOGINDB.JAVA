package wyf.cgq;
import java.util.*;
import javax.sql.*;
import java.sql.*;
import javax.naming.*;
public class LoginDB{
	public static String studentLogin(String uid,String pwd){//验证学生登录的方法
		String result="fail";								 //声明并初始化返回字符串
		Connection conn=null;Statement stmt=null;			 // 声明数据库连接和语句
		ResultSet rs=null;String sql=null;					 //声明结果集引用和sql语句
		try{
			conn=getConnection();							 //获得数据库连接
			if(conn!=null){									 //如果数据库连接不为空
				sql="select * from stuuser where stu_no='"+uid+"'"+//创建sql语句
				" and pwd='"+pwd+"'";
				stmt=conn.createStatement();				//创建Statement语句
				rs=stmt.executeQuery(sql);					//执行查询，获得结果集
				if(rs.next()){result="success";}			//有记录，用户名密码正确
			}}
		catch(SQLException e){e.printStackTrace();}			//异常捕获处理语句
		finally{
			try{
				if(rs!=null){rs.close();rs=null;}			//关闭结果集
				if(stmt!=null){stmt.close();stmt=null;}		//关闭语句
				if(conn!=null){conn.close();conn=null;}		//关闭数据库连接
			}
			catch(SQLException e){e.printStackTrace();}		//异常的捕获处理语句		
		}
		return result;										//返回验证结果字符串
	}
	public static String teacherLogin(String uid,String pwd){//验证教师登录的方法
		String result="fail";								 //声明并初始化返回字符串
		Connection conn=null;Statement stmt=null;			 // 声明数据库连接和语句
		String sql=null;ResultSet rs=null;					 //声明结果集引用和sql语句
		try{
			conn=getConnection();							 //获得数据库连接
			if(conn!=null){									 //如果数据库连接不为空
				sql="select col_no from teacheruser where uid='"+uid+"'"+
				" and pwd='"+pwd+"'";						 //创建sql语句
				stmt=conn.createStatement();				 //创建Statement语句
				rs=stmt.executeQuery(sql);					 //执行查询，获得结果集
				if(rs.next()){result=rs.getString(1);}		 //有记录，用户名密码正确
			}}
		catch(SQLException e){e.printStackTrace();}			//异常的捕获处理语句
		finally{
			try{
				if(rs!=null){rs.close();rs=null;}			//关闭结果集
				if(stmt!=null){stmt.close();stmt=null;}		//关闭语句
				if(conn!=null){conn.close();conn=null;}		//关闭数据库连接
			}
			catch(SQLException e){e.printStackTrace();}		//异常的捕获处理语句			
		}
		return result;										//返回验证结果字符串
	}
	public static Connection getConnection(){				//获得数据库连接的方法
		Connection conn=null;								//声明数据库连接引用
		try{
			Context initial=new InitialContext();			//获得上下文
			DataSource ds=(DataSource)initial.lookup("java:comp/env/xsglxt");
			conn=ds.getConnection();						//通过数据源获得数据库连接
		}
		catch(NamingException e){e.printStackTrace();}		//异常的捕获处理语句
		catch(SQLException e){e.printStackTrace();}			//异常的捕获处理语句
		return conn;										//返回数据库连接
	}}