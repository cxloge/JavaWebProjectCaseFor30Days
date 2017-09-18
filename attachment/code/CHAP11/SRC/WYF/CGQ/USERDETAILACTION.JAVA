package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import java.math.*;
public class UserDetailAction extends ActionSupport{
	private SearchDB searchDB;
	private String userNumber;
	private String savePath;
	private NewUser user;
	private String result="";
	public void setSearchDB(SearchDB searchDB){
		this.searchDB=searchDB;
	}
	public void setUserNumber(String userNumber){
		this.userNumber=userNumber;
	}
	public String getUserNumber(){
		return this.userNumber;
	}
	public void setSavePath(String savePath){
		this.savePath=savePath;
	}
	public String getSavePath(){
		return ServletActionContext.getRequest().getRealPath(savePath);
	}
	public String getPath(){
		return this.savePath;
	}
	public void setResult(String result){
		this.result=result;
	}
	public String getResult(){
		return this.result;
	}
	public NewUser getUser(){
		return this.user;
	}
	public String execute(){
		String sql="select oa_user.user_number,oa_user.user_name,oa_user.user_realname,"+
				"oa_user.user_gender,oa_user.user_birth,oa_dept.dept_name,"+
				"oa_group.group_name,oa_role.role_name,oa_user.user_email,oa_user.user_phone,"+
				"oa_user.user_jianli,oa_user.user_salary,oa_user.user_imgpath "+
				"from oa_user,oa_dept,oa_group,oa_role where oa_user.user_number='"+this.userNumber+
				"' and oa_user.dept_number=oa_dept.dept_number and oa_user.group_number="+
				"oa_group.group_number and oa_user.role_number=oa_role.role_number";
		List list=this.searchDB.getArrayList(sql);
		if(!list.isEmpty())
		{
			Object[] o=(Object[])list.get(0);
			System.out.println(this.savePath+"/"+(String)o[12]);
			this.user=new NewUser((String)o[0],(String)o[1],(String)o[2],((Character)o[3]).toString(),
					(Date)o[4],(String)o[5],(String)o[6],(String)o[7],(String)o[8],
					(String)o[9],(String)o[10],((BigDecimal)o[11]).doubleValue(),this.savePath+"/"+(String)o[12]);
		}
		return "success";
	}
}