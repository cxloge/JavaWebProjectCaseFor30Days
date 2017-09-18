package wyf.zrk;

public class ConsumerBackDetail {
	private String cbdid;
	private String cbid;
	private String gid;
	private int cbdamount;
	private double cbdprice;
	private double cbdtotalprice;
	public ConsumerBackDetail(){}
	public ConsumerBackDetail(String cbdid,String cbid,String gid,int cbdamount,double cbdprice,double cbdtotalprice){
		this.cbdid = cbdid;
		this.cbid = cbid;
		this.gid = gid;
		this.cbdamount = cbdamount;
		this.cbdprice = cbdprice;
		this.cbdtotalprice = cbdtotalprice;
	}
	public String getCbdid() {
		return cbdid;
	}
	public void setCbdid(String cbdid) {
		this.cbdid = cbdid;
	}
	public String getCbid() {
		return cbid;
	}
	public void setCbid(String cbid) {
		this.cbid = cbid;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public int getCbdamount() {
		return cbdamount;
	}
	public void setCbdamount(int cbdamount) {
		this.cbdamount = cbdamount;
	}
	public double getCbdprice() {
		return cbdprice;
	}
	public void setCbdprice(double cbdprice) {
		this.cbdprice = cbdprice;
	}
	public double getCbdtotalprice() {
		return cbdtotalprice;
	}
	public void setCbdtotalprice(double cbdtotalprice) {
		this.cbdtotalprice = cbdtotalprice;
	}
}
