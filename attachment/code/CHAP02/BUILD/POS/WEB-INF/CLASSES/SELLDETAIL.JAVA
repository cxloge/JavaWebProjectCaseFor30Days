package wyf.zrk;

public class SellDetail {
	private String edid;
	private String eid;
	private String gid;
	private int edamount;
	private double edprice;
	private double edtotalprice;
	public SellDetail(){}
	public SellDetail(String edid,String eid,String gid,int edamount,double edprice,double edtotalprice){
		this.edid = edid;
		this.eid = eid;
		this.gid = gid;
		this.edamount = edamount;
		this.edprice = edprice;
		this.edtotalprice = edtotalprice;
	}
	public String getEdid() {
		return edid;
	}
	public void setEdid(String edid) {
		this.edid = edid;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public int getEdamount() {
		return edamount;
	}
	public void setEdamount(int edamount) {
		this.edamount = edamount;
	}
	public double getEdprice() {
		return edprice;
	}
	public void setEdprice(double edprice) {
		this.edprice = edprice;
	}
	public double getEdtotalprice() {
		return edtotalprice;
	}
	public void setEdtotalprice(double edtotalprice) {
		this.edtotalprice = edtotalprice;
	}
}
