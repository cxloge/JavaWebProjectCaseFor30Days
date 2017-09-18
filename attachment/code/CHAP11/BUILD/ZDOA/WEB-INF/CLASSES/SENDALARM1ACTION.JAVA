package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
public class SendAlarm1Action extends ActionSupport{
	private SearchDB searchDB;//声明SearchDB的引用
	private List deptList;//用于存放部门列表
	private String hqldept="from Dept";//搜索部门的Hql语句
	public void setSearchDB(SearchDB searchDB){//searchDB的setter方法
		this.searchDB=searchDB;
	}
	public List getDeptList(){//获得部门列表的方法
		List list=searchDB.getInstanceList(hqldept);//调用searchDB的相应方法
		list.add(0,new Dept(null,"选择部门"));//添加一个用于提示的信息
		return list;//返回部门列表
	}
	public String execute(){
		return "success";
	}
}