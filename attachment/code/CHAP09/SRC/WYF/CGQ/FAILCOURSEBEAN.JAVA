package wyf.cgq;
import java.util.*;
public class FailCourseBean
{
	private LoginBean lb;
	private int size;
	public void setLb(LoginBean lb)
	{
		this.lb=lb;
	}
	public LoginBean getLb()
	{
		return this.lb;
	}
	public int getSize()
	{
		this.getFailCourse();
		return size;
	}
	public ArrayList getFailCourse()
	{
		ArrayList al=StudentDB.getFailCourseList(lb.getId());
		this.size=al.size();
		return al;
	}
}