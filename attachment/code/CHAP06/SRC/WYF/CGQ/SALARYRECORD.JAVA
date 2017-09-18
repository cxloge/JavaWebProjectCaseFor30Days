package wyf.cgq;
public class SalaryRecord
{
	private String impId;
	private String impName;
	private String opyear;
	private String opmonth;
	private double sBase;
	private double sExtra;
	private double sHoliday;
	private double sAbsence;
	private double sTotal;
	private int sState;
	public SalaryRecord()
	{
	}
	public SalaryRecord(String impId,String impName,String opyear,String opmonth,
						double sBase,double sExtra,double sHoliday,double sAbsence,
						double sTotal,int sState)
	{
		this.impId=impId;
		this.impName=impName;
		this.opyear=opyear;
		this.opmonth=opmonth;
		this.sBase=sBase;
		this.sExtra=sExtra;
		this.sHoliday=sHoliday;
		this.sAbsence=sAbsence;
		this.sTotal=sTotal;
		this.sState=sState;
	}
	public double getSBase()
	{
		return this.sBase;
	}
	public String getImpId()
	{
		return this.impId;
	}
	public String getImpName()
	{
		return this.impName;
	}
	public String getOpyear()
	{
		return this.opyear;
	}
	public String getOpmonth()
	{
		return this.opmonth;
	}
	public double getSExtra()
	{
		return this.sExtra;
	}
	public double getSHoliday()
	{
		return this.sHoliday;
	}
	public double getSAbsence()
	{
		return this.sAbsence;
	}
	public double getSTotal()
	{
		return this.sTotal;
	}
	public int getSState()
	{
		return this.sState;
	}
}