package wyf.cgq;
public class Grade
{
	private String courseName;
	private double score;
	private double xuefen;
	public Grade()
	{
	}
	public Grade(String courseName,double score,double xuefen)
	{
		this.courseName=courseName;
		this.score=score;
		this.xuefen=xuefen;
	}
	public void setCourseName(String courseName)
	{
		this.courseName=courseName;
	}
	public String getCourseName()
	{
		return this.courseName;
	}
	public void setScore(double score)
	{
		this.score=score;
	}
	public double getScore()
	{
		return this.score;
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