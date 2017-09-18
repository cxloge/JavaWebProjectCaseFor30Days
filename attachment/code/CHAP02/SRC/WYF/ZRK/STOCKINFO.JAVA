package wyf.zrk;

import java.util.*;

public class StockInfo {
	private String sid;
	private String pid;
	private Date sdate;
	private double stotalprice;
	private String sbuyer;
	public StockInfo(){}
	public StockInfo(String sid,String pid,Date sdate,double stotalprice,String sbuyer){
		this.sid = sid;
		this.pid = pid;
		this.sdate = sdate;
		this.stotalprice = stotalprice;
		this.sbuyer = sbuyer;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public double getStotalprice() {
		return stotalprice;
	}
	public void setStotalprice(double stotalprice) {
		this.stotalprice = stotalprice;
	}
	public String getSbuyer() {
		return sbuyer;
	}
	public void setSbuyer(String sbuyer) {
		this.sbuyer = sbuyer;
	}
}
