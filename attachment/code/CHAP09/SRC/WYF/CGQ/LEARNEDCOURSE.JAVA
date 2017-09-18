package wyf.cgq;
public class LearnedCourse
{
	private String courseNo;
	private String courseName;
	private double xuefen;
	private double score;
	public LearnedCourse()
	{
	}
	public LearnedCourse(String courseNo,String courseName,double xuefen,double score)
	{
		this.courseNo=courseNo;
		this.courseName=courseName;
		this.xuefen=xuefen;
		this.score=score;
	}
	public void setCourseNo(String courseNo)
	{
		this.courseNo=courseNo;
	}
	public String getCourseNo()
	{
		return this.courseNo;
	}
	public String getCourseName()
	{
		return this.courseName;
	}
	public double getXuefen()
	{
		return this.xuefen;
	}
	public double getScore()
	{
		return this.score;
	}
}