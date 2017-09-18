package wyf;

public class Admin_Item {
	private String aid;
	private String aname;
	private String alevel;

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
	public String getAlevel() {
		return alevel.trim();
	}
	public void setAlevel(String alevel) {
		this.alevel = alevel;
	}
	public boolean isSuper() {
		return this.alevel.equals("³¬¼¶");
	}
}
