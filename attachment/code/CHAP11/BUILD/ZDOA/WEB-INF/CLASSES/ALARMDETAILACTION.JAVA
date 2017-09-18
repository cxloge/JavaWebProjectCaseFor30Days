package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import java.math.*;
public class AlarmDetailAction{
	private SearchDB searchDB;//声明SearchDB的引用
	private InsertDB insertDB;//声明InsertDB的引用
	private String alarmNumber;//用于存放报警编号的属性
	private Alarm alarm;//声明一个Alarm对象的引用
	private int currenPage;//获得CurrenPage
	public void setSearchDB(SearchDB searchDB){//searchDB的setter方法
		this.searchDB=searchDB;
	}
	public void setInsertDB(InsertDB insertDB){//insertDB的setter方法
		this.insertDB=insertDB;
	}
	public void setAlarmNumber(String alarmNumber){//报警编号的setter方法
		this.alarmNumber=alarmNumber.trim();
	}
	public Alarm getAlarm(){//获得Alarm对象的方法
		return this.alarm;
	}
	public void setCurrenPage(int currenPage){//currenPage的setter方法
		this.currenPage=currenPage;
	}
	public int getCurrenPage(){//currenPage的getter方法
		return this.currenPage;
	}
	public String execute(){//重写的execute方法
		String sql1="update oa_alarm set alarm_state=1 where alarm_number='"+this.alarmNumber+"'";
		this.insertDB.update(sql1);
		String sql2="select oa_alarm.alarm_title,oa_alarm.alarm_time,"+
					"oa_user.user_realname,oa_dept.dept_name,"+
					"oa_alarm.alarm_detail from "+
					"oa_alarm,oa_user,oa_dept where oa_alarm.alarm_fromuser="+
					"oa_user.user_number and oa_alarm.alarm_dept=oa_dept.dept_number "+
					"and oa_alarm.alarm_number='"+this.alarmNumber+"'";
		List list=this.searchDB.getArrayList(sql2);//调用searchDB的方法获得搜索列表
		Object[] o=(Object[])list.get(0);//获得第一个对象
		alarm=new Alarm((String)o[0],(Date)o[1],(String)o[2],
						(String)o[3],(String)o[4]);//组织Alarm对象
		return "success";//返回逻辑视图
	}
}