package wyf.zrk;

import java.util.*;

public class SellInfo {
	private String eid;
	private Date edate;
	private String cid;
	private double etotalprice;
	private String eseller;
	public SellInfo(){}
	public SellInfo(String eid,String cid,Date edate,double etotalprice,String eseller){
		this.eid = eid;
		this.edate = edate;
		this.cid = cid;
		this.etotalprice = etotalprice;
		this.eseller = eseller;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public double getEtotalprice() {
		return etotalprice;
	}
	public void setEtotalprice(double etotalprice) {
		this.etotalprice = etotalprice;
	}
	public String getEseller() {
		return eseller;
	}
	public void setEseller(String eseller) {
		this.eseller = eseller;
	}
}
