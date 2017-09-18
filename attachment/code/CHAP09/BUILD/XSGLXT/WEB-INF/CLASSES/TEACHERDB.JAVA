package wyf.cgq;
import java.util.*;
import java.util.Date;
import javax.sql.*;
import java.sql.*;
import javax.naming.*;
import javax.faces.model.SelectItem;
public class TeacherDB{
	public static boolean changePwd(String uid,String oldpwd,String newpwd){//修改密码的方法
		boolean result=false;		//用于存放修改结果
		Connection conn=null;Statement stmt=null;String sql=null;//声明数据库连接及Statement、sql语句
		try{conn=getConnection();//获得数据库连接
			if(conn!=null){		//如果连接不为空
				sql="update teacheruser set pwd='"+newpwd+"' where uid='"+uid+"' and pwd='"+oldpwd+"'";
				stmt=conn.createStatement();//创建sql语句及Statement
				int i=stmt.executeUpdate(sql);//执行sql语句
				if(i==1){result=true;} //如果更改成功，返回true
			}
		}
		catch(Exception e){e.printStackTrace();}//对异常的处理
		finally{
			try{if(stmt!=null){stmt.close();stmt=null;}//关闭Statement语句
				if(conn!=null){conn.close();conn=null;}//关闭数据库连接
			}
			catch(SQLException e){e.printStackTrace();}	//	异常处理语句		
		}
		return result;//返回结果
	}
	
	public static String getCollById(String colid){//根据学院编号获得学院名称
		String coll=null;Connection conn=null;Statement stmt=null;//声明连接语句
		String sql=null;ResultSet rs=null;//声明结果集及sql字符串引用
		try{conn=getConnection();//获得数据库连接
			if(conn!=null){//如果不为空
				sql="select col_name from colleges where col_no='"+colid+"'";
				stmt=conn.createStatement();//创建Statement语句
				rs=stmt.executeQuery(sql);//执行SQL语句
				if(rs.next()){coll=new String(rs.getString("col_name").getBytes("ISO-8859-1"));
				}//获得学院的名称并转码
				}}
		catch(Exception e){e.printStackTrace();}//对异常的处理
		finally{try{if(rs!=null){rs.close();rs=null;}//关闭结果集
				if(stmt!=null){stmt.close();stmt=null;}//关闭Statement语句
				if(conn!=null){conn.close();conn=null;}//关闭数据库连接
			}
			catch(SQLException e){e.printStackTrace();}	//对异常的处理			
		}return coll;					//返回学院名称
	}
	public static ArrayList<SelectItem> getDeptListByCollid(String colid){//活的专业列表的方法
		ArrayList<SelectItem> al=new ArrayList<SelectItem>();//创建专业列表
		Connection conn=null;Statement stmt=null;//声明数据库连接及语句
		String sql=null;ResultSet rs=null;//声明sql语句及结果集引用
		try{conn=getConnection();//获得数据库连接
			if(conn!=null){//如果不为空
				sql="select dept_no,dept_name from depts where col_no='"+colid+"'";
				stmt=conn.createStatement();rs=stmt.executeQuery(sql);//  创建语句执行SQL
				while(rs.next()){//遍历结果集，获得专业信息，并加入到列表中
					String dept_no=rs.getString("dept_no");
					String dept_name=new String(rs.getString("dept_name").getBytes("ISO-8859-1"));
					al.add(new SelectItem(dept_no,dept_name));
				}}}
		catch(Exception e){e.printStackTrace();}//对异常的处理	
		finally{try{if(rs!=null){rs.close();rs=null;}//关闭结果集
				if(stmt!=null){stmt.close();stmt=null;}//关闭Statement语句
				if(conn!=null){conn.close();conn=null;}//关闭数据库连接
			}
			catch(SQLException e){e.printStackTrace();}	//对异常的处理				
		}return al;//返回专业列表
	}
	public static ArrayList<SelectItem> getClassListByDeptid(String deptno){
		ArrayList<SelectItem> al=new ArrayList<SelectItem>();
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="select class_no,class_name from classes where dept_no='"+deptno+"'";
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					String class_no=rs.getString("class_no");
					String class_name=new String(rs.getString("class_name").getBytes("ISO-8859-1"));
					al.add(new SelectItem(class_no,class_name));
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
	public static String AddStu(String sno,String sname,String sgender,
	                            int biryear,int birmonth,int birday,
	                            String nativeplace,String collid,String deptid,
	                            String classid,String mianmao,int comeyear,
	                            int comemonth,int comeday)
	{
		String result="addstufail";Connection conn=null;//声明结果字符串及数据库连接引用
		Statement stmt=null;String sql=null;ResultSet rs=null;//声明语句，sql，结果集
		try{conn=getConnection();//获得数据库连接
			if(conn!=null){//如果不为空
				sql="select stu_no from students where stu_no='"+sno+"'";//创建sql语句
				stmt=conn.createStatement();//常见statement语句
				rs=stmt.executeQuery(sql);//执行语句
				if(rs.next()){return "restuadd";}//如果有记录说明该学号学生存在
				conn.setAutoCommit(false);//关闭自动提交
				sql="insert into students values('"+sno+"','"+new String(sname.getBytes(),"ISO-8859-1")+"',"+
				     "'"+new String(sgender.getBytes(),"ISO-8859-1")+"',"+
					"'"+biryear+"-"+birmonth+"-"+birday+"','"+new String(nativeplace.getBytes(),"ISO-8859-1")+"','"+collid+"',"+
					"'"+deptid+"','"+classid+"','"+new String(mianmao.getBytes(),"ISO-8859-1")+"','"+comeyear+"-"+comemonth+"-"+comeday+"')";
				int i=stmt.executeUpdate(sql);//执行sql语句插入新学生
				if(i!=1){conn.rollback();//如果不等于一，则插入失败，回滚
					conn.setAutoCommit(true);//打开自动提交
					return "addstufail";//返回结果字符串
				}
				sql="insert into stuuser values('"+sno+"','"+sno+"')";
				i=stmt.executeUpdate(sql);//向学生用户表中添加新用户
				if(i!=1){conn.rollback(); //如果不等于一，则插入失败，回滚
					conn.setAutoCommit(true);//打开自动提交
					return "addstufail";//返回结果字符串
				}conn.commit();result="success";//提交并返回字符串
			}}
		catch(Exception e){try{conn.rollback();//有异常则回滚
				conn.setAutoCommit(true);//打开自动提交
			}catch(SQLException ea){ea.printStackTrace();}//对异常的处理	
		}
		finally{try{if(rs!=null){rs.close();rs=null;}	//关闭结果集
				if(stmt!=null){stmt.close();stmt=null;}//关闭语句
				if(conn!=null){conn.close();conn=null;}//关闭数据库连接
			}
			catch(SQLException e){e.printStackTrace();}//对异常的处理	
		}return result;//返回结果字符串
	}
	public static String[] searchMsg(String sno){//查询学生基本信息的方法
		String[] result=new String[10];//创建存放学生基本信息的数组
		Connection conn=null;Statement stmt=null;//声明数据库连接及Statement语句
		ResultSet rs=null;String sql=null;//声明结果集引用及sql语句的引用
		try{conn=getConnection();//获得数据库连接
			if(conn!=null){	//如果数据库连接不为空
				sql="select stu_no,stu_name,stu_gender,stu_birthday,nativeplace,"+
				      "colleges.col_name,depts.dept_name,classes.class_name,mianmao,cometime "+
				      "from students,colleges,depts,classes where students.col_no=colleges.col_no"
				      +" and students.dept_no=depts.dept_no and students.class_no=classes.class_no"
				      +" and students.stu_no='"+sno+"'";//创建SQL语句
				stmt=conn.createStatement();rs=stmt.executeQuery(sql);//创建语句并执行
				if(rs.next()){//如果又记录，说明又该学号的学生
					for(int i=0;i<10;i++){//遍历各个字段
						if(i==3||i==9){//将日期组织成字符串
							Date date=rs.getDate(i+1);String year=date.getYear()+1900+"年";
							String month=date.getMonth()+1+"月";String day=date.getDate()+"日";
							result[i]=year+month+day;
						}
						else{result[i]=new String(rs.getString(i+1).getBytes("ISO-8859-1"));
						}//不是日期的则直接或的再转码即可
					}return result;	//返回字符串数组
				}
				else{return null;}//没有该学生则返回null
			}}
		catch(Exception e){e.printStackTrace();}//异常的处理语句
		finally{try{if(stmt!=null){stmt.close();stmt=null;}//关闭语句
				if(conn!=null){conn.close();conn=null;}//关闭数据库连接
				if(rs!=null){rs.close();rs=null;}//关闭结果集
			}
			catch(SQLException e){e.printStackTrace();}	//异常的处理语句			
		}return result;//返回结果字符串数组
	}
	public static ArrayList getGradeList(String sno){//根据学号获得成绩类表的方法
		ArrayList al=new ArrayList();//创建用于存放成绩信息的列表
		Connection conn=null;Statement stmt=null;//声明数据库连接及Statement语句
		String sql=null;ResultSet rs=null;//声明结果集引用及sql语句的引用
		try{conn=getConnection();//获得数据库连接
			if(conn!=null){//如果数据库连接不为空
				sql="select course.cou_name,grade.score,course.xuefen from course,grade"+
					" where grade.stu_no='"+sno+"' and grade.isdual=1 and "+
			 		"grade.cou_no=course.cou_no";
				stmt=conn.createStatement();rs=stmt.executeQuery(sql);//创建语句并执行
				while(rs.next()){//遍历结果集，将成绩信息存储到列表中
					al.add(new Grade(new String(rs.getString(1).getBytes("ISO-8859-1")),
							rs.getDouble(2),rs.getDouble(3)));}return al;//返回成绩列表
			}}
		catch(Exception e){	e.printStackTrace();}//异常的处理语句
		finally{try{if(rs!=null){rs.close();rs=null;}//关闭结果集
				if(stmt!=null){stmt.close();stmt=null;}//关闭语句
				if(conn!=null){conn.close();conn=null;}//关闭数据库连接
			}
			catch(SQLException e){e.printStackTrace();}	//异常的处理语句			
		}return null;}
		
		public static ArrayList getCourseItemList(String collno){//获得学院开设课程列表的方法
		ArrayList al=new ArrayList();//创建存放课程信息的列表
		Connection conn=null;Statement stmt=null;//声明数据库连接及Statement语句的引用
		String sql=null;ResultSet rs=null;//声明sql与结果集的引用
		try{conn=getConnection();//获得数据库连接
			if(conn!=null){//数据库连接已经获得
				sql="select cou_no,cou_name,xuefen,colleges.col_name,depts.dept_name from "+
			       "course,colleges,depts where depts.dept_no=course.dept_no and"+
			       " course.col_no=course.col_no and depts.col_no=colleges.col_no and course.col_no='"+collno+"'";
				stmt=conn.createStatement();rs=stmt.executeQuery(sql);//创建Statement并执行sql语句
				while(rs.next()){//遍历结果集并将信息存入列表
					al.add(new CourseItem(new String(rs.getString(1).getBytes("ISO-8859-1")),
							new String(rs.getString(2).getBytes("ISO-8859-1")),
							rs.getDouble(3),new String(rs.getString(4).getBytes("ISO-8859-1")),
							new String(rs.getString(5).getBytes("ISO-8859-1"))));			
				}return al;//返回列表
			}}catch(Exception e){e.printStackTrace();}//异常的处理语句	
		finally{try{if(rs!=null){rs.close();rs=null;}//关闭结果集
				if(stmt!=null){stmt.close();stmt=null;}//关闭语句
				if(conn!=null){conn.close();conn=null;}//关闭数据库连接
			}catch(SQLException e){e.printStackTrace();}//异常的处理语句					
		}return null;}//返回
		
		
	public static String  addToDB(String courseNo,int day,int times,String teacher,String collno){
		String result="addfail";//声明结果字符串并赋初值
		Connection conn=null;Statement stmt=null;String sql=null;ResultSet rs=null;
		try{conn=getConnection();//获得数据库连接
			if(conn!=null){//如果数据库连接不为空
				sql="select cou_no from course where cou_no='"+courseNo+"' and col_no='"+collno+"'";
				stmt=conn.createStatement();rs=stmt.executeQuery(sql);//创建语句并执行sql
				if(!rs.next()){return "nocourse";}//如果没有有则说明该记录数据库中不存在
				sql="insert into coursemsg(cou_no,cou_day,cou_time,teacher) values('"+courseNo+"',"+
				     day+","+times+",'"+new String(teacher.getBytes(),"ISO-8859-1")+"')";
				int i=stmt.executeUpdate(sql);//如果没有则进行插入
				if(i==1){return "addok";}//插入成功，返回标志字符串
			}}catch(Exception e){System.out.println("添加失败");}//异常的处理语句
		finally{try{if(rs!=null){rs.close();rs=null;}//关闭结果集
				if(stmt!=null){stmt.close();stmt=null;}//关闭语句
				if(conn!=null){conn.close();conn=null;}//关闭数据库连接
			}catch(SQLException e){e.printStackTrace();}//异常的处理语句				
		}return result;}//返回结果字符串
		
		
	public static ArrayList getCourseMsgItemList(String collno){
		ArrayList al=new ArrayList();//创建存放可选课程的列表
		Connection conn=null;Statement stmt=null;String sql=null;ResultSet rs=null;
		try{conn=getConnection();//获得数据库连接
			if(conn!=null){//如果数据库连接不为空
				sql="select coursemsg.cou_no,course.cou_name,cou_day,cou_time,teacher,onchosing,"
					+"course.xuefen from course,coursemsg where course.col_no='"+collno+"' and "+
					"course.cou_no=coursemsg.cou_no";
				stmt=conn.createStatement();rs=stmt.executeQuery(sql);//创建语句并执行SQL
				while(rs.next()){//遍历结果集
					al.add(new CourseMsgItem(rs.getString(1),//将课程信息存入列表
					       new String(rs.getString(2).getBytes("ISO-8859-1")),
					       rs.getInt(3),rs.getInt(4),
					       new String(rs.getString(5).getBytes("ISO-8859-1")),
					       rs.getString(6),rs.getDouble(7)));		
				}}}catch(Exception e){e.printStackTrace();}//异常的处理语句
		finally{try{if(rs!=null){rs.close();rs=null;}//关闭结果集
				if(stmt!=null){stmt.close();stmt=null;}//关闭语句
				if(conn!=null){conn.close();conn=null;}//关闭数据库连接
			}catch(SQLException e){e.printStackTrace();}//异常的处理语句				
		}return al;}//返回学生可选课程列表
	  
	public static void gongBu(String courseno,int day,int times){
		Connection conn=null;Statement stmt=null;String sql=null;
		try{conn=getConnection();//获得数据库连接
			if(conn!=null){//如果数据库连接不为空
				sql="update coursemsg set onchosing='1' where cou_no='"+courseno+"' and"+
				   " cou_day="+day+" and cou_time="+times;
				stmt=conn.createStatement();int i=stmt.executeUpdate(sql);//创建语句执行sql
			}}catch(Exception e){e.printStackTrace();}//异常的处理语句
		finally{try{if(stmt!=null){stmt.close();stmt=null;}//关闭语句
				if(conn!=null){conn.close();conn=null;}//关闭数据库连接
			}catch(SQLException e){e.printStackTrace();}//异常的处理语句				
		}}     
	public static void delete(String courseno,int day,int times){
		Connection conn=null;Statement stmt=null;String sql=null;
		try{conn=getConnection();
			if(conn!=null)
			{
				sql="delete from coursemsg where cou_no='"+courseno+"' and"+
				   " cou_day="+day+" and cou_time="+times;
				stmt=conn.createStatement();
				int i=stmt.executeUpdate(sql);
				
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
	public static ArrayList<SelectItem> getCourseItem(String collno)
	{
		ArrayList<SelectItem> al=new ArrayList<SelectItem>();
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="select distinct cou_name,course.cou_no from course,grade where"+
		  		" course.col_no='"+collno+"' and course.cou_no=grade.cou_no and isdual=0";
				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					String courno=rs.getString(2);
					String couname=new String(rs.getString(1).getBytes("ISO-8859-1"));
					al.add(new SelectItem(courno,couname));
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
	public static void stopChoseCourse(String colNo)
	{
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="update coursemsg,course set coursemsg.onchosing='0' where course.col_no='"+colNo+"'"+
				     " and course.cou_no=coursemsg.cou_no";
				  System.out.println(sql+"=========");
				stmt=conn.createStatement();
				int i=stmt.executeUpdate(sql);
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
	public static ArrayList getGradeItemList(String courno)//根据课程号
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
				sql="select grade.cou_no,cou_name,grade.stu_no,stu_name,xuefen,score from "+
			       "course,grade,students where grade.cou_no=course.cou_no and grade.stu_no="+
			       "students.stu_no and grade.cou_no='"+courno+"' and isdual=0";

				stmt=conn.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next())
				{
					al.add(new GradeItem(
						    new String(rs.getString(1).getBytes("ISO-8859-1")),
							new String(rs.getString(2).getBytes("ISO-8859-1")),
							new String(rs.getString(3).getBytes("ISO-8859-1")),
							new String(rs.getString(4).getBytes("ISO-8859-1")),
							rs.getDouble(5),
							rs.getDouble(6)));			
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
	/*public static void saveScore(String courseNo,String stuNo,double score)
	{
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="update grade set score="+score+" where cou_no='"+courseNo+"' and"+
				    " stu_no='"+stuNo+"'";
				stmt=conn.createStatement();
				int i=stmt.executeUpdate(sql);
				
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
	}*/
	public static void saveScore(List list)
	{
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			conn.setAutoCommit(false);
			for(Object o:list)
			{
				GradeItem gi=(GradeItem)o;
				String courseNo=gi.getCourseNo();
				String stuNo=gi.getStuNo();
				double score=gi.getScore();
				sql="update grade set score="+score+" where cou_no='"+courseNo+"' and"+
				    " stu_no='"+stuNo+"'";
				stmt.addBatch(sql);
			}
			stmt.executeBatch();
			conn.commit();
			conn.setAutoCommit(true);
		}
		catch(Exception e)
		{
			try
			{
				conn.rollback();
				conn.setAutoCommit(true);
			}
			catch(SQLException ea)
			{
				ea.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	public static boolean gongBuScore(String courseNo)
	{
		Connection conn=null;
		Statement stmt=null;
		String sql=null;
		try
		{
			conn=getConnection();
			if(conn!=null)
			{
				sql="update grade set isdual=1 where cou_no='"+courseNo+"' and"+
				    " isdual=0";
				stmt=conn.createStatement();
				int i=stmt.executeUpdate(sql);
				if(i!=0)
				{
					return true;
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
		return false;
	}
	
	public static String addCou(String cno,String cname,double xuefen,String colno,String deptno)
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql=null;
		String result="";
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			sql="select * from course where cou_no='"+cno+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				return "已经有该课程号的课程";
			}
			else
			{
				sql="insert into course (cou_no,cou_name,xuefen,col_no,dept_no)"+
				" values('"+cno+"','"+cname+"',"+xuefen+",'"+colno+"','"+deptno+"')";
				int i=stmt.executeUpdate(sql);
				if(i==1)
				{
					return "插入成功";
				}
				else
				{
					return "插入失败";
				}
			}
			
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
			return "插入失败";
		}
	}
	
	
		
	public static Connection getConnection(){//获得数据库连接的方法
		Connection conn=null;			//声明数据库连接引用
		try{Context initial=new InitialContext();//获得上下文
			DataSource ds=(DataSource)initial.lookup("java:comp/env/xsglxt");//获得数据源
			conn=ds.getConnection();//获得数据库连接
		}
		catch(NamingException e){e.printStackTrace();}//异常处理语句
		catch(SQLException e){e.printStackTrace();}//异常处理语句
		return conn;		//返回数据库连接
	}
}