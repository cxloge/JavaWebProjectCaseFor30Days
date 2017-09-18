package wyf;

public class AddAdminBean extends BaseBean{
	private String aname;
	private String pwd;
	private String rePwd;
	public String getAname() {				//aname属性的getter方法
		return aname;
	}
	public void setAname(String aname) {	//aname属性的setter方法
		this.aname = aname;
	}
	public String getPwd() {				//pwd属性的setter方法
		return pwd;
	}
	public void setPwd(String pwd) {		//pwd属性的getter方法
		this.pwd = pwd;
	}
	public String getRePwd() {				//rePwd属性的getter方法
		return rePwd;
	}
	public void setRePwd(String rePwd) {	//rePwd的setter方法
		this.rePwd = rePwd;
	}
	
	public void addAdmin(){
		if(pwd.equals(rePwd)){					//如果两次输入的密码一致
			String sql = "select 1 from admin_info where AName='"+this.aname+"'";
			if(dbu.isExist(sql)){				//该管理员名已经存在
				message = "该管理员名已经存在，添加失败";
			}
			else{								
				sql = "insert into admin_info(AName,APwd) values('"+this.aname+
					"','"+this.pwd+"')";					//插入新管理员的SQL语句			
				if(dbu.update(sql)){						//添加成功
					message = "管理员添加成功";				//添加成功的提示消息
				}
				else{
					message = "未知错误，添加失败";			//添加失败的提示消息
				}	
			}
		}
		else{
			message = "两次密码输入不一致，添加管理员失败";	//两次密码输入不一致的提示消息
		}
	}
}
