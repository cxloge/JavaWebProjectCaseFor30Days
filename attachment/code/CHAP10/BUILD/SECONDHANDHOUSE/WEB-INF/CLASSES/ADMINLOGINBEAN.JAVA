package wyf.zrk;

import javax.faces.application.*;
import javax.faces.component.*;
import javax.faces.context.*;
import javax.faces.validator.*;
import java.util.*;

public class AdminLoginBean {
	private AdminInfo admin;
	private String aname = "zrk";
	private String apwd = "860607";
	private String yzm;
	private String errMsg;
	private boolean flag;							//用来表示是否已经登录
	private DButilDAOImpl db;
	
	private String level;
	
	
	public void setAname(String name) {
		this.aname = name;
	}
	public String getAname() {
		return this.aname;
	}
	public void setApwd(String pwd) {
		this.apwd = pwd;
	}
	public String getApwd() {
		return this.apwd;
	}
	public void setYzm(String yzm) {
		this.yzm = yzm;
	}
	public String getYzm() {
		return this.yzm;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getErrMsg() {
		String msg = this.errMsg;
		this.errMsg = "";
		return msg;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public boolean getFlag() {
		return this.flag;
	}
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public AdminInfo getAdmin() {
		return this.admin;
	}
	public boolean getLevel() {
		if(this.level.equals("超级")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	public String login() {
		String msg = "success";
		System.out.println("admin is logining ......");
		FacesContext fc = FacesContext.getCurrentInstance();
		String randnum = ((String)fc.getExternalContext().getSessionMap().get("randNum")).toLowerCase();
		if(!this.getYzm().toLowerCase().equals(randnum)){
			errMsg = "验证码错误，请重新输入！";
			msg = "error";
		}
		else {
			try {
				String name = new String(aname.getBytes(),"ISO-8859-1");
				String pwd = new String(apwd.getBytes(),"ISO-8859-1");
				String hql = "from AdminInfo as ai where ai.a_name='"
								+name+"' and ai.a_pwd='"+pwd+"'";
				List<AdminInfo> ls = (List<AdminInfo>)db.getInfo(hql);
				if(ls.size()==0) {
					this.flag = false;
					msg = "error";
					errMsg = "用户名或密码错误！";
				}
				else {
					this.admin = ls.get(0);
					this.admin.setA_gender(new String(this.admin.getA_gender().getBytes("ISO-8859-1"),"gbk"));
					this.admin.setA_level(new String(this.admin.getA_level().getBytes("ISO-8859-1"),"gbk"));
					this.admin.setA_name(new String(this.admin.getA_name().getBytes("ISO-8859-1"),"gbk"));					
					this.flag = true;
					System.out.println(admin);
					this.level = this.admin.getA_level();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return msg;
	}
	public String adminLogout() {
		if(this.flag) {
			this.flag = false;
		}
		return "adminLogout";
	}
}
