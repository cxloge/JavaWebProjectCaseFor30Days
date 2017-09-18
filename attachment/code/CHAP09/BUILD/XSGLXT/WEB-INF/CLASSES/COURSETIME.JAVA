package wyf.cgq;
public class CourseTime
{
	private String[] courseinfo=new String[8];
	public void CourseTime(){}
	public void addCourse(int i,String name)
	{
		this.courseinfo[i]=name;
	}
	public String getZero()
	{
		return courseinfo[0];
	}
	public void setZero(String zero)
	{
		courseinfo[0]=zero;
	}
	public String getOne()
	{
		return courseinfo[1];
	}
	public void setOne(String one)
	{
		courseinfo[1]=one;
	}
	public String getTwo()
	{
		return courseinfo[2];
	}
	public void setTwo(String two)
	{
		courseinfo[2]=two;
	}
	public String getThree()
	{
		return courseinfo[3];
	}
	public void setThree(String three)
	{
		courseinfo[3]=three;
	}
	public String getFour()
	{
		return courseinfo[4];
	}
	public void setFour(String four)
	{
		courseinfo[4]=four;
	}
	public String getFive()
	{
		return courseinfo[5];
	}
	public void setFive(String five)
	{
		courseinfo[5]=five;
	}
	public String getSix()
	{
		return courseinfo[6];
	}
	public void setSix(String six)
	{
		courseinfo[6]=six;
	}
	public String getSeven()
	{
		return courseinfo[7];
	}
	public void setSeven(String seven)
	{
		courseinfo[7]=seven;
	}


	
}