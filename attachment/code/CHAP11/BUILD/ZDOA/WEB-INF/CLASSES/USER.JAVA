package wyf.cgq;
public class User{
	private String userNumber;//用于记录用户编号
	private String uid;//用户的登陆名
	private String pwd;//用户的密码
	private Role role;//用户的职位
	public User(){}//无参构造器
	public User(String userNumber,String uid,String pwd,Role role){//有参构造器
		this.userNumber=userNumber;this.uid=uid;this.pwd=pwd;
		this.role=role;
	}
	public void setUserNumber(String userNumber){this.userNumber=userNumber;}
	public String getUserNumber(){return this.userNumber;}//userNumber的getter及setter方法
	public void setUid(String uid){this.uid=uid;}//uid的setter方法
	public String getUid(){return this.uid;}//uid的getter方法
	public void setPwd(String pwd){this.pwd=pwd;}//pwd的setter方法
	public String getPwd(){return this.pwd;}//pwd的getter方法
	public void setRole(Role role){this.role=role;}//role的getter方法
	public Role getRole(){return this.role;}//role的setter方法
}