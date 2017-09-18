package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import java.math.*;
public class ViewUserAction extends FenYeAction{
	private String deptNumber="00000";
	private List deptList;
	private String hqldept="from Dept";
	public List getDeptList(){
		List list=this.getSearchDB().getInstanceList(hqldept);
		list.add(0,new Dept("00000","查看全部"));
		return list;
	}
	public void setDeptNumber(String deptNumber){
		this.deptNumber=deptNumber;
	}
	public List getUserList(){
		
		int begin=(this.getCurrenPage()-1)*this.getPageSpan();
		int end=this.getCurrenPage()*this.getPageSpan();
		String deptsql="";
		if(!this.deptNumber.equals("00000")){
			deptsql=" and oa_user.dept_number='"+this.deptNumber+"' "; 
		}
		String sql="select userName,realName,gender,deptName,roleName,phone,userNumber from("+
				"select rownum rn,userName,realName,gender,deptName,roleName,phone,userNumber from("+
				"select oa_user.user_name userName,oa_user.user_realname realName,"+
				"oa_user.user_gender gender,oa_dept.dept_name deptName,"+
				"oa_role.role_name roleName,oa_user.user_phone phone,oa_user.user_number userNumber "+
				"from oa_user,oa_dept,oa_role "+
				"where oa_user.dept_number=oa_dept.dept_number and "+
				"oa_user.role_number=oa_role.role_number "+deptsql+
				")) where rn>"+begin+" and rn<="+end;
		List list=this.getSearchDB().getArrayList(sql);
		
		int size=list.size();
		List userlist=new ArrayList();
		for(int i=0;i<size;i++){
			Object[] o=(Object[])list.get(i);
			NewUser newuser=new NewUser((String)o[0],(String)o[1],((Character)o[2]).toString(),(String)o[3],
			(String)o[4],(String)o[5],(String)o[6]);
			userlist.add(newuser);
		}
		return userlist;
	}
	public String execute(){
		this.updateInfo();
		return "success";
	}
	public void updateInfo(){
		String deptSql="";
		if(!this.deptNumber.equals("00000")){
			deptSql="where oa_user.dept_number='"+this.deptNumber+"' "; 
		}
		String sql="select count(*) from oa_user "+deptSql;
		List list=this.getSearchDB().getArrayList(sql);
		int total=((BigDecimal)list.get(0)).intValue();
		this.setMaxPage(total%this.getPageSpan()==0?total/this.getPageSpan():(total/this.getPageSpan()+1));
	}
}