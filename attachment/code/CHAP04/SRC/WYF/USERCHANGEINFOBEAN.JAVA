package wyf;


public class UserChangeInfoBean extends BaseBean{    
    private UserLogBean ulb;	//记录用户登陆信息的Bean引用
	private User_Item ui;
	public void setUlb(UserLogBean ulb){
		this.ulb = ulb;			//接受ulb依赖注入的setter方法
	}
    public void setGender(String gender){
		ui.setUgender(gender);
	}
	public String getGender(){
		return ui.getUgender();
	}
	public void setEmail(String email){
		ui.setUemail(email);
	}
	public String getEmail(){
		return ui.getUemail();
	}
	public void setPhone(String phone){
		ui.setUphone(phone);
	}
	public String getPhone(){
		return ui.getUphone();
	}
	
	public String initial(){				//初始化用户资料				
    	if(ulb.getUname()==null){			
    		return "userLogin";				//用户登陆超时或者没有登陆
    	}
    	else{
    		String sql = "select usid,uname,ugender,uemail,uphone from user_info "+
    			"where uname='"+ulb.getUname()+"'";					//得到用户资料的SQL语句
    		this.ui = (User_Item)dbu.getUserList(sql,1,1).get(0);	//搜索得到用户资料
    	}
    	return "goChangeInfo";										//返回修改资料页面视图
    }
    public String changeInfo(){
    	if(ulb.getUname()==null){
    		return "userLogin";					//用户登陆超时或者没有登陆
    	}
    	else{
    		String sql = "update user_info set ugender='"+ui.getUgender()+"',"+
    			"uemail='"+ui.getUemail()+"',uphone='"+ui.getUphone()+"' where usid="+ulb.getUsid();
    		if(dbu.update(sql)){					//更新用户修改后的资料
    			message = "资料已经保存";			//资料保存成功信息
    		}
    		else{
    			message = "未知错误，修改失败";		//保存失败信息
    		}
    	}
    	return "success";							//返回success
    }
}