package wyf.cgq;
import java.util.*;
public class QianDaoRecord
{
	private String impId;
	private String impName;
	private String departName;
	private String date;
	private int state;
	public QianDaoRecord()
	{
	}
	public QianDaoRecord(String impId,String impName,String departName,String date,int state)
	{
		this.impId=impId;
		this.impName=impName;
		this.departName=departName;
		this.date=date;
		this.state=state;
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
	public String getDate()
	{
		return this.date;
	}
	public int getState()
	{
		return this.state;
	}
}