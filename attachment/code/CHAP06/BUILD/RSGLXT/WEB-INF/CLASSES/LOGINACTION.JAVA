package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
@Validation()
public class LoginAction extends ActionSupport
{
	private String uid="20050318";
	private String pwd="20050318";
	private String yanzhengma;
	private String result="";
	
	@RequiredStringValidator(message="${getText(\"validate.uidempty\")}")
	public void setUid(String uid)
	{
		this.uid=uid;
	}
	public String getUid()
	{
		return this.uid;
	}
	@RequiredStringValidator(message="${getText(\"validate.pwdempty\")}")
	public void setPwd(String pwd)
	{
		this.pwd=pwd;
	}
	public String getPwd()
	{
		return this.pwd;
	}
	public void setYanzhengma(String yanzhengma)
	{
		this.yanzhengma=yanzhengma;
	}
	public String getYanzhengma()
	{
		return this.yanzhengma;
	}
	public String getResult()
	{
		String temp=result;
		this.result="";
		return temp;
	}
	public String execute()
	{
		String yanzhengma=(String)ActionContext.getContext().getSession().get("yanzhengma");
		if(yanzhengma!=null)
		{
			if(!yanzhengma.equals(this.yanzhengma.toLowerCase()))
			{
				this.result=this.getText("login.yanzhengmaerror");
				return SUCCESS;
			}
			else
			{
				String[] impinfo=LoginDB.login(uid,pwd);
				if(Integer.parseInt(impinfo[0])==1)
				{
					Map session=ActionContext.getContext().getSession();
					session.put("right","manage");
					session.put("user",impinfo[1]);
					return "manage";
				}
				else if(Integer.parseInt(impinfo[0])==2)
				{
					Map session=ActionContext.getContext().getSession();
					session.put("right","personal");
					session.put("user",impinfo[1]);
					return "personal";
				}
				else
				{
					result=this.getText("login.wronguid");
				}
			}
		}
		return SUCCESS;
	}
}