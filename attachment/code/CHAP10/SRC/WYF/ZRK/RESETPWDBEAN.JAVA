package wyf.zrk;

import java.util.*;

public class ResetPwdBean {
	private DButilDAOImpl db;
	private InfoBean info;
	private String aname;
	private String firstPwd;
	private String secondPwd;
	private String errMsg;
	
	
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public void setInfo(InfoBean info) {
		this.info = info;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAname() {
		return this.aname;
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
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getErrMsg() {
		String msg = this.errMsg;
		this.errMsg = "";
		return msg;
	}
	
	public String reset() {
		String msg = "";
		try {
			String name = new String(aname.getBytes(),"gbk");
			String hql = "from AdminInfo as ai where ai.a_name='"+name+"'";
			List<AdminInfo> ls = (List<AdminInfo>)db.getInfo(hql);
			if(ls.size()==0) {
				msg = "resetpwd";
				errMsg = "该管理员不存在！";
			}
			else {
				AdminInfo ai = ls.get(0);
				ai.setA_pwd(this.firstPwd);
				String ms = db.updateObj("admininfo",ai);
				if(ms.equals("yes")) {
					msg = "info";
					info.setMsg("恭喜您，密码重置成功！");
					info.setUrl("AdminIndex.jsp");
				}
				else {
					msg = "resetpwd";
					errMsg = "密码重置失败！";
				}
			}			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
}