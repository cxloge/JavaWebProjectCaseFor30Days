package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
public class DelDepartAction extends DepartmentListBaseAction
{
	private String departId;
	public void setDepartId(String departId)
	{
		this.departId=departId;
	}
	public String execute()
	{
		
		int impnum=ManageDB.getImpNumByDepartId(departId);
		if(impnum!=0)
		{
			this.setRead(false);
			this.setResult("员工尚未处理，不能删除部门");
			return "success";
		}
		ManageDB.delDepart(departId);
		return "success";
	}
}