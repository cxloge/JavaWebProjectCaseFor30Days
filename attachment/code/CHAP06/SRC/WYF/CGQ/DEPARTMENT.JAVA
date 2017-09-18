package wyf.cgq;
public class Department
{
	private String departId;
	private String departName;
	private int departNum;
	private String departDescrip;
	public Department()
	{
	}
	public Department(String departId,String departName,int departNum,String departDescrip)
	{
		this.departId=departId;
		this.departName=departName;
		this.departNum=departNum;
		this.departDescrip=departDescrip;
	}
	public String getDepartId()
	{
		return this.departId;
	}
	public String getDepartName()
	{System.out.println("getDepartName()"+this.departName);
		return this.departName;
	}
	
	public void setDepartName(String departName)
	{
		
		this.departName=departName;
		System.out.println("++++++++++++++"+this.departName);
	}
	public int getDepartNum()
	{
		return departNum;
	}
	public String getDepartDescrip()
	{
		System.out.println("getDepartDescrip()"+this.departDescrip);
		return this.departDescrip;
	}
	public void setDepartDescrip(String departDescrip)
	{
		this.departDescrip=departDescrip;
		System.out.println("departDescrip"+"+++++++"+this.departDescrip);
	}
}