package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import org.apache.struts2.*;
import java.math.*;
public class ChangePwdAction{
	private InsertDB insertDB;
	private String oldpwd;
	private String newpwd1;
	private String newpwd2;
	private String result="";
	public void setInsertDB(InsertDB insertDB){
		this.insertDB=insertDB;
	}
	public void setOldpwd(String oldpwd){
		this.oldpwd=oldpwd.trim();
	}
	public void setNewpwd1(String newpwd1){
		this.newpwd1=newpwd1.trim();
	}
	public void setNewpwd2(String newpwd2){
		this.newpwd2=newpwd2.trim();
	}
	public String getResult(){
		return this.result;
	}
	public String execute(){
		if(!this.newpwd1.equals(this.newpwd2)){
			this.result="两次输入的新密码不匹配，请重新输入";
			return "success";
		}
		String usernumber=(String)ActionContext.getContext().getSession().get("user");
		String sql="update oa_user set user_pwd='"+this.newpwd1+"' where user_number='"+
					usernumber+"' and user_pwd='"+this.oldpwd+"'";
		int i=insertDB.update(sql);
		if(i<1){
			this.result="请检查您的旧密码是否正确";
			return "success";
		}
		this.result="密码修改成功";
		return "success";
	}
}
