package wyf.cgq;
public class DelDepartEWAction extends DepartEWAction
{
	private String delImpId;
	private String workTime;
	public void setDelImpId(String delImpId)
	{
		this.delImpId=delImpId;
	}
	public void setWorkTime(String workTime)
	{
		this.workTime=workTime;
		System.out.println(workTime);
	}
	public String execute()
	{
		ManageDB.delExtraWork(delImpId,workTime);
		return "success";
	}
}