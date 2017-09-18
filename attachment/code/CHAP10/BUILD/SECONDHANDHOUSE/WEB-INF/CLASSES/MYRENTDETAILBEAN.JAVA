package wyf.zrk;

public class MyRentDetailBean {
	private RentInfo ri;
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
	private String high;
	private int lease;
	private String address;
	
	public void setRi(RentInfo ri) {
		this.ri = ri;
	}
	public String getMsgtype() {
		return this.ri.getR_msgtype();
	}
	public String getLocation() {
		return this.ri.getR_location();
	}
	public String getDetail() {
		return this.ri.getR_detail();
	}
	public double getLongitude() {
		return this.ri.getR_longitude();
	}
	public double getLatitude() {
		return this.ri.getR_latitude();
	}
	public String getWuye() {
		return this.ri.getR_wuye();
	}
	public String getType() {
		return this.ri.getR_type();
	}
	public double getArea() {
		return this.ri.getR_area();
	}
	public double getPrice() {
		return this.ri.getR_price();
	}
	public String getLinkman() {
		return this.ri.getR_linkman();
	}
	public String getTel() {
		return this.ri.getR_tel();
	}
	public String getEmail() {
		return this.ri.getR_email();
	}
	public String getPublishtime() {
		return this.ri.getR_publishtime().toString().substring(0,10);
	}
	public String getRemark() {
		return this.ri.getR_remark();
	}
	public String getHigh() {
		return this.high;
	}
	public int getLease() {
		return this.ri.getR_lease();
	}
	public String getAddress(){
		return this.ri.getR_address();
	}
	
	
	
	
	
}