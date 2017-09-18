package wyf.cgq;
public class GradeItem
{
	private String courseNo;
	private String courseName;
	private String stuNo;
	private String stuName;
	private double xuefen;
	private double score;
	public GradeItem()
	{
	}
	public GradeItem(String courseNo,String courseName,String stuNo,String stuName,double xuefen,double score)
	{
		this.courseNo=courseNo;
		this.courseName=courseName;
		this.stuNo=stuNo;
		this.stuName=stuName;
		this.xuefen=xuefen;
		this.score=score;
	}
	public String getCourseNo()
	{
		return this.courseNo;
	}
	public void setCourseNo(String courseNo)
	{
		this.courseNo=courseNo;
	}
	
	public String getCourseName()
	{
		return this.courseName;
	}
	public void setCourseName(String courseName)
	{
		this.courseName=courseName;
	}
	public String getStuNo()
	{
		return this.stuNo;
	}
	public void setStuNo(String stuNo)
	{
		this.stuNo=stuNo;
	}
	
	public String getStuName()
	{
		return this.stuName;
	}
	public void setStuName(String stuName)
	{
		this.stuName=stuName;
	}
	public double getXuefen()
	{
		return this.xuefen;
	}
	public void setXuefen(double xuefen)
	{
		this.xuefen=xuefen;
	}
	public double getScore()
	{
		return this.score;
	}
	public void setScore(double score){this.score=score;/*TeacherDB.saveScore(this.courseNo,this.stuNo,score);*/}
}