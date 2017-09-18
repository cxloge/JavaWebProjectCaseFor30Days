package wyf;
public class List_Item {
	public String getOId() {
		return OId;
	}
	public void setOId(String id) {
		OId = id;
	}
	public String getOTime() {
		return OTime;
	}
	public void setOTime(String time) {
		OTime = time;
	}
	public String getOStatus() {
		return OStatus;
	}
	public void setOStatus(String status) {
		OStatus = status;
	}
	public String getODetail() {
		return ODetail;
	}
	public void setODetail(String detail) {
		ODetail = detail;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	private boolean flag;
	
	public boolean getFlag(){
		return this.OStatus.equals("Ô¤¶©ÖÐ");
	}
	private String OId;
	private String OTime;
	private String OStatus;
	private String ODetail;
	private String uname;
}
