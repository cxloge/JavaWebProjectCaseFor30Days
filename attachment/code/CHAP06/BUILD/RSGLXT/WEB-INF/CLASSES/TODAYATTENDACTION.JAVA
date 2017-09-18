package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
public class TodayAttendAction
{
	private String departId="0000";
	private int attendType=-1;
	private int currenPage=1;
	private int maxPage;
	private int pageSpan=5;
	private int totalMessage;
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
	public void setDepartId(String departId)
	{
		this.departId=departId;
		this.setCurrenPage(1);
		ActionContext.getContext().getSession().put("departId",departId);
	}
	public String getDepartId()
	{
		Object obj=ActionContext.getContext().getSession().get("departId");
		if(obj!=null)
		{
			this.departId=(String)obj;
		}
		return this.departId;
	}
	public void setAttendType(int attendType)
	{
		this.attendType=attendType;
		this.setCurrenPage(1);
		ActionContext.getContext().getSession().put("attendType",attendType);
	}
	public int getAttendType()
	{
		Object obj=ActionContext.getContext().getSession().get("attendType");
		if(obj!=null)
		{
			this.attendType=(Integer)obj;
		}
		return this.attendType;
	}
	public void setCurrenPage(int currenPage)
	{
		if(currenPage>0 && currenPage<=this.getMaxPage())
		{
			this.currenPage=currenPage;
		}
		
	}
	public int getCurrenPage()
	{
		return this.currenPage;
	}
	public int getTotalMessage()
	{
		this.totalMessage=ManageDB.getTotalMessage(this.getDepartId(),this.getAttendType());
		return this.totalMessage;
	}
	public int getMaxPage()
	{
		this.pageSpan=this.getPageSpan();
		this.totalMessage=this.getTotalMessage();
		this.maxPage=this.totalMessage%pageSpan==0?(this.totalMessage/pageSpan):(this.totalMessage/pageSpan+1);
		return this.maxPage;
	}
	public Map getDepartList()
	{
		Map map=ManageDB.getDepartList();
		map.put("0000","全部");
		return map;
	}
	public List getRecordList()
	{
		this.pageSpan=this.getPageSpan();
		List list=ManageDB.getRecordList(this.getDepartId(),this.getAttendType(),this.getCurrenPage(),pageSpan);
		return list;
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
	public String execute()
	{
		return "success";
	}
}