package wyf.cgq;
public class ExtraWorkDetailAction
{
	private String impId;
	private String workTime;
	private ExtraWork extraWork;
	public ExtraWork getExtraWork()
	{
		return this.extraWork;
	}
	public void setImpId(String impId)
	{
		this.impId=impId;
	}
	public void setWorkTime(String workTime)
	{
		this.workTime=workTime;
	}
	public String execute()
	{
		this.extraWork=ManageDB.getExtraWorkDetail(impId,workTime);
		return "success";
	}
}