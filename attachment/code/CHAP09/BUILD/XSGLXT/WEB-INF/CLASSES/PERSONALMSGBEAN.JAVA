package wyf.cgq;
public class PersonalMsgBean
{
	private LoginBean lb;
	private String sno;
	private String sname;
	private String sgender;
	private String birth;
	private String nativeplace;
	private String coll;
	private String dept;
	private String classes;
	private String mianmao;
	private String comedate;
	public void setLb(LoginBean lb)
	{
		this.lb=lb;
	}
	public LoginBean getLb()
	{
		return this.lb;
	}
	public void setSno(String sno)
	{
		this.sno=sno;
	}
	public String getSno()
	{
		return this.lb.getId();
	}
	public void setSname(String sname)
	{
		this.sname=sname;
	}
	public String getSname()
	{
		return StudentDB.getNameByNo(lb.getId());
	}
	public void setSgender(String sgender)
	{
		this.sgender=sgender;
	}
	public String getSgender()
	{
		System.out.println(StudentDB.getGenderByNo(lb.getId())+"==============");
		return StudentDB.getGenderByNo(lb.getId());
	}
	public void setBirth(String birth)
	{
		this.birth=birth;
	}
	public String getBirth()
	{
		return StudentDB.getBirthByNo(lb.getId());
	}
	public void setNativeplace(String nativeplace)
	{
		this.nativeplace=nativeplace;
	}
	public String getNativeplace()
	{
		return StudentDB.getNativeplaceByNo(lb.getId());
	}
	public void setColl(String coll)
	{
		this.coll=coll;
	}
	public String getColl()
	{
		return StudentDB.getCollByNo(lb.getId());
	}
	public void setDept(String dept)
	{
		this.dept=dept;
	}
	public String getDept()
	{
		return StudentDB.getDeptByNo(lb.getId());
	}
	public void setClasses(String classes)
	{
		this.classes=classes;
	}
	public String getClasses()
	{
		return StudentDB.getClassByNo(lb.getId());
	}
	public void setMianmao(String mianmao)
	{
		this.mianmao=mianmao;
	}
	public String getMianmao()
	{
		return StudentDB.getMianmaoByNo(lb.getId());
	}
	public void setComedate(String comedate)
	{
		this.comedate=comedate;
	}
	public String getComedate()
	{
		return StudentDB.getComeDateByNo(lb.getId());
	}
}