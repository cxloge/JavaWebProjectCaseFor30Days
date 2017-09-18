package wyf.cgq;
public class FaFangSalaryAction extends SalaryTableAction
{
	private String fImpId;
	private String fyear;
	private String fmonth;
	public void setFImpId(String fImpId)
	{
		this.fImpId=fImpId;
	}
	public void setFyear(String fyear)
	{
		this.fyear=fyear;
	}
	public void setFmonth(String fmonth)
	{
		this.fmonth=fmonth;
	}
	public String execute()
	{
		ManageDB.faFangSalary(fImpId,fyear,fmonth);
		super.execute();
		return "success";
	}
}