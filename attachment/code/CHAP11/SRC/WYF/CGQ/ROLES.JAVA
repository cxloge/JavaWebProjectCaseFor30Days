package wyf.cgq;
public class Roles{
	private String roleNumber;
	private String groupNumber;
	private String roleName;
	private int roleRight;
	public Roles(){
	}
	public Roles(String roleNumber,String groupNumber,String roleName,int roleRight){
		this.roleNumber=roleNumber;
		this.groupNumber=groupNumber;
		this.roleName=roleName;
		this.roleRight=roleRight;
	}
	public Roles(String roleNumber,String roleName){
		this.roleNumber=roleNumber;
		this.roleName=roleName;
	}
	public void setRoleNumber(String roleNumber){
		this.roleNumber=roleNumber;
	}
	public String getRoleNumber(){
		return this.roleNumber;
	}
	public void setGroupNumber(String groupNumber){
		this.groupNumber=groupNumber;
	}
	public String getGroupNumber(){
		return this.groupNumber;
	}
	public void setRoleName(String roleName){
		this.roleName=roleName;
	}
	public String getRoleName(){
		return this.roleName;
	}
	public void setRoleRight(int roleRight){
		this.roleRight=roleRight;
	}
	public int getRoleRight(){
		return this.roleRight;
	}
}