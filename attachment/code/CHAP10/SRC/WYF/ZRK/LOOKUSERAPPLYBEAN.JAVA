package wyf.zrk;

import java.util.*;
import javax.faces.event.*;
import javax.faces.model.*;

public class LookUserApplyBean {
	private DataModel dm = new ListDataModel();
	private DButilDAOImpl db;
	private List<RelationToUserAndMsg> list;
	private boolean flag;
	private LookUserApplyDetailBean ladb;
	
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public boolean getFlag() {
		return this.flag;
	}
	public void setLadb(LookUserApplyDetailBean ladb) {
		this.ladb = ladb;
	}
	public String getInitList() {
		try {
			String hql = "from RelationToUserAndMsg as rt where rt.r_agree='"+
					new String("·ñ".getBytes(),"ISO-8859-1")+"'";
			list = (List<RelationToUserAndMsg>)db.getInfo(hql);
			if(list.size()!=0) {
				this.flag = true;
			}
			else {
				this.flag = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public DataModel getApplyList() {
		List<ApplyItem> ls = new ArrayList<ApplyItem>();
		try {
			for(RelationToUserAndMsg rt:list) {
				ApplyItem ai = new ApplyItem();
				ai.setId(rt.getRtuam_id());
				String type = new String(rt.getR_type().getBytes("ISO-8859-1"),"gbk");
				ai.setMsgtype(type);
				if(type.equals("³ö×â")||type.equals("Çó×â")) {
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
	
	public String getSelectObj() {
		ApplyItem ai = (ApplyItem)dm.getRowData();
		this.ladb.setAi(ai);
		return "detail";
	}
	
	
	
	
	
}