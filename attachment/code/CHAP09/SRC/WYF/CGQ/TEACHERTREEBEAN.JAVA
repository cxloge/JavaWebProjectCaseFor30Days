package wyf.cgq;
public class TeacherTreeBean{				
	private boolean root1=true;					//控制一级节点的属性
	private boolean root11=true;				//控制系统选项下属节点的属性
	private boolean root21=true;				//控制学生信息管理下属节点的属性
	private boolean root31=true;				//控制课程管理下树节点的属性
	private LoginBean lb;						//声明LoginBean的应用
	public void setLb(LoginBean lb){this.lb=lb;}//lb的setter方法
	public String clickCom(){					//点击根节点的业务处理方法
		root1=!root1;return "success";}			//将root1属性取反
	public String clickRoot11(){				//点击系统选项节点的处理方法
		root11=!root11;return "success";}		//将root11属性取反
	public String clickRoot21(){				//点击学生信息管理节点的处理方法
		root21=!root21;return "success";}		//将root21属性取反
	public String clickRoot31(){				//点击课程管理节点的处理方法
		root31=!root31;return "success";}		//将root31属性取反
	public void setRoot1(boolean root1){this.root1=root1;}	  //root1的setter方法
	public boolean getRoot1(){return this.root1;}			  //root1的getter方法
	public void setRoot11(boolean root11){this.root11=root11;}//root11的setter方法
	public boolean getRoot11(){return this.root11;}			  //root11的getter方法
	public void setRoot21(boolean root21){this.root21=root21;}//root21的setter方法
	public boolean getRoot21(){return this.root21;}			  //root21的getter方法
	public void setRoot31(boolean root31){this.root31=root31;}//root31的setter方法
	public boolean getRoot31(){return this.root31;}			  //root31的getter方法
	public String reLogin(){					//点击重新登录节点的业务处理方法
		lb.setId(null);							//设置lb的id属性为null
		lb.setUid(null);						//设置lb的uid属性为null
		return "login";							//返回标志字符串
	}}