package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
public class SendDoc2Action extends SendDocAction{
	private InsertDB insertDB;//声明InsertDB的引用
	private String type;//用于存放申请类型
	private List firstList;//一级审批的部门列表
	private List secondList;//二级审批部门的列表
	private String topic;//申请的标题
	private String content;//申请的具体内容
	public void setInsertDB(InsertDB insertDB){//insertDB的setter方法
		this.insertDB=insertDB;
	}
	public void setType(String type){//申请类别的setter方法
		this.type=type.trim();
	}
	public String getType(){//申请类别的getter方法
		return this.type;
	}
	public void setFirstList(List firstList){//一级审批的部门列表的setter方法
		this.firstList=firstList;
	}
	public List getFirstList(){//一级审批的部门列表的getter方法
		return this.firstList;
	}
	public void setSecondList(List secondList){//二级审批部门的列表的setter方法
		this.secondList=secondList;
	}
	public List getSecondList(){//二级审批部门的列表的getter方法
		return this.secondList;
	}
	public void setTopic(String topic){//申请的标题的setter方法
		this.topic=topic;
	}
	public String getTopic(){//申请的标题的getter方法
		return this.topic;
	}
	public void setContent(String content){//申请的具体内容的setter方法
		this.content=content;
	}
	public String getContent(){//申请的具体内容的getter方法
		return this.content;
	}
	public String execute(){//重写的execute方法
		int docnum=this.getSearchDB().getDocMax();//获得编号
		String from=(String)this.getSession().get("user");//获得申请人编号
		String sql="insert into oa_doc (doc_num,doc_from,doc_title,doc_content,doc_type,doc_time)"+
		" values('"+docnum+"','"+from+"','"+this.topic+"','"+this.content+"',"+this.type+",sysdate)";
		boolean b=this.insertDB.saveDoc(sql,docnum,this.firstList,this.secondList,this.type);//插入
		if(b==true){
			this.setResult("发送成功");
		}//发送成功
		else{
			this.setResult("发送失败");
		}//发送失败
		return "success";
	}
}