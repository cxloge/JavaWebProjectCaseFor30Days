package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import java.math.*;
public class AttTimeAction{
	private SearchDB searchDB;
	private String startTime;
	private String endTime;
	public void setSearchDB(SearchDB searchDB){
		this.searchDB=searchDB;
	}
	public String getStartTime(){
		return this.startTime;
	}
	public String getEndTime(){
		return this.endTime;
	}
	public List getHourList(){
		List list=new ArrayList();
		for(int i=0;i<24;i++){
			list.add(i);
		}
		return list;
	}
	public List getMinList(){
		List list=new ArrayList();
		for(int i=0;i<60;i++){
			list.add(i);
		}
		return list;
	}
	public String execute(){
		String sql="select att_starthour,att_startmin,att_endhour,att_endmin "+
				"from oa_attendtime";
		List list=this.searchDB.getArrayList(sql);
		Object[] o=(Object[])list.get(0);
		this.startTime=((BigDecimal)o[0]).intValue()+"时"+((BigDecimal)o[1]).intValue()+"分";
		this.endTime=((BigDecimal)o[2]).intValue()+"时"+((BigDecimal)o[3]).intValue()+"分";
		return "success";
	}
}