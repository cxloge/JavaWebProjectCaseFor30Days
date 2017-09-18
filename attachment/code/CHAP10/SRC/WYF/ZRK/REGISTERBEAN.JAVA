package wyf.zrk;

import java.util.*;

public class RegisterBean{
	private DButilDAOImpl db;
	private String uname;				//注册的用户名
	private String firstPwd;			//第一次输入的密码
	private String secondPwd;			//第二次输入的密码
	private String ugender="男";			//用户性别
	private String uemail;				//邮箱
	private String randNum;				//验证码
	private String errMsg;				//错误信息提示
	private InfoBean info;				//成功信息提示
	
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public DButilDAOImpl getDb() {
		return this.db;
	}
	public void setUname(String uname){
		this.uname = uname;
	}
	public String getUname(){
		return this.uname;
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
	public void setUgender(String ugender){
		if(!ugender.equals("男")&&!ugender.equals("女")){
			errMsg = "信息输入有误，请重新输入！";
		}
		this.ugender = ugender;
	}
	public void setUemail(String email) {
		this.uemail = email;
	}
	public String getUemail() {
		return this.uemail;
	}
	public String getUgender(){
		return this.ugender;
	}
	public void setRandNum(String randNum){
		this.randNum = randNum;
	}
	public String getRandNum(){
		return this.randNum;
	}
	public void setErrMsg(String errMsg){
		this.errMsg = errMsg;
	}
	public String getErrMsg(){
		String msg = errMsg;
		errMsg = "";
		return msg;
	}
	public void setInfo(InfoBean ib) {
		this.info = ib;
	}
	public InfoBean getInfo() {
		return this.info;
	}
	
	
	public String register(){
		String flag = "register";
		String name = "";
		try {
			name = new String(uname.getBytes(),"ISO-8859-1");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		String hql = "from UserInfo as ui where ui.u_name='"+name+"'";
		List ls = db.getInfo(hql);
		if(ls.size()!=0) {
			errMsg = "该用户名已经存在！";
			flag = "fail";
		}
		else {
			/*
			String sql = "insert into userinfo(u_name,u_pwd,u_gender,u_email) values('"+
							name+"','"+new String(firstPwd.getBytes(),"ISO-8859-1")+"','"+
							new String(ugender.getBytes(),"ISO-8859-1")+"','"+uemail+"'";
			String msg = db.InsertObj(sql);
			*/
			UserInfo ui = new UserInfo();
			try {
				ui.setU_name(new String(uname.getBytes(),"ISO-8859-1"));
				ui.setU_pwd(new String(firstPwd.getBytes(),"ISO-8859-1"));
				ui.setU_email(uemail);
				ui.setU_gender(new String(ugender.getBytes(),"ISO-8859-1"));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			String msg = db.insertObj("userinfo",ui);
			if(msg.equals("yes")) {
				info.setMsg(uname+"，恭喜您，注册成功！");
				flag = "register";
				SendMail sm = new SendMail();
				sm.setFrom("JavaLover@foxmail.com");
				sm.setName("JavaLover@foxmail.com");
				sm.setPwd("860607");
				sm.setTo(this.uemail);
				sm.setTitle("迅捷二手房注册信息");
				sm.setText("恭喜您，在迅捷二手房信息注册成功，请记住你的具体信息！用户名："
								+this.uname+",密码是："+this.firstPwd);
				Thread t = new Thread(sm);
				t.start();
			}
			else {
				errMsg = "插入失败！";
				flag = "fail";
			}
		}
		return flag;
	}
	
	
	
}