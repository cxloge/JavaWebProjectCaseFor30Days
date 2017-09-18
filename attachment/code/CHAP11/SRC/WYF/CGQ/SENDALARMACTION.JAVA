package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import dojox.cometd.*;
public class SendAlarmAction extends SendAlarm1Action{
	private InsertDB insertDB;//声明InsertDB的引用
	private String title;//用于存放报警主题的属性
	private String detail;//用于存放报警详细内容的属性
	private String result;//用于存放发送结果的属性
	private String deptNumber;//用于存放报警部门的属性
	public void setInsertDB(InsertDB insertDB){//insertDB的setter方法
		this.insertDB=insertDB;
	}
	public void setTitle(String title){
		this.title=title;
	}//title属性的setter方法
	public String getTitle(){
		return this.title;
	}//title属性的getter方法
	public void setDeptNumber(String deptNumber){
		this.deptNumber=deptNumber;
	}//deptNumber属性的setter方法
	public String getDeptNumber(){
		return this.deptNumber;
	}//deptNumber属性的getter方法
	public void setDetail(String detail){
		this.detail=detail;
	}//detail属性的setter方法
	public String getDetail(){
		return this.detail;
	}//detail属性的getter方法
	public String getResult(){
		return this.result;
	}//result属性的getter方法
	public String execute(){
		String fromuser=((String)this.getSession().get("user")).trim();//获得发送者编号
		Alarm alarm=new Alarm();//创建一个Alarm对象
		alarm.setTitle(this.title);
		alarm.setDetail(this.detail);
		alarm.setTime(new Date());
		alarm.setFromuser(fromuser);
		alarm.setDeptNumber(this.deptNumber);//设置其相应的属性
		this.insertDB.saveAlarm(alarm);//将对象保存到数据库
		this.result="发送成功";//设置处理结果
		alarmComet();//调用alarmComet方法，发送即时报警
		return "success";
	}
	public Map getSession(){
		return ActionContext.getContext().getSession();
	}//获得session的方法
	private void alarmComet(){
		Bayeux b=(Bayeux)ActionContext.getContext().getApplication().get(Bayeux.DOJOX_COMETD_BAYEUX);
		Channel c= b.getChannel("/Alarm",true);//获得信道
		Map<String,String> message = new HashMap<String,String>();//常见一个map
		message.put("deptNumber",this.deptNumber);//将部门编号存入map
		c.publish(
			        b.newClient("server_user"),//发送的客户
			        message,//消息
			        "new_server_message" //消息id
			     );
	}
}