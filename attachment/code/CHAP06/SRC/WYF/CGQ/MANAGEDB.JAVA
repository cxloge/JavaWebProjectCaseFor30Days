package wyf.cgq;
import java.util.*;
import java.util.Date;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.io.*;
public class ManageDB
{
	public static List getImpList(String departId,int pageSpan,int currenPageNo,int orderBySalary,int orderByAge)
	{
		ArrayList list=new ArrayList();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{ 
			conn=getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql="select imployeeinfo.impId,imployeeinfo.impName,"+
			"imployeeinfo.impBirth,departmentinfo.departName,"+
			"imployeeinfo.impRoll,imployeeinfo.impSalary,"+
			"imployeeinfo.impTel,imployeeinfo.impGender from "+
			"imployeeinfo,departmentinfo where "+
			"imployeeinfo.departId=departmentinfo.departId "+
			"and imployeeinfo.impState=0 "+
			(departId.equals("0000")?"":("and departmentinfo.departId='"+
			departId+"' "))+
			((orderBySalary==0?
			(orderByAge==0?"":("order by imployeeinfo.impBirth"+(orderByAge==1?" asc":" desc"))):
			("order by imployeeinfo.impSalary"+(orderBySalary==1?" asc":" desc"))));
			rs=stmt.executeQuery(sql);
			int num=0;
			if(currenPageNo!=1)
			{
				rs.absolute((currenPageNo-1)*pageSpan);
			}
			while(num<pageSpan&&rs.next())
			{
				num++;
				String impId=rs.getString("impId");
				String impName=new String(rs.getString("impName").getBytes("ISO-8859-1"));
				Date impBirth=rs.getDate("impBirth");
				String departName=new String(rs.getString("departName").getBytes("ISO-8859-1"));
				String impRoll=new String(rs.getString("impRoll").getBytes("ISO-8859-1"));
				double impSalary=rs.getDouble("impSalary");
				String impGender=new String(rs.getString("impGender").getBytes("ISO-8859-1"));
				String impTel=rs.getString("impTel");
				Impleey tempimp=new Impleey(impId,impName,impGender,
					impBirth,departName,impRoll,impSalary,impTel);
				list.add(tempimp);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return list;
	}
	public static int getImpTotalMessage(String departId)
	{
		int totalmessage=0;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String sql="select count(*) from imployeeinfo where "+
				(departId.equals("0000")?"":("departId='"+departId+"' and "))+
				"impState=0";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				totalmessage=rs.getInt(1);
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
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return totalmessage;
	}
	public static Map getDepartList()
	{
		Map map=new HashMap();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String sql="select departId,departName from departmentinfo";
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				String departId=rs.getString("departId");
				String departName=new String(rs.getString("departName").getBytes("ISO-8859-1"));
				map.put(departId,departName);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return map;
	}
	public static Impleey getImpDetail(String impId)
	{
		Impleey imp=null;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String sql="select imployeeinfo.impId,imployeeinfo.impName,imployeeinfo.impGender,"+
					"imployeeinfo.impBirth,departmentinfo.departName,imployeeinfo.impRoll,"+
					"imployeeinfo.impSalary,imployeeinfo.impTel,imployeeinfo.impEmail,"+
					"imployeeinfo.impPic,imployeeinfo.impBio,imployeeinfo.impState"+
					" from imployeeinfo,departmentinfo where"+
					" imployeeinfo.impId='"+impId+"' and"+
					" departmentinfo.departId=imployeeinfo.departId";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				String impId2=rs.getString("impId");
				String impName=new String(rs.getString("impName").getBytes("ISO-8859-1"));
				String impGender=new String(rs.getString("impGender").getBytes("ISO-8859-1"));
				Date impBirth=rs.getDate("impBirth");
				String departName=new String(rs.getString("departName").getBytes("ISO-8859-1"));
				String impRoll=new String(rs.getString("impRoll").getBytes("ISO-8859-1"));
				double impSalary=rs.getDouble("impSalary");
				String impTel=rs.getString("impTel");
				String impEmail=rs.getString("impEmail");
				String impPic=rs.getString("impPic");
				String impBio=new String(rs.getString("impBio").getBytes("ISO-8859-1"));
				String impState=rs.getInt("impState")==0?"在职":"离职";
				imp=new Impleey(impId2,impName,impGender,impBirth,departName,impRoll,
						impSalary,impTel,impEmail,impPic,impBio,impState);
				
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return imp;
	}
	public static boolean hasImp(String impId)
	{
		boolean b=false;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String sql="select impId from imployeeinfo where impId='"+impId+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				b=true;
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return b;
	}
	public static boolean addImp(String impId,String impName,String impGender,
			Date impBirth,String impEmail,String departId,String impRoll,
			double impSalary,String impTel,String impPic,String impBio,String dir)
	{
		boolean b=false;
		Connection conn=null;
		Statement stmt=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String birth=impBirth.getYear()+1900+"-"+(impBirth.getMonth()+1)+"-"+impBirth.getDate();
			conn.setAutoCommit(false);
			String sql="insert into imployeeinfo values('"+impId+"','"+new String(impName.getBytes(),"ISO-8859-1")+"','"+new String(impGender.getBytes(),"ISO-8859-1")+"','"+
				birth+"','"+impEmail+"','"+departId+"','"+new String(impRoll.getBytes(),"ISO-8859-1")+"',"+impSalary+",'"+impTel+"','"+
				(impPic.equals("")?(dir+"default.png"):(dir+impPic))+"','"+new String(impBio.getBytes(),"ISO-8859-1")+"',"+0+")";
			int num=stmt.executeUpdate(sql);
			if(num==1)
			{
				String sql1="insert into userinfo values('"+impId+"','"+impId+"',"+(departId.equals("0001")?1:2)+")";
				num=stmt.executeUpdate(sql1);
				if(num==1)
				{
					num=stmt.executeUpdate("update departmentinfo set departNum=departNum+1 where departId='"+departId+"'");
					if(num==1)
					{
						conn.commit();
						conn.setAutoCommit(true);
						b=true;
					}
					
				}
			}
		}
		catch(Exception e)
		{
			try
			{
				conn.rollback();
				conn.setAutoCommit(true);
			}
			catch(Exception ea)
			{
				ea.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return b;
	}
	public static List getDepartmentList(int currenPage,int pageSpan)
	{
		ArrayList list=new ArrayList();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql="select departId,departName,departNum,departDescrip from departmentinfo";
			rs=stmt.executeQuery(sql);
			if(currenPage>1)
			{
				rs.absolute((currenPage-1)*pageSpan);
			}
			int num=0;
			while(num<pageSpan&&rs.next())
			{
				num++;
				String departId=rs.getString("departId");
				String departName=new String(rs.getString("departName").getBytes("ISO-8859-1"));
				int departNum=rs.getInt("departNum");
				String s=new String(rs.getString("departDescrip").getBytes("ISO-8859-1"));
				String departDescrip=null;
				if(s.length()>5)
				{
					departDescrip=s.substring(0,5)+"....";	
				}
				else
				{
					departDescrip=s;
				}
				Department dttemp=new Department(departId,departName,departNum,departDescrip);
				list.add(dttemp);
			}
			System.out.println(list.size()+"部门数量");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return list;
	}
	public static List getImpByDepartId(String departId,int currenPage,int pageSpan)
	{
		ArrayList list=new ArrayList();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql="select impId,impName,impBirth,impRoll,impSalary,impTel,impGender from "+
			"imployeeinfo where departId='"+departId+"'";
			rs=stmt.executeQuery(sql);
			if(currenPage>1)
			{
				rs.absolute((currenPage-1)*pageSpan);
			}
			int num=0;
			while(num<pageSpan&&rs.next())
			{
				num++;
				String impId=rs.getString("impId");
				String impName=new String(rs.getString("impName").getBytes("ISO-8859-1"));
				Date impBirth=rs.getDate("impBirth");
				String impRoll=new String(rs.getString("impRoll").getBytes("ISO-8859-1"));
				double impSalary=rs.getDouble("impSalary");
				String impGender=new String(rs.getString("impGender").getBytes("ISO-8859-1"));
				String impTel=rs.getString("impTel");
				Impleey tempimp=new Impleey(impId,impName,impGender,
					impBirth,"",impRoll,impSalary,impTel);
				list.add(tempimp);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return list;
	}
	public static int getDepartTotalMessage(String departId)
	{
		int totalmessage=0;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String sql="select count(*) from imployeeinfo where "+
				"departId='"+departId+"' and impState=0";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				totalmessage=rs.getInt(1);
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
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return totalmessage;
	}
	public static String getDepartNameById(String departId)
	{
		String departName=null;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String sql="select departName from departmentinfo where departId='"+departId+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				departName=new String(rs.getString("departName").getBytes("ISO-8859-1"));
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return departName;
	}
	
	public static Department getDepartById(String departId)
	{
		Department department=null;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String sql="select departId,departName,departNum,departDescrip from departmentinfo"+
					" where departId='"+departId+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				String departIds=rs.getString("departId");
				String departName=new String(rs.getString("departName").getBytes("ISO-8859-1"));
				int departNum=rs.getInt("departNum");
				String departDescrip=new String(rs.getString("departDescrip").getBytes("ISO-8859-1"));
				department=new Department(departIds,departName,departNum,departDescrip);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return department;
	}
	public static int getDepartTotalMessage()//DepartmentListBaseAction调用获得部门总数量
	{
		int totalmessage=0;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String sql="select count(*) from departmentinfo";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				totalmessage=rs.getInt(1);
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
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return totalmessage;
	}
	public static int updateDepartment(String departId,String departName,String departDescrip)
	{
		Connection conn=null;
		PreparedStatement stmt=null;
		try
		{
			conn=getConnection();
			stmt=conn.prepareStatement("update departmentinfo set departName=?,departDescrip=? where departId=?");
			stmt.setString(1,new String(departName.getBytes(),"ISO-8859-1"));
			stmt.setString(2,new String(departDescrip.getBytes(),"ISO-8859-1"));
			stmt.setString(3,departId);
			int i=stmt.executeUpdate();
			if(i==1)
			{
				return 1;
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return -1;
	}
	public static void delDepart(String departId)
	{
		Connection conn=null;
		Statement stmt=null;
		try
		{
			conn=getConnection();
			String sql="delete from departmentinfo where departId='"+departId+"'";
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public static int getImpNumByDepartId(String departId)
	{
		int impNum=0;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String sql="select count(*) from imployeeinfo where departId='"+departId+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				impNum=rs.getInt(1);
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
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return impNum;
	}
	public static int addDepart(String departId,String departName,String departDescrip)
	{
		int i=0;
		Connection conn=null;
		Statement stmt=null;
		try
		{
			conn=getConnection();
			String sql="insert into departmentinfo(departId,departName,departNum,departDescrip)"+
			" values('"+departId+"','"+new String(departName.getBytes(),"ISO-8859-1")+"',"+
			0+",'"+new String(departDescrip.getBytes(),"ISO-8859-1")+"')";
			stmt=conn.createStatement();
			i=stmt.executeUpdate(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return i;
	}
	public static boolean hasRecord(String date)
	{
		boolean has=true;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String sql="select count(*) from attendanceinfo where attendTime='"+date+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				int impNum=rs.getInt(1);
				if(impNum>0)
				{
					has=true;
				}
				else
				{
					has=false;
				}
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
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return has;
	}
	public static void generateQianDaoTable(String date)
	{
		Connection conn=null;
		Statement stmt=null;
		try
		{
			conn=getConnection();
			String sql="insert into attendanceinfo "+
			"select impId,'"+date+"',0 from imployeeinfo where impState=0 and impId not in "+
			"(select impId from holsinfo where holsState=1 and '"+date+"' "+
			"between startTime and endTime) union "+
			"select impId,'"+date+"',2 from holsinfo where holsState=1 "+
			"and '"+date+"' between startTime and endTime";
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public static List getQianDaoTable(String date,int currenPage,int pageSpan)
	{
		ArrayList list=new ArrayList();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql="select imployeeinfo.impId,imployeeinfo.impName,departmentinfo.departName,"+
					"attendanceinfo.attendTime,attendanceinfo.attendState "+
					"from imployeeinfo,attendanceinfo,departmentinfo "+
					"where imployeeinfo.departId=departmentinfo.departId and "+
					"imployeeinfo.impId=attendanceinfo.impId and attendanceinfo.attendTime='"+date+"'";
					System.out.println("=============="+sql);
			rs=stmt.executeQuery(sql);
			if(currenPage>1)
			{
				rs.absolute((currenPage-1)*pageSpan);
			}
			int num=0;
			while(num<pageSpan&&rs.next())
			{
				num++;
				String impId=rs.getString("impId");
				String impName=new String(rs.getString("impName").getBytes("ISO-8859-1"));
				String departName=new String(rs.getString("departName").getBytes("ISO-8859-1"));
				int attendState=rs.getInt("attendState");
				QianDaoRecord qdr=new QianDaoRecord(impId,impName,departName,date,attendState);
				list.add(qdr);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return list; 
	}
	public static int getTotalMessage(String date)
	{
		int totalMessage=0;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String sql="select count(*) "+
					"from imployeeinfo,attendanceinfo,departmentinfo "+
					"where imployeeinfo.departId=departmentinfo.departId and "+
					"imployeeinfo.impId=attendanceinfo.impId and attendanceinfo.attendTime='"+date+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				totalMessage=rs.getInt(1);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return totalMessage;
	}
	public static int qianDao(String impId,String date)
	{
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String sql="select * from attendanceinfo where impId='"+
			impId+"' and attendTime='"+date+"'";
			rs=stmt.executeQuery(sql);
			if(!rs.next())
			{
				return 0;//没有这个号
			}
			rs.close();
			sql="select * from attendanceinfo where impId='"+
			impId+"' and attendTime='"+date+"' and attendState=2";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				return 1;//已经请假
			}
			sql="update attendanceinfo set attendState=1 where impId='"+
			impId+"' and attendTime='"+date+"'";
			int i=stmt.executeUpdate(sql);
			if(i==1)
			{
				return 2;//成功
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
				if(rs!=null){rs.close();}
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return 0;
	}
	public static List getRecordList(String departId,int attendType,int currenPage,int pageSpan)
	{
		ArrayList list=new ArrayList();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			Date d=new Date();
			String departIdStr="";
			String attendTypeStr="";
			String date=d.getYear()+1900+"-"+(d.getMonth()+1)+"-"+d.getDate();
			conn=getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			if(!departId.equals("0000"))
			{
				departIdStr="and imployeeinfo.departId='"+departId+"'";
			}
			if(attendType!=-1)
			{
				attendTypeStr=" and attendanceinfo.attendState="+attendType;
			}
			String sql="select imployeeinfo.impId,imployeeinfo.impName,departmentinfo.departName,"+
					"attendanceinfo.attendTime,attendanceinfo.attendState "+
					"from imployeeinfo,attendanceinfo,departmentinfo "+
					"where imployeeinfo.departId=departmentinfo.departId and "+
					"imployeeinfo.impId=attendanceinfo.impId and attendanceinfo.attendTime='"+date+"' "+
					departIdStr+attendTypeStr;
			rs=stmt.executeQuery(sql);
			if(currenPage>1)
			{
				rs.absolute((currenPage-1)*pageSpan);
			}
			int num=0;
			while(num<pageSpan&&rs.next())
			{
				num++;
				String impId=rs.getString("impId");
				String impName=new String(rs.getString("impName").getBytes("ISO-8859-1"));
				String departName=new String(rs.getString("departName").getBytes("ISO-8859-1"));
				int attendState=rs.getInt("attendState");
				QianDaoRecord qdr=new QianDaoRecord(impId,impName,departName,date,attendState);
				list.add(qdr);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return list;
	}
	public static int getTotalMessage(String departId,int attendType)
	{
		int totalMessage=0;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			Date d=new Date();
			String departIdStr="";
			String attendTypeStr="";
			String date=d.getYear()+1900+"-"+(d.getMonth()+1)+"-"+d.getDate();
			conn=getConnection();
			stmt=conn.createStatement();
			if(!departId.equals("0000"))
			{
				departIdStr="and imployeeinfo.departId='"+departId+"'";
			}
			if(attendType!=-1)
			{
				attendTypeStr=" and attendanceinfo.attendState="+attendType;
			}
			String sql="select count(*) "+
					"from imployeeinfo,attendanceinfo,departmentinfo "+
					"where imployeeinfo.departId=departmentinfo.departId and "+
					"imployeeinfo.impId=attendanceinfo.impId and attendanceinfo.attendTime='"+date+"' "+
					departIdStr+attendTypeStr;
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				totalMessage=rs.getInt(1);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return totalMessage;
	}
	public static Holsinfo getHolsinfo(String impIds,String date)
	{
		Holsinfo holsinfo=null;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String sql="select holsinfo.impId,holsinfo.applyTime,holsinfo.startTime,"+
					"holsinfo.endTime,holsinfo.holdays,holsinfo.executes,"+
					"holsinfo.holsState,imployeeinfo.impName from holsinfo,"+
					"imployeeinfo where holsinfo.impId=imployeeinfo.impId "+
					"and holsinfo.impId='"+impIds+"' and '"+date+"' between "+
					"holsinfo.startTime and holsinfo.endTime";
					System.out.println(sql);
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				String impId=rs.getString("impId");
				String impName=new String(rs.getString("impName").getBytes("ISO-8859-1"));
				Date applyTime=rs.getDate("applyTime");
				Date startTime=rs.getDate("startTime");
				Date endTime=rs.getDate("endTime");
				int holdays=rs.getInt("holdays");
				String executes=new String(rs.getString("executes").getBytes("ISO-8859-1"));
				int holsState=rs.getInt("holsState");
				holsinfo=new Holsinfo(impId,impName,applyTime,startTime,endTime,holdays,executes,holsState);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return holsinfo;
	}
	
	public static boolean hasImpinwork(String impId)
	{
		boolean b=false;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String sql="select impId from imployeeinfo where impId='"+impId+"' and impState=0";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				b=true;
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return b;
	}
	public static boolean hasWorkRecord(String impId,String workTime)
	{
		boolean b=false;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String sql="select impId from extrawork where impId='"+impId+"' and workTime='"+workTime+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				b=true;
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return b;
	}
	public static boolean addWorkRecord(String impId,String time,String executes)
	{
		boolean b=false;
		Connection conn=null;
		Statement stmt=null;
		try
		{
			conn=getConnection();
			String sql="insert into extrawork values('"+impId+"','"+time+"','"+new String(executes.getBytes(),"ISO-8859-1")+"')";
			stmt=conn.createStatement();
			int i=stmt.executeUpdate(sql);
			if(i==1)
			{
				b=true;
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return b;
	}
	public static int getPEWTotalMessage(String impId,Date startTime,Date endTime)
	{
		int totalMessage=0;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			String start=startTime.getYear()+1900+"-"+(startTime.getMonth()+1)+"-"+startTime.getDate();
			String end=endTime.getYear()+1900+"-"+(endTime.getMonth()+1)+"-"+endTime.getDate();
			conn=getConnection();
			stmt=conn.createStatement();
			String sql="select count(*) from extrawork where impId='"+impId+"'"+
			" and workTime between '"+start+"' and '"+end+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				totalMessage=rs.getInt(1);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return totalMessage;
	}
	public static List getPEWRecordList(String impId,Date startTime,Date endTime,int currenPage,int pageSpan)
	{
		ArrayList list=new ArrayList();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			String start=startTime.getYear()+1900+"-"+(startTime.getMonth()+1)+"-"+startTime.getDate();
			String end=endTime.getYear()+1900+"-"+(endTime.getMonth()+1)+"-"+endTime.getDate();
			conn=getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql="select extrawork.impId,imployeeinfo.impName,"+
					"departmentinfo.departName,extrawork.workTime,extrawork.executes"+
					" from extrawork,imployeeinfo,departmentinfo where "+
					"extrawork.impId=imployeeinfo.impId and imployeeinfo.departId="+
					"departmentinfo.departId and extrawork.workTime between "+
					"'"+start+"' and '"+end+"' and extrawork.impId='"+impId+"'";
			rs=stmt.executeQuery(sql);
			if(currenPage>1)
			{
				rs.absolute((currenPage-1)*pageSpan);
			}
			int num=0;
			while(num<pageSpan&&rs.next())
			{
				num++;
				String impId1=rs.getString("impId");
				String impName=new String(rs.getString("impName").getBytes("ISO-8859-1"));
				String departName=new String(rs.getString("departName").getBytes("ISO-8859-1"));
				Date workTime=rs.getDate("workTime");
				String executes=new String(rs.getString("executes").getBytes("ISO-8859-1"));
				if(executes.length()>6)
				{
					executes=executes.substring(0,6)+"....";
				}
				else
				{
					executes=executes.substring(0,executes.length());
				}
				ExtraWork extrawork=new ExtraWork(impId1,impName,departName,workTime,executes);
				list.add(extrawork);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return list;
	}
	public static void delExtraWork(String delImpId,String workTime)
	{
		Connection conn=null;
		Statement stmt=null;
		try
		{
			conn=getConnection();
			String sql="delete from extrawork where impId='"+delImpId+"' and "+
					"workTime='"+workTime+"'";
			stmt=conn.createStatement();
			int i=stmt.executeUpdate(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public static ExtraWork getExtraWorkDetail(String impId,String workTime)
	{
		ExtraWork extrawork=null;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String sql="select extrawork.impId,imployeeinfo.impName,"+
					"departmentinfo.departName,extrawork.workTime,extrawork.executes"+
					" from extrawork,imployeeinfo,departmentinfo where "+
					"extrawork.impId=imployeeinfo.impId and imployeeinfo.departId="+
					"departmentinfo.departId and extrawork.workTime='"+workTime+"' "+
					"and extrawork.impId='"+impId+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				String impId1=rs.getString("impId");
				String impName=new String(rs.getString("impName").getBytes("ISO-8859-1"));
				String departName=new String(rs.getString("departName").getBytes("ISO-8859-1"));
				Date workTime1=rs.getDate("workTime");
				String executes=new String(rs.getString("executes").getBytes("ISO-8859-1"));
				extrawork=new ExtraWork(impId1,impName,departName,workTime1,executes);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return extrawork;
	}
	public static int getDEWTotalMessage(String departId,Date startTime,Date endTime)
	{
		int totalMessage=0;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			String start=startTime.getYear()+1900+"-"+(startTime.getMonth()+1)+"-"+startTime.getDate();
			String end=endTime.getYear()+1900+"-"+(endTime.getMonth()+1)+"-"+endTime.getDate();
			conn=getConnection();
			stmt=conn.createStatement();
			String departIdStr="";
			if(!departId.equals("0000"))
			{
				departIdStr=" and imployeeinfo.departId='"+departId+"'";
			}
			String sql="select count(*) from extrawork,imployeeinfo where "+
			"extrawork.workTime between '"+start+"' and '"+end+"' and "+
			"extrawork.impId=imployeeinfo.impId"+departIdStr;
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				totalMessage=rs.getInt(1);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return totalMessage;
	}
	public static List getDEWList(String departId,Date startTime,Date endTime,int currenPage,int pageSpan)
	{
		List list=new ArrayList();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			String start=startTime.getYear()+1900+"-"+(startTime.getMonth()+1)+"-"+startTime.getDate();
			String end=endTime.getYear()+1900+"-"+(endTime.getMonth()+1)+"-"+endTime.getDate();
			String departIdStr="";
			if(!departId.equals("0000"))
			{
				departIdStr=" and imployeeinfo.departId='"+departId+"'";
			}
			conn=getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql="select extrawork.impId,imployeeinfo.impName,"+
					"departmentinfo.departName,extrawork.workTime,extrawork.executes"+
					" from extrawork,imployeeinfo,departmentinfo where "+
					"extrawork.impId=imployeeinfo.impId and imployeeinfo.departId="+
					"departmentinfo.departId and extrawork.workTime between "+
					"'"+start+"' and '"+end+"'"+departIdStr;
			rs=stmt.executeQuery(sql);
			if(currenPage>1)
			{
				rs.absolute((currenPage-1)*pageSpan);
			}
			int num=0;
			while(num<pageSpan&&rs.next())
			{
				num++;
				String impId1=rs.getString("impId");
				String impName=new String(rs.getString("impName").getBytes("ISO-8859-1"));
				String departName=new String(rs.getString("departName").getBytes("ISO-8859-1"));
				Date workTime=rs.getDate("workTime");
				String executes=new String(rs.getString("executes").getBytes("ISO-8859-1"));
				if(executes.length()>6)
				{
					executes=executes.substring(0,6)+"....";
				}
				else
				{
					executes=executes.substring(0,executes.length());
				}
				ExtraWork extrawork=new ExtraWork(impId1,impName,departName,workTime,executes);
				list.add(extrawork);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return list;
	}
	public static int getTotalMessage(String departId,int attendType,Date startTime,Date endTime)
	{
		int totalMessage=0;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			String start=startTime.getYear()+1900+"-"+(startTime.getMonth()+1)+"-"+startTime.getDate();
			String end=endTime.getYear()+1900+"-"+(endTime.getMonth()+1)+"-"+endTime.getDate();
			conn=getConnection();
			stmt=conn.createStatement();
			String departIdStr="";
			String attendTypeStr="";
			if(!departId.equals("0000"))
			{
				departIdStr=" and imployeeinfo.departId='"+departId+"'";
			}
			if(attendType!=-1)
			{
				attendTypeStr=" and attendanceinfo.attendState="+attendType;
			}
			String sql="select count(*) from imployeeinfo,attendanceinfo "+
					"where imployeeinfo.impId=attendanceinfo.impId and "+
					"attendanceinfo.attendTime between '"+start+"' and '"+end+"' "+
					departIdStr+attendTypeStr;
		
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				totalMessage=rs.getInt(1);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return totalMessage;
	}
	
	public static List getRecordList(String departId,int attendType,Date startTime,Date endTime,int currenPage,int pageSpan)
	{
		ArrayList list=new ArrayList();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			String departIdStr="";
			String attendTypeStr="";
			String start=startTime.getYear()+1900+"-"+(startTime.getMonth()+1)+"-"+startTime.getDate();
			String end=endTime.getYear()+1900+"-"+(endTime.getMonth()+1)+"-"+endTime.getDate();
			conn=getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			if(!departId.equals("0000"))
			{
				departIdStr="and imployeeinfo.departId='"+departId+"'";
			}
			if(attendType!=-1)
			{
				attendTypeStr=" and attendanceinfo.attendState="+attendType;
			}
			String sql="select imployeeinfo.impId,imployeeinfo.impName,departmentinfo.departName,"+
					"attendanceinfo.attendTime,attendanceinfo.attendState "+
					"from imployeeinfo,attendanceinfo,departmentinfo "+
					"where imployeeinfo.departId=departmentinfo.departId and "+
					"imployeeinfo.impId=attendanceinfo.impId and attendanceinfo.attendTime "+
					"between '"+start+"' and '"+end+"' "+departIdStr+attendTypeStr;
			rs=stmt.executeQuery(sql);
			if(currenPage>1)
			{
				rs.absolute((currenPage-1)*pageSpan);
			}
			int num=0;
			while(num<pageSpan&&rs.next())
			{
				num++;
				String impId=rs.getString("impId");
				String impName=new String(rs.getString("impName").getBytes("ISO-8859-1"));
				String departName=new String(rs.getString("departName").getBytes("ISO-8859-1"));
				Date attendTime=rs.getDate("attendTime");
				String date=attendTime.getYear()+1900+"-"+(attendTime.getMonth()+1)+"-"+attendTime.getDate();
				int attendState=rs.getInt("attendState");
				QianDaoRecord qdr=new QianDaoRecord(impId,impName,departName,date,attendState);
				list.add(qdr);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	
	public static int getTotalMessage(String departId,String impId,String impName,int upSalary,int downSalary)
	{
		int totalMessage=0;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String departIdStr="";
			String impIdStr="";
			String impNameStr="";
			String upSalartStr="";
			String downSalaryStr="";
			if(departId!=null&&(!departId.equals("0000")))
			{
				departIdStr=" and imployeeinfo.departId='"+departId+"'";
			}
			if(impId!=null&&(!impId.equals("")))
			{
				impIdStr=" and imployeeinfo.impId like '%"+impId+"%' ";
			}
			if(impName!=null&&(!impName.equals("")))
			{
				impNameStr=" and imployeeinfo.impName like '%"+new String(impName.getBytes(),"ISO-8859-1")+"%' ";
			}
			if(upSalary!=0)
			{
				upSalartStr=" and imployeeinfo.impSalary<="+upSalary;
			}
			if(downSalary!=0)
			{
				downSalaryStr=" and imployeeinfo.impSalary>="+downSalary;
			}
			String sql="select count(*) from imployeeinfo,departmentinfo "+
					"where imployeeinfo.departId=departmentinfo.departId and "+
					" impState=0"+departIdStr+impIdStr+impNameStr+upSalartStr+
					downSalaryStr;
		
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				totalMessage=rs.getInt(1);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return totalMessage;
	}
	public static List getResultList(String departId,String impId,String impName,int currenPage,int pageSpan,int upSalary,int downSalary)
	{
		List list=new ArrayList();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String departIdStr="";
			String impIdStr="";
			String impNameStr="";
			String upSalartStr="";
			String downSalaryStr="";
			if(!departId.equals("0000"))
			{
				departIdStr=" and imployeeinfo.departId='"+departId+"'";
			}
			if(impId!=null&&(!impId.equals("")))
			{
				impIdStr=" and imployeeinfo.impId like '%"+impId+"%' ";
			}
			if(impName!=null&&(!impName.equals("")))
			{
				impNameStr=" and imployeeinfo.impName like '%"+new String(impName.getBytes(),"ISO-8859-1")+"%' ";
			}
			if(upSalary!=0)
			{
				upSalartStr=" and imployeeinfo.impSalary<="+upSalary;
			}
			if(downSalary!=0)
			{
				downSalaryStr=" and imployeeinfo.impSalary>="+downSalary;
			}
			String sql="select imployeeinfo.impId,imployeeinfo.impName,"+
			"imployeeinfo.impBirth,departmentinfo.departName,"+
			"imployeeinfo.impRoll,imployeeinfo.impSalary,"+
			"imployeeinfo.impTel,imployeeinfo.impGender from imployeeinfo,departmentinfo "+
					"where imployeeinfo.departId=departmentinfo.departId and "+
					" impState=0"+departIdStr+impIdStr+impNameStr+upSalartStr+
					downSalaryStr;
		
			rs=stmt.executeQuery(sql);
			int num=0;
			if(currenPage!=1)
			{
				rs.absolute((currenPage-1)*pageSpan);
			}
			while(num<pageSpan&&rs.next())
			{
				num++;
				String impId1=rs.getString("impId");
				String impName1=new String(rs.getString("impName").getBytes("ISO-8859-1"));
				Date impBirth=rs.getDate("impBirth");
				String departName=new String(rs.getString("departName").getBytes("ISO-8859-1"));
				String impRoll=new String(rs.getString("impRoll").getBytes("ISO-8859-1"));
				double impSalary=rs.getDouble("impSalary");
				String impGender=new String(rs.getString("impGender").getBytes("ISO-8859-1"));
				String impTel=rs.getString("impTel");
				Impleey tempimp=new Impleey(impId1,impName1,impGender,
					impBirth,departName,impRoll,impSalary,impTel);
				list.add(tempimp);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	public static void delImp(String delImpId)
	{
		Connection conn=null;
		Statement stmt=null;
		try
		{
			
			conn=getConnection();
			conn.setAutoCommit(false);
			String sql="update imployeeinfo set impState=1 where impId='"+delImpId+"'";
			stmt=conn.createStatement();
			int i=stmt.executeUpdate(sql);
			sql="delete from userinfo where impId='"+delImpId+"'";
			stmt.executeUpdate(sql);
			conn.commit();
			
		}
		catch(Exception e)
		{
			try
			{
				conn.rollback();
			}
			catch(SQLException ee)
			{
				ee.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			try
			{	
				conn.setAutoCommit(true);
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public static Impleey getImpById(String impId)
	{
		Impleey imp=null;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String sql="select imployeeinfo.impId,imployeeinfo.impName,imployeeinfo.impGender,"+
					"imployeeinfo.impBirth,imployeeinfo.departId,imployeeinfo.impRoll,"+
					"imployeeinfo.impSalary,imployeeinfo.impTel,imployeeinfo.impEmail,"+
					"imployeeinfo.impBio,imployeeinfo.impState"+
					" from imployeeinfo where"+
					" imployeeinfo.impId='"+impId+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				String impId2=rs.getString("impId");
				String impName=new String(rs.getString("impName").getBytes("ISO-8859-1"));
				String impGender=new String(rs.getString("impGender").getBytes("ISO-8859-1"));
				Date impBirth=rs.getDate("impBirth");
				String departId=new String(rs.getString("departId").getBytes("ISO-8859-1"));
				String impRoll=new String(rs.getString("impRoll").getBytes("ISO-8859-1"));
				double impSalary=rs.getDouble("impSalary");
				String impTel=rs.getString("impTel");
				String impEmail=rs.getString("impEmail");
				String impBio=new String(rs.getString("impBio").getBytes("ISO-8859-1"));
				String impState=rs.getInt("impState")==0?"在职":"离职";
				imp=new Impleey(impId2,impName,impGender,impBirth,departId,impRoll,
						impSalary,impTel,impEmail,impBio,impState);
				
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return imp;
	}
	public static boolean updateImp(String impId,String impName,String impGender,
			Date impBirth,String impEmail,String departId,String impRoll,
			double impSalary,String impTel,String impPic,String impBio,String dir)
	{
		boolean b=false;
		Connection conn=null;
		Statement stmt=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String birth=impBirth.getYear()+1900+"-"+(impBirth.getMonth()+1)+"-"+impBirth.getDate();
			String sql="update imployeeinfo set impName='"+new String(impName.getBytes(),"ISO-8859-1")+"',"+
			"impGender='"+new String(impGender.getBytes(),"ISO-8859-1")+"',impBirth='"+birth+"',impEmail='"+
			impEmail+"',departId='"+departId+"',impRoll='"+new String(impRoll.getBytes(),"ISO-8859-1")+"',"+
			"impSalary="+impSalary+",impTel='"+impTel+"',impBio='"+new String(impBio.getBytes(),"ISO-8859-1")+"'"+
			(impPic.equals("")?(""):(",impPic='"+dir+impPic+"'"))+" where impId='"+impId+"'";
			System.out.println(sql);
			int num=stmt.executeUpdate(sql);
			if(num==1)
			{
				b=true;
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return b;
	}
	
	public static List getSalaryList(double jiaBanFei,double qingJiaFei,double queQinFei,String departId,String year,String month,int currenPage,int pageSpan)
	{
		List list=new ArrayList();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		boolean has=false;
		try
		{
			conn=getConnection(); 
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql="select count(*) from salaryinfo where syear='"+year+"' and smonth='"+month+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				int i=rs.getInt(1);
				if(i>0)
				{
					
					has=true;
				}
			}
			rs.close();
			if(has==false)
			{
				int year1=Integer.parseInt(year);
				int month1=Integer.parseInt(month);
				Date d=new Date(year1,month1,0);
				int date=d.getDate();
				sql="insert into salaryinfo "+
						"(impId,syear,smonth,sBase,sExtra,sHoliday,sAbsence,sTotal,sState) "+
					"select imployeeinfo.impId,"+year1+","+month+",imployeeinfo.impSalary,"+
					"ifnull((select count(*)*"+jiaBanFei+" from extrawork "+
						"where extrawork.impId=imployeeinfo.impId "+
						"and extrawork.workTime between '"+year1+"-"+month+"-1' and '"+year1+"-"+month1+"-"+date+"'"+  
						" group by extrawork.impId),0) \"sExtra\","+
					"ifnull((select count(*)*"+queQinFei+" from attendanceinfo "+ 
						"where attendanceinfo.impId=imployeeinfo.impId "+
						"and attendanceinfo.attendTime between '"+year1+"-"+month+"-1' and '"+year1+"-"+month1+"-"+date+"'"+  
						" and attendanceinfo.attendState=0"+ 
						" group by attendanceinfo.impId),0) \"sAbsence\","+
					"ifnull((select count(*)*"+qingJiaFei+" from attendanceinfo"+ 
						" where attendanceinfo.impId=imployeeinfo.impId "+ 
						"and attendanceinfo.attendTime between '"+year1+"-"+month+"-1' and '"+year1+"-"+month1+"-"+date+"'"+  
						" and attendanceinfo.attendState=2 "+
						"group by attendanceinfo.impId),0) \"sHoliday\","+
					"("+
						"imployeeinfo.impSalary+"+
						"ifnull((select count(*)*"+jiaBanFei+" from extrawork "+
							"where extrawork.impId=imployeeinfo.impId "+
							"and extrawork.workTime between '"+year1+"-"+month+"-1' and '"+year1+"-"+month1+"-"+date+"'"+ 
							" group by extrawork.impId),0) "+
						" - "+
						"ifnull((select count(*)*"+queQinFei+" from attendanceinfo "+
							"where attendanceinfo.impId=imployeeinfo.impId "+
							"and attendanceinfo.attendTime between '"+year1+"-"+month+"-1' and '"+year1+"-"+month1+"-"+date+"'"+
							" and attendanceinfo.attendState=0 "+
							"group by attendanceinfo.impId),0) "+
						"- "+
						"ifnull((select count(*)*"+qingJiaFei+" from attendanceinfo "+
							"where attendanceinfo.impId=imployeeinfo.impId "+
							"and attendanceinfo.attendTime between '"+year1+"-"+month+"-1' and '"+year1+"-"+month1+"-"+date+"'"+
							" and attendanceinfo.attendState=2 "+
							"group by attendanceinfo.impId),0) "+
					") \"sTotal\","+
					"0"+
					" from imployeeinfo";
					System.out.println("++++++++++++++++++++++++++++++");
					System.out.println(sql);
						System.out.println("++++++++++++++++++++++++++++++");
				stmt.executeUpdate(sql);
			}
			String departIdStr="";
			if(!departId.equals("0000"))
			{
				departIdStr=" and imployeeinfo.departId='"+departId+"'";
			}
		
			sql="select salaryinfo.impId,imployeeinfo.impName,salaryinfo.syear,"+
				"salaryinfo.smonth,salaryinfo.sBase,salaryinfo.sExtra,"+
				"salaryinfo.sHoliday,salaryinfo.sAbsence,salaryinfo.sTotal,"+
				"salaryinfo.sState from salaryinfo,imployeeinfo "+
				"where salaryinfo.impId=imployeeinfo.impId"+departIdStr;
		
			rs=stmt.executeQuery(sql);
			int num=0;
			if(currenPage!=1)
			{
				rs.absolute((currenPage-1)*pageSpan);
			}
			while(num<pageSpan&&rs.next())
			{
				num++;
				String impId1=rs.getString("impId");
				String impName=new String(rs.getString("impName").getBytes("ISO-8859-1"));
				String opyear=rs.getString("syear");
				String opmonth=rs.getString("smonth");
				double sBase=rs.getDouble("sBase");
				double sExtra=rs.getDouble("sExtra");
				double sHoliday=rs.getDouble("sHoliday");
				double sAbsence=rs.getDouble("sAbsence");
				double sTotal=rs.getDouble("sTotal");
				int sState=rs.getInt("sState");
				SalaryRecord sr=new SalaryRecord(impId1,impName,opyear,opmonth,
						sBase,sExtra,sHoliday,sAbsence,sTotal,sState);
				list.add(sr);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return list;
	}
	public static int getSalaryTotalMessage(String departId,String year,String month)
	{
		int totalMessage=0;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String departIdStr="";
			if(departId!=null&&(!departId.equals("0000")))
			{
				departIdStr=" and imployeeinfo.departId='"+departId+"'";
			}
			String sql="select count(*) from imployeeinfo,salaryinfo "+
					"where imployeeinfo.impId=salaryinfo.impId and salaryinfo.syear='"+year+"' and salaryinfo.smonth='"+month+"'"+
					departIdStr;
		
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				totalMessage=rs.getInt(1);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return totalMessage;
	}
	public static void faFangSalary(String fImpId,String fyear,String fmonth)
	{
		Connection conn=null;
		Statement stmt=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			
			String sql="update salaryinfo set sState=1 where impId='"+fImpId+"'"+
					" and syear='"+fyear+"' and smonth='"+fmonth+"'";
			stmt.executeUpdate(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public static List getApplyList(String departId,int holsState,int currenPage,int pageSpan)
	{
		List list=new ArrayList();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String departIdStr="";
			if(!departId.equals("0000"))
			{
				departIdStr=" and imployeeinfo.departId='"+departId+"'";
			}
			String sql="select holsinfo.impId,holsinfo.applyTime,"+
					"holsinfo.startTime,holsinfo.endTime,holsinfo.executes,"+
					"holsinfo.holsState,imployeeinfo.impName,departmentinfo.departName"+
					" from holsinfo,imployeeinfo,departmentinfo "+
					"where holsinfo.impId=imployeeinfo.impId and "+
					"imployeeinfo.departId=departmentinfo.departId and "+
					"holsinfo.holsState="+holsState+departIdStr;
			
			rs=stmt.executeQuery(sql);
			int num=0;
			if(currenPage!=1)
			{
				rs.absolute((currenPage-1)*pageSpan);
			}
			while(num<pageSpan&&rs.next())
			{
				num++;
				String impId=rs.getString("impId");
				String impName=new String(rs.getString("impName").getBytes("ISO-8859-1"));
				String departName=new String(rs.getString("departName").getBytes("ISO-8859-1"));
				Date applyTime=rs.getDate("applyTime");
				Date startTime=rs.getDate("startTime");
				Date endTime=rs.getDate("endTime");
				String executes1=new String(rs.getString("executes").getBytes("ISO-8859-1"));
				String executes=executes1.length()>4?(executes1.substring(0,4)+"..."):executes1;
				int holsState1=rs.getInt("holsState");
				Holsinfo hol=new Holsinfo(impId,impName,departName,applyTime,startTime,endTime,executes,holsState1);
				list.add(hol);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return list;
	}
	public static int getApplyTotalMessage(String departId,int holsState)
	{
		int totalmessage=0;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String departIdStr="";
			if(!departId.equals("0000"))
			{
				departIdStr=" and imployeeinfo.departId='"+departId+"'";
			}
			String sql="select count(*)"+
					" from holsinfo,imployeeinfo,departmentinfo "+
					"where holsinfo.impId=imployeeinfo.impId and "+
					"imployeeinfo.departId=departmentinfo.departId and "+
					"holsinfo.holsState="+holsState+departIdStr;
			
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				totalmessage=rs.getInt(1);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return totalmessage;
	}
	public static void dualApply(int type,String oImpId,String startTime,String endTime)
	{
		Connection conn=null;
		Statement stmt=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			
			String sql="update holsinfo set holsState="+type+" where impId='"+oImpId+"'"+
					" and startTime='"+startTime+"' and endTime='"+endTime+"'";
			System.out.println(sql);
			int i=stmt.executeUpdate(sql);
			System.out.println(i+"##################################");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static int getPKQRecord(String impId,int stateType,String from_day,String to_day)
	{
		int totalmessage=0;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String typeStr="";
			if(stateType!=-1)
			{
				typeStr=" and attendanceinfo.attendState='"+stateType+"'";
			}
			String sql="select count(*) from attendanceinfo where attendTime "+
					"between '"+from_day+"' and '"+to_day+"' and impId='"+impId+"'"+
					typeStr;
			
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				totalmessage=rs.getInt(1);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return totalmessage;
	}
	
	public static List getPRecordList(String impId,int stateType,String from_day,String to_day,int currenPage,int pageSpan)
	{
		ArrayList list=new ArrayList();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			String attendTypeStr="";
			conn=getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			if(stateType!=-1)
			{
				attendTypeStr=" and attendanceinfo.attendState="+stateType;
			}
			String sql="select imployeeinfo.impId,imployeeinfo.impName,departmentinfo.departName,"+
					"attendanceinfo.attendTime,attendanceinfo.attendState "+
					"from imployeeinfo,attendanceinfo,departmentinfo "+
					"where imployeeinfo.departId=departmentinfo.departId and "+
					"imployeeinfo.impId=attendanceinfo.impId and attendanceinfo.attendTime "+
					"between '"+from_day+"' and '"+to_day+"' and imployeeinfo.impId='"+impId+"'"+
					attendTypeStr;
			rs=stmt.executeQuery(sql);
			if(currenPage>1)
			{
				rs.absolute((currenPage-1)*pageSpan);
			}
			int num=0;
			while(num<pageSpan&&rs.next())
			{
				num++;
				String impId1=rs.getString("impId");
				String impName=new String(rs.getString("impName").getBytes("ISO-8859-1"));
				String departName=new String(rs.getString("departName").getBytes("ISO-8859-1"));
				Date attendTime=rs.getDate("attendTime");
				String date=attendTime.getYear()+1900+"-"+(attendTime.getMonth()+1)+"-"+attendTime.getDate();
				int attendState=rs.getInt("attendState");
				QianDaoRecord qdr=new QianDaoRecord(impId1,impName,departName,date,attendState);
				list.add(qdr);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return list;
	}
	public static int getPSalaryTotal(String impId)
	{
		int totalmessage=0;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String sql="select count(*) from salaryinfo where impId='"+impId+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				totalmessage=rs.getInt(1);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return totalmessage;
	}
	public static List getPSalaryList(String impId,int currenPage,int  pageSpan)
	{
		List list=new ArrayList();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		boolean has=false;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			String sql="select salaryinfo.impId,imployeeinfo.impName,salaryinfo.syear,"+
				"salaryinfo.smonth,salaryinfo.sBase,salaryinfo.sExtra,"+
				"salaryinfo.sHoliday,salaryinfo.sAbsence,salaryinfo.sTotal,"+
				"salaryinfo.sState from salaryinfo,imployeeinfo "+
				"where salaryinfo.impId=imployeeinfo.impId and salaryinfo.impId='"+impId+"'"+
				" order by salaryinfo.syear desc,salaryinfo.smonth desc";
		
			rs=stmt.executeQuery(sql);
			int num=0;
			if(currenPage!=1)
			{
				rs.absolute((currenPage-1)*pageSpan);
			}
			while(num<pageSpan&&rs.next())
			{
				num++;
				String impId1=rs.getString("impId");
				String impName=new String(rs.getString("impName").getBytes("ISO-8859-1"));
				String opyear=rs.getString("syear");
				String opmonth=rs.getString("smonth");
				double sBase=rs.getDouble("sBase");
				double sExtra=rs.getDouble("sExtra");
				double sHoliday=rs.getDouble("sHoliday");
				double sAbsence=rs.getDouble("sAbsence");
				double sTotal=rs.getDouble("sTotal");
				int sState=rs.getInt("sState");
				SalaryRecord sr=new SalaryRecord(impId1,impName,opyear,opmonth,
						sBase,sExtra,sHoliday,sAbsence,sTotal,sState);
				list.add(sr);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return list;
	}
	public static int newApply(String startTime,String endTime,String execute,String impId)
	{
		Connection conn=null;
		Statement stmt=null;
		try
		{
			conn=getConnection();
			String sql="insert into holsinfo values('"+impId+"',now(),'"+startTime+"','"+
						endTime+"',to_days('"+endTime+"')-to_days('"+startTime+"')+1,'"+execute+"',0)";
			System.out.println(sql);
			stmt=conn.createStatement();
			int i=stmt.executeUpdate(sql);
			if(i==1)
			{
				return 1;
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return 0;
	}
	public static int getPApplyTotal(String impId)
	{
		int totalmessage=0;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement();
			String sql="select count(*) from holsinfo where impId='"+impId+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				totalmessage=rs.getInt(1);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return totalmessage;
	}
	public static List getPApplyList(String impId,int currenPage,int pageSpan)
	{
		List list=new ArrayList();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			conn=getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql="select holsinfo.impId,holsinfo.applyTime,"+
					"holsinfo.startTime,holsinfo.endTime,holsinfo.executes,"+
					"holsinfo.holsState,imployeeinfo.impName,departmentinfo.departName"+
					" from holsinfo,imployeeinfo,departmentinfo "+
					"where holsinfo.impId=imployeeinfo.impId and "+
					"imployeeinfo.departId=departmentinfo.departId and "+
					"holsinfo.impId='"+impId+"'";
			
			rs=stmt.executeQuery(sql);
			int num=0;
			if(currenPage!=1)
			{
				rs.absolute((currenPage-1)*pageSpan);
			}
			while(num<pageSpan&&rs.next())
			{
				num++;
				String impId1=rs.getString("impId");
				String impName=new String(rs.getString("impName").getBytes("ISO-8859-1"));
				String departName=new String(rs.getString("departName").getBytes("ISO-8859-1"));
				Date applyTime=rs.getDate("applyTime");
				Date startTime=rs.getDate("startTime");
				Date endTime=rs.getDate("endTime");
				String executes1=new String(rs.getString("executes").getBytes("ISO-8859-1"));
				String executes=executes1.length()>4?(executes1.substring(0,4)+"..."):executes1;
				int holsState1=rs.getInt("holsState");
				Holsinfo hol=new Holsinfo(impId1,impName,departName,applyTime,startTime,endTime,executes,holsState1);
				list.add(hol);
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
				if(rs!=null){rs.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return list;
	}
	public static int changePwd(String impId,String oldpwd,String newpwd)
	{
		Connection conn=null;
		Statement stmt=null;
		try
		{
			conn=getConnection();
			String sql="update userinfo set pwd='"+newpwd+"' where impId='"+impId+"' "+
						"and pwd='"+oldpwd+"'";
			stmt=conn.createStatement();
			int i=stmt.executeUpdate(sql);
			if(i==1)
			{
				return 1;
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
				if(conn!=null){conn.close();}
				if(stmt!=null){stmt.close();}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return 0;
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