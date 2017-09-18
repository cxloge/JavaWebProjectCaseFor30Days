package wyf.cgq;
import java.util.Date;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
public class StudentDB
{
	public static String getNameByNo(String stuno)
	{
		String stuName=null;
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="select stu_name from students where stu_no='"+stuno+"'";
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				if(rs.next())
				{
					stuName=new String(rs.getString(1).getBytes("ISO-8859-1"));	
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null){rs.close();rs=null;}
				if(stmt!=null){stmt.close();stmt=null;}
				if(conn!=null){conn.close();conn=null;}
			}
			catch(SQLException e){e.printStackTrace();}				
		}
		return stuName;
	}
	public static String getGenderByNo(String stuno)
	{
		String sgender=null;
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="select stu_gender from students where stu_no='"+stuno+"'";
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				if(rs.next())
				{
					sgender=new String(rs.getString(1).getBytes("ISO-8859-1"));	
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null){rs.close();rs=null;}
				if(stmt!=null){stmt.close();stmt=null;}
				if(conn!=null){conn.close();conn=null;}
			}
			catch(SQLException e){e.printStackTrace();}				
		}
		return sgender;
	}
	public static String getBirthByNo(String stuno)
	{
		String birth=null;
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="select stu_birthday from students where stu_no='"+stuno+"'";
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				if(rs.next())
				{
					Date date=rs.getDate(1);
					birth=date.getYear()+1900+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日";
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null){rs.close();rs=null;}
				if(stmt!=null){stmt.close();stmt=null;}
				if(conn!=null){conn.close();conn=null;}
			}
			catch(SQLException e){e.printStackTrace();}				
		}
		return birth;
	}
	public static String getNativeplaceByNo(String stuno)
	{
		String nativeplace=null;
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="select nativeplace from students where stu_no='"+stuno+"'";
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				if(rs.next())
				{
					nativeplace=new String(rs.getString(1).getBytes("ISO-8859-1"));	
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null){rs.close();rs=null;}
				if(stmt!=null){stmt.close();stmt=null;}
				if(conn!=null){conn.close();conn=null;}
			}
			catch(SQLException e){e.printStackTrace();}				
		}
		return nativeplace;
	}
	public static String getCollByNo(String stuno)
	{
		String coll=null;
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="select col_name from students,colleges where stu_no='"+stuno+"' and students.col_no=colleges.col_no";
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				if(rs.next())
				{
					coll=new String(rs.getString(1).getBytes("ISO-8859-1"));	
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null){rs.close();rs=null;}
				if(stmt!=null){stmt.close();stmt=null;}
				if(conn!=null){conn.close();conn=null;}
			}
			catch(SQLException e){e.printStackTrace();}				
		}
		return coll;
	}
	
	public static String getDeptByNo(String stuno)
	{
		String dept=null;
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="select dept_name from students,depts where stu_no='"+stuno+"' and students.dept_no=depts.dept_no";
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				if(rs.next())
				{
					dept=new String(rs.getString(1).getBytes("ISO-8859-1"));	
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null){rs.close();rs=null;}
				if(stmt!=null){stmt.close();stmt=null;}
				if(conn!=null){conn.close();conn=null;}
			}
			catch(SQLException e){e.printStackTrace();}				
		}
		return dept;
	}
	public static String getClassByNo(String stuno)
	{
		String className=null;
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="select class_name from students,classes where stu_no='"+stuno+"' and students.class_no=classes.class_no";
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				if(rs.next())
				{
					className=new String(rs.getString(1).getBytes("ISO-8859-1"));	
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null){rs.close();rs=null;}
				if(stmt!=null){stmt.close();stmt=null;}
				if(conn!=null){conn.close();conn=null;}
			}
			catch(SQLException e){e.printStackTrace();}				
		}
		return className;
	}
	public static String getMianmaoByNo(String stuno)
	{
		String mianmao=null;
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="select mianmao from students where stu_no='"+stuno+"'";
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				if(rs.next())
				{
					mianmao=new String(rs.getString(1).getBytes("ISO-8859-1"));	
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null){rs.close();rs=null;}
				if(stmt!=null){stmt.close();stmt=null;}
				if(conn!=null){conn.close();conn=null;}
			}
			catch(SQLException e){e.printStackTrace();}				
		}
		return mianmao;
	}
	
	public static String getComeDateByNo(String stuno)
	{
		String comeDate=null;
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="select cometime from students where stu_no='"+stuno+"'";
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				if(rs.next())
				{
					Date date=rs.getDate(1);
					comeDate=date.getYear()+1900+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日";
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null){rs.close();rs=null;}
				if(stmt!=null){stmt.close();stmt=null;}
				if(conn!=null){conn.close();conn=null;}
			}
			catch(SQLException e){e.printStackTrace();}				
		}
		return comeDate;
	}
	public static boolean changePwd(String uid,String oldpwd,String newpwd)
	{
		boolean result=false;
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="update stuuser set pwd='"+newpwd+"' where stu_no='"+uid+"' and pwd='"+oldpwd+"'";
				System.out.println(sql);
				stmt=conn.createStatement();
				int i=stmt.executeUpdate(sql);
				if(i==1)
				{
					result=true;
				}
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt!=null){stmt.close();stmt=null;}
				if(conn!=null){conn.close();conn=null;}
			}
			catch(SQLException e){e.printStackTrace();}				
		}
		return result;
	}
	
	public static ArrayList getCourseMsgItemList(String stuno){//根据学号获得所在学院所开设课程类表的方法
		ArrayList al=new ArrayList();//创建存放课程信息的列表
		Connection conn=null;Statement stmt=null;String sql=null;ResultSet rs=null;
		try{conn=getConnection();//获得数据库连接
			if(conn!=null){//如果数据库连接不为空
				sql="select coursemsg.cou_no,course.cou_name,cou_day,cou_time,teacher,onchosing,"
					+"course.xuefen from course,coursemsg where course.col_no=(select col_no from"+
					" students where students.stu_no='"+stuno+"') and course.cou_no=coursemsg.cou_no and "+
					"onchosing='1'";
				stmt=conn.createStatement();//创建语句
				rs=stmt.executeQuery(sql);//执行sql语句
				while(rs.next()){//遍历结果集，并将结果存储在列表中
					al.add(new CourseMsgItem(rs.getString(1),
					       new String(rs.getString(2).getBytes("ISO-8859-1")),
					       rs.getInt(3),rs.getInt(4),
					       new String(rs.getString(5).getBytes("ISO-8859-1")),
					       rs.getString(6),rs.getDouble(7)));		
				}}}
		catch(Exception e){e.printStackTrace();}//异常处理的语句
		finally{try{
				if(rs!=null){rs.close();rs=null;}//关闭结果集
				if(stmt!=null){stmt.close();stmt=null;}//关闭语句
				if(conn!=null){conn.close();conn=null;}//关闭数据库连接
			}catch(SQLException e){e.printStackTrace();}//异常的处理语句				
		}return al;//返回课程列表
	}
	public static String choseCourse(String stuNo,String courseNo){//选择课程的方法
		Connection conn=null;Statement stmt=null;String sql=null;ResultSet rs=null;
		try{conn=getConnection();//获得数据库连接
			if(conn!=null){//如果数据库连接不为空
				sql="select * from grade where stu_no='"+stuNo+"' and cou_no='"+courseNo+"'";
				stmt=conn.createStatement();//创建语句
				rs=stmt.executeQuery(sql);//执行sql语句
				if(rs.next()){return "rechose";}//如果不为空，说明前面已经选择过该课程
				rs.close();//关闭结果集
				sql="select cou_name from course,coursemsg,grade "+
					             "where grade.cou_no=course.cou_no "+
					            "and grade.cou_no=coursemsg.cou_no "+
					            "and grade.stu_no='"+stuNo+"' "+
					            "and grade.isdual=0 "+
					            "and (coursemsg.cou_day,coursemsg.cou_time) in "+
					            "(select cou_day,cou_time from coursemsg where "+
					            "cou_no='"+courseNo+"')";
				rs=stmt.executeQuery(sql);//执行sql语句
				if(rs.next()){//如果有记录，说明与其他课程时间冲突
					String courseName=new String(rs.getString(1).getBytes("ISO-8859-1"));
					return courseName;//获得冲突的课程的名字
				}
				rs.close();//关闭结果集
				sql="insert into grade(stu_no,cou_no) values('"+stuNo+"','"+courseNo+"')";
				int i=stmt.executeUpdate(sql);//执行插入记录的sql语句
				if(i==1){return "success";}//如果等于一，说明插入成功
				else{return "fail";}//否则插入失败
			}else{return "fail";}//否则插入失败
		}
		catch(Exception e){e.printStackTrace();}//异常的处理语句		
		finally{try{
				if(rs!=null){rs.close();rs=null;}//关闭结果集
				if(stmt!=null){stmt.close();stmt=null;}//关闭语句
				if(conn!=null){conn.close();conn=null;}//关闭数据库连接
			}catch(SQLException e){e.printStackTrace();}//异常的处理语句			
		}return null;}//返回
	public static ArrayList getMyCourseMsgItemList(String stuno)
	{
		ArrayList al=new ArrayList();
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="select coursemsg.cou_no,course.cou_name,cou_day,cou_time,teacher,onchosing,"
					+"course.xuefen from course,coursemsg,grade where course.cou_no=coursemsg.cou_no and "+
					"course.cou_no=grade.cou_no and coursemsg.cou_no=grade.cou_no and grade.stu_no='"+stuno+"'"+
					" and grade.isdual=0";
			       System.out.println(sql);
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					al.add(new CourseMsgItem(rs.getString(1),
					       new String(rs.getString(2).getBytes("ISO-8859-1")),
					       rs.getInt(3),rs.getInt(4),
					       new String(rs.getString(5).getBytes("ISO-8859-1")),
					       rs.getString(6),rs.getDouble(7)));		
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null){rs.close();rs=null;}
				if(stmt!=null){stmt.close();stmt=null;}
				if(conn!=null){conn.close();conn=null;}
			}
			catch(SQLException e){e.printStackTrace();}				
		}
		return al;
	}
	public static void deleteCourse(String courseNo,String stuNo)
	{
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="delete from grade where cou_no='"+courseNo+"' and stu_no='"+stuNo+"'";
				stmt=conn.createStatement();
				stmt.executeUpdate(sql);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(stmt!=null){stmt.close();stmt=null;}
				if(conn!=null){conn.close();conn=null;}
			}
			catch(SQLException e){e.printStackTrace();}				
		}
	}
	public static ArrayList getLearnedCourseList(String stuno)
	{
		ArrayList al=new ArrayList();
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="select grade.cou_no,cou_name,xuefen,score from course,grade "+
				    "where grade.cou_no=course.cou_no and grade.stu_no='"+stuno+"'"+
				    " and grade.isdual='1'";
			       System.out.println(sql);
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					al.add(new LearnedCourse(rs.getString(1),
					       new String(rs.getString(2).getBytes("ISO-8859-1")),
					       rs.getDouble(3),rs.getDouble(4)));		
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null){rs.close();rs=null;}
				if(stmt!=null){stmt.close();stmt=null;}
				if(conn!=null){conn.close();conn=null;}
			}
			catch(SQLException e){e.printStackTrace();}				
		}
		return al;
	}
	
	public static ArrayList getFailCourseList(String stuno)
	{
		ArrayList al=new ArrayList();
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="select grade.cou_no,cou_name,xuefen,score from course,grade "+
				    "where grade.cou_no=course.cou_no and grade.stu_no='"+stuno+"'"+
				    " and grade.isdual='1' and grade.score<60";
			       System.out.println(sql);
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					al.add(new LearnedCourse(rs.getString(1),
					       new String(rs.getString(2).getBytes("ISO-8859-1")),
					       rs.getDouble(3),rs.getDouble(4)));		
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null){rs.close();rs=null;}
				if(stmt!=null){stmt.close();stmt=null;}
				if(conn!=null){conn.close();conn=null;}
			}
			catch(SQLException e){e.printStackTrace();}				
		}
		return al;
	}
	public static Connection getConnection()
	{
		Connection conn=null;
		try
		{
			Context initial=new InitialContext();
			DataSource ds=(DataSource)initial.lookup("java:comp/env/xsglxt");
			conn=ds.getConnection();
		}
		catch(NamingException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
}