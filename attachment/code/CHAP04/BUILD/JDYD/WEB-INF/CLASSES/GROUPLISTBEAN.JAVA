package wyf;

import java.util.*;
import javax.faces.model.*;

public class GroupListBean extends BaseBean{
	
	private DataModel dm=new ListDataModel();
    private Vector al = new Vector();			//显示记录的集合
    private String sql;							//声明SQL语句引用
    private String gname;						//添加的分组名字
    public String getGname(){					//gname的getter方法		
    	return this.gname;	
    }	
    public void setGname(String gname){			//gname的getter方法
    	this.gname = gname;
    }
	public DataModel getGroupList() {			//显示记录集合
       	return dm;
	}
	
	public String initialGroup(){
		sql = "select GId,GName from group_info";		//搜索分组的SQL语句
		al = dbu.getGroupList(sql);						//执行搜索得到数据
       	dm.setWrappedData(al);							//设置数据模型
       	return "groupManage";							//返回分组管理页面视图
	}
	
	public void addGroup(){								
		sql = "select 1 from group_info where GName='"+gname+"'";
		if(dbu.isExist(sql)){							//该分组名已经存在
			message = "该分组名已经存在，添加失败";		//添加失败信息
		}
		else{											//符合添加条件
			sql = "insert into group_info(GName) values('"+gname+"')";
			if(dbu.update(sql)){						//执行更新
				message = "分组<"+gname+">添加成功";	//添加成功
			}
			else{
				message = "未知错误，添加失败";			//添加失败提示信息
			}
		}
		this.initialGroup();				//更新分组显示的数据模型
	}
	
	public void delete(){							//删除分组的方法
		GroupItem gi = (GroupItem)dm.getRowData();	//得到要删除分组的行对象		
		Vector<String> SQL = new Vector<String>();	
		sql = "delete from res_info where GId="+gi.getGid();
		SQL.add(sql);
		sql = "delete from group_info where GId="+gi.getGid();
		SQL.add(sql);
		if(dbu.update(SQL)){						//数据库更新成功
			al.remove(gi);							//更新页面数据
			message = "分组<"+gi.getGname()+">删除成功";
		}
		else{
			message = "该分组不可删除";				//不可删除提示信息
		}
	}
	public int getSize(){							//返回分组记录条数
		return al.size();
	}
}			