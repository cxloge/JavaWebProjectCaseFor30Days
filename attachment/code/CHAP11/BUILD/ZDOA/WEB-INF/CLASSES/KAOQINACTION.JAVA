package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import java.math.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class KaoQinAction{
	private InsertDB insertDB;//声明InsertDB的引用
	private SearchDB searchDB;//声明SearchDB的引用
	private int type;//声明类型
	public void setInsertDB(InsertDB insertDB){//insertDB的setter方法
		this.insertDB=insertDB;
	}
	public void setSearchDB(SearchDB searchDB){//searchDB的setter方法
		this.searchDB=searchDB;
	}
	public void setType(int type){//type的setter方法
		this.type=type;
	}
	public String execute(){//重写的execute方法
		String user=((String)ActionContext.getContext().getSession().get("user")).trim();//获得用户编号
		String sql="select att_starthour,att_startmin,att_endhour,att_endmin "+
				"from oa_attendtime";//组着查询考勤时间的sql
		List list=this.searchDB.getArrayList(sql);//执行查询
		Object[] o=(Object[])list.get(0);//获得第一个对象
		Date date=new Date();//常见一个时间对象
		int hour=date.getHours();//获得现在的小时
		int min=date.getMinutes();//获得现在的分钟
		int sec=date.getSeconds();//获得现在的秒
		int year=date.getYear()+1900;//获得现在的年
		int month=date.getMonth()+1;//获得现在的月份
		String strmonth=month>9?(month+""):(0+""+month);//组织月分字符串
		int day=date.getDate();//获得天
		String strday=day>9?(day+""):(0+""+day);//组织天字符串
		if(type==0){//如果是0，表示是上午考勤
			int atthour=((java.math.BigDecimal)o[0]).intValue();//获得规定的考勤小时
			int attmin=((java.math.BigDecimal)o[1]).intValue();//获得规定的考勤分钟
			if(atthour>hour||(atthour==hour&&attmin>=min)){//如果是按时考勤
				String sql1="update oa_attinfo set att_startstate=2,att_starttime='"+
						hour+":"+min+":"+sec+"',att_startip='"+this.getIp()+"' where "+
						"att_user='"+user+"' and to_char(att_time,'YYYY-MM-DD')='"+
						year+"-"+strmonth+"-"+strday+"'";//组织sql语句
				this.insertDB.update(sql1);//执行更新的sql语句
			}
			else{//如果考勤迟到
				String sql2="update oa_attinfo set att_startstate=1,att_starttime='"+
						hour+":"+min+":"+sec+"',att_startip='"+this.getIp()+"' where "+
						"att_user='"+user+"' and to_char(att_time,'YYYY-MM-DD')='"+
						year+"-"+strmonth+"-"+strday+"'";//组织sql语句
				this.insertDB.update(sql2);//执行更新的sql语句
			}
		}
		else{//如果是1，表示是下午考勤
			int atthour=((java.math.BigDecimal)o[2]).intValue();//获得规定的考勤小时
			int attmin=((java.math.BigDecimal)o[3]).intValue();//获得规定的考勤分钟
			if(atthour>hour||(atthour==hour&&attmin>=min)){//如果是按时考勤
				String sql1="update oa_attinfo set att_endstate=1,att_endtime='"+
						hour+":"+min+":"+sec+"',att_endip='"+this.getIp()+"' where "+
						"att_user='"+user+"' and to_char(att_time,'YYYY-MM-DD')='"+
						year+"-"+strmonth+"-"+strday+"'";//组织sql语句
				this.insertDB.update(sql1);//执行更新的sql语句
			}
			else{//如果考勤迟到
				String sql2="update oa_attinfo set att_endstate=2,att_endtime='"+
						hour+":"+min+":"+sec+"',att_endip='"+this.getIp()+"' where "+
						"att_user='"+user+"' and to_char(att_time,'YYYY-MM-DD')='"+
						year+"-"+strmonth+"-"+strday+"'";//组织sql语句
				this.insertDB.update(sql2);//执行更新的sql语句
			}
		}
		return "success";//返回逻辑视图
	}
	public String getIp() {//获得客户端ip的方法
		HttpServletRequest req=ServletActionContext.getRequest();//获得HttpServletRequest
		String cip =req.getHeader("x-forwarded-for");//分情况获得ip
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