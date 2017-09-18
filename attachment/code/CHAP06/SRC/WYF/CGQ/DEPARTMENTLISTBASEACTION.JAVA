package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
public class DepartmentListBaseAction
{
	private List departList;
	private int pageSpan=5;
	private int currenPage=1;
	private int maxPageNo;
	private int totalMessage;
	private String result;
	private boolean read=true;
	public void setRead(boolean read)
	{
		this.read=read;
	}
	public void setPageSpan(int pageSpan)
	{
		this.pageSpan=pageSpan;
		ActionContext.getContext().getSession().put("pageSpan",pageSpan);
		this.setCurrenPage(1);
	}
	public int getPageSpan()
	{
		Object obj=ActionContext.getContext().getSession().get("pageSpan");
		if(obj!=null)
		{
			this.pageSpan=(Integer)obj;
		}
		return this.pageSpan;
	}
	public Map getSpanList()
	{
		Map map=new HashMap();
		map.put(1,"每页1条");
		map.put(2,"每页2条");
		map.put(5,"每页5条");
		map.put(10,"每页10条");
		map.put(15,"每页15条");
		return map;
	}
	public boolean getRead()
	{
		return read;
	}
	public void setResult(String result)
	{
		this.result=result;
	}
	public String getResult()
	{
		return this.result;
	}
	public List getDepartList()
	{
		this.pageSpan=this.getPageSpan();
		List list=ManageDB.getDepartmentList(currenPage,pageSpan);
		System.out.println("部门数量"+list.size());
		return list;
	}
	public void setCurrenPage(int currenPage)
	{
		if(currenPage<=this.getMaxPageNo()&&currenPage>=1)
		{
			this.currenPage=currenPage;
		}
               
	}
	public int getCurrenPage()
	{
		return this.currenPage;
	}
	public int getMaxPageNo()
	{
		Object obj=ActionContext.getContext().getSession().get("pageSpan");
		if(obj!=null)
		{
			this.pageSpan=(Integer)obj;
		}
		this.pageSpan=this.getPageSpan();
		this.totalMessage=this.getTotalMessage();
		this.maxPageNo=(totalMessage%pageSpan)==0?(totalMessage/pageSpan):(totalMessage/pageSpan+1);
		return maxPageNo;
	}
	public int getTotalMessage()
	{
		this.totalMessage=ManageDB.getDepartTotalMessage();
		return this.totalMessage;
	}
	public String execute()
	{
		return "success";
	}
}