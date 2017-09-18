package wyf;

import java.util.*;
import javax.faces.model.*;

public class AdminListBean extends FenYeBean{
	
	@Override
	public String getSql() {					//得到用于分页的SQL语句
		sql = "select AId,AName,ALevel from admin_info";
		return (this.sql);						//返回SQL语句
	}
	
	public DataModel getAdminList() {			//显示记录集合
		al = dbu.getAdminList(this.getSql(),this.getCurPage(),this.getSpan());
       	dm.setWrappedData(al);					//执行查询并设置数据 
       	return dm;								//返回显示数据
	}
	
	public void delete(){										//删除管理员的动作
		Admin_Item ai = (Admin_Item)dm.getRowData();			//得到要删除管理员对象
		sql = "delete form admin_info where AId="+ai.getAid();	//组成SQL语句
		dbu.update(sql);										//执行更新
	}
}