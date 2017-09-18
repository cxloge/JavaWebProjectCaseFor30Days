package wyf.zrk;

import java.util.*;

public class ModifyMyQiuZuInfoBean {
	private UserLoginBean ulb;
	private DButilDAOImpl db;
	private InfoBean info;
	private RentInfo ri;
	private String msgtype;
	private String location = "唐山市";
	private String detail;
	private String wuye;
	private String type;
	private double area;
	private int lease;
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
	public void setRi(RentInfo ri) {
		this.ri = ri;
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
		return this.ri.getR_location();
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDetail() {
		return this.ri.getR_detail();
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getWuye() {
		return this.ri.getR_wuye();
	}
	public void setWuye(String wuye) {
		this.wuye = wuye;
	}
	public String getType() {
		return this.ri.getR_type();
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getArea() {
		return this.ri.getR_area();
	}
	public void setArea(double area) {
		this.area = area;
	}
	public int getLease() {
		return this.ri.getR_lease();
	}
	public void setLease(int lease) {
		this.lease = lease;
	}
	public double getPrice() {
		return this.ri.getR_price();
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getLinkman() {
		return this.ri.getR_linkman();
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getAddress() {
		return this.ri.getR_address();
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return this.ri.getR_tel();
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.ri.getR_email();
	}
	public String getRemark() {
		return this.ri.getR_remark();
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getHigh() {
		return this.ri.getR_high();
	}
	
	public String modify() {
		try {
			ri.setR_msgtype(new String(this.msgtype.getBytes(),"ISO-8859-1"));
			ri.setR_location(new String(this.location.getBytes(),"ISO-8859-1"));
			ri.setR_detail(new String(this.detail.getBytes(),"ISO-8859-1"));
			ri.setR_wuye(new String(this.wuye.getBytes(),"ISO-8859-1"));
			ri.setR_type(new String(this.type.getBytes(),"ISO-8859-1"));
			ri.setR_area(this.area);
			ri.setR_lease(this.lease);
			ri.setR_price(this.price);
			ri.setR_linkman(new String(this.linkman.getBytes(),"ISO-8859-1"));
			ri.setR_address(new String(this.address.getBytes(),"ISO-8859-1"));
			ri.setR_tel(this.tel);
			ri.setR_email(this.email);
			ri.setR_remark(new String(this.remark.getBytes(),"ISO-8859-1"));
			ri.setR_publishtime(new Date());
			ri.setU_id(this.ulb.getUser().getU_id());
			ri.setR_high(this.high);			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		String msg = db.updateObj("rentinfo",ri);
		if(msg.equals("yes")) {
			info.setMsg("恭喜您，信息修改成功！");
		}
		else {
			info.setMsg("Sorry，信息修改失败！");
		}		
		return "modify";
	}
	
	
	
}