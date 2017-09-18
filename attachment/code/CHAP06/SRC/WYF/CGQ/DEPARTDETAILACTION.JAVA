package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
public class DepartDetailAction
{
	private String departId;
	private Department department;
	public String getDepartId()
	{
		Object obj=ActionContext.getContext().getSession().get("departId");
		if(obj!=null)
		{
			this.departId=(String)obj;
		}
		return this.departId;
	}
	public void setDepartId(String departId)
	{
		this.departId=departId;
		ActionContext.getContext().getSession().put("departId",departId);
	}
	public Department getDepartment()
	{
		this.department=ManageDB.getDepartById(this.getDepartId());
		return this.department;
	}
	public String execute()
	{
		return "success";
	}
}