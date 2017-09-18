package wyf;

import java.util.*;
import javax.faces.model.*;

public class OrderListBean extends FenYeBean{
	private AdminOrderBean aob;					//订单处理后台Bean引用
	private String oid = "";					//封装搜索订单的ID
	public void setOid(String oid){
		this.oid = oid;							//订单ID的setter方法
	}
	public String getOid(){
		return this.oid;						//订单ID的getter方法
	}
	
	public void setAob(AdminOrderBean aob){
		this.aob = aob;							//aob的setter方法
	}	
	
	@Override
	public String getSql() {					//返回搜索订单记录的SQL语句
		sql = "select uname,OId,to_char(OTime,'yyyy-mm-dd') otime,OStatus,ODetail"+
			" from order_list,user_info where user_info.usid=order_list.usid and OId "+
			"like '%"+this.oid+"%'";			//搜索订单记录的SQL语句
		return (this.sql);
	}
	
	public DataModel getOrderList() {					//显示记录集合
		al = dbu.getOrderList(this.getSql(),this.getCurPage(),this.getSpan());
       	dm.setWrappedData(al);							//设置数据模型 
       	return dm;										//返回显示数据
	}

	public String detail(){								//订单详情
		this.aob.setLi((List_Item)dm.getRowData());		//将该订单对象设置到AdminOrderBean对象中
		return "success";								//返回success
	}
}