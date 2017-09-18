package wyf.zrk;

public class MySaleDetailBean {
	private SaleInfo si;
	private String msgtype;
	private String location;
	private String detail;
	private double longitude;
	private double latitude;
	private String wuye;
	private String type;
	private double area;
	private double price;
	private String linkman;
	private String tel;
	private String email;
	private String publishtime;
	private String remark;
	
	public SaleInfo getSi() {
		return si;
	}
	public void setSi(SaleInfo si) {
		this.si = si;
	}
	public String getMsgtype() {
		return this.si.getS_msgtype();
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
	public double getLongitude() {
		return this.si.getS_longitude();
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return this.si.getS_latitude();
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
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
	public String getTel() {
		return this.si.getS_tel();
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return this.si.getS_email();
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPublishtime() {
		return this.si.getS_publishtime().toString().substring(0,10);
	}
	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}
	public String getRemark() {
		return this.si.getS_remark();
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}