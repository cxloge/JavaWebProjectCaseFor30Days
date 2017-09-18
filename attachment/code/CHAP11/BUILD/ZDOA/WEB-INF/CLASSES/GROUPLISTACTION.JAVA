package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import java.math.*;
public class GroupListAction{
	private SearchDB searchDB;
	private String dept;
	private List groupList;
	public void setSearchDB(SearchDB searchDB){
		this.searchDB=searchDB;
	}
	public void setDept(String dept){
		this.dept=dept;
	}
	public List getGroupList(){
		System.out.println("********"+this.groupList.size());
		this.groupList.add(0,new Groups("","Ñ¡Ôñ×é"));
		return this.groupList;	
	}
	public String execute(){
		String hql="from Groups g where g.deptNumber='"+dept+"'";
		this.groupList=this.searchDB.getInstanceList(hql);
		return "success";
	}
}
