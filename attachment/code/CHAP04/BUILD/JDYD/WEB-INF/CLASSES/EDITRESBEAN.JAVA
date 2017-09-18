package wyf;

import javax.faces.model.*;

import java.util.*;
import java.sql.*;
import org.springframework.jdbc.support.*;
import org.springframework.jdbc.core.*;

public class EditResBean extends BaseBean{
	private ResItem ri;						//要修改编辑的资源对象
	public void setRi(ResItem ri){
		this.ri = ri;						//ri属性的setter方法
	}
	
	public String getRname() {				//资源名称的getter方法
		return ri.getRname();
	}
	public void setRname(String rname) {	//资源名称的setter方法
		ri.setRname(rname);
	}
	public String getGid() {				//资源编号的getter方法
		return ri.getGid();
	}
	public void setGid(String gid) {		//资源编号的setter方法
		ri.setGid(gid);
	}
	public String getRspec() {				//资源规格的getter方法
		return ri.getRspec();
	}
	public void setRspec(String rspec) {	//资源规格的setter方法
		ri.setRspec(rspec);
	}
	public String getRdetail() {			//资源描述的getter方法
		return ri.getRdetail();
	}
	public void setRdetail(String rdetail) {//资源描述的setter方法
		ri.setRdetail(rdetail);
	}
	public String getRprice() {				//价格的getter方法
		return ri.getRprice();
	}
	public void setRprice(String rprice) {	//价格的setter方法
		ri.setRprice(rprice);
	}
	public String getRstatus() {			//状态的getter方法
		return ri.getRstatus();
	}
	public void setRstatus(String rstatus) {	//价格的setter方法
		ri.setRstatus(rstatus);
	}
	
	public SelectItem[] getTypeList(){		//资源类别下拉列表框选项
		return dbu.getResType();
	}
	
	public void editRes(){					//编辑资源的方法
		String sql = "select 1 from res_info where RName='"+ri.getRname()+"' and "+
			"RID!="+ri.getRid();			//查看该资源改过后的名字是否已被占用
		if(dbu.isExist(sql)){
			message = "资源名称已经存在，请重新编辑";	//被占用的提示信息
		}
		else{
			sql = "update res_info set RName='"+ri.getRname()+"',GId="+ri.getGid()+
				",RSpec='"+ri.getRspec()+"',RDetail='"+ri.getRdetail()+"',RPrice="+
				ri.getRprice()+",RStatus='"+ri.getRstatus()+"' where RId="+ri.getRid();
			if(dbu.update(sql)){
				message = "编辑保存成功";				//更新数据库成功
			}
			else{
				message = "未知错误，保存失败";			//更新失败
			}
		}
	}
}