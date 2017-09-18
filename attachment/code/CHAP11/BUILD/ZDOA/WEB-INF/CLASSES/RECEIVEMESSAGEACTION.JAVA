package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import java.math.*;
public class ReceiveMessageAction extends FenYeAction{
	public List getMessageList(){
		int begin=(this.getCurrenPage()-1)*this.getPageSpan();
		int end=this.getCurrenPage()*this.getPageSpan();
		String usernumber=(String)this.getSession().get("user");
		String sql="select msgnumber,fromuser,msginfo,msgtime from("+
		"select rownum rn,msgnumber,fromuser,msginfo,msgtime from ("+
		"select oa_message.message_number msgnumber,"+
		"oa_user.user_realname fromuser,oa_message.message_info msginfo,"+
		"to_char(oa_message.message_time,'YYYY/MM/DD HH:MI:SS') msgtime"+
		" from oa_message,oa_user where oa_message.message_fromuser="+
		"oa_user.user_number and oa_message.message_touser='"+usernumber.trim()+"' "+
		"order by oa_message.message_time desc)) where rn>"+begin+" and rn<="+end;
		System.out.println(sql);
		List list=this.getSearchDB().getArrayList(sql);
		int size=list.size();
		List filelist=new ArrayList();
		for(int i=0;i<size;i++){
			Object[] o=(Object[])list.get(i);
			SendMsg msg=new SendMsg((String)o[0],(String)o[1],(String)o[2],(String)o[3]);
			
			filelist.add(msg);
		}
		return filelist;
	}
	public String execute(){
		this.updateInfo();
		return "success";
	}
	public void updateInfo(){
		String usernumber=(String)this.getSession().get("user");
		String sql="select count(*) from oa_message where message_touser='"+usernumber.trim()+"'";
		List list=this.getSearchDB().getArrayList(sql);
		int total=((BigDecimal)list.get(0)).intValue();
		this.setMaxPage(total%this.getPageSpan()==0?total/this.getPageSpan():(total/this.getPageSpan()+1));
	}
}
