package wyf;
import java.util.*;
import javax.faces.context.*;
import org.springframework.jdbc.core.*;

public class UserLogBean extends BaseBean{
	private String uname;					//用于封装登录用户名	
	private String pwd;						//用于封装登录的密码
	private String valCode;					//用于封装验证码
	private String usid;					//用于封装用户ID
	private boolean target = false;			//登陆后要跳转的页面标志位
	public void setTarget(boolean target){
		this.target = target;
	}
	public boolean getTarget(){
		return this.target;
	}
	public void setUsid(String usid){
		this.usid = usid;
	}
	public String getUsid(){
		return this.usid;
	}
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
	
	public void setValCode(String valCode){
		this.valCode = valCode.toUpperCase();					//将得到的验证码转为大写
	}
	public String getValCode(){
		return this.valCode;
	}
	
	public String loginUser(){
		FacesContext fc = FacesContext.getCurrentInstance();	//得到FacesContext实例
		ExternalContext ec = fc.getExternalContext();			//得到ExternalContext实例
		Map session = ec.getSessionMap();						//得到类似HttpSession的Map 实例
		String code = (String)session.get("randNum");			//得到session里的验证码
		code = code.toUpperCase();								//将验证码转成大写
		if(!code.equals(valCode)){								//如果输入的和系统产生的验证码不一样
			message = "验证码输入错误，登陆失败";				//验证码错误的提示信息
			return "fail";										//返回fail  
		}
		String sql = "select usid from user_info where uname='"+uname+
			"' and upwd='"+pwd+"'";								//验证用户名和密码是否正确的SQL语句	
		String result = "fail";
		this.setUsid(dbu.getStringInfo(sql));					//查询得到用户ID赋值给usid
		if(usid==null){
			message = "很抱歉，用户名和密码不匹配，登陆失败";	  //用户名和密码不匹配
		}
		else{
			message = uname+"，欢迎您的到来。";				//登录成功的提示消息
			if(this.target==false){
				result = "success";							//登录后返回首页视图
			}
			else{
				result = "toOrder";							//返回到当前订单视图
			}
		}
		return result;										//返回结果
	}
	public String userLogout(){
		this.setUsid(null);			//设置usid为null值
		this.setUname(null);		//设置uname为null值
		this.setMessage(null);		//设置message为null值
		this.setTarget(false);		//设置target为false
		return "userLogin";			//返回userLogin视图
	}
}