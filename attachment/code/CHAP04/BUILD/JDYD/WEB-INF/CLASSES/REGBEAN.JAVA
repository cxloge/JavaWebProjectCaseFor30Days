package wyf;
import java.util.*;
import javax.faces.context.*;
import org.springframework.jdbc.core.*;
public class RegBean extends BaseBean{
	private String uname;				//用于封装用户输入的注册用户名
	private String pwd;					//用于封装用户输入的注册密码
	private String rePwd;				//用于封装用户输入的确认密码
	private String gender;				//用于封装用户输入的性别
	private String email;				//用于封装用户输入的电子邮件地址
	private String phone;				//用于封装用户输入的电话号码信息
	private String valCode;				//用于存储用户输入的验证码
	public void setUname(String uname){
		this.uname = uname;
	}
	public String getUname(){
		return this.uname;
	}	
	public void setPwd(String pwd){
		this.pwd = pwd;
	}
	public String getPwd(){
		return this.pwd;
	}	
	public void setRePwd(String rePwd){
		this.rePwd = rePwd;
	}
	public String getRePwd(){
		return this.rePwd;
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	public String getGender(){
		return this.gender;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return this.email;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getPhone(){
		return this.phone;
	}
	public void setValCode(String valCode){
		this.valCode = valCode.toUpperCase();
	}
	public String getValCode(){
		return this.valCode;
	}

	public String userReg(){
		FacesContext fc = FacesContext.getCurrentInstance();	//得到FacesContext实例
		ExternalContext ec = fc.getExternalContext();			//得到ExternalContext实例
		Map session = ec.getSessionMap();						//得到类似HttpSession的Map 实例
		String code = (String)session.get("randNum");			//得到session里的验证码
		code = code.toUpperCase();								//将验证码转成大写
		if(!code.equals(valCode)){								//如果输入的和系统产生的验证码不一样
			message = "验证码输入错误，注册失败";				//验证码错误的提示信息
			return "fail";										//返回fail  
		}
		if(!rePwd.equals(pwd)){
			message = "两次密码输入不一致，注册失败";			  //两次密码不一致的提示信息
			return "fail";										//返回fail  
		}
		String sql = "select uname from user_info where uname='"+uname+"'";		
		if(dbu.isExist(sql)){
			message = "很抱歉，该用户名已经有人注册";			  //用户名已经被占用
			return "fail";										//返回fail  
		}
		sql = "insert into user_info(uname,upwd,ugender,uemail,uphone) values "+
			"('"+uname+"','"+pwd+"','"+gender+"','"+email+"','"+phone+"')";
		if(dbu.update(sql)){
			message = "恭喜您，用户名<"+uname+">注册成功";		//注册成功信息
		}
		else{
			message = "未知错误，注册失败";						//注册失败信息
		}
		return "success";
	}
}