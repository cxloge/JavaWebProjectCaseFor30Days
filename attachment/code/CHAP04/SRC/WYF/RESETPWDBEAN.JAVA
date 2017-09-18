package wyf;

public class ResetPwdBean extends BaseBean {
	private String aname;						//要重置密码的管理员名
	private String newPwd;						//重置后的密码
	private String reNewPwd;					//确认重置密码
	public String getAname() {					//aname的getter方法
		return aname;
	}
	public void setAname(String aname) {		//aname的setter方法
		this.aname = aname;
	}
	public String getNewPwd() {					//newPwd的getter方法
		return newPwd;
	}
	public void setNewPwd(String newPwd) {		//newPwd的setter方法
		this.newPwd = newPwd;
	}
	public String getReNewPwd() {				//reNewPwd的getter方法
		return reNewPwd;
	}
	public void setReNewPwd(String reNewPwd) {	//reNewPwd的setter方法
		this.reNewPwd = reNewPwd;
	}
	
	public void reset(){
		if(newPwd.equals(reNewPwd)){					//先判断两次密码输入是否相同
			String sql = "select 1 from admin_info where AName='"+aname+"'";
			if(dbu.isExist(sql)){						//如果该管理员名存在
				sql = "update admin_info set APwd='"+newPwd+"' where AName='"+aname+"'";
				if(dbu.update(sql)){					//执行更新
					message = "密码重置成功";			//重置成功提示消息
				}
				else{
					message  = "未知错误，重置失败";	//失败提示消息
				}
			}
			else{
				message = "该管理员名不存在";			//管理员名输入错误提示信息
			}
		}
		else{
			message = "两次输入密码不一致，重置失败";	//两次密码不一致时的提示
		}
	}
}
