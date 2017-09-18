package wyf;

public class BaseBean{
	protected DBUtil dbu;					//声明DBUtil对象引用
	protected String message;				//给用户的提示信息
	
	public void setDbu(DBUtil dbu){			//dbu属性的setter方法
		this.dbu = dbu;						//设置dbu属性的值
	}
	
	public void setMessage(String message){	//message属性的setter方法
		this.message = message;				//设置message属性值
	}	
	public String getMessage(){				//message属性的getter方法
		return this.message;				//返回message属性值
	}
}