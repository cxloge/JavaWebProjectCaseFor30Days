package wyf;

public class ResItem{
	private String rid;			//封装了资源编号属性
	private String rname;		//封装了资源名称属性
	private String rspec;		//封装了资源规格的属性
	private String rdetail;		//封装了资源描述的属性
	private String rprice;		//封装了资源价格
	private String gid;			//资源所属分组ID
	private String rstatus;		//资源状态
	
	public void setRstatus(String rstatus){
		this.rstatus = rstatus;				//rstatus的setter方法
	}
	public String getRstatus(){
		return this.rstatus;				//rstatus的getter方法
	}	
	
	public String getGid(){	
		return this.gid;					//gid的getter方法
	}
	
	public void setGid(String gid){
		this.gid = gid;						//gid的setter方法
	}
	
	public void setRid(String rid) {
		this.rid = rid;						//rid的setter方法 
	}

	public void setRname(String rname) {
		this.rname = rname; 				//rname的setter方法
	}

	public void setRspec(String rspec) {
		this.rspec = rspec; 				//rspec的setter方法
	}

	public void setRdetail(String rdetail) {
		this.rdetail = rdetail; 			//rdetail的setter方法
	}

	public void setRprice(String rprice) {
		this.rprice = rprice; 				//rprice的setter方法
	}

	public String getRid() {
		return (this.rid); 					//rid的getter方法
	}

	public String getRname() {
		return (this.rname); 				//rname的getter方法
	}

	public String getRspec() {
		return (this.rspec); 				//rspec的getter方法
	}

	public String getRdetail() {
		return (this.rdetail); 				//rdetail的getter方法
	}

	public String getRprice() {
		return (this.rprice); 				//rprice的getter方法
	}

}