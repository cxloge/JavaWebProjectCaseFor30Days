package wyf.zrk;

import java.util.*;

public class SaleContractInfoBean {
	private DButilDAOImpl db;
	private SaleContractDetailBean scdb;
	private String first;
	private String second;
	private String firstCardId;
	private String secondCardId;
	private String location;
	private double houseArea;
	private double housePrice;
	private String firstAgent;
	private String secondAgent;
	private String firstTel;
	private String secondTel;
	private String state;
	
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public void setScdb(SaleContractDetailBean scdb) {
		this.scdb = scdb;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getSecond() {
		return second;
	}
	public void setSecond(String second) {
		this.second = second;
	}
	public String getFirstCardId() {
		return firstCardId;
	}
	public void setFirstCardId(String firstCardId) {
		this.firstCardId = firstCardId;
	}
	public String getSecondCardId() {
		return secondCardId;
	}
	public void setSecondCardId(String secondCardId) {
		this.secondCardId = secondCardId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getHouseArea() {
		return houseArea;
	}
	public void setHouseArea(double houseArea) {
		this.houseArea = houseArea;
	}
	public double getHousePrice() {
		return housePrice;
	}
	public void setHousePrice(double housePrice) {
		this.housePrice = housePrice;
	}
	public String getFirstAgent() {
		return firstAgent;
	}
	public void setFirstAgent(String firstAgent) {
		this.firstAgent = firstAgent;
	}
	public String getSecondAgent() {
		return secondAgent;
	}
	public void setSecondAgent(String secondAgent) {
		this.secondAgent = secondAgent;
	}
	public String getFirstTel() {
		return firstTel;
	}
	public void setFirstTel(String firstTel) {
		this.firstTel = firstTel;
	}
	public String getSecondTel() {
		return secondTel;
	}
	public void setSecondTel(String secondTel) {
		this.secondTel = secondTel;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String insertContract() {
		ContractSaleInfo csi = new ContractSaleInfo();
		try {
			csi.setCs_first(new String(first.getBytes(),"ISO-8859-1"));
			csi.setCs_firstagent(new String(firstAgent.getBytes(),"ISO-8859-1"));
			csi.setCs_firstcardid(this.firstCardId);
			csi.setCs_firsttel(this.firstTel);
			csi.setCs_housearea(this.houseArea);
			csi.setCs_houselocation(new String(location.getBytes(),"ISO-8859-1"));
			csi.setCs_houseprice(this.housePrice);
			csi.setCs_second(new String(second.getBytes(),"ISO-8859-1"));
			csi.setCs_secondagent(new String(secondAgent.getBytes(),"ISO-8859-1"));
			csi.setCs_secondtel(this.secondTel);
			csi.setCs_secondcardid(this.secondCardId);
			csi.setCs_signtime(new Date());
			csi.setCs_state(new String(state.getBytes(),"ISO-8859-1"));
			ContractSaleInfo cs = new ContractSaleInfo();
			cs.setCs_first(this.first);
			cs.setCs_firstagent(this.firstAgent);
			cs.setCs_firstcardid(this.firstCardId);
			cs.setCs_firsttel(this.firstTel);
			cs.setCs_housearea(this.houseArea);
			cs.setCs_houselocation(this.location);
			cs.setCs_houseprice(this.housePrice);
			cs.setCs_second(this.second);
			cs.setCs_secondagent(this.secondAgent);
			cs.setCs_secondcardid(this.secondCardId);
			cs.setCs_secondtel(this.secondTel);
			cs.setCs_signtime(new Date());
			cs.setCs_state(this.state);
			this.scdb.setCsi(cs);
			
			System.out.println(cs.getCs_first());
			System.out.println(cs.getCs_second());
			System.out.println(cs.getCs_firstcardid());
			System.out.println(cs.getCs_firsttel());
			
			String msg = db.insertObj("contractsaleinfo",csi);				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "detail";
	}
	
	
	
	
	
	

	
	
	
	
	
}