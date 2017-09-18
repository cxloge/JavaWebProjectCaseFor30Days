package wyf.cgq;
public class QingJiaDetailAction
{
	private String impId;
	private String date;
	private Holsinfo holsinfo;
	public void setImpId(String impId)
	{
		this.impId=impId;
	}
	public void setDate(String date)
	{
		this.date=date;
	}
	public Holsinfo getHolsinfo()
	{
		this.holsinfo=ManageDB.getHolsinfo(impId,date);
		System.out.println(this.holsinfo.getImpId()+"---------------------");
		return this.holsinfo;
	}
	public String execute()
	{
		return "success";
	}
}