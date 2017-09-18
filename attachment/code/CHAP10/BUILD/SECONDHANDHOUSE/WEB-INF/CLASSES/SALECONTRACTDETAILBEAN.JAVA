package wyf.zrk;

import java.util.*;

public class SaleContractDetailBean {
	private ContractSaleInfo csi;
	private String first;
	private String second;
	private String firstCardId;
	private String secondCardId;
	private String firstTel;
	private String secondTel;
	private String firstAgent;
	private String secondAgent;
	private Date signTime;
	private String location;
	private double price;
	private double area;

	
	public void setCsi(ContractSaleInfo csi) {
		System.out.println("set the csi......");
		this.csi = csi;
		System.out.println("get the first....when set the csi"+this.csi.getCs_first());
	}
	public String getFirst() {
		
		System.out.println("get the first...."+this.csi.getCs_first());
		
		return this.csi.getCs_first();
	}
	public String getSecond() {
		return this.csi.getCs_second();
	}
	public String getFirstCardId() {
		return this.csi.getCs_firstcardid();
	}
	public String getSecondCardId() {
		return this.csi.getCs_secondcardid();
	}
	public String getFirstTel() {
		return this.csi.getCs_firsttel();
	}
	public String getSecondTel() {
		return this.csi.getCs_secondtel();
	}
	public String getFirstAgent() {
		return this.csi.getCs_firstagent();
	}
	public String getSecondAgent() {
		return this.csi.getCs_secondagent();
	}
	public Date getSignTime() {
		return this.csi.getCs_signtime();
	}
	public String getLocation() {
		return this.csi.getCs_houselocation();
	}
	public double getPrice() {
		return this.csi.getCs_houseprice();
	}
	public double getArea() {
		return this.csi.getCs_housearea();
	}
	
	
}