package wyf.cgq;
import com.opensymphony.xwork2.*;
import java.util.*;
public class SearchImpAction extends ActionSupport
{
	private String departId;
	private String impId;
	private String impName;
	private int upSalary;
	private int downSalary;
	
	
	private int currenPage=1;
	private int maxPage;
	private int totalMessage;
	private int pageSpan=5;
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
		if(currenPage>0&&currenPage<=this.getMaxPage())
		{
			this.currenPage=currenPage;
		}
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
	public int getCurrenPage()
	{
		return this.currenPage;
	}
	public int getMaxPage()
	{
		this.pageSpan=this.getPageSpan();
		this.totalMessage=this.getTotalMessage();
		this.maxPage=totalMessage%this.pageSpan==0?(totalMessage/pageSpan):(totalMessage/pageSpan+1);
		return this.maxPage;
	}
	public int getTotalMessage()
	{
		this.totalMessage=ManageDB.getTotalMessage(departId,impId,impName,upSalary,downSalary);
		return this.totalMessage;
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
	public void setDepartId(String departId)
	{
		this.setCurrenPage(1);
		this.departId=departId;
		ActionContext.getContext().getSession().put("departId",departId);
	}
	public String getImpId()
	{
		Object obj=ActionContext.getContext().getSession().get("impId");
		if(obj!=null)
		{
			this.impId=(String)obj;
		}
		return this.impId;
	}
	public void setImpId(String impId)
	{
		this.impId=impId;
		ActionContext.getContext().getSession().put("impId",impId);
	}
	public String getImpName()
	{
		Object obj=ActionContext.getContext().getSession().get("impName");
		if(obj!=null)
		{
			this.impName=(String)obj;
		}
		return this.impName;
	}
	public void setImpName(String impName)
	{
		this.impName=impName;
		ActionContext.getContext().getSession().put("impName",impName);
	}
	public void setDownSalary(int downSalary)
	{
		this.downSalary=downSalary;
		ActionContext.getContext().getSession().put("downSalary",downSalary);
	}
	public int getDownSalary()
	{
		Object obj=ActionContext.getContext().getSession().get("downSalary");
		if(obj!=null)
		{
			this.downSalary=(Integer)obj;
		}
		return this.downSalary;
	}
	public void setUpSalary(int upSalary)
	{
		this.upSalary=upSalary;
		ActionContext.getContext().getSession().put("upSalary",upSalary);
	}
	public int getUpSalary()
	{
		Object obj=ActionContext.getContext().getSession().get("upSalary");
		if(obj!=null)
		{
			this.upSalary=(Integer)obj;
		}
		return this.upSalary;
	}
	public Map getDepartList()
	{
		Map map=ManageDB.getDepartList();
		map.put("0000","全部");
		return map;
	}
	public List getImpList()
	{
		List list=ManageDB.getResultList(this.getDepartId(),this.getImpId(),this.getImpName(),this.getCurrenPage(),this.getPageSpan(),this.getUpSalary(),this.getDownSalary());
		return list;
	}
	public String execute()
	{
		if(this.getDepartId().equals("55555"))
		{
			this.setCurrenPage(1);
			this.setDepartId("0000");
			this.setUpSalary(0);
			this.setDownSalary(0);
			this.setImpName("");
			this.setImpId("");
			this.setPageSpan(pageSpan);
		}
		return "success";
	}
}