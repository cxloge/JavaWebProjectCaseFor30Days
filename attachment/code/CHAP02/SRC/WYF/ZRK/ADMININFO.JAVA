package wyf.zrk;

public class AdminInfo {
	private String aid;
	private String aname;
	private String apwd;
	private String alevel;
	public AdminInfo(){}
	public AdminInfo(String aid,String aname,String apwd,String alevel){
		this.aid = aid;
		this.aname = aname;
		this.apwd = apwd;
		this.alevel = alevel;
	}
	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getApwd() {
		return apwd;
	}

	public void setApwd(String apwd) {
		this.apwd = apwd;
	}

	public String getAlevel() {
		return alevel;
	}

	public void setAlevel(String alevel) {
		this.alevel = alevel;
	}



	public String toString(){
		return this.aname+"/t"+this.apwd;
	}
}
