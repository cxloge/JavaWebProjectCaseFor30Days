package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import java.math.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class AttOnlineAction{
	private SearchDB searchDB;
	private String attUser;
	private String attDept;
	private int attStart;
	private int attEnd;
	private String start;
	private String end;
	private String cIp;
	public void setSearchDB(SearchDB searchDB){
		this.searchDB=searchDB;
	}
	public String getAttUser(){
		return this.attUser;
	}
	public String getAttDept(){
		return this.attDept;
	}
	public int getAttStart(){
		return this.attStart;
	}
	public int getAttEnd(){
		return this.attEnd;
	}
	public String getStart(){
		return this.start;
	}
	public String getEnd(){
		return this.end;
	}
	public String getCIp(){
		return this.cIp;
	}
	public String execute(){
		String user=((String)(ActionContext.getContext().getSession().get("user"))).trim();
		Date d=new Date();
		String strmonth="";
		String strdate="";
		int year=d.getYear()+1900;
		int month=d.getMonth()+1;
		if(month<10){strmonth=0+""+month;}
		else{strmonth=month+"";}
		int date=d.getDate();
		if(date<10){strdate=0+""+date;}
		else{strdate=date+"";}
		String sql="select oa_attinfo.att_startstate,oa_attinfo.att_endstate,"+
				"oa_user.user_realname,oa_dept.dept_name,oa_attendtime.att_starthour,"+
				"oa_attendtime.att_startmin,oa_attendtime.att_endhour,"+
				"oa_attendtime.att_endmin from oa_attinfo,oa_user,"+
				"oa_dept,oa_attendtime where to_char(oa_attinfo.att_time,'YYYY-MM-DD')='"+
					year+"-"+strmonth+"-"+strdate+"' and oa_attinfo.att_user='"+
				user+"' and oa_attinfo.att_user=oa_user.user_number and "+
				"oa_user.dept_number=oa_dept.dept_number";
		List list=this.searchDB.getArrayList(sql);
		System.out.println(list.size()+"####################");
		Object[] o=(Object[])list.get(0);
		this.attUser=(String)o[2];
		this.attDept=(String)o[3];
		this.attStart=((BigDecimal)o[0]).intValue();
		this.attEnd=((BigDecimal)o[1]).intValue();
		this.start=((BigDecimal)o[4]).intValue()+"点"+((BigDecimal)o[5]).intValue()+"分";
		this.end=((BigDecimal)o[6]).intValue()+"点"+((BigDecimal)o[7]).intValue()+"分";
		this.cIp=this.getIp();
		return "success";
	}
	public String getIp() {
		HttpServletRequest req=ServletActionContext.getRequest();
		String cip =req.getHeader("x-forwarded-for");
		if(cip == null || cip.length() == 0 || "unknown".equalsIgnoreCase(cip)) {
			cip =req.getHeader("Proxy-Client-IP");
		}
		if(cip == null || cip.length() == 0 || "unknown".equalsIgnoreCase(cip)) {
			cip =req.getHeader("WL-Proxy-Client-IP");
		}
		if(cip == null || cip.length() == 0 || "unknown".equalsIgnoreCase(cip)) {
			cip = req.getRemoteAddr();
		}
		return cip;
	}
	
}