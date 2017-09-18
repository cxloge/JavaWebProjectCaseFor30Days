package wyf;

import java.util.*;
import javax.faces.model.*;

public class ResManageBean extends FenYeBean{
	
	private int type;
	private String rname;		//查看资源状态的资源名
	private EditResBean erb;	//要修改的资源引用
	private boolean flag;		//是否搜索标志
	 
	public void setErb(EditResBean erb){
		this.erb = erb;			//依赖注入方法
	}
	public void setType(int type){
		this.flag = false;		//不是显示搜索结果
		this.type = type;		//设置显示分类
		this.setCurPage(1);		//设置当前显示第一页
		this.getResList();		//更新数据模型
	}
	public int getType(){
		return this.type;		//type的getter方法
	}
	public String getRname(){	//rname的getter方法
		return this.rname;
	}
	public void setRname(String rname){
		this.rname = rname;			//rname的setter方法
	}
	public String toResPage(){			//到资源列表页面的方法
		sql = "select min(GId) from group_info";
		this.setType(Integer.parseInt(dbu.getStringInfo(sql)));
		return "resManage";
	}
	
	@Override
	public String getSql() {			//返回搜索显示记录的SQL语句
		sql = "select RId,GId,RName,RSpec,RDetail,RPrice,RStatus from res_info where "+
			"GId="+getType();			//普通显示
		if(this.flag){									//搜索资源
			sql = "select RId,GId,RName,RSpec,RDetail,RPrice,RStatus from res_info where "+
			"RName like '%"+this.rname+"%'";	//搜索的SQL语句
		}
		return (this.sql);				//返回SQL语句
	}
	
	public DataModel getResList() {					//显示记录集合
		al = dbu.getResList(this.getSql(),this.getCurPage(),this.getSpan());
       	dm.setWrappedData(al);
       	return dm;
	}
	
	public DataModel getOrderList(){
		return this.dm;
	}
	
	public SelectItem[] getTypeList(){				//资源类别下拉列表框选项
		return dbu.getResType();
	}
	
	public String resStatus(){						//查看资源状态
		ResItem ri = (ResItem)dm.getRowData();		//得到要查看资源状态的资源对象
		this.rname = ri.getRname();					//设置rname属性值
		sql = "select to_char(start_time,'yyyy-mm-dd') as st,"+
			"to_char(end_time,'yyyy-mm-dd') as end,OStatus as "+
			"status from order_info where end_time-start_time>=0"+
			" and RId="+ri.getRid();			//搜索该资源已被预订的日期段
		al = dbu.getResOrderList(sql);			//执行查询
		dm.setWrappedData(al);					//设置数据
		return "resStatus";
	}
	
	public void delete(){
		ResItem ri = (ResItem)dm.getRowData();		//得到要查看资源状态的资源对象
		sql = "delete from res_info where RId="+ri.getRid();
		dbu.update(sql);
	}
	
	public String edit(){
		ResItem ri = (ResItem)dm.getRowData();		//得到要查看资源状态的资源对象
		erb.setRi(ri);								//设置erb的资源对象属性值
		return "success";
	}
	
	public void search(){				//搜索的方法
		this.flag = true;				//置搜索标志位为true
		this.getResList();				//更新显示模型
	}
}