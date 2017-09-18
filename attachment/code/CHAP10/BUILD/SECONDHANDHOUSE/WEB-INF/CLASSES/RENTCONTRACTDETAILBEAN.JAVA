package wyf.zrk;

import java.util.*;

public class RentContractDetailBean {
	private ContractRentInfo cri;
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
	private Date signTime;
	public void setCri(ContractRentInfo cri) {
		this.cri = cri;
	}
	public String getFirst() {
		return this.cri.getCr_first();
	}
	public String getSecond() {
		return this.cri.getCr_second();
	}
	public Date getBeginTime() {
		return this.cri.getCr_begintime();
	}
	public Date getEndTime() {
		return this.cri.getCr_endtime();
	}
	public double getPrice() {
		return this.cri.getCr_price();
	}
	public String getFirstAgent() {
		return this.cri.getCr_firstagent();
	}
	public String getSecondAgent() {
		return this.cri.getCr_secondagent();
	}
	public String getFirstTel() {
		return this.cri.getCr_firsttel();
	}
	public String getSecondTel() {
		return this.cri.getCr_secondtel();
	}
	public String getAddress() {
		return this.cri.getCr_address();
	}
	public String getState() {
		return this.cri.getCr_state();
	}
	public Date getSignTime() {
		return this.cri.getCr_signtime();
	}
	
}