package wyf.cgq;
public class TeacherChangePwdBean
{
	private LoginBean lb;//LoginBean的引用
	private String pwd;// 用于存放用户修改前的真实密码
	private String oldpwd;//用户输入的原始密码
	private String newpwd;//用户输入的旧密码
	private String renewpwd;//用户第二次输入的旧密码
	private String different;//用于存放新密码两次输入不同时的信息
	private String result;//用于存放修改结果
	public void setLb(LoginBean lb){this.lb=lb;}//lb的setter方法
	public LoginBean getLb(){return this.lb;}//lb的getter方法
	public void setOldpwd(String oldpwd)
	{
		this.oldpwd=oldpwd;
	}
	public String getOldpwd()
	{
		return this.oldpwd;
	}
	public void setNewpwd(String newpwd)
	{
		this.newpwd=newpwd;
	}
	public String getNewpwd()
	{
		return this.newpwd;
	}
	public void setRenewpwd(String renewpwd)
	{
		this.renewpwd=renewpwd;
	}
	public String getRenewpwd()
	{
		return this.renewpwd;
	}
	public String getDifferent()
	{
		return this.different;
	}
	public String getResult()
	{
		String result1=result;
		result="";
		return result1;
	}
	public void setResult(String result)
	{
		result="";
	}
	public void changePwd(){//密码修改的业务逻辑方法
		this.different="";this.result="";//设置处理结果的初始值
		if(!this.newpwd.equals(this.renewpwd)){//两次输入的新密码不相同
			this.different="两次新密码不匹配";//设置结果值
			return ;							//返回
		}
		else{							//如果相同
			this.different="";			//设为空字符串
		}
		if(!lb.getPwd().equals(this.oldpwd)){//如果旧密码输入不正确
			this.result="旧密码不正确";			//这只错误信息
			return;							//返回
		}
		else{			//如果旧密码正确
			this.result="";		//设为空字符串
		}
		if(TeacherDB.changePwd(lb.getUid(),oldpwd,newpwd)==true){//执行修改密码
			result="修改成功";			//修改成功
			lb.setPwd(newpwd);			//将LoginBean中的pwd更新为最新的
		}
		else{					//如果修改失败
			result="修改失败";		//设置错误信息
		}
	}
}