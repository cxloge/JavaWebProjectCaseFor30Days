package wyf.cgq;
public class DocDept{
	private String deptName;
	private int deptState;
	public DocDept(){
	}
	public DocDept(String deptName,int deptState){
		this.deptName=deptName;
		this.deptState=deptState;
	}
	public String getDeptName(){
		return this.deptName;
	}
	public int getDeptState(){
		return this.deptState;
	}
}