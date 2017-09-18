package wyf.zrk;

import java.util.*;

public class ShowRentMsgBean {
	private InfoBean info;
	private DButilDAOImpl db;
	private UserLoginBean ulb;
	private RentInfo ri;
	private String msgtype;
	private String location;
	private String type;
	private String wuye;
	private double area;
	private int lease;
	private double price;
	private String high;
	private String publishtime;	
	private String linkman;
	private String email;
	private String tel;
	private String errMsg;
	private double longitude;
	private double latitude;
	
	public void setInfo(InfoBean info) {
		this.info = info;
	}
	public InfoBean getInfo() {
		return this.info;
	}
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public DButilDAOImpl getDb() {
		return this.db;
	}
	public void setUlb(UserLoginBean ulb) {
		this.ulb = ulb;
	}
	public UserLoginBean getUlb() {
		return this.ulb;
	}
	public void setRi(RentInfo ri) {
		this.ri = ri;
	}
	public RentInfo getRi() {
		return this.ri;
	}
	public String getMsgtype() {
		return this.ri.getR_msgtype();
	}
	public String getLocation() {
		return this.ri.getR_location();
	}
	public String getType() {
		return this.ri.getR_type();
	}
	public String getWuye() {
		return this.ri.getR_wuye();
	}
	public double getArea() {
		return this.ri.getR_area();
	}
	public int getLease() {
		return this.ri.getR_lease();
	}
	public double getPrice() {
		return this.ri.getR_price();
	}
	public String getHigh() {
		return this.ri.getR_high();
	}
	public String getPublishtime() {
		return this.ri.getR_publishtime().toString().substring(0,10);
	}
	public double getLongitude() {
		return this.ri.getR_longitude();
	}
	public double getLatitude() {
		return this.ri.getR_latitude();
	}
	
	
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getLinkman() {
		return this.linkman;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTel() {
		return this.tel;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getErrMsg() {
		String msg = this.errMsg;
		this.errMsg = "";
		return msg;
	}
	public String save() {
		String flag = "";
		if(!ulb.isFlag()) {
			errMsg = "¶Ô²»Æð£¬ÇëÄúÏÈµÇÂ¼£¡";
		}
		else {
			try {
				RelationToUserAndMsg rtuam = new RelationToUserAndMsg();
				rtuam.setR_type(new String(this.ri.getR_msgtype().getBytes(),"ISO-8859-1"));
				rtuam.setS_id(this.ri.getR_id());
				rtuam.setU_id(this.ri.getU_id());
				rtuam.setR_agree(new String("·ñ".getBytes(),"ISO-8859-1"));
				rtuam.setR_linkman(new String(this.linkman.getBytes(),"ISO-8859-1"));
				rtuam.setR_tel(this.tel);
				rtuam.setR_email(this.email);
				String msg = db.insertObj("relation",rtuam);
				if(msg.equals("yes")) {
					info.setMsg("¹§Ï²Äú£¬ÉêÇë³É¹¦£¡");
					flag = "apply";
				}
				else {
					errMsg = "ÉêÇëÊ§°Ü£¡";
					flag = "fail";
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	
	
	
}