package wyf.cgq;
public class RealUser{
	private String userNumber;
	private String userName;
	private String deptNumber;
	public RealUser(){
	}
	public RealUser(String userNumber,String userName,String deptNumber){
		this.userNumber=userNumber;
		this.userName=userName;
		this.deptNumber=deptNumber;
	}
	public void setUserNumber(String userNumber){
		this.userNumber=userNumber;
	}
	public String getUserNumber(){
		return this.userNumber;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getUserName(){
		return this.userName;
	}
	public void setDeptNumber(String deptNumber){
		this.deptNumber=deptNumber;
	}
	public String getDeptNumber(){
		return this.deptNumber;
	}
}