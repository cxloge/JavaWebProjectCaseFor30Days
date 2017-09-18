package wyf;
import java.util.Map;
import javax.faces.context.*;
import org.springframework.jdbc.core.*;

public class AdminLogBean extends BaseBean{
		
	private String aid;
	private String aname = "wyf";
	private String apwd = "123123";
	private String valCode;
	private boolean flag;			//是否超级管理员的标志
	public String getAid() {
		return aid;					//aid的getter方法
	}
	public void setAid(String aid) {
		this.aid = aid;				//aid的setter方法
	}
	public String getAname() {
		return aname;				//aname的getter方法
	}
	public void setAname(String aname) {
		this.aname = aname;			//aname的setter方法
	}
	public String getApwd() {
		return apwd;				//apwd的getter方法
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;			//apwd的setter方法
	}
	public String getValCode() {
		return valCode;				//valcode的getter方法
	}
	public void setValCode(String valCode) {
		this.valCode = valCode.toUpperCase();	//valCode的setter方法，将其转为大写
	}
	
	public boolean isSuper(){		
		return this.flag;				//返回是否是超级管理员的方法
	}
	public void loginAdmin(){
		FacesContext fc = FacesContext.getCurrentInstance();	//得到FacesContext实例
		ExternalContext ec = fc.getExternalContext();			//得到ExternalContext实例
		Map session = ec.getSessionMap();						//得到类似HttpSession的Map 实例
		String code = (String)session.get("randNum");			//得到session里的验证码
		code = code.toUpperCase();								//将验证码转成大写
		if(!code.equals(valCode)){								//如果输入的和系统产生的验证码不一样
			message = "验证码输入错误，登陆失败";				//验证码错误的提示信息												
		}
		else{										//验证码输入正确
			String sql = "select AId from admin_info where AName='"+aname+
				"' and APwd='"+apwd+"'";			//验证用户名和密码的SQL语句
			this.setAid(dbu.getStringInfo(sql));	//设置管理员编号属性
			if(aid==null){
				message = "登陆失败，用户名和密码不匹配";	//登录失败提示信息
			}
			else{
				message = aname+",欢迎进入酒店预订管理中心";	//登录成功提示信息
				sql = "select ALevel from admin_info where AId="+this.aid;
				this.flag = dbu.getStringInfo(sql).equals("超级");	//得到管理员的级别信息
			}
		}
	}
	
	public String adminLogout(){
		this.setAid(null);			//设置aid属性值为null
		this.setAname(null);		//设置aname属性值为null
		this.setMessage(null);		//设置message属性为null
		this.flag = false;			//设置管理员级别标志为false，即普通管理员
		return "adminLogin";		//返回管理登录页面
	}
}
