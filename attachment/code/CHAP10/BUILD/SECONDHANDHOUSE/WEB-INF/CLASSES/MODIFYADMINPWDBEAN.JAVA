package wyf.zrk;

public class ModifyAdminPwdBean {
	private InfoBean info;
	private AdminLoginBean alb;
	private DButilDAOImpl db;
	private String aname;
	private String oldPwd;
	private String firstPwd;
	private String secondPwd;
	private String errMsg;	
	
	public void setInfo(InfoBean info) {
		this.info = info;
	}
	public void setAlb(AdminLoginBean alb) {
		this.alb = alb;
	}
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public String getAname() {
		return this.alb.getAname();
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getOldPwd() {
		return this.oldPwd;
	}
	public void setFirstPwd(String firstPwd) {
		this.firstPwd = firstPwd;
	}
	public String getFirstPwd() {
		return this.firstPwd;
	}
	public void setSecondPwd(String secondPwd) {
		this.secondPwd = secondPwd;
	}
	public String getSecondPwd() {
		return this.secondPwd;
	}
	public void setErrMsg(String msg) {
		this.errMsg = errMsg;
	}
	public String getErrMsg() {
		String msg = errMsg;
		this.errMsg = "";
		return msg;
	}
	
	public String modify() {
		System.out.println("admin modify......");
		String msg = "";
		if(oldPwd.trim().equals("")) {
			errMsg = "旧密码不能为空！";
			msg = "error";
		}
		else if(firstPwd.trim().equals("")) {
			errMsg = "第一次新密码不能为空！";
			msg = "error";
		}
		else if(secondPwd.trim().equals("")) {
			errMsg = "第二次新密码不能为空！";
			msg = "error";
		}
		else if(!firstPwd.trim().equals(secondPwd.trim())) {
			errMsg = "两次输入密码不一致！";
			msg = "error";
		}
		else if(!alb.getApwd().equals(oldPwd.trim())) {
			errMsg = "旧密码输入错误！";
			msg = "error";
		}
		else {
			AdminInfo ai = new AdminInfo();
			ai.setA_pwd(this.firstPwd);
			ai.setA_id(this.alb.getAdmin().getA_id());
			String flag = db.updateObj("admininfo",ai);
			if(flag.equals("yes")) {
				this.info.setUrl("AdminIndex.jsp");
				this.info.setMsg("恭喜您，密码修改成功！");
				msg = "success";
			}
			else if(flag.equals("no")) {
				errMsg = "密码修改失败！";
				msg = "error";
			}
		}
		return msg;
	}
	
	
	
	
}