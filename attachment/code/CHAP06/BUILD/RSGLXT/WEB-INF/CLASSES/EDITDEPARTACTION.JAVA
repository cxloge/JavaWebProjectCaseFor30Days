package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
public class EditDepartAction
{
	private String departId;
	private String departName;
	private String departNum;
	private String departDescrip;
	private Department department;
	private String result;
	private boolean read=true;
	public boolean getRead()
	{
		boolean b=read;
		read=!read;
		return b;
	}
	public void setRead(boolean read)
	{
		this.read=read;
	}
	public String getResult()
	{
		return result;
	}
	public void setResult(String result)
	{
		this.result=result;
	}
	public void setDepartId(String departId)
	{
		this.departId=departId;
		ActionContext.getContext().getSession().put("departId",departId);
	}
	public String getDepartId()
	{
		Object obj=ActionContext.getContext().getSession().get("departId");
		if(obj!=null)
		{
			this.departId=(String)obj;
		}
		return this.departId;
	}
	public String getDepartName()
	{
		return this.getDepartment().getDepartName();
	}
	public void setDepartName(String departName)
	{
		this.departName=departName;
		ActionContext.getContext().getSession().put("departName",departName);
	}
	public void setDepartDescrip(String departDescrip)
	{
		this.departDescrip=departDescrip;
		ActionContext.getContext().getSession().put("departDescrip",this.departDescrip);
	}
	public String getDepartDescrip()
	{
		return this.getDepartment().getDepartDescrip();
	}
	public int getDepartNum()
	{
		return this.getDepartment().getDepartNum();
	}
	public Department getDepartment()
	{
		String departId=this.getDepartId();
		if(departId!=null)
		{
			this.department=ManageDB.getDepartById(departId);
		}
		return this.department;
		
	}
	
	public String execute()
	{
		return "success";
	}
	
}