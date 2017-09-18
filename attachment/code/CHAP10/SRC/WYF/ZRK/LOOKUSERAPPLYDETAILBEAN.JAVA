package wyf.zrk;

import java.util.*;

public class LookUserApplyDetailBean {
	private ApplyItem ai;
	private DButilDAOImpl db;
	private String location;
	private String msgType;
	private String high;
	private String houseType;
	private String wuye;
	private double area;
	private String linkman;
	private String tel;
	private String email;
	private RelationToUserAndMsg rt;
	
	public void setAi(ApplyItem ai) {
		this.ai = ai;
	}
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public String getLocation() {
		return this.location;
	}
	public String getMsgType() {
		return this.msgType;
	}
	public String getHigh() {
		return this.high;
	}
	public String getHouseType() {
		return this.houseType;
	}
	public String getWuye() {
		return this.wuye;
	}
	public double getArea() {
		return this.area;
	}
	public String getLinkman() {
		return this.linkman;
	}
	public String getTel() {
		return this.tel;
	}
	public String getEmail() {
		return this.email;
	}
	
	public String getInitList() {
		try {
			String hql = "from RelationToUserAndMsg as rt where rt.rtuam_id="+ai.getId();
			List<RelationToUserAndMsg> ls = (List<RelationToUserAndMsg>)db.getInfo(hql);
			rt = ls.get(0);		
			String type = new String(rt.getR_type().getBytes("ISO-8859-1"),"gbk");
			this.linkman = new String(rt.getR_linkman().getBytes("ISO-8859-1"),"gbk");
			this.email = rt.getR_email();
			this.tel = rt.getR_tel();
			if(type.equals("Çó×â")) {
				String hqlRent = "from RentInfo as ri where ri.r_id="+rt.getS_id();
				List<RentInfo> tempList = (List<RentInfo>)db.getInfo(hqlRent);
				RentInfo ri = tempList.get(0);
				this.location = new String(ri.getR_address().getBytes("ISO-8859-1"),"gbk");
				this.msgType = new String(ri.getR_msgtype().getBytes("ISO-8859-1"),"gbk");
				this.high = new String(ri.getR_high().getBytes("ISO-8859-1"),"gbk");
				this.houseType = new String(ri.getR_type().getBytes("ISO-8859-1"),"gbk");
				this.wuye = new String(ri.getR_wuye().getBytes("ISO-8859-1"),"gbk");
				this.area = ri.getR_area();
			}
			else {
				String hqlSale = "from SaleInfo as si where si.s_id="+rt.getS_id();
				List<SaleInfo> tempList = (List<SaleInfo>)db.getInfo(hqlSale);
				SaleInfo si = tempList.get(0);
				this.location = new String(si.getS_address().getBytes("ISO-8859-1"),"gbk");
				this.msgType = new String(si.getS_msgtype().getBytes("ISO-8859-1"),"gbk");
				this.high = new String(si.getS_high().getBytes("ISO-8859-1"),"gbk");
				this.houseType = new String(si.getS_type().getBytes("ISO-8859-1"),"gbk");
				this.wuye = new String(si.getS_wuye().getBytes("ISO-8859-1"),"gbk");
				this.area = si.getS_area();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public String agree() {
		try {
			rt.setR_agree(new String("ÊÇ".getBytes(),"ISO-8859-1"));
			String msg = db.updateObj("relation",rt);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "userapply";
	}
	
	
	
	
	
	
	
}