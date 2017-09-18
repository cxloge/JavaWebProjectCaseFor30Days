package wyf.cgq;
import com.opensymphony.xwork2.*;
public class PersonInfoAction
{
	private Impleey imp;
	public Impleey getImp()
	{
		return this.imp;
	}
	public String execute()
	{
		Object impId=ActionContext.getContext().getSession().get("user");
		if(impId!=null)
		{
			String impId1=(String)impId;
			imp=ManageDB.getImpDetail(impId1);
		}
		return "success";
	}
}