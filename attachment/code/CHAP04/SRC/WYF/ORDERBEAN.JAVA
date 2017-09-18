package wyf;
import java.util.*;
import javax.faces.event.*;
import javax.faces.context.*;
import javax.faces.event.*;
import javax.faces.model.*;
import java.sql.*;
import org.springframework.jdbc.core.*;
public class OrderBean extends BaseBean{
	Vector<Info_Item> v = new Vector<Info_Item>();	//存放订单明细
	protected DataModel dm=new ListDataModel();
	private boolean isSubmit;						//订单是否提交标志
	private JdbcTemplate jt;						//声明JdbcTemplate引用
	private UserLogBean ulb;	//记录用户登陆信息的Bean引用
	private String start;		//封装用户输入的预订开始时间
	private String end;			//封装用户输入的预订结束时间
	private String rid;			//用户要预订资源的编号
	private String rname;		//用户要预订资源的名称
	
	
	public void setUlb(UserLogBean ulb){
		this.ulb = ulb;			//接受ulb依赖注入的setter方法
	}
	public void setJt(JdbcTemplate jt){
		this.jt = jt;			//接受jt依赖注入的setter方法
	}
	public String getStart(){
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		String sql = "select RName from res_info where rid="+rid;
		this.rname = dbu.getStringInfo(sql);		//查询得到资源名称
		this.rid = rid;								//设置rid属性值
	}
		
	public void addToOrder(){								//添加到订单方法
		Info_Item ii = new Info_Item(rid,rname,start,end);	//创建订单记录对象
		v.add(ii);											//将订单记录添加到向量
		this.isSubmit = false;								//设置是否提交标志位为false
	}
	
	public DataModel getOrderList() {			//用于得到当前订单数据模型的方法
       	dm.setWrappedData(v);					//设置DataModel
       	return dm;								//返回DataModel值
	}
	
	public void remove(ActionEvent e){			//删除某一条预订详情的方法
		this.v.remove(dm.getRowData());			//删除用户选择的某一条记录
	}
		
	public void removeAll(){					//清空当前订单方法
		v.removeAllElements();					//清空存储订单的向量
	}
	
	public String submitOrder(){
		if(ulb.getUsid()==null){				//要提交订单则首先判断用户是否登录
			ulb.setTarget(true);				//登陆后跳转的页面
			return "LOGIN";						//返回LOGIN视图			
		}
		String sql = "select max(OId) from order_list";	//查询到主键最大值的SQL语句
		int oid = jt.queryForInt(sql)+1;				//执行查询得到结果并加一
		sql = "insert into order_list(OId,usid,OTime) values("+oid+","+ulb.getUsid()+",sysdate)";
		Vector<String> SQL = new Vector<String>();		//创建SQL语句向量
		SQL.add(sql);									//将SQL语句添加到向量
		for(int i=0;i<v.size();i++){
			Info_Item ii = v.get(i);						//得到订单信息对象
			sql = "insert into order_info(OId,RID,Start_Time,End_Time) values("+
				oid+","+ii.getRid()+",to_date('"+ii.getStart()+"','yyyy-mm-dd'),"+
				"to_date('"+ii.getEnd()+"','yyyy-mm-dd'))";	//组合成插入数据库的SQL语句
			SQL.add(sql);									//将SQL语句添加到向量
		}
		if(dbu.update(SQL)){
			this.isSubmit = true;							//订单已经提交
			v.removeAllElements();							//清空当前订单
			this.message = "订单提交成功，欢迎您再次光临";	//给出提示信息
		}
		else{
			message = "未知错误，订单提交失败";				//如果更新失败则提示错误
		}
		return "SUCCESS";
	}
	
	public boolean getSubmit(){
		return this.isSubmit;
	}
	
	public int getSize(){
		return v.size();
	}
}