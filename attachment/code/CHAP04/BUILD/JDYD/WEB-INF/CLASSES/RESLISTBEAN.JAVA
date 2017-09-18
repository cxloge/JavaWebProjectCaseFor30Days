package wyf;

import java.util.*;
import javax.faces.model.*;

public class ResListBean extends FenYeBean{
	
	private int type;					//资源类别，默认显示客房	
	private boolean isOrder;			//资源是否可被预订的标志位
	private String rname;				//查看资源状态的资源名
	public String getTypeName(){
		sql = "select GName from group_info where GId="+this.getType();
		return dbu.getStringInfo(sql);
	}
	
	public void setType(int type){	//显示类别设置
		this.type = type;
		this.setCurPage(1);			//设置当前显示第一页
	}
	public int getType(){
		return this.type;			
	}
	public boolean getIsOrder(){		
		return this.isOrder;
	}
	public String getRname(){
		return this.rname;
	}
	
	public String toOrderPage(){
		sql = "select min(GId) from group_info";	//默认显示第一个分组的资源
		this.setType(Integer.parseInt(dbu.getStringInfo(sql)));		
		return "resList";							//返回资源列表页面显示
	}
	@Override
	public String getSql() {						//返回搜索可预订资源的SQL语句
		sql = "select RId,GId,RName,RSpec,RDetail,RPrice,RStatus from res_info where "+
			"RStatus='空闲' and RId not in(select RId from order_info where "+
			"OStatus='预定中') and GId="+getType();
		return (this.sql);							//返回此条SQL语句
	}
	
	public DataModel getResList() {					//显示记录集合
		al = dbu.getResList(this.getSql(),this.getCurPage(),this.getSpan());
       	dm.setWrappedData(al);						//设置数据模型
       	return dm;									//返回数据模型
	}
	
	public DataModel getOrderList(){
		return this.dm;
	}
	
	public SelectItem[] getTypeList(){				//资源类别下拉列表框选项
		return dbu.getResType();
	}
	
	public SelectItem[] getRidList(){				 //资源名称下拉列表框选项
		SelectItem[] list=new SelectItem[al.size()]; //创建SelectItem类型数组	
		for(int i=0;i<al.size();i++){
			ResItem ri = (ResItem)al.get(i);		//得到ResItem对象
			int rid = Integer.valueOf(ri.getRid());	//将ResItem对象的rid属性转换成int型
			String rname = ri.getRname();			//得到ResItem的rname属性值
			list[i]=new SelectItem(rid,rname);		//创建SelectItem对象
		}
		return list;								//返回SelectItem数组
	}
	
	public String resStatus(){						//查看资源状态
		ResItem ri = (ResItem)dm.getRowData();		//得到要查看资源状态的资源对象
		this.rname = ri.getRname();					//设置rname属性值
		sql = "select * from order_info where OStatus='预定中' and RId="+ri.getRid();
		if(dbu.isExist(sql)){						//如果该资源有预定中的订单
			this.isOrder = false;					//则该资源不可再下订单
		}
		else{
			this.isOrder = true;					//该资源可预订
			sql = "select to_char(start_time,'yyyy-mm-dd') as st,"+
				"to_char(end_time,'yyyy-mm-dd') as end,OStatus as "+
				"status from order_info where end_time-start_time>=0"+
				" and RId="+ri.getRid();			//搜索该资源已被预订的日期段			
			al = dbu.getResOrderList(sql);			//执行查询
			dm.setWrappedData(al);					//设置数据
		}
		return "success";
	}
}