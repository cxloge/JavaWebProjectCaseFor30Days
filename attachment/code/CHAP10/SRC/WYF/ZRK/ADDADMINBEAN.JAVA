package wyf.zrk;

import java.util.*;

public class AddAdminBean {
	private DButilDAOImpl db;
	private String aname;
	private String firstPwd;
	private String secondPwd;
	private String agender = "男";
	private String errMsg;
	private InfoBean info;
	
	public void setInfo(InfoBean info) {
		this.info = info;
	}
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAname() {
		return this.aname;
	}
	public void setFirstPwd(String firstpwd) {
		this.firstPwd = firstpwd;
	}
	public String getFirstPwd() {
		return this.firstPwd;
	}
	public void setSecondPwd(String secondpwd) {
		this.secondPwd = secondpwd;
	}
	public String getSecondPwd() {
		return this.secondPwd;
	}
	public void setAgender(String agender) {
		this.agender = agender;
	}
	public String getAgender() {
		return this.agender;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getErrMsg() {
		String msg = this.errMsg;
		this.errMsg = "";
		return msg;
	}
	
	public String add() {
		String msg = "";
		try {
			String name = new String(aname.getBytes(),"ISO-8859-1");
			String hqlName = "from AdminInfo as ai where ai.a_name='"+name+"'";
			List ls = db.getInfo(hqlName);
			if(ls.size()!=0) {
				this.errMsg = "该用户名已经存在！";
				msg = "addadmin";
			}
			else {
				AdminInfo ai = new AdminInfo();
				ai.setA_gender(new String(this.agender.getBytes(),"ISO-8859-1"));
				ai.setA_level(new String("普通".getBytes(),"ISO-8859-1"));
				ai.setA_name(new String(this.aname.getBytes(),"ISO-8859-1"));
				ai.setA_pwd(this.firstPwd);
				String ms = db.insertObj("admininfo",ai);
				if(ms.equals("yes")) {
					msg = "info";
					info.setMsg("恭喜您，添加成功！");
					info.setUrl("AdminIndex.jsp");
				}
				else {
					msg = "addadmin";
					errMsg = "管理员添加失败！";
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
}