package wyf.zrk;

public class LookUserInfoBean {
	private UserLoginBean ulb;
	private String uname;
	private String ugender;
	private String uemail;
	
	public void setUlb(UserLoginBean ulb) {
		this.ulb = ulb;
	}
	public UserLoginBean getUlb() {
		return this.ulb;
	}
	public String getUname() {
		try{
			uname = this.ulb.getUser().getU_name();
			uname = new String(uname.getBytes("ISO-8859-1"),"GBK");			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return uname;
	}
	public String getUgender() {
		try {
			ugender = this.ulb.getUser().getU_gender();
			ugender = new String(ugender.getBytes("ISO-8859-1"),"GBK");			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ugender;
	}
	public String getUemail() {
		try {
			uemail = this.ulb.getUser().getU_email();
			uemail = new String(uemail.getBytes("ISO-8859-1"),"GBK");			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return uemail;
	}
}