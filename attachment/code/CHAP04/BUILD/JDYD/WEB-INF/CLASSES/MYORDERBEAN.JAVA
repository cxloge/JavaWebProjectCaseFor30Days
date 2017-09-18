package wyf;
import java.util.*;
import javax.faces.event.*;
import javax.faces.model.*;
public class MyOrderBean extends FenYeBean{
	private UserLogBean ulb;		//用户登录Bean引用
	private List_Item li;			//要查看订单详情的订单对象
	public void setUlb(UserLogBean ulb){
		this.ulb = ulb;				//ulb的setter方法
	}
	public String getOrderId(){
		return this.li.getOId();	//返回查看详情的订单ID
	}
	@Override
	public String getSql(){
		sql = "select uname,OId,to_char(OTime,'yyyy-mm-dd') otime,OStatus,ODetail"+
			" from order_list,user_info where order_list.usid="+ulb.getUsid()+
			" and user_info.usid=order_list.usid";		//搜索登陆用户订单的SQL语句
		return (this.sql);								//返回该SQL语句
	}
	
	public DataModel getMyOrderList() {					//返回我的订单显示数据
		al = dbu.getOrderList(this.getSql(),this.getCurPage(),this.getSpan());
       	dm.setWrappedData(al);							//设置数据模型
       	return dm;										//返回数据模型
	}
	
	public DataModel getOrderDetail(){					//返回订单详情的显示数据
		sql = "select ORId,b.RId,b.rname,GName,b.st,b.end,b.status from group_info gi,"+
			"(select ORId,a.RId,ri.rname,ri.GId,a.st,a.end,a.status from res_info ri,("+
			"select ORId,RId,to_char(Start_Time,'yyyy-mm-dd') st,"+
			"to_char(End_Time,'yyyy-mm-dd') end,OStatus status from order_info "+
			"where OId="+li.getOId()+")a where a.RId=ri.RId)b where gi.GId=b.GId ";
		al = dbu.getOrderDetail(sql);					//执行查询得到订单详情数据
		dm.setWrappedData(al);							//设置数据模型
		return dm;										//返回显示数据
	}
	public String detail(){					//用户点击查看订单详情
		li = ((List_Item)dm.getRowData());	//得到查看详情的订单对象
		this.getOrderDetail();				//调用getOrderDetail方法
		return "success";					//返回success
	}
	
	public void cancle(){							//取消订单的方法
		li = (List_Item)dm.getRowData();			//得到取消的订单对象
		Vector<String> SQL = new Vector<String>();	//创建SQL数组
		sql = "delete from order_info where OId="+li.getOId();
		SQL.add(sql);								//将sql语句添加进向量
		sql = "delete from order_list where OId="+li.getOId();
		SQL.add(sql);								//将sql语句添加进向量
		dbu.update(SQL);							//执行更新
	}
	
	public void delete(){
		Info_Item ii = (Info_Item)dm.getRowData();	//得到取消的订单对象
		sql = "delete from order_info where ORId="+ii.getOrid();
		dbu.update(sql);							//执行更新
		sql = "select * from order_info where OId="+li.getOId();//查看该订单是否还有记录
		if(!dbu.isExist(sql)){
			al.removeAllElements();
			sql = "delete from order_list where OId="+li.getOId();
			dbu.update(sql);						//删掉订单表中该订单的记录			
		}
	}
}