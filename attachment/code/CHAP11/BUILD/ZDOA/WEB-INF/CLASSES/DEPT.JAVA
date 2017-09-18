package wyf.cgq;
public class Dept{
	private String deptNumber;//用于存储部门编号的属性
	private String deptName;//用于存储部门名称的属性
	public Dept(){
	}//无参构造器
	public Dept(String deptNumber,String deptName){//有参构造器
		this.deptNumber=deptNumber;
		this.deptName=deptName;
	}
	public void setDeptNumber(String deptNumber){//deptNumber的setter方法
		this.deptNumber=deptNumber;
	}
	public String getDeptNumber(){//deptNumber的getter方法
		return this.deptNumber;
	}
	public void setDeptName(String deptName){//deptName的setter方法
		this.deptName=deptName;
	}
	public String getDeptName(){//deptname的getter方法
		return this.deptName;
	}
}