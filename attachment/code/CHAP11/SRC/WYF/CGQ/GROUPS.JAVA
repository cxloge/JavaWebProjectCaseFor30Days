package wyf.cgq;
public class Groups{
	private String groupNumber;
	private String deptNumber;
	private String groupName;
	public Groups(){
	}
	public Groups(String groupNumber,String deptNumber,String groupName){
		this.groupNumber=groupNumber;
		this.deptNumber=deptNumber;
		this.groupName=groupName;
	}
	public Groups(String groupNumber,String groupName){
		this.groupNumber=groupNumber;
		this.groupName=groupName;
	}
	public  void setGroupNumber(String groupNumber){
		this.groupNumber=groupNumber;
	}
	public String getGroupNumber(){
		return this.groupNumber;
	}
	public void setDeptNumber(String deptNumber){
		this.deptNumber=deptNumber;
	}
	public String getDeptNumber(){
		return this.deptNumber;
	}
	public void setGroupName(String groupName){
		this.groupName=groupName;
	}
	public String getGroupName(){
		return this.groupName;
	}
}