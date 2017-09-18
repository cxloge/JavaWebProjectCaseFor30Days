package wyf.zrk;

public class GoodsInfo {
	private String gid;
	private String gname;
	private String gcid;
	private String gunit;
	private double gpin;
	private double gpout;
	private int gamount;
	public GoodsInfo(){}
	public GoodsInfo(String gid,String gname,String gcid,
		String gunit,double gpin,double gpout,int gamount){
		this.gid = gid;
		this.gname = gname;
		this.gcid = gcid;
		this.gunit = gunit;
		this.gpin = gpin;
		this.gpout = gpout;
		this.gamount = gamount;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGcid() {
		return gcid;
	}
	public void setGcid(String gcid) {
		this.gcid = gcid;
	}
	public String getGunit() {
		return gunit;
	}
	public void setGunit(String gunit) {
		this.gunit = gunit;
	}
	public double getGpin() {
		return gpin;
	}
	public void setGpin(double gpin) {
		this.gpin = gpin;
	}
	public double getGpout() {
		return gpout;
	}
	public void setGpout(double gpout) {
		this.gpout = gpout;
	}
	public int getGamount() {
		return gamount;
	}
	public void setGamount(int gamount) {
		this.gamount = gamount;
	}
	public String toString(){
		return this.gname;
	}	
}
