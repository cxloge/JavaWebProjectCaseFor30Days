package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import org.apache.struts2.*;
import java.math.*;
public class ChangeAttAction{
	private InsertDB insertDB;//声明insertDB的引用
	private String startHour;//用于存放开始小时的属性
	private String startMin;//用于存放开始分钟的属性
	private String endHour;//用于存放结束小时的属性
	private String endMin;//用于存放结束分钟的属性
	public void setInsertDB(InsertDB insertDB){//insertDB的setter方法
		this.insertDB=insertDB;
	}
	public void setStartHour(String startHour){//开始小时的setter方法
		this.startHour=startHour;
	}
	public void setStartMin(String startMin){//开始分钟的setter方法
		this.startMin=startMin;
	}
	public void setEndHour(String endHour){//结束小时的setter方法
		this.endHour=endHour;
	}
	public void setEndMin(String endMin){//结束分钟的setter方法
		this.endMin=endMin;
	}
	public String execute(){//重写的execute方法
		String sql="update oa_attendtime set att_starthour="+this.startHour+
					",att_startmin="+this.startMin+",att_endhour="+this.endHour+
					",att_endmin="+this.endMin;//组织更改记录的sql语句
		int i=insertDB.update(sql);//调用update方法更新记录
		return "success";//返回逻辑视图
	}
}
