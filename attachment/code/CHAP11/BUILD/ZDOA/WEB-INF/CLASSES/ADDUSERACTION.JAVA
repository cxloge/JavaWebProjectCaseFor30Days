package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
public class AddUserAction extends ActionSupport{
	private SearchDB searchDB;
	private String hqldept="from Dept";
	private String name;
	private String pwd1;
	private String pwd2;
	private String realName;
	private String gender;
	private String birth;
	private String dept;
	private String group;
	private String role;
	private String email;
	private String tel;
	private double salary;
	private String jianli;
	private String result="";
	public void setSearchDB(SearchDB searchDB){
		this.searchDB=searchDB;
	}
	public List getDeptList(){
		List list=searchDB.getInstanceList(hqldept);
		list.add(0,new Dept(null,"选择部门"));
		System.out.println(list);
		return list;
	}
	public List getRoleList(){
		List list=new ArrayList();
		list.add(0,new Roles("","选择角色"));
		return list;
	}
	public List getGroupList(){
		List list=new ArrayList();
		list.add(0,new Groups("","选择组"));
		return list;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	public void setPwd1(String pwd1){
		this.pwd1=pwd1;
	}
	public String getPwd1(){
		return this.pwd1;
	}
	public void setPwd2(String pwd2){
		this.pwd2=pwd2;
	}
	public String getPwd2(){
		return this.pwd2;
	}
	public void setRealName(String realName){
		this.realName=realName;
	}
	public String getRealName(){
		return this.realName;
	}
	public void setGender(String gender){
		this.gender=gender;
	}
	public String getGender(){
		return this.gender;
	}
	public void setBirth(String birth){
		this.birth=birth;
	}
	public String getBirth(){
		return this.birth;
	}
	public void setGroup(String group){
		this.group=group;
	}
	public String getGroup(){
		return this.group;
	}
	public void setDept(String dept){
		this.dept=dept;
	}
	public String getDept(){
		return this.dept;
	}
	public void setRole(String role){
		this.role=role;
	}
	public String getRole(){
		return this.role;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return this.email;
	}
	public void setTel(String tel){
		this.tel=tel;
	}
	public String getTel(){
		return this.tel;
	}
	public void setSalary(double salary){
		this.salary=salary;
	}
	public double getSalary(){
		return this.salary;
	}
	public void setJianli(String jianli){
		this.jianli=jianli;
	}
	public String getJianli(){
		return this.jianli;
	}
	public String getResult(){
		return this.result;
	}
	public void setResult(String result){
		this.result=result;
	}
	public String execute(){
		return "success";
	}
	public Map getSession(){
		return ActionContext.getContext().getSession();
	}
}