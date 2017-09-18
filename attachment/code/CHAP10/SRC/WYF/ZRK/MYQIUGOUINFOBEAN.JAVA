package wyf.zrk;

import java.util.*;
import javax.faces.model.*;

public class MyQiuGouInfoBean {
	private UserLoginBean ulb;
	private DButilDAOImpl db;
	private MySaleDetailBean msdb;
	private ModifyMyQiuGouInfoBean mmqgib;
	private DataModel dm = new ListDataModel();
	private boolean flag;
	private List<SaleInfo> list;
	
	public boolean isFlag() {
		return this.flag;
	}
	public void setMmqgib(ModifyMyQiuGouInfoBean mmqgib) {
		this.mmqgib = mmqgib;
	}
	public void setUlb(UserLoginBean ulb) {
		this.ulb = ulb;
	}
	public UserLoginBean getUlb() {
		return this.ulb;
	}
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public void setMsdb(MySaleDetailBean msdb) {
		this.msdb = msdb;
	}

	public String getInitList() {
		String type = "";
		try {
			type = new String("Çó¹º".getBytes(),"ISO-8859-1");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		int id = this.ulb.getUser().getU_id();
		String hql = "from SaleInfo as si where si.s_msgtype='"+type+"' and si.u_id="+id;
		list = (List<SaleInfo>)db.getInfo(hql);
		if(list.size()!=0) {
			this.flag = true;
		}
		else {
			this.flag = false;
		}
		for(SaleInfo si:list) {
			try {
				si.setS_msgtype(new String(si.getS_msgtype().getBytes("ISO-8859-1"),"gbk"));
				si.setS_detail(new String(si.getS_detail().getBytes("ISO-8859-1"),"gbk"));
				si.setS_location(new String(si.getS_location().getBytes("ISO-8859-1"),"gbk"));
				si.setS_type(new String(si.getS_type().getBytes("ISO-8859-1"),"gbk"));
				si.setS_wuye(new String(si.getS_wuye().getBytes("ISO-8859-1"),"gbk"));
				si.setS_remark(new String(si.getS_remark().getBytes("ISO-8859-1"),"gbk"));
				si.setS_linkman(new String(si.getS_linkman().getBytes("ISO-8859-1"),"gbk"));
				si.setS_address(new String(si.getS_address().getBytes("ISO-8859-1"),"gbk"));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	public DataModel getSaleList() {
		dm.setWrappedData(list);
		return dm;
	}
	public String getSelectList() {
		this.msdb.setSi((SaleInfo)dm.getRowData());
		return "myqiugoudetail";
	}
	
	public void deleteSaleObj() {
		SaleInfo si = (SaleInfo)dm.getRowData();
		String flag = db.deleteObj("saleinfo",si);
	}
	
	public String modifySaleObj() {
		this.mmqgib.setSi((SaleInfo)dm.getRowData());
		return "modifymyqiugouinfo";
	}
	
	
}