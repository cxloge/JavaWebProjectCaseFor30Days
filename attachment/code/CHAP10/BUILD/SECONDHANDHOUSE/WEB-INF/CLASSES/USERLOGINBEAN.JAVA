package wyf.zrk;

import javax.faces.application.*;
import javax.faces.component.*;
import javax.faces.context.*;
import javax.faces.validator.*;
import java.util.*;

public class UserLoginBean{
	private UserInfo user;
	private String uname;				//用户名
	private String upwd;				//密码
	private String yzm;					//验证码
	private String errMsg;				//错误提示信息
	private boolean flag;				//用来标志是否登录
	private DButilDAOImpl db;			//注入数据库操纵类引用
	private String url = "";
	
	public void setUser(UserInfo user){
		this.user = user;
	}
	public UserInfo getUser(){
		return this.user;
	}	
	public void setUname(String uname){
		this.uname = uname;
	}
	public String getUname(){
		return this.uname;
	}
	public void setUpwd(String upwd){
		this.upwd = upwd;
	}
	public String getUpwd(){
		return this.upwd;
	}
	public void setYzm(String yzm){
		this.yzm = yzm;
	}
	public String getYzm(){
		return this.yzm;
	}
	public void setErrMsg(String errMsg){
		this.errMsg = "";
	}
	public String getErrMsg(){
		String msg = this.errMsg;
		errMsg = "";
		return msg;
	}
	public void setFlag(boolean flag){
		this.flag = flag;
	}
	public boolean isFlag(){
		return this.flag;
	}
	public void setDb(DButilDAOImpl db){
		this.db = db;
	}
	public DButilDAOImpl getDb(){
		return this.db;
	}
	public void setUrl(String url) {
		System.out.println("set the url is:"+url);
		this.url = url;
	}
	public String getUrl() {
		return this.url;
	}	
	
/*	
	public void validateYzm(FacesContext context,UIComponent component,
			java.lang.Object value) throws ValidatorException{
			String randNum = (String)value;
			System.out.println("the random number is:"+randNum);
			FacesContext fc = FacesContext.getCurrentInstance();
			String rand = (String)fc.getExternalContext().getSessionMap().get("randNum");
			if(!randNum.toLowerCase().equals(rand.toLowerCase())){
				FacesMessage message = new FacesMessage(
	                 FacesMessage.SEVERITY_ERROR, 
	                 "error", 
	                 "验证码输入错误！");
	            throw new ValidatorException(message);
			}
	}
*/	
	
	public String login(){
		FacesContext fc = FacesContext.getCurrentInstance();
		String randnum = ((String)fc.getExternalContext().getSessionMap().get("randNum")).toLowerCase();
		if(!this.getYzm().toLowerCase().equals(randnum)){
			errMsg = "验证码错误，请重新输入！";
			return "error";
		}
		else{
			String hql = "";
			try {
				hql = "from UserInfo as ui where ui.u_name='"+new String(uname.getBytes(),"ISO-8859-1")
							+"' and u_pwd='"+upwd+"'";
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			List<UserInfo> ls = (List<UserInfo>)db.getInfo(hql);
			if(ls.size()!=0){
				user = ls.get(0);				
				flag = true;
				if(url.equals("rentpublish")){
					url = "";
					return "rentpublish";
				}
				else if(url.equals("salepublish")) {
					url = "";
					return "salepublish";
				}
				else if(url.equals("qiuzupublish")) {
					url = "";
					return "qiuzupublish";
				}
				else if(url.equals("qiugoupublish")) {
					url = "";
					return "qiugoupublish";
				}
				else if(url.equals("showrentmsg")) {
					url = "";
					return "showrentmsg";
				}
				else if(url.equals("showqiuzumsg")) {
					url = "";
					return "showqiuzumsg";
				}
				else if(url.equals("showsalemsg")) {
					url = "";
					return "showsalemsg";
				}
				else if(url.equals("showqiugoumsg")) {
					url = "";
					return "showqiugoumsg";
				}
				else if(url.equals("questioninfo")) {
					url = "";
					return "questioninfo";
				}
				else {
					return "success";
				}
				
			}
			else{
				flag = false;
				errMsg = "用户名或密码无效，请重新登录！";
				return "error";
			}		
		}
		
		

	}
	
}