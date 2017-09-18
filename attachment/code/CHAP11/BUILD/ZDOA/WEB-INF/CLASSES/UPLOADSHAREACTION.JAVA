package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
public class UploadShareAction extends ActionSupport{
	private SearchDB searchDB;
	private String hqltype="from ShareType";
	public void setSearchDB(SearchDB searchDB){
		this.searchDB=searchDB;
	}
	public List getTypeList(){
		List list=searchDB.getInstanceList(hqltype);
		return list;
	}
	public String execute(){
		return "success";
	}
	public Map getSession(){
		return ActionContext.getContext().getSession();
	}
}