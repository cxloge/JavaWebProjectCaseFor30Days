package wyf.zrk;

import java.util.*;

public class ModifyMyQiuGouInfoBean {
	private UserLoginBean ulb;
	private DButilDAOImpl db;
	private SaleInfo si;
	private InfoBean info;
	private String msgtype;
	private String location;
	private String detail;
	private String wuye;
	private String type;
	private double area;
	private double price;
	private String linkman;
	private String address;
	private String tel;
	private String email;
	private String remark;
	private String high;
	public void setSi(SaleInfo si) {
		this.si = si;
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
	public DButilDAOImpl getDb() {
		return this.db;
	}
	public void setInfo(InfoBean ib) {
		this.info = ib;
	}
	public InfoBean getInfo() {
		return this.info;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public String getLocation() {
		return this.si.getS_location();
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDetail() {
		return this.si.getS_detail();
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getWuye() {
		return this.si.getS_wuye();
	}
	public void setWuye(String wuye) {
		this.wuye = wuye;
	}
	public String getType() {
		return this.si.getS_type();
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getArea() {
		return this.si.getS_area();
	}
	public void setArea(double area) {
		this.area = area;
	}
	public double getPrice() {
		return this.si.getS_price();
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getLinkman() {
		return this.si.getS_linkman();
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getAddress() {
		return this.si.getS_address();
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return this.si.getS_tel();
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.si.getS_email();
	}
	public String getRemark() {
		return this.si.getS_remark();
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getHigh() {
		return this.si.getS_high();
	}
	
	public String modify() {
		try {
			si.setS_location(new String(this.location.getBytes(),"ISO-8859-1"));
			si.setS_detail(new String(this.detail.getBytes(),"ISO-8859-1"));
			si.setS_wuye(new String(this.wuye.getBytes(),"ISO-8859-1"));
			si.setS_type(new String(this.type.getBytes(),"ISO-8859-1"));
			si.setS_area(this.area);
			si.setS_price(this.price);
			si.setS_linkman(new String(this.linkman.getBytes(),"ISO-8859-1"));
			si.setS_address(new String(this.address.getBytes(),"ISO-8859-1"));
			si.setS_tel(this.tel);
			si.setS_email(this.email);
			si.setS_remark(new String(this.remark.getBytes(),"ISO-8859-1"));
			si.setS_high(this.high);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		String msg = db.updateObj("saleinfo",si);
		if(msg.equals("yes")) {
			info.setMsg("恭喜您，信息修改成功！");
		}
		else {
			info.setMsg("Sorry，信息修改失败！");
		}		
		return "modify";
	}	
}