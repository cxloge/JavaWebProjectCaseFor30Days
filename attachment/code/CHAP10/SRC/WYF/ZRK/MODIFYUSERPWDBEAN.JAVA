package wyf.zrk;

public class ModifyUserPwdBean{
	private UserLoginBean ulb;
	private DButilDAOImpl db;
	private String oldPwd;
	private String firstPwd;
	private String secondPwd;
	private String errMsg;
	
	public void setUlb(UserLoginBean ulb){
		this.ulb = ulb;
		System.out.println("set ulb is:"+this.ulb);
	}
	public UserLoginBean getUlb(){
		return this.ulb;
	}
	public void setDb(DButilDAOImpl db) {
		this.db = db;
		System.out.println("db is :"+this.db);
	}
	public DButilDAOImpl getDb() {
		return this.db;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getOldPwd() {
		return this.oldPwd;
	}
	public void setFirstPwd(String firstPwd){
		this.firstPwd = firstPwd;
	}
	public String getFirstPwd(){
		return this.firstPwd;
	}
	public void setSecondPwd(String secondPwd){
		this.secondPwd = secondPwd;
	}
	public String getSecondPwd(){
		return this.secondPwd;
	}
	public void setErrMsg(String errMsg){
		this.errMsg = "";
	}
	public String getErrMsg(){
		String msg = errMsg;
		errMsg = "";
		return msg;
	}
	
	public String modify(){
		String msg = "error";
		if(oldPwd.trim().equals("")) {
			errMsg = "旧密码不能为空！";
		}
		else if(firstPwd.trim().equals("")) {
			errMsg = "第一次新密码不能为空！";
		}
		else if(secondPwd.trim().equals("")) {
			errMsg = "第二次新密码不能为空！";
		}
		else if(!firstPwd.trim().equals(secondPwd.trim())) {
			errMsg = "两次输入密码不一致！";
		}
		else if(!ulb.getUpwd().equals(oldPwd.trim())) {
			errMsg = "旧密码输入错误！";
		}
		else {
			UserInfo ui = new UserInfo();
			ui.setU_pwd(firstPwd);
			ui.setU_id(ulb.getUser().getU_id());
			String flag = db.updateObj("userinfo",ui);
			if(flag.equals("yes")) {
				msg = "success";
			}
			else if(flag.equals("no")) {
				errMsg = "密码修改失败！";
			}
		}
		return msg;
	}
}