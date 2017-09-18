package wyf.cgq;
import java.util.*;
public class ExtraWork
{
	private String impId;
	private String impName;
	private String departName;
	private Date workTime;
	private String executes;
	public ExtraWork()
	{
	}
	public ExtraWork(String impId,String impName,String departName,Date workTime,String executes)
	{
		this.impId=impId;
		this.impName=impName;
		this.departName=departName;
		this.workTime=workTime;
		this.executes=executes;
	}
	public String getImpId()
	{
		return this.impId;
	}
	public String getImpName()
	{
		return this.impName;
	}
	public String getDepartName()
	{
		return this.departName;
	}
	public Date getWorkTime()
	{
		return this.workTime;
	}
	public String getExecutes()
	{
		return this.executes;
	}
}