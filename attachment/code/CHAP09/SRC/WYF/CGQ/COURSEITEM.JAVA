package wyf.cgq;
public class CourseItem
{
	private String courseNo;
	private String courseName;
	private double xuefen;
	private String collName;
	private String deptName;
	public CourseItem(String courseNo,String courseName,double xuefen,String collName,String deptName)
	{
		this.courseNo=courseNo;
		this.courseName=courseName;
		this.xuefen=xuefen;
		this.collName=collName;
		this.deptName=deptName;
	}
	public CourseItem()
	{	
	}
	public void setCourseNo(String courseNo)
	{
		this.courseNo=courseNo;
	}
	public String getCourseNo()
	{
		return this.courseNo;
	}
	public void setCourseName(String courseName)
	{
		this.courseName=courseName;
	}
	public String getCourseName()
	{
		return this.courseName;
	}
	public double getXuefen()
	{
		return this.xuefen;
	}
	public String getCollName()
	{
		return this.collName;
	}
	public String getDeptName()
	{
		return this.deptName;
	}
}