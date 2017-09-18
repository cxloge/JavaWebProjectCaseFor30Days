package wyf;

import java.util.*;
import javax.faces.model.*;

public class UserListBean extends FenYeBean{
	
	private String uname = "";				//用于搜索用户的用户名
	
	public void setUname(String uname){		//uname的setter方法
		this.uname = uname;
	}
	public String getUname(){				//uname的getter方法
		return this.uname;
	}
	
	@Override
	public String getSql() {				//搜索用户的SQL语句
		sql = "select usid,uname,ugender,uemail,uphone from user_info where "+
			"uname like '%"+this.uname+"%'";
		return (this.sql);					//返会该SQL语句
	}
	
	public DataModel getUserList() {		//显示记录集合
		al = dbu.getUserList(this.getSql(),this.getCurPage(),this.getSpan());
       	dm.setWrappedData(al);				//设置显示数据模型
       	return dm;							//返回现实数据
	}
	
	public void delete(){							//删除用户的操作
		User_Item ui = (User_Item)dm.getRowData();	//得到要删除用户对象
		sql = "delete from user_info where usid="+ui.getUsid();
		dbu.update(sql);							//更新数据库
	}
	
}