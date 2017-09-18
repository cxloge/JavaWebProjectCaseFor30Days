package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import java.math.*;
public class ViewAttAction extends FenYeAction{
	
	public List getAttList(){
		int begin=(this.getCurrenPage()-1)*this.getPageSpan();
		int end=this.getCurrenPage()*this.getPageSpan();
		System.out.println(begin+"%%%%%%%%%%%"+end);
		String sql="select attTime,attName,deptName,startState,startTime,startIp,endState,endTime,endIp from("+
				"select rownum rn,attTime,attName,deptName,startState,startTime,startIp,endState,endTime,endIp from ("+
				"select to_char(oa_attinfo.att_time,'YYYY\"Äê\"MM\"ÔÂ\"DD\"ÈÕ\"') attTime,"+
				"oa_user.user_realname attName,oa_dept.dept_name deptName,"+
				"oa_attinfo.att_startstate startState,oa_attinfo.att_starttime startTime,"+
				"oa_attinfo.att_startip startIp,oa_attinfo.att_endstate endState,"+
				"oa_attinfo.att_endtime endTime,oa_attinfo.att_endip endIp from "+
				"oa_user,oa_dept,oa_attinfo where oa_attinfo.att_user=oa_user.user_number "+
				"and oa_user.dept_number=oa_dept.dept_number order by oa_attinfo.att_time "+
				"desc))  where rn>"+begin+" and rn<="+end;
		System.out.println(sql);
		List list=this.getSearchDB().getArrayList(sql);
		int size=list.size();
		List attlist=new ArrayList();
		for(int i=0;i<size;i++){
			Object[] o=(Object[])list.get(i);
			Attinfo att=new Attinfo((String)o[1],(String)o[0],(String)o[2],(String)o[8],
			((BigDecimal)o[6]).intValue(),(String)o[7],(String)o[5],((BigDecimal)o[3]).intValue(),(String)o[4]);
			attlist.add(att);
		}
		System.out.println(attlist.size());
		return attlist;
	}
	public String execute(){
		this.updateInfo();
		return "success";
	}
	public void updateInfo(){
		String sql="select count(*) from oa_attinfo";
		List list=this.getSearchDB().getArrayList(sql);
		int total=((BigDecimal)list.get(0)).intValue();
		this.setMaxPage(total%this.getPageSpan()==0?total/this.getPageSpan():(total/this.getPageSpan()+1));
	}
}