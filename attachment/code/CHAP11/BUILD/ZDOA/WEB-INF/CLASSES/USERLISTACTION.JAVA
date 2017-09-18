package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
public class UserListAction implements Action{
	private SearchDB searchDB;//声明SearchDB的引用
	private String deptNumber;//声明存放部门编号的属性
	private String userList;//用于存放用户列表的属性
	private String hqluser;//声明hql的引用
	public void setSearchDB(SearchDB searchDB){//searchDB的setter方法
		this.searchDB=searchDB;
	}
	public void setDeptNumber(String deptNumber){//deptNumber的setter方法
		this.deptNumber=deptNumber;
	}
	public String getUserList(){//userList的getter方法
		return userList;
	}
	public String execute(){//重写的execute方法
		hqluser="from RealUser ru where ru.deptNumber='"+deptNumber+"'";//组织hql语句
		List list=searchDB.getInstanceList(hqluser);//获得用户列表
		int size=list.size();//获得list的大小
		StringBuilder result=new StringBuilder();//创建StringBuilder对象
		result.append("<table width=\"100%\" ><tr><td style=\"width:10\"></td><td><table border=0 width=\"100%\">");
		for(int i=0;i<size;i++){//遍历list组织html代码
			RealUser user=(RealUser)list.get(i);
			String unumber=user.getUserNumber();
			String uname=user.getUserName();
			result.append("<tr style=\"height:20px;color:#404040;font-size:14px;\" onmouseout=\"mouseoutcolor('row");
			result.append(i);
			result.append("')\" onmouseover=\"mouseovercolor('row");
			result.append(i);
			result.append("')\" onclick=\"add('");
			result.append(unumber);
			result.append("')\" id=\"row");
			result.append(i);
			result.append("\">");
			result.append("<td align=\"right\"><img src=\"images/usrlist.gif\"></td><td align=\"left\">");
			result.append(uname);
			result.append("<td></tr>");
		}
		result.append("</table></td></tr></table>");//组织完毕
		this.userList=result.toString();//转化为字符串
		userList=new MyConverter().escape(userList);//进行编码
		return "success";//返回逻辑视图
	}
}
