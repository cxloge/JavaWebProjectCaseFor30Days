package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import java.math.*;
public class ReceiveFileAction extends FenYeAction{
	public List getMyFileList(){//获得文件列表的方法
		int begin=(this.getCurrenPage()-1)*this.getPageSpan();//记录的开始位置
		int end=this.getCurrenPage()*this.getPageSpan();//记录的结束位置
		String usernumber=(String)this.getSession().get("user");//获得用户的编号
		String sql="select filename,realname,fromuser,touser,filetime,fileinfo,username,filenumber from("+
		"select rownum rn,filename,realname,fromuser,touser,filetime,fileinfo,username,filenumber from ("+
		"select oa_transfile.transfile_name filename,"+
		"oa_transfile.transfile_realname realname,oa_transfile.transfile_fromuser fromuser,"+
		"oa_transfile.transfile_touser touser,to_char(oa_transfile.transfile_time,'YYYY/MM/DD HH:MI:SS') filetime,"+
		"oa_transfile.transfile_info fileinfo,oa_user.user_realname username,oa_transfile.transfile_number filenumber"+
		" from oa_transfile,oa_user where oa_transfile.transfile_fromuser="+
		"oa_user.user_number and oa_transfile.transfile_touser='"+usernumber.trim()+"' "+
		"order by oa_transfile.transfile_time desc)) where rn>"+begin+" and rn<="+end;//组织SQL
		List list=this.getSearchDB().getArrayList(sql);//获得搜索的列表
		int size=list.size();//获得列表的大小
		List filelist=new ArrayList();//创建List，存放文件对象
		for(int i=0;i<size;i++){//遍历List
			Object[] o=(Object[])list.get(i);//获得其中的一个对象
			Transfile tf=new Transfile((String)o[0],(String)o[1],(String)o[2],(String)o[3],
			(String)o[4],(String)o[5],(String)o[6],(String)o[7]);//造文件对象
			filelist.add(tf);//将文件对象放入filelist
		}
		return filelist;//返回文件对象列表
	}
	public String execute(){//重写的execute方法
		this.updateInfo();//更新最大页数
		return "success";//返回逻辑视图
	}
	public void updateInfo(){//更新最大页数的方法
		String usernumber=(String)this.getSession().get("user");//获得用户的编号
		String sql="select count(*) from oa_transfile where transfile_touser='"+usernumber.trim()+"'";
		List list=this.getSearchDB().getArrayList(sql);//组织SqL并查询记录总条数
		int total=((BigDecimal)list.get(0)).intValue();//获得记录总条数
		this.setMaxPage(total%this.getPageSpan()==0?total/this.getPageSpan():(total/this.getPageSpan()+1));//更新总页数
	}
}
