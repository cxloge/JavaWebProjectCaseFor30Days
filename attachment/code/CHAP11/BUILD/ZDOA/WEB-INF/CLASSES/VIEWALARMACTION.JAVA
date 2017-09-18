package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import java.math.*;
public class ViewAlarmAction extends FenYeAction{
	private String deptNumber="00000";//用于存储部门编号的属性
	private List deptList;//用于存放部门列表
	private String hqldept="from Dept";//搜索部门列表的hql语句
	public List getDeptList(){//获得部门列表的方法
		List list=this.getSearchDB().getInstanceList(hqldept);//获得部门列表
		list.add(0,new Dept("00000","查看全部"));//代表全部部门的选项
		return list;//返回部门列表
	}
	public void setDeptNumber(String deptNumber){//deptNumber的setter方法0
		this.deptNumber=deptNumber;
	}
	public List getAlarmList(){//获得报警列表的方法
		int begin=(this.getCurrenPage()-1)*this.getPageSpan();//开始的记录数
		int end=this.getCurrenPage()*this.getPageSpan();//结束的记录数
		String deptsql="";//存放部门条件的sql语句
		if(!this.deptNumber.equals("00000")){//如果部门编号不是表示全部
			deptsql=" and oa_alarm.alarm_dept='"+this.deptNumber+"' "; //添加部门条件的sql
		}
		String sql="select numbers,state,title,deptname,time,fromuser from("+
					"select rownum rn,numbers,state,title,deptname,time,fromuser from("+
					"select oa_alarm.alarm_number numbers,oa_alarm.alarm_title title,"+
					"oa_alarm.alarm_time time,oa_user.user_realname fromuser,"+
					"oa_alarm.alarm_state state,oa_dept.dept_name deptname from "+
					"oa_alarm,oa_user,oa_dept where oa_alarm.alarm_fromuser="+
					"oa_user.user_number and oa_alarm.alarm_dept=oa_dept.dept_number "+
					deptsql+"order by oa_alarm.alarm_time desc)) where rn>"+begin+" and rn<="+end;
		List list=this.getSearchDB().getArrayList(sql);//获得报警记录列表
		int size=list.size();//获得记录总条数
		List alarmlist=new ArrayList();//创建一个List
		for(int i=0;i<size;i++){//遍历获得的list
			Object[] o=(Object[])list.get(i);//获得其中一条记录
			Alarm alarm=new Alarm((String)o[0],((BigDecimal)o[1]).intValue(),(String)o[2],(String)o[3],
			(Date)o[4],(String)o[5]);//组织一个Alarm对象
			alarmlist.add(alarm);//放入前面创建的list中
		}
		return alarmlist;//返回报警记录列表
	}
	public String execute(){
		this.updateInfo();//调用updateInfo方法，更新最大页
		return "success";
	}
	public void updateInfo(){
		String deptSql="";//存放部门条件的sql语句
		if(!this.deptNumber.equals("00000")){//如果部门编号不是表示全部
			deptSql="where oa_alarm.alarm_dept='"+this.deptNumber+"' "; 
		}
		String sql="select count(*) from oa_alarm "+deptSql;//组织sql语句
		List list=this.getSearchDB().getArrayList(sql);//获得搜索列表
		int total=((BigDecimal)list.get(0)).intValue();//取得记录总条数
		this.setMaxPage(total%this.getPageSpan()==0?total/this.getPageSpan():(total/this.getPageSpan()+1));
	}
}