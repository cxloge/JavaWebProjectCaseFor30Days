package wyf;

public class Info_Item {
	private String rname;
	private String start;
	private String end;
	private String rid;
	private String gname;
	private String status;
	private String orid;
	private boolean flag;
	
	public boolean getFlag(){
		return this.status.equals("Ô¤¶©ÖÐ");
	}
	
	public String getOrid() {
		return orid;
	}
	
	public void setOrid(String orid) {
		this.orid = orid;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getGname(){
		return this.gname;
	}
	
	public void setGname(String gname){
		this.gname = gname;
	}
	
	public String getRname() {
		return rname;
	}
	
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public Info_Item(String rid,String rname,String start,String end){
		this.rid = rid;
		this.rname = rname;
		this.start = start;
		this.end = end;
	}
	public Info_Item(){
	}
}
