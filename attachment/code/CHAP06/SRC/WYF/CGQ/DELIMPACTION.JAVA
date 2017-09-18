package wyf.cgq;
public class DelImpAction extends SearchImpAction
{
	private String delImpId;
	public void setDelImpId(String delImpId)
	{
		this.delImpId=delImpId;
	}
	public String execute()
	{
		ManageDB.delImp(delImpId);
		return "success";
	}
}