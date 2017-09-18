package wyf.cgq;
import java.util.*;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.validator.annotations.*;
public class ImpleeyListAction extends ActionSupport
{
	private int pageSpan=5;
	private int currenPageNo=1;
	private String departId="0000";
	private int orderBySalary=0;//0:不按这个排序，1:升序，-1:降序
	private int orderByAge=0;//0:不按这个排序，1:升序，-1:降序
	private int maxPageNo;
	private int totalMessage;
	public void setPageSpan(int pageSpan)
	{
		this.pageSpan=pageSpan;
		ActionContext.getContext().getSession().put("pageSpan",pageSpan);
		this.setCurrenPageNo(1);
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
	public int getMaxPageNo()
	{
		Map session=ActionContext.getContext().getSession();
		if(session.get("pageSpan")!=null)
		{
			this.pageSpan=(Integer)session.get("pageSpan");
		}
		totalMessage=this.getTotalMessage();
		return totalMessage%pageSpan==0?totalMessage/pageSpan:(totalMessage/pageSpan+1);
	}
	public int getTotalMessage()
	{
		Map session=ActionContext.getContext().getSession();
		if(session.get("departId")!=null)
		{
			this.departId=(String)session.get("departId");
		}
		return ManageDB.getImpTotalMessage(departId);
	}
	public void setCurrenPageNo(int currenPageNo)
	{
		if(currenPageNo<=this.getMaxPageNo()&&currenPageNo>=1)
		{
			this.currenPageNo=currenPageNo;
		}
	}
	public int getCurrenPageNo()
	{
		return this.currenPageNo;
	}
	public void setDepartId(String departId)
	{
		this.departId=departId;
		ActionContext.getContext().getSession().put("departId",departId);
		ActionContext.getContext().getSession().put("orderBySalary",0);
		ActionContext.getContext().getSession().put("orderByAge",0);
		this.setCurrenPageNo(1);
	}
	public String getDepartId()
	{
		Object obj=(ActionContext.getContext().getSession().get("departId"));
		if(obj!=null)
		{
			this.departId=(String)obj;
		}
		return this.departId;
	}
	public int getOrderBySalary()
	{
		return this.orderBySalary;
	}
	public void setOrderBySalary(int orderBySalary)
	{
		this.orderBySalary=orderBySalary;
		ActionContext.getContext().getSession().put("orderBySalary",orderBySalary);
		ActionContext.getContext().getSession().put("orderByAge",0);
		this.setCurrenPageNo(1);
	}
	public int getOrderByAge()
	{
		return this.orderByAge;
	}
	public void setOrderByAge(int orderByAge)
	{
		this.orderByAge=orderByAge;
		ActionContext.getContext().getSession().put("orderBySalary",0);
		ActionContext.getContext().getSession().put("orderByAge",orderByAge);
		this.setCurrenPageNo(1);
	}
	public Map getDepartList()
	{
		Map map=ManageDB.getDepartList();
		map.put("0000","全部");
		return map;
	}
	public void setDepartList(Map map)
	{
	
	}
	public List getImpList()
	{
		Map session=ActionContext.getContext().getSession();
		if(session.get("departId")!=null)
		{
			this.departId=(String)session.get("departId");
		}
		if(session.get("pageSpan")!=null)
		{
			this.pageSpan=(Integer)session.get("pageSpan");
		}
		if(session.get("orderBySalary")!=null)
		{
			this.orderBySalary=(Integer)session.get("orderBySalary");
		}
		if(session.get("orderByAge")!=null)
		{
			this.orderByAge=(Integer)session.get("orderByAge");
		}
		
		List list=ManageDB.getImpList(departId,pageSpan,currenPageNo,orderBySalary,orderByAge);
	
		return list;
	}
	public String execute()
	{
		return SUCCESS;
	}
}