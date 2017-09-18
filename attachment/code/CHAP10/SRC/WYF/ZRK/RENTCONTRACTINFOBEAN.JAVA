package wyf.zrk;

import java.util.*;

public class RentContractInfoBean {
	private DButilDAOImpl db;
	private RentContractDetailBean rcdb;
	private String first;
	private String second;
	private Date beginTime;
	private Date endTime;
	private double price;
	private String firstAgent;
	private String secondAgent;
	private String firstTel;
	private String secondTel;
	private String address;
	private String state;
	private String errMsg;
	
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public void setRcdb(RentContractDetailBean rcdb) {
		this.rcdb = rcdb;
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
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getErrMsg() {
		String msg = this.errMsg;
		this.errMsg = "";
		return msg;
	}
	public String insertContract() {
		String ms = "";
		if(beginTime.before(endTime)) {
			ContractRentInfo cri = new ContractRentInfo();
			try {
				cri.setCr_address(new String(address.getBytes(),"ISO-8859-1"));
				cri.setCr_begintime(this.beginTime);
				cri.setCr_endtime(this.endTime);
				cri.setCr_first(new String(first.getBytes(),"ISO-8859-1"));
				cri.setCr_firstagent(new String(firstAgent.getBytes(),"ISO-8859-1"));
				cri.setCr_firsttel(this.firstTel);
				cri.setCr_price(this.price);
				cri.setCr_second(new String(second.getBytes(),"ISO-8859-1"));
				cri.setCr_secondagent(new String(secondAgent.getBytes(),"ISO-8859-1"));
				cri.setCr_secondtel(this.secondTel);
				cri.setCr_signtime(new Date());
				cri.setCr_state(new String(state.getBytes(),"ISO-8859-1"));
				String msg = db.insertObj("contractrentinfo",cri);
				System.out.println(msg+":insert......");
				ContractRentInfo cr = new ContractRentInfo();
				cr.setCr_address(this.address);
				cr.setCr_begintime(this.beginTime);
				cr.setCr_endtime(this.endTime);
				cr.setCr_first(this.first);
				cr.setCr_firstagent(this.firstAgent);
				cr.setCr_firsttel(this.firstTel);
				cr.setCr_price(this.price);
				cr.setCr_second(this.second);
				cr.setCr_secondagent(this.secondAgent);
				cr.setCr_secondtel(this.secondTel);
				cr.setCr_signtime(new Date());
				cr.setCr_state(this.state);
				this.rcdb.setCri(cr);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			ms = "detail";
		}
		else {
			errMsg = "起始日期必须在结束日期之前！";
			ms = "";
		}
		
		return ms;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}