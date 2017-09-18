package wyf.cgq;
import com.opensymphony.xwork2.*;
import java.util.*;
import com.opensymphony.xwork2.validator.annotations.*;
public class PersonEWAction extends ActionSupport
{
	private String impId;
	private Date startTime;
	private Date endTime;
	private int currenPage=1;
	private int pageSpan=5;
	private int maxPage;
	private int totalMessage;
	private boolean first=false;
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
	public int getCurrenPage()
	{
		return this.currenPage;
	}
	public void setCurrenPage(int currenPage)
	{
		if(currenPage>0&&currenPage<=this.getMaxPage())
		{
			this.currenPage=currenPage;
		}
		
	}
	@RequiredFieldValidator(message="${getText(\"validate.startTimeEM\")}",shortCircuit=true)
	public void setStartTime(Date startTime)
	{
		
		this.startTime=startTime;
		ActionContext.getContext().getSession().put("startTime",startTime);
	}
	public Date getStartTime()
	{
		Object obj=ActionContext.getContext().getSession().get("startTime");
		if(obj!=null)
		{
			this.startTime=(Date)obj;
		}
		return this.startTime;
	}
	@RequiredFieldValidator(message="${getText(\"validate.endTimeEM\")}",shortCircuit=true)
	public void setEndTime(Date endTime)
	{
		this.endTime=endTime;
		ActionContext.getContext().getSession().put("endTime",endTime);
	}
	public Date getEndTime()
	{
		Object obj=ActionContext.getContext().getSession().get("endTime");
		if(obj!=null)
		{
			this.endTime=(Date)obj;
		}
		return this.endTime;
	}
	public int getTotalMessage()
	{
		if(!this.getImpId().equals("999"))
		{
			if(this.getStartTime()!=null&&this.getEndTime()!=null)
			this.totalMessage=ManageDB.getPEWTotalMessage(this.getImpId(),this.getStartTime(),this.getEndTime());
		}
		
		return totalMessage;
	}
	public int getMaxPage()
	{
		this.pageSpan=this.getPageSpan();
		this.totalMessage=this.getTotalMessage();
		this.maxPage=this.totalMessage%this.pageSpan==0?(this.totalMessage/this.pageSpan):(this.totalMessage/this.pageSpan+1);
		return this.maxPage;
	}
	public void setImpId(String impId)
	{
		
		this.impId=impId;
		ActionContext.getContext().getSession().put("impId",impId);
	}
	public String getImpId()
	{
		Object obj=ActionContext.getContext().getSession().get("impId");
		if(obj!=null)
		{
			impId=(String)obj;
		}
		return impId;
	}
	public boolean getFirst()
	{
		return first;
	}
	public List getPEWRecordList()
	{
		List list=new ArrayList();
		if(this.getImpId().equals("999"))
		{
			return list;
		}
		else
		{
			this.pageSpan=this.getPageSpan();
			list=ManageDB.getPEWRecordList(this.getImpId(),this.getStartTime(),this.getEndTime(),this.getCurrenPage(),this.pageSpan);
		}
		return list;
	}
	public String execute()
	{
		if(this.getImpId().equals("999"))
		{
			this.first=true;
		}
		return "success";
	}
}