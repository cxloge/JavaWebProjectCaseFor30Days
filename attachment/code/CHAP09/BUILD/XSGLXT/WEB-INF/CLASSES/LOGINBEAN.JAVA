package wyf.cgq;
public class LoginBean{
	private String uid;      		//用与封装用户的登录用户名
	private String pwd;      		//用于封装用户的登录密码
	private String type;     		//用于封装用户登陆类型
	private String id;       		//用于记录学号或学院号的属性
	public void setUid(String uid){this.uid=uid;}    //uid属性对应的setter方法
	public String getUid(){return this.uid;}     	 //uid属性对应的getter方法
	public void setPwd(String pwd){this.pwd=pwd;}	 //pwd属性对应的setter方法
	public String getPwd(){return this.pwd;}		 //pwd属性对应的getter方法
	public void setType(String type){this.type=type;}//type属性对应的setter方法
	public String getType(){return this.type;}		 //type属性对应的getter方法
	public String getId(){return this.id;}			 //id属性对应的getter方法
	public void setId(String id){this.id=id;}		 //id属性对应的setter方法
	public boolean getLogin(){return this.id!=null;} //用于判断是否登录
	public String verify(){							 //用于处理表单的方法
		String result="fail";						 //标志字符串，默认登录失败
		if(type.equals("student")){					 //如果是学生用户登录
			result=LoginDB.studentLogin(uid,pwd);	 //调用LoginDB查询数据库进行判断
			if(result.equals("success")){this.id=uid;}//登录成功，设置id的值
			else{this.id=null;}						  //登录失败，设置id为null
		}
		else{										  //如果是教师用户登录
			result=LoginDB.teacherLogin(uid,pwd);	  //调用LoginDB查询数据库进行判断
			if(!result.equals("fail")){				  //如果返回的不是fail
				this.id=result;result="teacher";}	  //设置id的值，
			else{this.id=null;}						  //如果返回的是fail,则设置id为null
		}
		return result;								  //返回最后处理的结果
	}
}