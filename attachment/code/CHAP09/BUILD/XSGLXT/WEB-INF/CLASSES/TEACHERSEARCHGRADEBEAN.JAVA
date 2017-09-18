package wyf.cgq;
import java.util.*;
public class TeacherSearchGradeBean
{
	private String sno;
	private String result;
	private boolean cansee;
	private ArrayList al;
	private int size;
	
	public void setSno(String sno)
	{
		this.sno=sno;
	}
	public String getSno()
	{
		return this.sno;
	}
	public String getResult()
	{
		System.out.println("huo de result;");
		String result1=result;
		result="";
		System.out.println("");
		return result1;
	}
	public void setResult(String result)
	{
		this.result="";
	}
	public boolean getCansee()
	{
		return this.cansee;
	}
	public List getGradeList()
	{
		return al;
	}
	public int getSize()
	{
		return this.size;
	}
	public String search(){//处理查询成绩的方法
		al=TeacherDB.getGradeList(sno);//调用TeacherDB的业务方法进行查询
		if(al!=null){
			result="";cansee=true;this.size=al.size();
			if(size==0){result="没有该学号的学生的相关成绩信息";
			}
		}//如果有记录，将cansee设为true
		else{result="没有该学号的学生的相关成绩信息";cansee=false;}//如果没有记录，将cansee设为false
		return "success";//返回导航字符串
	}
}