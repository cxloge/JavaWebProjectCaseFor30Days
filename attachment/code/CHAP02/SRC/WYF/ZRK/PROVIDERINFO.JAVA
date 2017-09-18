package wyf.zrk;

public class ProviderInfo {
	private String pid;
	private String pname;
	private String plinkman;
	private String paddress;
	private String ptel;
	private String pemail;
	private String premark;
	
	public ProviderInfo(){}
	public ProviderInfo(String pid,String pname,String plinkman,String paddress,String ptel,String pemail,String premark){
		this.pid = pid;
		this.pname = pname;
		this.plinkman = plinkman;
		this.paddress = paddress;
		this.ptel = ptel;
		this.pemail = pemail;
		this.premark = premark;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPlinkman() {
		return plinkman;
	}
	public void setPlinkman(String plinkman) {
		this.plinkman = plinkman;
	}
	public String getPaddress() {
		return paddress;
	}
	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}
	public String getPtel() {
		return ptel;
	}
	public void setPtel(String ptel) {
		this.ptel = ptel;
	}
	public String getPemail() {
		return pemail;
	}
	public void setPemail(String pemail) {
		this.pemail = pemail;
	}
	public String getPremark() {
		return premark;
	}
	public void setPremark(String premark) {
		this.premark = premark;
	}	
}
