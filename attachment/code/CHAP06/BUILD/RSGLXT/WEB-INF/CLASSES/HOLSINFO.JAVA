package wyf.cgq;
import java.util.*;
public class Holsinfo
{
	private String impId;
	private String impName;
	private Date applyTime;
	private Date startTime;
	private Date endTime;
	private int holdays;
	private String executes;
	private int holsState;
	private String departName;
	public Holsinfo()
	{	
	}
	
	public Holsinfo(String impId,String impName,Date applyTime,
					Date startTime,Date endTime,int holdays,
					String executes,int holsState)
	{
		this.impId=impId;
		this.impName=impName;
		this.applyTime=applyTime;
		this.startTime=startTime;
		this.endTime=endTime;
		this.holdays=holdays;
		this.executes=executes;
		this.holsState=holsState;
	}
	public Holsinfo(String impId,String impName,String departName,Date applyTime,Date startTime,Date endTime,String executes,int holsState)
	{
		this(impId,impName,applyTime,startTime,endTime,0,executes,holsState);
		this.departName=departName;
	}
	public String getDepartName()
	{
		return this.departName;
	}
	public String getImpId()
	{
		return this.impId;
	}
	public String getImpName()
	{
		return this.impName;
	}
	public Date getApplyTime()
	{
		return this.applyTime;
	}
	public Date getStartTime()
	{
		return this.startTime;
	}
	public Date getEndTime()
	{
		return this.endTime;
	}
	public int getHoldays()
	{
		return this.holdays;
	}
	public String getExecutes()
	{
		return this.executes;
	}
	public int getHolsState()
	{
		return this.holsState;
	}
}