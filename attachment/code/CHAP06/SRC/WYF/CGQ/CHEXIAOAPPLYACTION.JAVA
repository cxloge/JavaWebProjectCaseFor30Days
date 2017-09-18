package wyf.cgq;
public class CheXiaoApplyAction extends AppSearchAction
{
	private int type;
	private String oImpId;
	private String endTime;
	private String startTime;
	public void setType(int type)
	{
		this.type=type;
	}
	public void setOImpId(String oImpId)
	{
		this.oImpId=oImpId;
	}
	public void setStartTime(String startTime)
	{
		this.startTime=startTime;
	}
	public void setEndTime(String endTime)
	{
		this.endTime=endTime;
	}
	public String execute()
	{
		ManageDB.dualApply(type,oImpId,startTime,endTime);
		super.execute();
		return "success";
	}
}