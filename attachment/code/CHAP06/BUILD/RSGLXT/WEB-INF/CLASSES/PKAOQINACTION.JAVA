package wyf.cgq;
import com.opensymphony.xwork2.*;
import java.util.*;
public class PKaoQinAction
{
	private Date from_day;
	private Date to_day;
	private int stateType=-1;
	private int currenPage=1;
	private int maxPage=1;
	private int totalMessage;
	private int pageSpan=5;
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
	public void setFrom_day(Date from_day)
	{
		this.from_day=from_day;
		ActionContext.getContext().getSession().put("from_day",from_day);
	}
	public Date getFrom_day()
	{
		Object obj=ActionContext.getContext().getSession().get("from_day");
		if(obj!=null)
		{
			this.from_day=(Date)obj;
		}
		System.out.println(from_day);
		return this.from_day;
	}
	public String getFrom_day1()
	{
		this.from_day=this.getFrom_day();
		String s=from_day.getYear()+1900+"-"+(from_day.getMonth()+1)+"-"+from_day.getDate();
		return s;
	}
	public void setTo_day(Date to_day)
	{
		this.to_day=to_day;
		ActionContext.getContext().getSession().put("to_day",to_day);
	}
	public String getTo_day1()
	{
		this.to_day=this.getTo_day();
		String s=to_day.getYear()+1900+"-"+(to_day.getMonth()+1)+"-"+to_day.getDate();
		return s;
	}
	public Date getTo_day()
	{
		Object obj=ActionContext.getContext().getSession().get("to_day");
		if(obj!=null)
		{
			this.to_day=(Date)obj;
		}
		return this.to_day;
	}
	public void setStateType(int stateType)
	{
		this.stateType=stateType;
		ActionContext.getContext().getSession().put("stateType",stateType);
	}
	public int getStateType()
	{
		Object obj=ActionContext.getContext().getSession().get("stateType");
		if(obj!=null)
		{
			this.stateType=(Integer)obj;
		}
		return this.stateType;
	}
	public int getCurrenPage()
	{
		System.out.println(currenPage+"==============");
		return this.currenPage;
	}
	public void setCurrenPage(int currenPage)
	{
		this.currenPage=currenPage;
	}
	public int getTotalMessage()
	{
		this.totalMessage=ManageDB.getPKQRecord(this.getImpId(),this.getStateType(),this.getFrom_day1(),this.getTo_day1());
		return this.totalMessage;
	}
	public int getMaxPage()
	{
		this.pageSpan=this.getPageSpan();
		this.totalMessage=this.getTotalMessage();
		this.maxPage=this.totalMessage%pageSpan==0?(this.totalMessage/pageSpan):(this.totalMessage/pageSpan+1);
		return this.maxPage;
	}
	public Map getStateList()
	{
		Map map=new HashMap();
		map.put(-1,"全部");
		map.put(0,"缺勤");
		map.put(1,"在职");
		map.put(2,"请假");
		return map;
	}
	public List getRecordList()
	{
		this.pageSpan=this.getPageSpan();
		List list=new ArrayList();
		if(this.getFrom_day1()!=null&&this.getTo_day1()!=null)
		{
			list=ManageDB.getPRecordList(this.getImpId(),this.getStateType(),this.getFrom_day1(),this.getTo_day1(),this.getCurrenPage(),pageSpan);

		}
		
		System.out.println("public List getRecordList()===="+list.size());
		return list;
	}
	public String getImpId()
	{
		String impId=(String)(ActionContext.getContext().getSession().get("user"));
		return impId;
	}
	public String execute()
	{

		return "success";
	}
}