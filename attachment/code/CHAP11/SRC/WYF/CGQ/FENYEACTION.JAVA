package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
import org.apache.struts2.*;
import java.io.*;
public class FenYeAction extends ActionSupport{
	private SearchDB searchDB;//声明SearchDB的引用
	private InsertDB insertDB;//声明InsertDB的引用
	private int currenPage=1;//声明当前页的引用
	private int pageSpan=5;//声明页跨度，默认每页显示5条
	private int maxPage;//声明最大页数
	private int totalMessage;//用于记录总的记录条数
	public void setSearchDB(SearchDB searchDB){//searchDB的setter方法
		this.searchDB=searchDB;}
	public SearchDB getSearchDB(){//searchDB的getter方法
		return this.searchDB;}
	public void setInsertDB(InsertDB insertDB){//insertDB的setter方法
		this.insertDB=insertDB;}
	public InsertDB getInsertDB(){//insertDB的getter方法
		return this.insertDB;}
	public void setCurrenPage(int currenPage){//currenPage的setter方法
		this.currenPage=currenPage;}
	public int getCurrenPage(){//currenPage的getter方法
		return this.currenPage;}
	public void setPageSpan(int pageSpan){//pageSpan的setter方法
		this.pageSpan=pageSpan;
		this.getSession().put("pageSpan",pageSpan);//将该值放入session
		this.currenPage=1;//将当前页设为第一页
	}
	public int getPageSpan(){
		Object obj=this.getSession().get("pageSpan");//从session里获得页跨度
		if(obj!=null){this.pageSpan=(Integer)obj;}//obj不为空，这位当前页跨度
		return this.pageSpan;//返回页跨度
	}
	public void setMaxPage(int maxPage){this.maxPage=maxPage;}//maxPage的setter方法
	public int getMaxPage(){return this.maxPage;}//maxPage的getter方法
	public String execute(){return "success";}//重写的execute方法
	public Map getSession(){//获得session的方法
		return ActionContext.getContext().getSession();
	}
}
