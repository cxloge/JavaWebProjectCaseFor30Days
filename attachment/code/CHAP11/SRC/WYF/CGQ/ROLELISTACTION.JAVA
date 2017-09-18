package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import java.math.*;
public class RoleListAction{
	private SearchDB searchDB;
	private String group;
	private List roleList;
	public void setSearchDB(SearchDB searchDB){
		this.searchDB=searchDB;
	}
	public void setGroup(String group){
		this.group=group;
	}
	public List getRoleList(){
		this.roleList.add(0,new Roles("","Ñ¡Ôñ½ÇÉ«"));
		return this.roleList;	
	}
	public String execute(){
		String hql="from Roles r where r.groupNumber='"+group+"'";
		System.out.println(hql);
		this.roleList=this.searchDB.getInstanceList(hql);
		return "success";
	}
}
