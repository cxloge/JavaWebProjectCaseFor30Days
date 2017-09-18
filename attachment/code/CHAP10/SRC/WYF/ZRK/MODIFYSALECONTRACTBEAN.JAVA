package wyf.zrk;

public class ModifySaleContractBean {
	private DButilDAOImpl db;
	private ContractSaleInfo csi;
	private String state;
	
	public void setDb(DButilDAOImpl db) {
		this.db = db;
	}
	public void setCsi(ContractSaleInfo csi) {
		this.csi = csi;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return this.state;
	}
	
	public String modify() {
		try {
			csi.setCs_state(new String(state.getBytes(),"ISO-8859-1"));
			db.updateObj("contractsaleinfo",csi);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "modify";
	}
	
	
	
}