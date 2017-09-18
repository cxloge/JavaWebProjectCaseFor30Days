package wyf.cgq;
import java.util.*;
public class NewUser{
	private String userNumber;
	private String userName;
	private String userPwd;
	private String realName;
	private String gender;
	private Date birth;
	private String deptNumber;
	private String groupNumber;
	private String roleNumber;
	private String email;
	private String phone;
	private String jianli;
	private String imgpath;
	private double salary;
	
	private String deptName;
	private String groupName;
	private String roleName;
	public NewUser(String userNumber,String userName,String realName,String gender,
				Date birth,String deptName,String groupName,String roleName,
				String email,String phone,String jianli,double salary,String imgpath){
		this.userNumber=userNumber;
		this.userName=userName;
		this.realName=realName;
		this.gender=gender;
		this.birth=birth;
		this.deptName=deptName;
		this.groupName=groupName;
		this.roleName=roleName;
		this.email=email;
		this.phone=phone;
		this.jianli=jianli;
		this.salary=salary;
		this.imgpath=imgpath;
	}
	public NewUser(){
	}
	
	public NewUser(Date birth, String deptNumber, String email,
			String gender, String groupNumber, String imgpath, String jianli,
			String phone, String realName, String roleNumber, double salary,
			String userName, String userNumber, String userPwd) {
		this.birth = birth;
		this.deptNumber = deptNumber;
		this.email = email;
		this.gender = gender;
		this.groupNumber = groupNumber;
		this.imgpath = imgpath;
		this.jianli = jianli;
		this.phone = phone;
		this.realName = realName;
		this.roleNumber = roleNumber;
		this.salary = salary;
		this.userName = userName;
		this.userNumber = userNumber;
		this.userPwd = userPwd;
	}
	public NewUser(Date birth, String deptNumber, String email,
			String gender, String groupNumber, String imgpath, String jianli,
			String phone, String realName, String roleNumber, double salary,
			String userName,String userPwd) {
		this.birth = birth;
		this.deptNumber = deptNumber;
		this.email = email;
		this.gender = gender;
		this.groupNumber = groupNumber;
		this.imgpath = imgpath;
		this.jianli = jianli;
		this.phone = phone;
		this.realName = realName;
		this.roleNumber = roleNumber;
		this.salary = salary;
		this.userName = userName;
		this.userPwd = userPwd;
	}
	public NewUser(String userName,String realName,String gender,String deptName,
					String roleName,String phone,String userNumber){
		this.userName=userName;
		this.realName=realName;
		this.gender=gender;
		this.deptName=deptName;
		this.roleName=roleName;
		this.phone=phone;
		this.userNumber=userNumber;
	}
	
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getDeptNumber() {
		return deptNumber;
	}
	public void setDeptNumber(String deptNumber) {
		this.deptNumber = deptNumber;
	}
	public String getGroupNumber() {
		return groupNumber;
	}
	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}
	public String getRoleNumber() {
		return roleNumber;
	}
	public void setRoleNumber(String roleNumber) {
		this.roleNumber = roleNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getJianli() {
		return jianli;
	}
	public void setJianli(String jianli) {
		this.jianli = jianli;
	}
	public String getImgpath() {
		return imgpath.substring(1,imgpath.length());
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDeptName(){
		return this.deptName;
	}
	public String getRoleName(){
		return this.roleName;
	}
	public String getGroupName(){
		return this.groupName;
	}
	
}