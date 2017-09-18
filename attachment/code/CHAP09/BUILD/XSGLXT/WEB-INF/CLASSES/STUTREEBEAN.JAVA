package wyf.cgq;
public class StuTreeBean
{
	private LoginBean lb;
	private boolean com=true;
	private boolean root1=true;
	private boolean root11=true;
	private boolean root21=true;
	private boolean root31=true;
	public void setLb(LoginBean lb)
	{
		this.lb=lb;
	}
	public String clickCom()
	{
		root1=!root1;
		return "success";
	}
	public String clickRoot11()
	{
		root11=!root11;
		return "success";
	}
	public String clickRoot21()
	{
		root21=!root21;
		return "success";
	}
	public String clickRoot31()
	{
		root31=!root31;
		return "success";
	}
	public void setRoot1(boolean root1)
	{
		this.root1=root1;
	}
	public boolean getRoot1()
	{
		return this.root1;
	}
	public void setRoot11(boolean root11)
	{
		this.root11=root11;
	}
	public boolean getRoot11()
	{
		return this.root11;
	}
	public void setRoot21(boolean root21)
	{
		this.root21=root21;
	}
	public boolean getRoot21()
	{
		return this.root21;
	}
	public void setRoot31(boolean root31)
	{
		this.root31=root31;
	}
	public boolean getRoot31()
	{
		return this.root31;
	}
	public String reLogin()
	{
		lb.setId(null);
		lb.setUid(null);
		return "login";
	}
}