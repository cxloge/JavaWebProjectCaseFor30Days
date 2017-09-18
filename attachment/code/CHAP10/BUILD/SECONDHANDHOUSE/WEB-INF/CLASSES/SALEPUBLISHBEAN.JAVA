package wyf.zrk;

import java.util.*;

public class SalePublishBean {
	private UserLoginBean ulb;
	private DButilDAOImpl db;
	private InfoBean info;
	private String msgtype;
	private String location = "唐山市";
	private String detail;
	private double longitude = 0;
	private double latitude = 0;
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
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public String getWuye() {
		return wuye;
	}
	public void setWuye(String wuye) {
		this.wuye = wuye;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getHigh() {
		return this.high;
	}
	
	public String publish() {
		SaleInfo si = new SaleInfo();
		try {
			si.setS_msgtype(new String(this.msgtype.getBytes(),"ISO-8859-1"));
			si.setS_location(new String(this.location.getBytes(),"ISO-8859-1"));
			si.setS_detail(new String(this.detail.getBytes(),"ISO-8859-1"));
			si.setS_longitude(this.longitude);
			si.setS_latitude(this.latitude);
			si.setS_wuye(new String(this.wuye.getBytes(),"ISO-8859-1"));
			si.setS_type(new String(this.type.getBytes(),"ISO-8859-1"));
			si.setS_area(this.area);
			si.setS_price(this.price);
			si.setS_linkman(new String(this.linkman.getBytes(),"ISO-8859-1"));
			si.setS_address(new String(this.address.getBytes(),"ISO-8859-1"));
			si.setS_tel(this.tel);
			si.setS_email(this.email);
			si.setS_remark(new String(this.remark.getBytes(),"ISO-8859-1"));
			si.setS_publishtime(new Date());
			si.setU_id(this.ulb.getUser().getU_id());
			si.setS_high(this.high);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		String msg = db.insertObj("saleinfo",si);
		if(msg.equals("yes")) {
			info.setMsg("恭喜您，信息发布成功！");
			SendMail sm = new SendMail();
			sm.setFrom("JavaLover@foxmail.com");
			sm.setName("JavaLover@foxmail.com");
			sm.setPwd("860607");
			sm.setTo(this.ulb.getUser().getU_email());			
			sm.setTitle("迅捷二手房信息发布提示");
			sm.setText("恭喜您，您在迅捷二手房交易网上的"+this.msgtype+"信息发布成功！");
			Thread t = new Thread(sm);
			t.start();
		}
		else {
			info.setMsg("Sorry，信息发布失败！");
		}		
		return "publish";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}