package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import org.apache.struts2.*;
import com.opensymphony.xwork2.validator.annotations.*;
public class AddImpleeyBaseAction extends ActionSupport
{
	public String impId;
	public String impName;
	public String impGender="男";
	public Date impBirth=new Date();
	public String impEmail;
	public String departId;
	public String impRoll;
	public double impSalary;
	public String impTel;
	public String impBio;
	
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

	public String getDepartId()
	{
		return this.departId;
	}
	
	public void setDepartId(String departId)
	{
		this.departId=departId;
	}
	public Map getDepartList()
	{
		Map departlist=ManageDB.getDepartList();
		return departlist;
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

	public String getImpEmail()
	{
		return this.impEmail;
	}

	
	public String getImpBio()
	{
		return this.impBio;
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
		return SUCCESS;
	}
}