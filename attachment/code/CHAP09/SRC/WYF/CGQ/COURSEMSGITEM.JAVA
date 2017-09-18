package wyf.cgq;
public class CourseMsgItem
{
	private String courNo;
	private String courName;
	private int day;
	private int times;
	private String teacher;
	private String state;
	private double xuefen;
	public CourseMsgItem()
	{
	}
	public CourseMsgItem(String courNo,String courName,int day,int times,
	                     String teacher,String state,double xuefen)
	{
		this.courNo=courNo;
		this.courName=courName;
		this.day=day;
		this.times=times;
		this.teacher=teacher;
		this.state=state;
		this.xuefen=xuefen;
	}	                   
	public void setCourNo(String courNo)
	{
		this.courNo=courNo;
	}
	public String getCourNo()
	{
		return this.courNo;
	}
	public void setCourName(String courName)
	{
		this.courName=courName;
	}
	public String getCourName()
	{
		return this.courName;
	}
	public void setDay(int day)
	{
		this.day=day;
	}
	public int getDay()
	{
		return this.day;
	}
	public void setTimes(int times)
	{
		this.times=times;
	}
	public int getTimes()
	{
		return this.times;
	}
	public void setTeacher(String teacher)
	{
		this.teacher=teacher;
	}
	public String getTeacher()
	{
		return this.teacher;
	}
	public void setState(String state)
	{
		this.state=state;
	}
	public boolean getState()
	{
		return this.state.equals("0");
	}
	public void setXuefen(double xuefen)
	{
		this.xuefen=xuefen;
	}
	public double getXuefen()
	{
		return this.xuefen;
	}
}

