package wyf.zrk;

import java.util.*;
import javax.faces.model.*;

public class MyApplyInfoBean {
	private UserLoginBean ulb;
	private DButilDAOImpl db;
	private DataModel dm = new ListDataModel();
	private boolean showObj;
	private List<RelationToUserAndMsg> list;
	private MySaleDetailBean msdb;
	private MyRentDetailBean mrdb;
	
	public void setMrdb(MyRentDetailBean mrdb) {
		this.mrdb = mrdb;
	}
	public void setMsdb(MySaleDetailBean msdb) {
		this.msdb = msdb;
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
	public boolean getShowObj() {
		return this.showObj;
	}
	public String getInitList() {
		String hqlList = "from RelationToUserAndMsg as rm where rm.u_id="
							+this.ulb.getUser().getU_id();
		list = (List<RelationToUserAndMsg>)db.getInfo(hqlList);
		if(list.size()==0) {
			showObj = false;
		}
		else {
			showObj = true;
		}
		return "";
	}

	public DataModel getMyApplyList() {
		List<ApplyItem> ls = new ArrayList<ApplyItem>();
		try {
			for(int i=0;i<list.size();i++) {
				RelationToUserAndMsg rt = list.get(i);
				ApplyItem ai = new ApplyItem();
				ai.setId(rt.getRtuam_id());
				ai.setAgree(new String(rt.getR_agree().getBytes("ISO-8859-1"),"gbk"));
				String type = new String(rt.getR_type().getBytes("ISO-8859-1"),"gbk");
				ai.setMsgtype(type);
				if(type.equals("出租")||type.equals("求租")) {
					String hql = "from RentInfo as ri where ri.r_id="+rt.getS_id();
					List<RentInfo> tempList = (List<RentInfo>)db.getInfo(hql);
					if(tempList.size()!=0) {
						RentInfo ri = tempList.get(0);
						ai.setLocation(new String(ri.getR_location().getBytes("ISO-8859-1"),"gbk"));
						ai.setType(new String(ri.getR_type().getBytes("ISO-8859-1"),"gbk"));
					}
				}
				else {
					String hql = "from SaleInfo as si where si.s_id="+rt.getS_id();
					List<SaleInfo> tempList = (List<SaleInfo>)db.getInfo(hql);
					if(tempList.size()!=0) {
						SaleInfo si = tempList.get(0);
						ai.setLocation(new String(si.getS_location().getBytes("ISO-8859-1"),"gbk"));
						ai.setType(new String(si.getS_type().getBytes("ISO-8859-1"),"gbk"));
					}
				}
				ls.add(ai);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		this.dm.setWrappedData(ls);
		return dm;
	}
	
	public void deleteObj() {
		ApplyItem ai = (ApplyItem)dm.getRowData();
		String msg = this.db.deleteObj("relation",ai.getId());
	}
	
	public String showDetail() {
		String aim = "";
		ApplyItem ai = (ApplyItem)dm.getRowData();
		String hql = "from RelationToUserAndMsg as rt where rt.rtuam_id="+ai.getId();
		List<RelationToUserAndMsg> ls = (List<RelationToUserAndMsg>)db.getInfo(hql);
		if(ls.size()!=0) {
			RelationToUserAndMsg rt = ls.get(0);
			String msgtype = rt.getR_type();
			String isAgree = "是";
			try {
				isAgree = new String(isAgree.getBytes(),"ISO-8859-1");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			if(rt.getR_agree().equals(isAgree)) {
				try {
					msgtype = new String(msgtype.getBytes("ISO-8859-1"),"gbk");
					if(msgtype.equals("出售")) {
						String tempHql = "from SaleInfo as si where si.s_id="+rt.getS_id();
						List<SaleInfo> tempLs = (List<SaleInfo>)db.getInfo(tempHql);
						SaleInfo si = tempLs.get(0);
						si.setS_address(new String(si.getS_address().getBytes("ISO-8859-1"),"gbk"));
						si.setS_detail(new String(si.getS_detail().getBytes("ISO-8859-1"),"gbk"));
						si.setS_linkman(new String(si.getS_linkman().getBytes("ISO-8859-1"),"gbk"));
						si.setS_location(new String(si.getS_location().getBytes("ISO-8859-1"),"gbk"));
						si.setS_msgtype(new String(si.getS_msgtype().getBytes("ISO-8859-1"),"gbk"));
						si.setS_remark(new String(si.getS_remark().getBytes("ISO-8859-1"),"gbk"));
						si.setS_type(new String(si.getS_type().getBytes("ISO-8859-1"),"gbk"));
						si.setS_wuye(new String(si.getS_wuye().getBytes("ISO-8859-1"),"gbk"));
						this.msdb.setSi(si);
						aim = "mysaledetail";
					}
					else if(msgtype.equals("求购")) {
						String tempHql = "from SaleInfo as si where si.s_id="+rt.getS_id();
						List<SaleInfo> tempLs = (List<SaleInfo>)db.getInfo(tempHql);
						SaleInfo si = tempLs.get(0);
						si.setS_address(new String(si.getS_address().getBytes("ISO-8859-1"),"gbk"));
						si.setS_detail(new String(si.getS_detail().getBytes("ISO-8859-1"),"gbk"));
						si.setS_linkman(new String(si.getS_linkman().getBytes("ISO-8859-1"),"gbk"));
						si.setS_location(new String(si.getS_location().getBytes("ISO-8859-1"),"gbk"));
						si.setS_msgtype(new String(si.getS_msgtype().getBytes("ISO-8859-1"),"gbk"));
						si.setS_remark(new String(si.getS_remark().getBytes("ISO-8859-1"),"gbk"));
						si.setS_type(new String(si.getS_type().getBytes("ISO-8859-1"),"gbk"));
						si.setS_wuye(new String(si.getS_wuye().getBytes("ISO-8859-1"),"gbk"));
						this.msdb.setSi(si);
						aim = "myqiugoudetail";
					}
					else if(msgtype.equals("出租")) {
						String tempHql = "from RentInfo as ri where ri.r_id="+rt.getS_id();
						List<RentInfo> tempLs = (List<RentInfo>)db.getInfo(tempHql);
						RentInfo ri = tempLs.get(0);
						ri.setR_address(new String(ri.getR_address().getBytes("ISO-8859-1"),"gbk"));
						ri.setR_detail(new String(ri.getR_detail().getBytes("ISO-8859-1"),"gbk"));
						ri.setR_linkman(new String(ri.getR_linkman().getBytes("ISO-8859-1"),"gbk"));
						ri.setR_location(new String(ri.getR_location().getBytes("ISO-8859-1"),"gbk"));
						ri.setR_msgtype(new String(ri.getR_msgtype().getBytes("ISO-8859-1"),"gbk"));
						ri.setR_remark(new String(ri.getR_remark().getBytes("ISO-8859-1"),"gbk"));
						ri.setR_type(new String(ri.getR_type().getBytes("ISO-8859-1"),"gbk"));
						ri.setR_wuye(new String(ri.getR_wuye().getBytes("ISO-8859-1"),"gbk"));
						this.mrdb.setRi(ri);
						aim = "myrentdetail";						
					}
					else if(msgtype.equals("求租")) {
						String tempHql = "from RentInfo as ri where ri.r_id="+rt.getS_id();
						List<RentInfo> tempLs = (List<RentInfo>)db.getInfo(tempHql);
						RentInfo ri = tempLs.get(0);
						ri.setR_address(new String(ri.getR_address().getBytes("ISO-8859-1"),"gbk"));
						ri.setR_detail(new String(ri.getR_detail().getBytes("ISO-8859-1"),"gbk"));
						ri.setR_linkman(new String(ri.getR_linkman().getBytes("ISO-8859-1"),"gbk"));
						ri.setR_location(new String(ri.getR_location().getBytes("ISO-8859-1"),"gbk"));
						ri.setR_msgtype(new String(ri.getR_msgtype().getBytes("ISO-8859-1"),"gbk"));
						ri.setR_remark(new String(ri.getR_remark().getBytes("ISO-8859-1"),"gbk"));
						ri.setR_type(new String(ri.getR_type().getBytes("ISO-8859-1"),"gbk"));
						ri.setR_wuye(new String(ri.getR_wuye().getBytes("ISO-8859-1"),"gbk"));
						this.mrdb.setRi(ri);
						aim = "myqiuzudetail";						
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}				
			}

		}		
		return aim;
	}
	
		
}