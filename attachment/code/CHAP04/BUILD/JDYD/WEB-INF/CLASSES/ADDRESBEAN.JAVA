package wyf;

import java.util.*;
import javax.faces.model.*;

public class AddResBean extends BaseBean{
	private String rname;		//资源名称
	private String gid;			//资源所属分组ID
	private String rspec;		//资源规格
	private String rdetail;		//资源描述
	private String rprice;		//价格
	private String rstatus;		//资源状态
	
	public String getRname() {
		return rname;						//rname的getter方法
	}
	public void setRname(String rname) {
		this.rname = rname;					//rname的setter方法
	}
	public String getGid() {
		return gid;							//gid的getter方法
	}
	public void setGid(String gid) {
		this.gid = gid;						//gid的setter方法
	}
	public String getRspec() {
		return rspec;						//rspec的getter方法
	}
	public void setRspec(String rspec) {
		this.rspec = rspec;					//rspec的setter方法
	}
	public String getRdetail() {
		return rdetail;						//rdetail的getter方法
	}
	public void setRdetail(String rdetail) {
		this.rdetail = rdetail;					//rdetail的setter方法
	}
	public String getRprice() {
		return rprice;							//rprice的getter方法
	}
	public void setRprice(String rprice) {
		this.rprice = rprice;					//rprice的setter方法
	}
	public String getRstatus() {
		return rstatus;							//rstatus的getter方法
	}
	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;					//rstatus的setter方法
	}
	
	
	public SelectItem[] getTypeList(){		
		return dbu.getResType();				//资源类别下拉列表框选项
	}
	
	public void addRes(){
		String sql = "select 1 from res_info where RName='"+this.rname+"'";
		if(dbu.isExist(sql)){					//判断添加的资源名是否已经存在
			message = "该资源名称已经存在，添加失败";
		}
		else{									//符合添加条件
			sql = "insert into res_info(GId,RName,RSpec,RDetail,RPrice) values("+this.gid+
				",'"+this.rname+"','"+this.rspec+"','"+this.rdetail+"',"+this.rprice+")";
			if(dbu.update(sql)){				//更新数据库
				message = "添加成功";			//添加成功提示信息
			}
			else{
				message = "未知错误，添加失败";	//添加失败提示信息
			}    
		}
	}
	
}
