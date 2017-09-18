package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import java.math.*;
public class OpDocAction{
	private InsertDB insertDB;
	private String docnum;
	private int type;
	public void setInsertDB(InsertDB insertDB){
		this.insertDB=insertDB;
	}
	public void setDocnum(String docnum){
		this.docnum=docnum;
	}
	public void setType(int type){
		this.type=type;
	}
	public String getUser(){
		return ((String)ActionContext.getContext().getSession().get("user")).trim();
	}
	public String execute(){
		String sql1="update oa_docdept set dept_state="+this.type+
					" where doc_num='"+this.docnum+"' and "+
					"dept_num in (select dept_number from oa_user where user_number='"+this.getUser()+"')";
		String sql2="";
		if(this.type==1){
			sql2="update oa_doc set doc_state=1 where doc_num='"+this.docnum+"' "+
				"and (select count(*) from oa_docdept where doc_num='"+this.docnum+"' "+
				"and dept_state=0)=0";
		}
		if(this.type==2){
			sql2="update oa_doc set doc_state=2 where doc_num='"+this.docnum+"'";
		}
		this.insertDB.updatedoc(sql1,sql2);
		return "success";
	}
}