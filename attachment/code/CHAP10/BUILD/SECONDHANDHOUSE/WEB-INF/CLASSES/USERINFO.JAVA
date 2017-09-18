package wyf.zrk;

public class UserInfo{
	private int u_id;
	private String u_name;
	private String u_pwd;
	private String u_gender;
	private String u_email;
	
	public void setU_id(int uid){
		this.u_id = uid;
	}
	public int getU_id(){
		return this.u_id;
	}
	public void setU_name(String uname){
		this.u_name = uname;
	}
	public String getU_name(){
		return this.u_name;
	}
	public void setU_pwd(String upwd){
		this.u_pwd = upwd;
	}
	public String getU_pwd(){
		return this.u_pwd;
	}
	public void setU_gender(String ugender){
		this.u_gender = ugender;
	}
	public String getU_gender(){
		return this.u_gender;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_email() {
		return this.u_email;
	}	
	@Override
	public String toString(){
		return this.u_id+" "+this.u_name+" "+this.u_pwd+" "+this.u_gender;
	}
}