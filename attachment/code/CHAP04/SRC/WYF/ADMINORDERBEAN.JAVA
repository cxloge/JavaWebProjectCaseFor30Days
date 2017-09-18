package wyf;

import java.util.*;
import javax.faces.model.*;

public class AdminOrderBean extends BaseBean{
	private List_Item li;								//查看订单详情的订单对象引用
	private Vector al;									//存放订单详情数据的向量
	private DataModel dm=new ListDataModel();			//创建ListDataModel对象
	public void setLi(List_Item li){
		this.li = li;									//设置订单对象值
	}
	public String getOrderId(){
		return this.li.getOId();						//得到订单编号的方法
	}
	
	public void setStatus(String status){
		li.setOStatus(status);							//订单状态的setter方法
	}
	public String getStatus(){
		return li.getOStatus();							//订单状态的getter方法
	}
	
	public void setDetail(String detail){
		li.setODetail(detail);							//订单描述的setter方法
	}
	public String getDetail(){
		return li.getODetail();							//订单描述的getter方法
	}
	
	
	public DataModel getOrderDetail(){					//得到订单详情的方法
		String sql = "select ORId,b.RId,b.rname,GName,b.st,b.end,b.status from group_info gi,"+
			"(select ORId,a.RId,ri.rname,ri.GId,a.st,a.end,a.status from res_info ri,("+
			"select ORId,RId,to_char(Start_Time,'yyyy-mm-dd') st,"+
			"to_char(End_Time,'yyyy-mm-dd') end,OStatus status from order_info "+
			"where OId="+li.getOId()+")a where a.RId=ri.RId)b where gi.GId=b.GId ";
		al = dbu.getOrderDetail(sql);					//执行查询得到详情数据
		dm.setWrappedData(al);							//设置数据
		return dm;										//返回数据模型
	}
	
	public void deal(){									//处理订单的方法
		Vector<String> SQL = new Vector<String>();
		String sql = "update order_info set OStatus='"+this.getStatus()+"' where OId="+li.getOId();	
		SQL.add(sql);									//将SQL语句添加到向量
		sql = "update order_list set OStatus='"+this.getStatus()+"',ODetail='"+this.getDetail()+
			"' where OId="+li.getOId();
		SQL.add(sql);									//将SQL语句添加到向量
		if(dbu.update(SQL)){
			message = "订单处理成功";					//订单处理成功提示消息
		}
		else{
			message = "未知错误，订单处理失败";			//处理失败提示消息
		}
	}
	
	public int getSize(){								//返回订单详情记录条数的方法
		this.getOrderDetail();							//调用更新订单详情方法
		return al.size();								//返回记录条数
	}
}