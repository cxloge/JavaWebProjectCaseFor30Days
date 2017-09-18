package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import java.math.*;
public class ReadDocAction{
	private SearchDB searchDB;
	private String docnum;
	private String topic;
	private String content;
	private int canRead;
	public void setSearchDB(SearchDB searchDB){
		this.searchDB=searchDB;
	}
	public String getTopic(){
		return this.topic;
	}
	public String getContent(){
		return this.content;
	}
	public int getCanRead(){
		return this.canRead;
	}
	public String getUser(){
		return ((String)ActionContext.getContext().getSession().get("user")).trim();
	}
	public void setDocnum(String docnum){
		this.docnum=docnum;
	}
	public String getDocnum(){
		return this.docnum;
	}
	public String execute(){
		String sql="select "+
						"oa_doc.doc_num,"+
						"oa_doc.doc_title,"+
						"oa_doc.doc_content,"+
						"0 "+ 
					"from "+
						"oa_doc "+
					"where "+
						"oa_doc.doc_num "+
					"in ("+
						"select doc_num from oa_docdept where "+
						"oa_docdept.doc_num='"+this.docnum+"' "+
						"and oa_docdept.dept_num in "+
							"(select dept_number from oa_user where user_number='"+this.getUser()+"') "+
						" and oa_docdept.doc_type=2 and"+
						" 0 not in (select count(*) from oa_docdept where doc_type=1 and dept_state=0 and doc_num='"+this.docnum+"')) "+
					"union "+
					"select "+
						"oa_doc.doc_num, "+
						"oa_doc.doc_title, "+
						"oa_doc.doc_content, "+
						"1 "+
					"from "+
						"oa_doc "+
					"where  "+
						"oa_doc.doc_num='"+this.docnum+"'";
		List list=this.searchDB.getArrayList(sql);
		Object[] o=(Object[])list.get(0);
		this.docnum=((BigDecimal)o[0]).intValue()+"";
		this.topic=(String)o[1];
		this.content=(String)o[2];
		this.canRead=((BigDecimal)o[3]).intValue();
		
		return "success";
	}
}