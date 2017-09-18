package wyf;

public class UserChangePwdBean extends BaseBean{
	private String oldPwd;		//记录用户输入的老密码
	private String newPwd;		//记录用户输入的新密码
	private String reNewPwd;	//记录用户输入的确认新密码
	private UserLogBean ulb;	//记录用户登陆信息的Bean引用
	
	public void setUlb(UserLogBean ulb){
		this.ulb = ulb;			//接受ulb依赖注入的setter方法
	}

	public void setOldPwd(String oldPwd){
		this.oldPwd = oldPwd;
	}
	public String getOldPwd(){
		return this.oldPwd;
	}
	
	public void setNewPwd(String newPwd){
		this.newPwd = newPwd;
	}
	public String getNewPwd(){
		return this.newPwd;
	}
	
	public void setReNewPwd(String reNewPwd){
		this.reNewPwd = reNewPwd;
	}
	public String getReNewPwd(){
		return this.reNewPwd;
	}
	
	public String changePwd(){
		if(!newPwd.equals(reNewPwd)){
			return "fail";						//两次输入的新密码不一致时
		}
		if(ulb.getUname()==null){
			return "userLogin";					//用户登陆超时或者没有登陆
		}
		String sql = "select 1 from user_info where uname='"+ulb.getUname()+
			"' and upwd='"+oldPwd+"'";			// 查看输入的密码是否匹配的SQL语句
		if(dbu.isExist(sql)){					//如果输入的密码正确
			sql = "update user_info set upwd='"+newPwd+"' where uname='"+ulb.getUname()+"'";//更新用户密码的SQL语句
			if(dbu.update(sql)){
				message = "密码修改成功，下一次请用新密码登陆";	//修改成功提示信息
			}
			else{
				message = "未知错误，修改失败";					//修改失败提示信息
			}
		}
		else{
			message = "旧密码输入错误，修改失败";				//不符合修改密码条件
		}
		return "success";
	}
}