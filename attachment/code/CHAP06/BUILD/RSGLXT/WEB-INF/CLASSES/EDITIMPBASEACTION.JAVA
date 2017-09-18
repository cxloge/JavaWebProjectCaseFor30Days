package wyf.cgq;
import com.opensymphony.xwork2.*;
import java.util.*;
public class EditImpBaseAction extends ActionSupport
{
	private String editImpId;
	private String impId;
	private String impName;
	private String impGender="男";
	private Date impBirth=new Date();
	private String impEmail;
	private String departId;
	private String impRoll;
	private double impSalary;
	private String impTel;
	private String impBio;
	private String result;
	public void setResult(String result)
	{
		this.result=result;
	}
	public String getResult()
	{
		String result=this.result;
		this.result="";
		return result;
	}
	public String getImpId()
	{
		return this.impId;
	}
	public String getImpName()
	{
		return this.impName;
	}

	public String getImpGender()
	{
		return this.impGender;
	}

	public Date getImpBirth()
	{
		return this.impBirth;
	}
	public String getImpEmail()
	{
		return this.impEmail;
	}
	public String getDepartId()
	{
		return this.departId;
	}
	

	public String getImpRoll()
	{
		return this.impRoll;
	}
	public double getImpSalary()
	{
		return this.impSalary;
	}
	
	public String getImpTel()
	{
		return this.impTel;
	}
	public String getImpBio()
	{
		return this.impBio;
	}
	public void setDepartId(String departId)
	{
		this.departId=departId;
	}
	public void setImpSalary(double impSalary)
	{
		this.impSalary=impSalary;
	}
	public void setImpTel(String impTel)
	{
		this.impTel=impTel;
	}
	public void setImpId(String impId)
	{
		System.out.println("public void setImpId(String impId)");
		this.impId=impId;
	}
	public void setImpName(String impName)
	{
		this.impName=impName;
	}
	public void setImpGender(String impGender)
	{
		this.impGender=impGender;
	}
	public void setImpBirth(Date impBirth)
	{
		this.impBirth=impBirth;
	}

	public void setImpRoll(String impRoll)
	{
		this.impRoll=impRoll;
	}
	public void setImpBio(String impBio)
	{
		this.impBio=impBio;
	}
	public void setImpEmail(String impEmail)
	{
		this.impEmail=impEmail;
	}
	public void setEditImpId(String editImpId)
	{
		this.editImpId=editImpId;
		ActionContext.getContext().getSession().put("editImpId",editImpId);
	}
	public String getEditImpId()
	{
		Object obj=ActionContext.getContext().getSession().get("editImpId");
		if(obj!=null)
		{
			this.editImpId=(String)obj;
		}
		return this.editImpId;
	}
	public Map getDepartList()
	{
		Map departlist=ManageDB.getDepartList();
		return departlist;
	}
	public Map getGenderList()
	{
		Map map=new HashMap();
		map.put("男","男性");
		map.put("女","女性");
		return map;
	}
	public String execute()
	{
		Impleey imp=ManageDB.getImpById(this.getEditImpId());
		this.impId=imp.getImpId();
		this.impName=imp.getImpName();
		this.departId=imp.getDepartId();
		this.impGender=imp.getImpGender();
		this.impBirth=imp.getImpBirth();
		this.impEmail=imp.getImpEmail();
		this.impBio=imp.getImpBio();
		this.impRoll=imp.getImpRoll();
		this.impSalary=imp.getImpSalary();
		this.impTel=imp.getImpTel();
		return "success";
	}
}