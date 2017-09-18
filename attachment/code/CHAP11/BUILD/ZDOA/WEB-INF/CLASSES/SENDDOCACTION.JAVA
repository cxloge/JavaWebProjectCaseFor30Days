package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
public class SendDocAction extends ActionSupport{
	private SearchDB searchDB;
	private List deptList;
	private String hqldept="from Dept";
	private String result="";
	public void setSearchDB(SearchDB searchDB){
		this.searchDB=searchDB;
	}
	public SearchDB getSearchDB(){
		return this.searchDB;
	}
	public List getDeptList(){
		List list=searchDB.getInstanceList(hqldept);
		return list;
	}
	public void setResult(String result){
		this.result=result;
	}
	public String getResult(){
		return this.result;
	}
	public String execute(){
		return "success";
	}
	public Map getSession(){
		return ActionContext.getContext().getSession();
	}
}