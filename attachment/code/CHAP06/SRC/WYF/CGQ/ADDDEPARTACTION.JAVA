package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
public class AddDepartAction extends ActionSupport
{
	private String departId;
	private String departName;
	private String departDescrip;
	private String result;
	private boolean read=true;
	
	public String getDepartId()
	{
		return this.departId;
	}
	@RequiredStringValidator(message="${getText(\"validate.departIdEM\")}",shortCircuit=true)
    @RegexFieldValidator(message="${getText(\"validate.departIdE\")}",
                        expression="[\\d]{3,4}",shortCircuit=true)
	public void setDepartId(String departId)
	{
		System.out.println(departId);
		this.departId=departId;
	}
	public boolean getRead()
	{
		return this.read;
	}
	public String getResult()
	{
		return this.result;
	}
	@RequiredStringValidator(message="${getText(\"validate.departNameEM\")}",shortCircuit=true)
	public void setDepartName(String departName)
	{
		this.departName=departName;
	}
	public String getDepartName()
	{
		return this.departName;
	}
	@RequiredStringValidator(message="${getText(\"validate.departDescripEM\")}",shortCircuit=true)
	public void setDepartDescrip(String departDescrip)
	{
		this.departDescrip=departDescrip;	
	}
	public String getDepartDescrip()
	{
		return this.departDescrip;
	}
	public String execute()
	{
		Department d=ManageDB.getDepartById(departId);
		this.read=false;
		if(d==null)
		{
			int i=ManageDB.addDepart(departId,departName,departDescrip);
			if(i==1)
			{
				this.result="添加成功";
			}
			else
			{
				this.result="添加失败";
			}
		}
		else 
		{
			this.result="已经存在该编号的部门";
		}
		return "success";
	}
}