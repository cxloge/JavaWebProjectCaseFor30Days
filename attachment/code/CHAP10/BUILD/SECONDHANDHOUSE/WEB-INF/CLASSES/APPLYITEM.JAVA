package wyf.zrk;

public class ApplyItem {
	private String location;
	private String msgtype;
	private String agree;
	private String type;
	private int id;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocation() {
		return this.location;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public String getMsgtype() {
		return this.msgtype;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}
	public String getAgree() {
		return this.agree;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}