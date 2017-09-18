package wyf.cgq;
import com.opensymphony.xwork2.*;
public class ZhuXiaoAction
{
	
	public String execute()
	{
		ActionContext.getContext().getSession().put("right","no");
		return "success";
	}
}