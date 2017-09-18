package wyf.zrk;

public class ShowSaleMsgBean {
	private InfoBean info;
	private DButilDAOImpl db;
	private UserLoginBean ulb;
	private SaleInfo si;
	private String linkman;
	private String email;
	private String tel;
	private String errMsg;
	private String msgtype;
	private String location;
	private String wuye;
	private String type;
	private String high;
	private double area;
	private double price;
	private String publishtime;
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
	public void setSi(SaleInfo si) {
		this.si = si;
	}
	public SaleInfo getSi() {
		return this.si;
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
		String msg = errMsg;
		errMsg = "";
		return msg;
	}
	public String getMsgtype() {
		return this.si.getS_msgtype();
	}
	public String getLocation() {
		return this.si.getS_location();
	}
	public String getType() {
		return this.si.getS_type();
	}
	public String getWuye() {
		return this.si.getS_wuye();
	}
	public String getHigh() {
		return this.si.getS_high();
	}
	public String getPublishtime() {
		return this.si.getS_publishtime().toString().substring(0,10);
	}
	public double getArea() {
		return this.si.getS_area();
	}
	public double getPrice() {
		return this.si.getS_price();
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLongitude() {
		return this.si.getS_longitude();
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLatitude() {
		return this.si.getS_latitude();
	}
	
	
	
	
	public String save() {
		String flag = "";
		if(!ulb.isFlag()) {
			errMsg = "¶Ô²»Æð£¬ÇëÄúÏÈµÇÂ¼£¡";
		}
		else {
			try {
				RelationToUserAndMsg rtuam = new RelationToUserAndMsg();
				rtuam.setR_type(new String(this.si.getS_msgtype().getBytes(),"ISO-8859-1"));
				rtuam.setS_id(this.si.getS_id());
				rtuam.setU_id(this.si.getU_id());
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