package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import org.apache.struts2.*;
import java.math.*;
public class DelAlarmAction extends ViewAlarmAction{
	private List<String> delList;
	private int currenPage;
	public int getCurrenPage(){
		return this.currenPage;
	}
	public void setCurrenPage(int currenPage){
		this.currenPage=currenPage;
	}
	public void setDelList(List delList){
		this.delList=delList;
	}
	public String execute(){
		this.delete();
		return "success";
	}
	public void delete(){
		if(delList!=null){
			this.getInsertDB().delAlarmList(delList);
		}
		
	}

}
