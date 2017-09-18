package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import java.math.*;
public class MyDocAction extends FenYeAction{
	
	public List getDocList(){
		int begin=(this.getCurrenPage()-1)*this.getPageSpan();
		int end=this.getCurrenPage()*this.getPageSpan();
		String user=((String)this.getSession().get("user")).trim();
		String sql="select docnum,fromuser,deptname,title,to_char(doctime,'YYYY-MM-DD HH:MI:SS') from ("+
				"select rownum rn,docnum,fromuser,deptname,title,doctime from("+
				"select oa_doc.doc_num docnum,	oa_user.user_realname fromuser,	oa_dept.dept_name deptname,"+
				"oa_doc.doc_title title,oa_doc.doc_time doctime from oa_doc,oa_user,oa_dept "+
				"where 	oa_user.user_number=oa_doc.doc_from "+
				"and	oa_dept.dept_number="+
				"oa_user.dept_number and oa_doc.doc_from='"+this.getUser()+"'"+
				" order by oa_doc.doc_time desc)) where rn>"+begin+" and rn<="+end;
		List list=this.getSearchDB().getArrayList(sql);
		int size=list.size();
		List doclist=new ArrayList();
		for(int i=0;i<size;i++){
			Object[] o=(Object[])list.get(i);
			Docs doc=new Docs(((BigDecimal)o[0]).intValue(),(String)o[1],(String)o[2],(String)o[3],(String)o[4]);
			doclist.add(doc);
		}
		return doclist;
	}
	public String execute(){
		this.updateInfo();
		return "success";
	}
	public void updateInfo(){
		String sql="select count(*) from("+
				"select oa_doc.doc_num docnum,	oa_user.user_realname fromuser,	oa_dept.dept_name deptname,"+
				"oa_doc.doc_title title,oa_doc.doc_time doctime from oa_doc,oa_user,oa_dept "+
				"where 	oa_user.user_number=oa_doc.doc_from "+
				"and	oa_dept.dept_number="+
				"oa_user.dept_number and oa_doc.doc_from='"+this.getUser()+"')";
		List list=this.getSearchDB().getArrayList(sql);
		int total=((BigDecimal)list.get(0)).intValue();
		this.setMaxPage(total%this.getPageSpan()==0?total/this.getPageSpan():(total/this.getPageSpan()+1));
	}
	public String getUser(){
		return ((String)ActionContext.getContext().getSession().get("user")).trim();
	}
}