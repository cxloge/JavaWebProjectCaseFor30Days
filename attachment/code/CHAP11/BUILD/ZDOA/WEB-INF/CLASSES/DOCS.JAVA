package wyf.cgq;
public class Docs{
	private int docnum;
	private String fromuser;
	private String deptname;
	private String title;
	private String doctime;
	public Docs(){
	}
	public Docs(int docnum,String fromuser,String deptname,  String title, String doctime) {
		super();
		this.deptname = deptname;
		this.docnum = docnum;
		this.doctime = doctime;
		this.fromuser = fromuser;
		this.title = title;
	}
	public int getDocnum() {
		return docnum;
	}
	public void setDocnum(int docnum) {
		this.docnum = docnum;
	}
	public String getFromuser() {
		return fromuser;
	}
	public void setFromuser(String fromuser) {
		this.fromuser = fromuser;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDoctime() {
		return doctime;
	}
	public void setDoctime(String doctime) {
		this.doctime = doctime;
	}
}