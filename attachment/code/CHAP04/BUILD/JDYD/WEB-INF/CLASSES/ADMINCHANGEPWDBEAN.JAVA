package wyf;

public class AdminChangePwdBean extends BaseBean{
	private String oldPwd;
	private String newPwd;
	private String reNewPwd;
	private AdminLogBean alb;
	
	public void setAlb(AdminLogBean alb) {	//依赖注入方法
		this.alb = alb;
	}
	public String getOldPwd() {
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getReNewPwd() {
		return reNewPwd;
	}
	public void setReNewPwd(String reNewPwd) {
		this.reNewPwd = reNewPwd;
	}
	
	public void changePwd(){
		String sql = "select 1 from admin_info where AId="+alb.getAid()+
			" and APwd='"+this.oldPwd+"'";		//验证管理员输入密码的正确性的SQL语句
		if(dbu.isExist(sql)){					//可以修改密码
			if(newPwd.equals(reNewPwd)){
				sql = "update admin_info set APwd='"+this.newPwd+"' where "+
					"AId="+alb.getAid();
				if(dbu.update(sql)){
					message = "密码修改成功，下次请用新密码登陆";
				}
				else{
					message = "未知错误，密码修改失败";
				}
			}
			else{
				message = "两次输入密码不相同，修改失败";
			}
		}
		else{
			message = "旧密码输入错误，修改失败";
		}
	}
}
