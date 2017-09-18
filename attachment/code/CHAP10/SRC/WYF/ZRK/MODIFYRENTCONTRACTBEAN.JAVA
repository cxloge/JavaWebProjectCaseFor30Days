package wyf.zrk;

public class ModifyRentContractBean {
	private DButilDAOImpl db;
	private ContractRentInfo cri;
	private String state;
	
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public void setCri(ContractRentInfo cri) {
		this.cri = cri;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return this.state;
	}
	
	public String modify() {
		try {
			cri.setCr_state(new String(state.getBytes(),"ISO-8859-1"));
			db.updateObj("contractrentinfo",cri);			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "modify";
	}
	
	
	
}