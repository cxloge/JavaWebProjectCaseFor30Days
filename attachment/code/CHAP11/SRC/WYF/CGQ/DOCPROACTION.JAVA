package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
import java.math.*;
public class DocProAction{
	private SearchDB searchDB;//声明searchDB的引用
	private List firstList;//用于存放一级审批列表
	private List secondList;//用于存放二级审批列表
	private String topic;//用于存放申请主题
	private int type;//用于存放神奇类别
	private int state;//用于存放申请状态
	private String docnum;//用于存放申请的编号
	public void setSearchDB(SearchDB searchDB){//searchDB的setter方法
		this.searchDB=searchDB;
	}
	public void setDocnum(String docnum){
		this.docnum=docnum;
	}//docnum的setter方法
	public String getTopic(){
		return this.topic;
	}//topic的getter方法
	public List getFirstList(){
		return this.firstList;
	}//topic的getter方法
	public List getSecondList(){
		return this.secondList;
	}//topic的getter方法
	public int getType(){
		return this.type;
	}//topic的getter方法
	public int getState(){
		return this.state;
	}//topic的getter方法
	public String execute(){
		String sql1="select doc_title,doc_type,doc_state from oa_doc where "+
				"doc_num='"+this.docnum+"'";//搜索申请的sql语句
		List list=this.searchDB.getArrayList(sql1);//获得搜索列表
		Object[] o=(Object[])list.get(0);//获得第一个对象
		this.topic=(String)o[0];//取出主题
		this.type=((BigDecimal)o[1]).intValue();//取出类型
		this.state=((BigDecimal)o[2]).intValue();//取出状态
		firstList=new ArrayList();//创建一个ArrayList，存放一级审批部门类表
		String sql2="select oa_dept.dept_name,oa_docdept.dept_state from "+
				"oa_dept,oa_docdept where oa_docdept.doc_num='"+this.docnum+"' "+
				"and oa_dept.dept_number=oa_docdept.dept_num and oa_docdept.doc_type=1";
		list=this.searchDB.getArrayList(sql2);//组织SqL并查询一级审批部门
		int size=list.size();//获得部门个数
		for(int i=0;i<size;i++){//遍历List
			Object[] o1=(Object[])list.get(i);//取出一个对象
			DocDept dd=new DocDept((String)o1[0],((BigDecimal)o1[1]).intValue());
			firstList.add(dd);//组织成对象并放入firstList中
		}
		if(this.type==2){//如果是二级审批
			this.secondList=new ArrayList();//创建一个ArrayList，存放二级审批部门类表
			sql2="select oa_dept.dept_name,oa_docdept.dept_state from "+
				"oa_dept,oa_docdept where oa_docdept.doc_num='"+this.docnum+"' "+
				"and oa_dept.dept_number=oa_docdept.dept_num and oa_docdept.doc_type=2";
			list=this.searchDB.getArrayList(sql2);//组织SqL并查询二级审批部门
			size=list.size();//获得部门个数
			for(int i=0;i<size;i++){//遍历List
				Object[] o2=(Object[])list.get(i);//取出一个对象
				DocDept dd=new DocDept((String)o2[0],((BigDecimal)o2[1]).intValue());
				secondList.add(dd);//组织成对象并放入secondList中
			}
		}
		return "success";//返回逻辑视图名
	}
}