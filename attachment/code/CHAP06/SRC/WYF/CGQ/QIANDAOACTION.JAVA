package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
public class QianDaoAction extends ActionSupport
{
	private List list;
	private int currenPage=1;
	private int pageSpan=5;
	private int totalMessage;
	private int maxPage;
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
	public void setCurrenPage(int currenPage)
	{
		if(currenPage<=this.getMaxPage()&&currenPage>=1)
		{
			this.currenPage=currenPage;
		}
		
	}
	public int getCurrenPage()
	{
		return this.currenPage;
	}
	public int getMaxPage()
	{
		this.pageSpan=this.getPageSpan();
		this.totalMessage=this.getTotalMessage();
		this.maxPage=totalMessage%this.pageSpan==0?(totalMessage/this.pageSpan):(totalMessage/this.pageSpan+1);
		return this.maxPage;
	}
	public int getTotalMessage()
	{
		Date opDate=(Date)(ActionContext.getContext().getSession().get("opdate"));
		String date=opDate.getYear()+1900+"-"+(opDate.getMonth()+1)+"-"+opDate.getDate();
		totalMessage=ManageDB.getTotalMessage(date);
		return totalMessage;
	}
	public List getQianDaoList()
	{
		this.pageSpan=this.getPageSpan();
		Date opDate=(Date)(ActionContext.getContext().getSession().get("opdate"));
		String date=opDate.getYear()+1900+"-"+(opDate.getMonth()+1)+"-"+opDate.getDate();
		if(!ManageDB.hasRecord(date))
		{
			ManageDB.generateQianDaoTable(date);
		}
		list=ManageDB.getQianDaoTable(date,this.getCurrenPage(),pageSpan);
		return list;
	}
	public String execute() 
	{
		return "success";
	}
}