package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
public class EditDepartSaveAction extends EditDepartAction
{
	public void setDepartName(String departName)
	{
		super.setDepartName(departName);
	}
	public void setDepartDescrip(String departDescrip)
	{
		super.setDepartDescrip(departDescrip);
	}
	public String execute()
	{
		String departId=this.getDepartId();
		String departDescrip=(String)(ActionContext.getContext().getSession().get("departDescrip"));
		String departName=(String)(ActionContext.getContext().getSession().get("departName"));
		System.out.println("#############"+departId+"##"+departName+"##"+departDescrip);
		int i=ManageDB.updateDepartment(departId,departName,departDescrip);
		if(i==1)
		{
			this.setResult("修改成功");
		}
		else
		{
			 this.setResult("修改失败");
		}
		this.setRead(false);
		return "success";
	}
}