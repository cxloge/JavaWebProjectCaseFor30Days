package wyf.cgq;
public class Role{
	private String roleNumber;
	private int roleRight;
	public Role(){
	}
	public Role(String roleNumber,int roleRight){
		this.roleNumber=roleNumber;
		this.roleRight=roleRight;
	}
	public void setRoleNumber(String roleNumber){
		this.roleNumber=roleNumber;
	}
	public String getRoleNumber(){
		return this.roleNumber;
	}
	public void setRoleRight(int roleRight){
		this.roleRight=roleRight;
	}
	public int getRoleRight(){
		return this.roleRight;
	}
	
}