package wyf.zrk;

public class AdminInfo {
	private int a_id;
	private String a_name;
	private String a_pwd;
	private String a_gender;
	private String a_level;
	
	public void setA_id(int id) {
		this.a_id = id;
	}
	public int getA_id() {
		return this.a_id;
	}
	public void setA_name(String name) {
		this.a_name = name;
	}
	public String getA_name() {
		return this.a_name;
	}
	public void setA_pwd(String pwd) {
		this.a_pwd = pwd;
	}
	public String getA_pwd() {
		return this.a_pwd;
	}
	public void setA_gender(String gender) {
		this.a_gender = gender;
	}
	public String getA_gender() {
		return this.a_gender;
	}
	public void setA_level(String level) {
		this.a_level = level;
	}
	public String getA_level() {
		return this.a_level;
	}
	@Override
	public String toString(){
		return this.a_name+"    "+this.a_pwd+"          "+this.a_level+"    "+this.a_id+"    "+this.a_gender;
	}
	
	
}