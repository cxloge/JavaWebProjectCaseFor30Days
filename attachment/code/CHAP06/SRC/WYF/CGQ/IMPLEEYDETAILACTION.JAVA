package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
public class ImpleeyDetailAction implements Action
{
	private String impId;
	private Impleey imp;
	public String getImpId()
	{
		return this.impId;
	}
	public void setImpId(String impId)
	{
		this.impId=impId;
		ActionContext.getContext().getSession().put("impId",impId);
	}
	public Impleey getImp()
	{
		return this.imp;
	}
	public String execute()
	{
		Object impId=ActionContext.getContext().getSession().get("impId");
		if(impId!=null)
		{
			this.impId=(String)impId;
			this.imp=ManageDB.getImpDetail(this.impId);
		}
		return SUCCESS;
		
	}
}