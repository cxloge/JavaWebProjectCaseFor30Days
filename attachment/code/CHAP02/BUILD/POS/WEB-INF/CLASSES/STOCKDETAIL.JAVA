package wyf.zrk;

public class StockDetail {
	private String sdid;
	private String sid;
	private String gid;
	private int sdamount;
	private double sdprice;
	private double sdtotalprice;
	public StockDetail(){}
	public StockDetail(String sdid,String sid,String gid,int sdamount,double sdprice,double sdtotalprice){
		this.sdid = sdid;
		this.sid = sid;
		this.gid = gid;
		this.sdamount = sdamount;
		this.sdprice = sdprice;
		this.sdtotalprice = sdtotalprice;
	}
	public String getSdid() {
		return sdid;
	}
	public void setSdid(String sdid) {
		this.sdid = sdid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public int getSdamount() {
		return sdamount;
	}
	public void setSdamount(int sdamount) {
		this.sdamount = sdamount;
	}
	public double getSdprice() {
		return sdprice;
	}
	public void setSdprice(double sdprice) {
		this.sdprice = sdprice;
	}
	public double getSdtotalprice() {
		return sdtotalprice;
	}
	public void setSdtotalprice(double sdtotalprice) {
		this.sdtotalprice = sdtotalprice;
	}
}
