package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
@Validation()
public class LoginAction extends ActionSupport{
	private String uid;//用于封装用户名的属性
	private String pwd;//用于封装密码的属性
	private String yanzhengma;//用于封装验证码的属性
	private String result="";//用于封装请求结果的属性
	private LoginDB loginDB;//声明用于搜索数据库的类的引用
	@RequiredStringValidator(message="${getText(\"validate.uidempty\")}")
	public void setUid(String uid){this.uid=uid;}//uid的setter方法
	public String getUid(){return this.uid;}//uid的getter方法
	@RequiredStringValidator(message="${getText(\"validate.pwdempty\")}")
	public void setPwd(String pwd){this.pwd=pwd;}//pwd的setter方法
	public String getPwd(){return this.pwd;	}//pwd的getter方法
	public void setYanzhengma(String yanzhengma){this.yanzhengma=yanzhengma;}
	public String getYanzhengma(){return this.yanzhengma;}//yanzhengma的setter及getter方法
	public String getResult(){return result;}//result的getter方法
	public void setLoginDB(LoginDB loginDB){this.loginDB=loginDB;}//loginDB的setter方法
	public String execute(){
		String yanzhengma=(String)ActionContext.getContext().getSession().get("yanzhengma");//获得session终的验证码
		if(yanzhengma!=null){//如果验证码不为空
			if(!yanzhengma.equals(this.yanzhengma.toLowerCase())){//如果输入验证码不正确
				this.result=this.getText("login.yanzhengmaerror");//设置错误提示信息
				return SUCCESS;//返回到登陆页面
			}
			else{String hql="from User u where u.uid='"+uid+"' and u.pwd='"+pwd+"'";//如果正确
				List list=loginDB.getUser(hql);//搜索数据库
				if(list.size()>0){//如果有该用户，即用户名和密码正确
					User user=(User)list.get(0);//获得该用户
					int right=user.getRole().getRoleRight();//获得该用户的权限
					this.getSession().put("user",user.getUserNumber());//将用户编号放入session
					this.getSession().put("right",right);//将权限放入session
					return "mainmanage";//返回逻辑视图
				}
				else{this.result="用户名或密码错误";//没有该用户
					return SUCCESS;//返回登陆页面的逻辑视图
				}
			}
		}
		return SUCCESS;
	}
	public Map getSession(){//获得session的方法
		return ActionContext.getContext().getSession();}
}