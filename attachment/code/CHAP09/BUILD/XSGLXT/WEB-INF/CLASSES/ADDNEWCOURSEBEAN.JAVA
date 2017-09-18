package wyf.cgq;
import java.util.*;
import javax.faces.model.SelectItem;
public class AddNewCourseBean
{
	private LoginBean lb;
	private String result="";
	private String cno="111";
	private String cname;
	private double xuefen;
	private String deptno;
	private String colno;
	public void setLb(LoginBean lb)
	{
		this.lb=lb;
	}
	public void setCno(String cno)
	{
		this.cno=cno;
	}
	public String getCno()
	{
		return this.cno;
	}
	public void setCname(String cname)
	{
		this.cname=cname;
	}
	public String getCname()
	{
		return this.cname;
	}
	public void setXuefen(double xuefen)
	{
		this.xuefen=xuefen;
	}
	public double getXuefen()
	{
		return this.xuefen;
	}
	public void setDeptno(String deptno)
	{
		this.deptno=deptno;
	}
	public String getDeptno()
	{
		return this.deptno;
	}
	public List getDeptList()
	{
		ArrayList list=TeacherDB.getDeptListByCollid(lb.getId());
		if(this.deptno==null)
		{
			this.deptno=(String)(((SelectItem)list.get(0)).getValue());
		}
		return list;
	}
	public String getResult()
	{
		String result1=this.result;
		this.result="";
		return result1;
	}
	public void setResult(String result)
	{
		this.result="";
	}
	public String addCou()
	{
		System.out.println(this.cname+"===="+this.cno+"==="+this.xuefen+"==="+this.deptno);
		result=TeacherDB.addCou(this.cno,this.cname,this.xuefen,lb.getId(),this.deptno);
		return "success";
	}
}