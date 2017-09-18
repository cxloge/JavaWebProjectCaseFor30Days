package wyf.cgq;
import java.util.*;
public class LearnedCourseBean
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
		this.getLearnedCourse();
		return size;
	}
	public ArrayList getLearnedCourse()
	{
		ArrayList al=StudentDB.getLearnedCourseList(lb.getId());
		size=al.size();
		return al;
	}
}