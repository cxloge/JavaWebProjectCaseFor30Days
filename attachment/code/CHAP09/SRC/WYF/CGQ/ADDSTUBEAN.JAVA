package wyf.cgq;
import java.util.*;
import javax.faces.model.SelectItem;
import javax.faces.event.ValueChangeEvent;
public class AddStuBean
{
	private LoginBean lb;
	private String sno;
	private String sname;
	private String sgender="男";
	private int biryear=new Date().getYear()+1900-20;
	private int birmonth=1;
	private int birday=1;
	private String nativeplace;
	private String collid;
	private String deptid;
	private String classid;
	private String mianmao;
	private int comeyear=new Date().getYear()+1900;
	private int comemonth;
	private int comeday;
	private String msg;
	public void setSno(String sno)
	{
		this.sno=sno;
	}
	public String getSno()
	{
		return this.sno;
	}
	public void setSname(String sname)
	{
		this.sname=sname;
	}
	public String getSname()
	{
		return this.sname;
	}
	public void setSgender(String sgender)
	{
		this.sgender=sgender;
	}
	public String getSgender()
	{
		return this.sgender;
	}
	public void setBiryear(int biryear)
	{
		this.biryear=biryear;
	}
	public int getBiryear()
	{
		return this.biryear;
	}
	public void setBirmonth(int birmonth)
	{
		this.birmonth=birmonth;
	}
	public int getBirmonth()
	{
		return this.birmonth;
	}
	public void setBirday(int birday)
	{
		this.birday=birday;
	}
	public int getBirday()
	{
		return this.birday;
	}
	public void setNativeplace(String nativeplace)
	{
		this.nativeplace=nativeplace;
	}
	public String getNativeplace()
	{
		return this.nativeplace;
	}
	public void setCollid(String collid)
	{
		this.collid=collid;
	}
	public String getCollid()
	{
		return this.collid;
	}
	public void setDeptid(String deptid)
	{
		this.deptid=deptid;
	}
	public String getDeptid()
	{
		return this.deptid;
	}
	public void setClassid(String classid)
	{
		this.classid=classid;
	}
	public String getClassid()
	{
		return this.classid;
	}
	public void setMianmao(String mianmao)
	{
		this.mianmao=mianmao;
	}
	public String getMianmao()
	{
		return this.mianmao;
	}
	public void setComeyear(int comeyear)
	{
		this.comeyear=comeyear;
	}
	public int getComeyear()
	{
		return this.comeyear;
	}
	public void setComemonth(int comemonth)
	{
		this.comemonth=comemonth;
	}
	public int getComemonth()
	{
		return this.comemonth;
	}
	public void setComeday(int comeday)
	{
		this.comeday=comeday;
	}
	public int getComeday()
	{
		return this.comeday;
	}
	public String getMsg()
	{
		String msg1=msg;
		msg="";
		return msg1;
	}
	public void setMsg(String msg)
	{
		msg="";
	}
	
	public void setLb(LoginBean lb)
	{
		this.lb=lb;
	}
	public LoginBean getLb()
	{
		return this.lb;
	}
	
	public ArrayList<SelectItem> getBiryearList(){//获得出生日期年的列表的方法
		int year=new Date().getYear()+1900;			//获得当前年
		ArrayList<SelectItem> biryearList=new ArrayList<SelectItem>();//创建年列表
		for(int i=year-30;i<=year-15;i++){//获得一定范围内的年号
			biryearList.add(new SelectItem(i,i+"年"));//添加到年列表中
		}
		return biryearList;	//返回年列表
	}
	public ArrayList<SelectItem> getBirmonthList(){//获得出生日期月的列表的方法
		ArrayList<SelectItem> birmonthList=new ArrayList<SelectItem>();//创建月列表
		for(int i=1;i<=12;i++){
			birmonthList.add(new SelectItem(i,i+"月"));//将12个月依次添加到列表中
		}
		return birmonthList;//返回列表
	}
	public ArrayList<SelectItem> getBirdayList(){//获得出生日期日的类表
		ArrayList<SelectItem> birdayList=new ArrayList<SelectItem>();//创建日列表
		Date d=new Date(biryear,birmonth,0);//根据年与月创建时间对象
		int date=d.getDate();//获得该月的最大天数
		for(int i=1;i<=date;i++){//遍历这些天数
			birdayList.add(new SelectItem(i,i+"日"));//添加到列表中
		}
		return birdayList;//返回日列表
	}
	public String getColl(){	//获得学院名的方法
		collid=lb.getId();		//获得用户的id号，及学员编号
		String coll=TeacherDB.getCollById(collid);//调用TeacherDB的方法获得学院的名称
		return coll;//返回学院的名称
	}
	public ArrayList<SelectItem> getDeptList(){//获得专业列表的方法
		ArrayList<SelectItem> al=TeacherDB.getDeptListByCollid(collid);//获得专业列表
		if(deptid==null){//如果专业列表不为空
			SelectItem sl=al.get(0);//获得列表第一项
			deptid=(String)sl.getValue();//初始化deptid
		}
		return al;		//返回专业类表
	}
	public ArrayList<SelectItem> getClassList(){//获得班级列表的方法
		ArrayList<SelectItem> al=TeacherDB.getClassListByDeptid(deptid);//获得班级列表
		return al;//返回班级列表
	}
	public ArrayList<SelectItem> getMianmaoList(){//获得政治面貌的列表
		ArrayList al=new ArrayList();//创建ArrayList列表
		al.add(new SelectItem("团员","团员"));
		al.add(new SelectItem("学生","学生"));//将相应的政治面貌选项添加到列表中
		al.add(new SelectItem("党员","党员"));
		return al;		//返回列表
	}
	public void updateClass(ValueChangeEvent event){//更新班级列表的方法
		this.getClassList();
	}
	public void updateBirday(ValueChangeEvent event){//更新出生日期中日列表的方法
		this.getBirdayList();
	}
	public void updateComeday(ValueChangeEvent event){//更新入学时间中日列表的方法
		this.getComedayList();
	}
	public ArrayList<SelectItem> getComeyearList(){//获得入学日期年的列表的方法
		int year=new Date().getYear()+1900;//获得当前年
		ArrayList<SelectItem> comeyearList=new ArrayList<SelectItem>();//创建年列表
		for(int i=year-10;i<=year+1;i++){//获得一定范围内的年号
			comeyearList.add(new SelectItem(i,i+"年"));//添加到年列表中
		}
		return comeyearList;//返回年列表
	}
	public ArrayList<SelectItem> getComemonthList(){//获得出生日期月的列表的方法
		ArrayList<SelectItem> comemonthList=new ArrayList<SelectItem>();//创建月列表
		for(int i=1;i<=12;i++){
			comemonthList.add(new SelectItem(i,i+"月"));//将12个月依次添加到列表中
		}
		return comemonthList;//返回列表
	}
	public ArrayList<SelectItem> getComedayList(){//获得出生日期日的类表
		ArrayList<SelectItem> comedayList=new ArrayList<SelectItem>();//创建日列表
		Date d=new Date(comeyear,comemonth,0);//根据年与月创建时间对象
		int date=d.getDate();//获得该月的最大天数
		for(int i=1;i<=date;i++){
			comedayList.add(new SelectItem(i,i+"日"));//添加到列表中
		}
		return comedayList;//返回日列表
	}
	public String addStu(){  //添加学生的业务逻辑方法
		String result=TeacherDB.AddStu(sno,sname,sgender,biryear,birmonth,
		                birday,nativeplace,collid,deptid,classid,mianmao,
		                comeyear,comemonth,comeday);//调用TeacherDB的方法插入学生
		if(result.equals("success")){this.msg="插入成功";}//插入成功
		else if(result.equals("restuadd")){
			this.msg="插入失败，已经有了该学号学生";//插入失败，已经有该学号学生
		}
		else if(result.equals("addstufail")){
			this.msg="插入失败";//插入失败
		}
		return "success";//返回来向页面
	}
}