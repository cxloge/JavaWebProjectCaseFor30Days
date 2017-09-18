package wyf.zrk;

import java.util.*;
import javax.faces.model.*;

public class MyRentInfoBean {
	private UserLoginBean ulb;
	private DButilDAOImpl db;
	private MyRentDetailBean mrdb;
	private ModifyMyRentInfoBean mmrib;
	private DataModel dm = new ListDataModel();
	private boolean flag;
	private List<RentInfo> list;
	
	public void setMmrib(ModifyMyRentInfoBean mmrib) {
		this.mmrib = mmrib;
	}
	public void setUlb(UserLoginBean ulb) {
		this.ulb = ulb;
	}
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public void setMrdb(MyRentDetailBean mrdb) {
		this.mrdb = mrdb;
	}
	public boolean isFlag() {
		return this.flag;
	}
	
	public String getInitList() {
		String type = "";
		try {
			type = new String("Гізт".getBytes(),"ISO-8859-1");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		int id = this.ulb.getUser().getU_id();
		String hql = "from RentInfo as ri where ri.r_msgtype='"+type+"' and ri.u_id="+id;
		list = (List<RentInfo>)db.getInfo(hql);
		if(list.size()!=0) {
			this.flag = true;
		}
		else {
			this.flag = false;
		}
		try {
			for(RentInfo ri:list) {
				ri.setR_msgtype(new String(ri.getR_msgtype().getBytes("ISO-8859-1"),"gbk"));
				ri.setR_address(new String(ri.getR_address().getBytes("ISO-8859-1"),"gbk"));
				ri.setR_detail(new String(ri.getR_detail().getBytes("ISO-8859-1"),"gbk"));
				ri.setR_linkman(new String(ri.getR_linkman().getBytes("ISO-8859-1"),"gbk"));
				ri.setR_location(new String(ri.getR_location().getBytes("ISO-8859-1"),"gbk"));
				ri.setR_remark(new String(ri.getR_remark().getBytes("ISO-8859-1"),"gbk"));
				ri.setR_type(new String(ri.getR_type().getBytes("ISO-8859-1"),"gbk"));
				ri.setR_wuye(new String(ri.getR_wuye().getBytes("ISO-8859-1"),"gbk"));				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public DataModel getRentList() {
		dm.setWrappedData(list);
		return dm;
	}
	
	public String getSelectObj() {
		RentInfo ri = (RentInfo)dm.getRowData();
		this.mrdb.setRi(ri);
		return "myrentdetail";
	}
	public void deleteRentObj() {
		RentInfo ri = (RentInfo)dm.getRowData();
		String flag = db.deleteObj("rentinfo",ri);
	}
	public String modifyRentObj() {
		this.mmrib.setRi((RentInfo)dm.getRowData());
		return "modifymyrentinfo";
	}	
	
	
}